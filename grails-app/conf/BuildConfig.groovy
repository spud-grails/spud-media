grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()

        mavenRepo 'http://dl.bintray.com/karman/karman'
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        // runtime 'mysql:mysql-connector-java:5.1.27'
    }

    plugins {
        runtime ":asset-pipeline:1.9.9"


        if(System.getProperty('plugin.mode') != 'local') {
            runtime ":selfie:0.3.5"
            runtime ":spud-core:0.6.1"

            runtime(':hibernate4:4.3.5.4') {
                export = false
            }
        }

        build(":release:3.0.1",
              ":rest-client-builder:1.0.3"
              ) {
            export = false
        }
    }
}

if(System.getProperty('plugin.mode') == 'local') {
    grails.plugin.location."spud-core" = "../spud-core"
    grails.plugin.location."selfie" = "../../plugins/selfie"

}
