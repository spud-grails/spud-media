package spud.media

import com.bertramlabs.plugins.selfie.Attachment

class SpudMedia {

    private static final IMAGE_TYPES = ['jpeg', 'jpg', 'png', 'gif']

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
    static mapping = { ctx ->
        def cfg = ctx?.grailsApplication?.config
        datasource(cfg?.spud?.core?.datasource ?: 'DEFAULT')
        cache true
        table 'spud_media'
        autoTimestamp true
        dateCreated column: 'created_at'
        lastUpdated column: 'updated_at'
    }

    boolean isImage() {
        log.debug "Checking Content ${attachment?.contentType}"
        IMAGE_TYPES.any { attachment?.contentType?.contains it }
    }

    boolean isPdf() {
        attachment?.contentType?.contains('pdf')
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
