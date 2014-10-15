<div class="spud_media_picker_item"
	data-id="${mediaItem.id}"
	data-type="${mediaItem.isImage() ? 'img' : 'file'}"
	data-url="${mediaItem.attachment.url('original')}"
	data-name="${mediaItem.attachment.fileName}"
	data-size="${sp.humanFileSize(size:mediaItem.attachment.fileSize)}"
	data-lastmod="${formatDate(format: "MM/dd/yyyy hh:mm a", date: mediaItem.lastUpdated)}"
	data-protected="${mediaItem.isProtected ? 'Yes' : 'No'}"
>
	<span class="spud_media_picker_item_thumb">
		<img src="${mediaItem.isImage() ? mediaItem.attachment.url('thumb') : sp.imageFromType(contentType: mediaItem.attachment.contentType) }" class="size-50-thumb" />
	</span>
	<span class="spud_media_picker_item_filename">
		${mediaItem.attachment.fileName}
	</span>
</div>
