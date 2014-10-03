package spud.media

import  spud.core.*
import  spud.security.*
import  spud.blog.*

@SpudApp(name="Media", thumbnail="spud/admin/media_icon.png", order="3")
@SpudSecure(['MEDIA'])
class MediaController {
    static namespace = "spud_admin"
    def index() {
        def media = SpudMedia.list([sort: 'dateCreated', order:'desc', max:25] + params)
        render view: '/spud/admin/media/index', model: [media: media, mediaCount: SpudMedia.count()]
    }

    def create() {
        def media = new SpudMedia()
        render view: '/spud/admin/media/create', model: [media: media]
    }

    def save() {
        def media = new SpudMedia(params.media)

        if(!media.save(flush:true)) {
            flash.error("Error Uploading Attachment")
            redirect action: 'index'
            return
        }

        flash.notice = 'Successfully uploaded ${media.attachment?.fileName}'
        redirect action: 'index'
    }

    def delete() {
        def media = loadMedia()
        if(!media) {
            return
        }

        media.delete(flush:true)
        redirect action: 'index'
    }

    private loadMedia() {
        def media = SpudMedia.get(params.long('id'))
        if(!media) {
            flash.error = 'Media Object not found!'
            redirect action: 'index'
            return false
        }
        return media
    }
}