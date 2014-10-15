<html>
<head>
  <title>Spud Media Picker</title>
  <asset:javascript src="spud/admin/application.js"/>
  <asset:stylesheet href="spud/admin/application.css"/>
  <asset:javascript src="spud/tiny_mce/tiny_mce_popup"/>
</head>
<body class="spud_media_picker">

  <div class="spud_media_picker_container">

    <div class="spud_media_picker_tabs">
      <a class="spud_media_picker_tab" href="#spud_media_picker_tab_upload">Upload</a>
      <a class="spud_media_picker_tab" href="#spud_media_picker_tab_choose">Choose</a>
      <a class="spud_media_picker_tab" href="#spud_media_picker_tab_advanced">Advanced</a>
    </div>

    <div class="spud_media_picker_tab_body spud_media_picker_tab_upload">
		<g:uploadForm name="upload" url="[action:'save',resource:'mediaPicker',namespace:'spud_admin',format: 'POST']" class="spud_media_picker_upload_form" target="spud_media_picker_upload_target">
				<label for="media.attachment">Upload New File</label>

				<input type="file" name="media.attachment" id="spud_media_attachment" /><br/>


				<div class="progress progress-striped active spud_media_picker_upload_progress">
				<div class="bar"></div>
				</div>
				<div class="spud_media_picker_buttons">
					<g:submitButton name="update" value="Upload" class="btn btn-primary btn-xs spud_media_picker_tab_upload_submit"/>
					<a href="#" class="btn btn-xs spud_media_picker_button_cancel">Cancel</a>
				</div>

		</g:uploadForm>
    </div>

    <div class="spud_media_picker_tab_body spud_media_picker_tab_choose">
      <div class="spud_media_picker_list">
		<g:render template="/spud/admin/mediaPicker/media" collection="${media}" var="mediaItem"/>
      </div>
      <div class="spud_media_picker_details">
        <img src="" class="spud_media_picker_details_thumb" />
        <ul class="spud_media_picker_details_meta">
          <li>File Name: <span class="spud_media_picker_details_name"></span></li>
          <li>File Size: <span class="spud_media_picker_details_size"></span></li>
          <li>Last Modified: <span class="spud_media_picker_details_lastmod"></span></li>
          <li>Protected: <span class="spud_media_picker_details_protected"></span></li>
        </ul>
      </div>
      <div class="spud_media_picker_buttons">
        <a href='#' class='btn btn-mini btn-primary spud_media_picker_button_use_selected'>Use Selected</a>
        <a href='#' class='btn btn-mini btn-primary spud_media_picker_button_cancel'>Cancel</a>
      </div>
    </div>

    <div class="spud_media_picker_tab_body spud_media_picker_tab_advanced">
      <div class="spud_media_picker_option spud_media_picker_option_selected_file">
        <label>Selected File:</label>
        <input name="spud_media_picker_option_selected_file" type="text" disabled="disabled" />
      </div>
      <div class="spud_media_picker_option spud_media_picker_option_type">
        <label>Media Type:</label>
        <input name="spud_media_picker_option_type" type="text" disabled="disabled" />
      </div>
      <div class="spud_media_picker_option spud_media_picker_option_target">
        <label>Open Link In:</label>
        <select name="spud_media_picker_option_target">
          <option value="">Same Window</option>
          <option value="_blank">New Window</option>
        </select>
      </div>
      <div class="spud_media_picker_option spud_media_picker_option_text">
        <label>Link Text:</label>
        <input name="spud_media_picker_option_text" type="text" />
      </div>
      <div class="spud_media_picker_option spud_media_picker_option_float">
        <label>Float Image:</label>
        <select name="spud_media_picker_option_float">
          <option value="none">Normal</option>
          <option value="left">Left</option>
          <option value="right">Right</option>
        </select>
      </div>
      <div class="spud_media_picker_option spud_media_picker_option_title">
        <label>Title:</label>
        <input name="spud_media_picker_option_title" type="text" />
      </div>
      <div class="spud_media_picker_option spud_media_picker_option_dimensions">
        <label>Dimensions:</label>
        <input name="spud_media_picker_option_dimension_w" type="text" placeholder="auto" /> px by <input name="spud_media_picker_option_dimension_h" type="text" placeholder="auto" /> px
      </div>
      <div class="spud_media_picker_buttons">
        <a href='#' class="btn btn-mini btn-primary spud_media_picker_button_insert">Insert</a>
        <a href='#' class="btn btn-mini btn-primary spud_media_picker_button_cancel">Cancel</a>

      </div>
    </div>

  </div>

  <iframe id="spud_media_picker_upload_target" name="spud_media_picker_upload_target" style="display:none;"></iframe>

  <script>
    $(document).ready(spud.admin.mediapicker.init);
  </script>

</body>
</html>
