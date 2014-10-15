<div class="spud_media_picker_item"
	data-id="${mediaItem.id}"
	data-type="${mediaItem.isImage() ? 'img' : 'file'}"
	data-url="${mediaItem.attachment.url('original')}"
	data-name="${mediaItem.attachment.fileName}"
	data-size="${mediaItem.attachment.fileSize}"
	data-lastmod="${mediaItem.lastUpdated}"
	data-protected="${mediaItem.isProtected ? 'Yes' : 'No'}"
>
	<span class="spud_media_picker_item_thumb">
		<img src="${mediaItem.imageFromType}" class="size-50-thumb" />
	</span>
	<span class="spud_media_picker_item_filename">
		${mediaItem.attachment.fileName}
	</span>
</div>
