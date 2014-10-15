package spud.media

import java.math.*

class SpudMediaTagLib {
    static namespace = 'sp'
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def humanFileSize = { attrs ->
        def size = new BigDecimal(attrs.size ?: 0)

        def measurement = ''
        if(size > 1024) {
            measurement = 'KB'
            size = size / 1024
        }

        if(size > 1024) {
            measurement = 'MB'
            size = size / 1024
        }
        if(size > 1024) {
            measurement = 'GB'
            size = size / 1024
        }

        size = size.setScale(1,RoundingMode.HALF_UP)
        out << "${size} ${measurement}"
    }

    def imageFromType = { attrs ->
        def contentType = attrs.contentType
        def imagePath = "spud/admin/files_thumbs/dat_thumb.png"
        if(contentType) {
            if(contentType =~ /jpeg|jpg/) {
                imagePath = "spud/admin/files_thumbs/jpg_thumb.png"
            }
            else if(contentType =~ /png/) {
                imagePath = "spud/admin/files_thumbs/png_thumb.png"
            }
            else if(contentType =~ /zip|tar|tar\.gz|gz/) {
                imagePath = "spud/admin/files_thumbs/zip_thumb.png"
            }
            else if(contentType =~ /xls|xlsx/) {
                imagePath = "spud/admin/files_thumbs/xls_thumb.png"
            }
            else if(contentType =~ /doc|docx/) {
                imagePath = "spud/admin/files_thumbs/doc_thumb.png"
            }
            else if(contentType =~ /ppt|pptx/) {
                imagePath = "spud/admin/files_thumbs/ppt_thumb.png"
            }
            else if(contentType =~ /txt|text/) {
                imagePath = "spud/admin/files_thumbs/txt_thumb.png"
            }
            else if(contentType =~ /pdf|ps/) {
                imagePath = "spud/admin/files_thumbs/pdf_thumb.png"
            }
            else if(contentType =~ /mp3|wav|aac/) {
                imagePath = "spud/admin/files_thumbs/mp3_thumb.png"
            }
        }

        out << g.assetPath(src:imagePath)
    }
}
