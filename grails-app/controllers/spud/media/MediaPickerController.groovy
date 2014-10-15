package spud.media

import  spud.core.*
import  spud.security.*
import  spud.blog.*

@SpudSecure(['MEDIA'])
class MediaController {
	def index() {
		def media = SpudMedia.list([sort: 'dateCreated', order:'desc'] + params)
		render view: '/spud/admin/mediaPicker/index', model: [media: media]
	}
}
