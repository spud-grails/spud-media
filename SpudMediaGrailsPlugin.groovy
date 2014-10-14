class SpudMediaGrailsPlugin {
    // the plugin version
    def version = "0.1.0"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.3 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Spud Media Plugin" // Headline display name of the plugin
    def author = "David Estes"
    def authorEmail = "destes@bcap.com"
    def description = 'Provides Media management for Spud'

    def documentation = "https://github.com/spud-grails/spud-media"
    def license = "APACHE"
    def organization = [name: "Bertram Labs", url: "http://www.bertramlabs.com/"]
    def issueManagement = [system: "GITHUB", url: "https://github.com/spud-grails/spud-media/issues"]

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
        applyDefaultConfiguration(application.config)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { ctx ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
        applyDefaultConfiguration(application.config)
    }

    def onShutdown = { event ->
        // TODO Implement code that is executed when the application shuts down (optional)
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
                        baseUrl:"http://localhost:8080${servletContext.contextPath ?: ''}/${mapping}"
                    ]
                ]
            ]
        }
    }
}
