<g:applyLayout name="spud/admin/detail" >
	<content tag="detail">
		<g:uploadForm name="upload" url="[action:'save',resource:'media',namespace:'spud_admin',format: 'POST']" class="form-horizontal">
			<fieldset>
				<legend>Upload Media</legend>

				<div class="form-group">
					<label for="media.attachment" class="control-label col-sm-4">Choose File</label>
					<div class="col-sm-8">
						<input type="file" name="media.attachment" /><br/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-8 col-sm-offset-4">
						<g:submitButton name="update" value="Upload" class="btn btn-primary" data-loading-text="Uploading..." /> or <spAdmin:link action="index" class="btn">cancel</spAdmin:link>
					</div>
				</div>
			</fieldset>
		</g:uploadForm>
	</content>
</g:applyLayout>
