import org.codehaus.groovy.grails.web.context.ServletContextHolder as SCH

class SpudMediaGrailsPlugin {
    def version = "0.6.2"
    def grailsVersion = "2.3 > *"
    def loadAfter = ['spud-core']

    def title = "Spud Media Plugin"
    def author = "David Estes"
    def authorEmail = "destes@bcap.com"
    def description = 'Provides Media management for Spud'

    def documentation = "https://github.com/spud-grails/spud-media"
    def license = "APACHE"
    def organization = [name: "Bertram Labs", url: "http://www.bertramlabs.com/"]
    def issueManagement = [system: "GITHUB", url: "https://github.com/spud-grails/spud-media/issues"]
    def scm             = [url: "https://github.com/spud-grails/spud-media"]

    def doWithSpring = {
        applyDefaultConfiguration(application.config)
    }

    def onConfigChange = { event ->
        applyDefaultConfiguration(application.config)
    }

    def applyDefaultConfiguration(config) {
        def selfieConf = config.grails.plugin.selfie
        if (selfieConf.domain.containsKey('spudMedia') || selfieConf.containsKey('storage')) {
            return
        }

        def karmanConf = config.grails.plugin.karman
        def mapping = karmanConf.serveLocalMapping ?: 'storage'
        def basePath = karmanConf.storagePath ?: 'storage'
        selfieConf.domain.spudMedia = [
            storage: [
                bucket: 'default',
                providerOptions: [
                    provider:'local',
                    basePath: basePath,
                    baseUrl:"http://localhost:8080${SCH.servletContext?.contextPath ?: ''}/${mapping}"
                ]
            ]
        ]
    }
}
