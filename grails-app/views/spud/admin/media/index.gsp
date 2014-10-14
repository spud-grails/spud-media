<g:applyLayout name="spud/admin/detail" >

<content tag="data_controls">
  <spAdmin:link action="create" title="Upload File" class="btn btn-sm btn-primary">Upload File</spAdmin:link>
</content>
<content tag="detail">
  <div class="page_list">
	<g:each var="mediaItem" in ="${media}">
				<div class="page_row">

				<span class="row_meta">
					<img src="${mediaItem.imageFromType}" class="size-50-thumb" />
					<g:link url="${mediaItem.attachment.url('original')}">${mediaItem.attachment.fileName}</g:link>
				</span>

				<span class="edit_controls">
		            <spAdmin:link action="delete" id="${mediaItem.id}" data-confirm="Are you sure you want to remove this file?" data-method="DELETE" method="DELETE" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></spAdmin:link>
				</span>

				<br style="clear:both;"/>
			</div>
	</g:each>

	<g:paginate action="index" namespace="spud_admin" total="${mediaCount}" max="25" />

  </div>
</content>

</g:applyLayout>
