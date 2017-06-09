// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'carhub.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'carhub.UserAuthority'
grails.plugin.springsecurity.authority.className = 'carhub.Authority'
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets*',      access: ['permitAll']],
	[pattern: 'js*',       access: ['permitAll']],
	[pattern: 'css*',      access: ['permitAll']],
	[pattern: 'images*',   access: ['permitAll']],
	[pattern: 'favicon.ico', access: ['permitAll']],
	[pattern: '/restOauth*',	 access: ['permitAll']],
	[pattern: '/login*', 		 access: ['permitAll']],
	[pattern: '/apidocs*', 		 access: ['permitAll']],
	[pattern: '/api/index',          access: ['permitAll']],
	[pattern: '/api/login',          access: ['permitAll']],
	[pattern: '/api/logout',        access: ['isFullyAuthenticated()']],
	[pattern: '/api/cars/v3/**',   	 access: ['isFullyAuthenticated()']],
	[pattern: '/api/cars/**',        access: ['permitAll']],
	[pattern: '*',             access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
		[pattern: '/api/cars/v3/**', filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter'],
		[pattern: '/api/login', filters:'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']
]

grails.plugin.springsecurity.rest.login.active=true
grails.plugin.springsecurity.rest.login.endpointUrl='/api/login'
grails.plugin.springsecurity.rest.logout.endpointUrl = '/api/logout'
grails.plugin.springsecurity.rest.token.validation.useBearerToken = false
grails.plugin.springsecurity.rest.token.validation.headerName = 'X-Auth-Token'
grails.plugin.springsecurity.rest.token.storage.memcached.hosts = 'localhost:11211'
grails.plugin.springsecurity.rest.token.storage.memcached.username = ''
grails.plugin.springsecurity.rest.token.storage.memcached.password = ''
grails.plugin.springsecurity.rest.token.storage.memcached.expiration = 86400
