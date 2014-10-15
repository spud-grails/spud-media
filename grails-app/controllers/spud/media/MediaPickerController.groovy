package spud.media

import  spud.core.*
import  spud.security.*
import  spud.blog.*

@SpudSecure(['MEDIA'])
class MediaPickerController {
	static namespace="spud_admin"
	def index() {
		def media = SpudMedia.list([sort: 'dateCreated', order:'desc'] + params)
		render view: '/spud/admin/mediaPicker/index', model: [media: media]
	}

	def save() {
		println "Trying to save ${params}"
		def media = new SpudMedia(params.media)
		if(media.save(flush:true)) {
			if(request.getHeader('X-Requested-With')) {
		        render template: '/spud/admin/mediaPicker/media', model: [mediaItem: media]
				return
			} else {
				render template: '/spud/admin/mediaPicker/media', model: [mediaItem: media]
				return
			}
		}
		render text:'', status: 422
	}
}
