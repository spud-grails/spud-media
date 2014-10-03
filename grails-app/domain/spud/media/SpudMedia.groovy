package spud.media

import com.bertramlabs.plugins.selfie.Attachment
import com.bertramlabs.plugins.selfie.AttachmentUserType

class SpudMedia {

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
    Date dateCreated
    Date lastUpdated

    static constraints = {
        cropX nullable:true
        cropY nullable:true
        cropW nullable:true
        cropH nullable:true
        cropS nullable:true
    }

    static mapping = {
        def cfg = it?.getBean('grailsApplication')?.config
        datasource(cfg?.spud?.core?.datasource ?: 'DEFAULT')
        cache true
        table 'spud_media'
        autoTimestamp true
        dateCreated column: 'created_at'
        lastUpdated column: 'updated_at'

        attachment type: AttachmentUserType, {
            column name: "attachment_file_name"
            column name: "attachment_file_size"
            column name: "attachment_content_type"
        }
    }
}
