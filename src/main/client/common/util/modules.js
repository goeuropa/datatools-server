export const getFeed = (feeds, id) => {
  // console.log(feeds, id)
  const useMtc = DT_CONFIG.modules.gtfsapi.use_extension === 'mtc'
  const feed = feeds ? feeds.find(f => useMtc ? f.externalProperties.MTC.AgencyId === id : f.id === id) : null
  return feed
}

export const getFeedId = (feed) => {
  const useMtc = DT_CONFIG.modules.gtfsapi.use_extension === 'mtc'
  return !feed ? null : useMtc ? feed.externalProperties.MTC.AgencyId : feed.id
}

export const getAlertsUrl = () => {
  return DT_CONFIG.modules.alerts.use_extension === 'mtc' ? DT_CONFIG.extensions.mtc.rtd_api + '/ServiceAlert' : '/api/manager/secure/alerts'
}

export const getSignConfigUrl = () => {
  return DT_CONFIG.modules.sign_config.use_extension === 'mtc' ? DT_CONFIG.extensions.mtc.rtd_api + '/DisplayConfiguration' : '/api/manager/secure/displays'
}

export const getDisplaysUrl = () => {
  return DT_CONFIG.modules.sign_config.use_extension === 'mtc' ? DT_CONFIG.extensions.mtc.rtd_api + '/Display' : '/api/manager/secure/displays'
}