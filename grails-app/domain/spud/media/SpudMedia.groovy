package spud.media

import com.bertramlabs.plugins.selfie.Attachment

class SpudMedia {

    static transients = ['imageFromType']

    static attachmentOptions = [
    attachment: [
    styles: [
    thumb: [width: 50, height: 50, mode: 'fit'],
    medium: [width: 250, height: 250, mode: 'scale']
    ]

    ]
    ]

    Attachment attachment
    Integer cropX
    Integer cropY
    Integer cropW
    Integer cropH
    Integer cropS

    Boolean isProtected=false
    Integer siteId=0
    Date dateCreated
    Date lastUpdated

    static constraints = {
        cropX nullable:true
        cropY nullable:true
        cropW nullable:true
        cropH nullable:true
        cropS nullable:true
    }
    static embedded = ['attachment']
    static mapping = {
        def cfg = it?.getBean('grailsApplication')?.config
        datasource(cfg?.spud?.core?.datasource ?: 'DEFAULT')
        cache true
        table 'spud_media'
        autoTimestamp true
        dateCreated column: 'created_at'
        lastUpdated column: 'updated_at'
    }


    def isImage() {
        println "Checking COntent ${attachment?.contentType}"
        if(attachment?.contentType?.contains('jpeg') || attachment?.contentType?.contains('jpg') || attachment?.contentType?.contains('png') || attachment?.contentType?.contains('gif')) {
            true
        } else {
            false
        }
    }

    def isPdf() {
        if(attachment?.contentType?.contains('pdf')) {
            true
        } else {
            false
        }
    }

    def grailsCacheAdminService
    def afterInsert() {
        grailsCacheAdminService.clearAllCaches()
    }

    def afterUpdate() {
        grailsCacheAdminService.clearAllCaches()
    }

    def afterDelete() {
        grailsCacheAdminService.clearAllCaches()
    }
}
