// @flow

import objectPath from 'object-path'

import type {
  DataToolsConfig,
  ExtensionType,
  GtfsPlusTable,
  MessageFile,
  ModuleType
} from '../../types'

const DEFAULT_CONFIG = {
  extensions: {},
  modules: {
    editor: {}
  },
  specifications: {
    gtfs: null,
    gtfsplus: null
  }
}

export function getConfigProperty (propertyString: string): ?any {
  const CONFIG: DataToolsConfig = window.DT_CONFIG
  return objectPath.get(CONFIG, propertyString)
}

export function getGtfsSpec (): Array<any> {
  const CONFIG: DataToolsConfig = window.DT_CONFIG
  const GTFS_SPEC = CONFIG.specifications.gtfs
  if (!GTFS_SPEC) throw new Error('GTFS yml configuration file is not defined!')
  return GTFS_SPEC
}

export function getGtfsPlusSpec (): Array<GtfsPlusTable> {
  const CONFIG: DataToolsConfig = window.DT_CONFIG
  const GTFS_PLUS_SPEC = CONFIG.specifications.gtfsplus
  if (!GTFS_PLUS_SPEC) throw new Error('GTFS+ yml configuration file is not defined!')
  return GTFS_PLUS_SPEC
}

/**
 * Create a function to lookup and return a message within a particular component.
 * This function must be called after the config has been initialized.
 */
export function getComponentMessages (componentName: string): string => string {
  const CONFIG: DataToolsConfig = window.DT_CONFIG
  const componentMessages = (
    objectPath.get(CONFIG, ['messages', 'active', 'components', componentName]) ||
    {}
  )
  return (path: string) => {
    const message = objectPath.get(componentMessages, path)
    if (typeof message === 'string') {
      return message
    } else {
      console.warn(`Couldn't find message entry for ${componentName}.${path}`)
      return `{${path}}`
    }
  }
}

export function isModuleEnabled (moduleName: ModuleType): boolean {
  const CONFIG: DataToolsConfig = window.DT_CONFIG
  return !!(
    objectPath.get(CONFIG, ['modules', moduleName, 'enabled'])
  )
}

export function isExtensionEnabled (extensionName: ExtensionType): boolean {
  const CONFIG: DataToolsConfig = window.DT_CONFIG
  return !!(
    objectPath.get(CONFIG, ['extensions', extensionName, 'enabled'])
  )
}

function initializeConfig () {
  if (!process.env.SETTINGS) {
    throw new Error('SETTINGS environment variable not set')
  }
  const config: DataToolsConfig = {
    ...DEFAULT_CONFIG,
    ...JSON.parse(process.env.SETTINGS)
  }
  if (config.modules.gtfsplus && config.modules.gtfsplus.enabled) {
    // $FlowFixMe - assume file exists and make flow happy
    const gtfsplus = require('../../../gtfsplus.yml')
    config.specifications.gtfsplus = gtfsplus
  }
  // $FlowFixMe - assume file exists and make flow happy
  const gtfs = require('../../../gtfs.yml')
  config.specifications.gtfs = gtfs

  const languages: Array<MessageFile> = [
    // $FlowFixMe - assume file exists and make flow happy
    require('../../../i18n/english.yml'),
    // $FlowFixMe - assume file exists and make flow happy
    require('../../../i18n/espanol.yml'),
    // $FlowFixMe - assume file exists and make flow happy
    require('../../../i18n/francais.yml')
  ]

  // For some weird reason that probably has to do with how yaml files are
  // required in the test environment, the message files are stored with an
  // object key that contains the full path. Therefore, do a little hack to
  // fix this.
  // TODO: change this in mastarm?
  if (process.env.NODE_ENV === 'test') {
    languages.forEach(lang => {
      Object.keys(lang).forEach(key => {
        if (key.indexOf('.') > -1) {
          objectPath.set(lang, key, lang[key])
        }
      })
    })
  }
  const languageId = window.localStorage.getItem('lang')
    ? window.localStorage.getItem('lang')
    : navigator.language
  const active = languages.find(l => l._id === languageId) ||
    languages.find(l => l._id === 'en-US')
  if (!active) throw new Error('Language file is misconfigured!')
  // is an array containing all the matching modules
  config.messages = {
    active,
    all: languages
  }
  // Set config to global.
  // TODO: remove window.DT_CONFIG in favor of keeping config entirely in store.
  window.DT_CONFIG = config
}

initializeConfig()