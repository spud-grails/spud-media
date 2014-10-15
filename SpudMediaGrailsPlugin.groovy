class SpudMediaGrailsPlugin {
    // the plugin version
    def version = "0.6.0"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.3 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Spud Media Plugin" // Headline display name of the plugin
    def author = "David Estes"
    def authorEmail = "destes@bcap.com"
    def description = 'Provides Media management for Spud'

    def documentation = "https://github.com/spud-grails/spud-media"
    def license = "APACHE"
    def organization = [name: "Bertram Labs", url: "http://www.bertramlabs.com/"]
    def issueManagement = [system: "GITHUB", url: "https://github.com/spud-grails/spud-media/issues"]

    def doWithSpring = {
        applyDefaultConfiguration(application.config)
    }


    def onConfigChange = { event ->
        applyDefaultConfiguration(application.config)
    }

    def applyDefaultConfiguration(config) {
        if(!config.grails.plugin.selfie.domain.containsKey('spudMedia') && !config.grails.plugin.selfie.containsKey('storage')) {
            def mapping = config.grails.plugin.karman.serveLocalMapping ?: 'storage'
            def basePath = config.grails.plugin.karman.storagePath ?: 'storage'
            def servletContext = org.codehaus.groovy.grails.web.context.ServletContextHolder.getServletContext()
            config.grails.plugin.selfie.domain.'spudMedia' = [
                storage: [
                    bucket: 'default',
                    providerOptions: [
                        provider:'local',
                        basePath: basePath,
                        baseUrl:"http://localhost:8080${servletContext?.contextPath ?: ''}/${mapping}"
                    ]
                ]
            ]
        }
    }
}
