package spud.media

import spud.core.SpudSecure

@SpudSecure(['MEDIA'])
class MediaPickerController {
	static namespace="spud_admin"
	def spudMultiSiteService

	def index() {
		def mediaCriteria = {
			eq('siteId',spudMultiSiteService.activeSite.siteId)
		}
		def media = SpudMedia.createCriteria().list([sort: 'dateCreated', order:'desc'] + params,mediaCriteria)

		render view: '/spud/admin/mediaPicker/index', model: [media: media]
	}

	def save() {
		log.debug "Trying to save ${params}"
		def media = new SpudMedia(params.media)
		if(media.save(flush:true)) {
			render template: '/spud/admin/mediaPicker/media', model: [mediaItem: media]
		}
		else {
			render text:'', status: 422
		}
	}
}
