//= require /spud/admin/tiny_mce
/**
 * editor_plugin_src.js
 *
 * Copyright 2009, Moxiecode Systems AB
 * Released under LGPL License.
 *
 * License: http://tinymce.moxiecode.com/license
 * Contributing: http://tinymce.moxiecode.com/contributing
 */

(function() {

  // Tell spud about our plugin and button
  window.SpudTinyMCE.registerPlugin('spud_media_picker');
  window.SpudTinyMCE.registerButton('spud_media_picker');

  tinymce.create('tinymce.plugins.SpudMediaPicker', {
    /**
     * Initializes the plugin, this will be executed after the plugin has been created.
     * This call is done before the editor instance has finished it's initialization so use the onInit event
     * of the editor instance to intercept that event.
     *
     * @param {tinymce.Editor} ed Editor instance that the plugin is initialized in.
     * @param {string} url Absolute URL to where the plugin is located.
     */
    init : function(ed, url) {
      // Register the command so that it can be invoked by using tinyMCE.activeEditor.execCommand('mceExample');
      ed.addCommand('spudMediaShowPicker', function(){
        ed.windowManager.open({
          title: 'Spud Media Picker',
          file: window.contextPath + '/spud/admin/media_picker',
          width: 450 + parseInt(ed.getLang('example.delta_width', 0), 10),
          height: 300 + parseInt(ed.getLang('example.delta_height', 0), 10),
          inline: 1,
          resizable: false,
          popup_css: false, // prevent tinymce from injecting some default css into our dialog box
          close_previous: true, // close any previously opened dialogs
          scrollbars: false
        });
      });

      // Register picker button
      ed.addButton('spud_media_picker', {
        title: 'Insert Spud Media',
        cmd: 'spudMediaShowPicker',
        image: window.assetPath + 'spud/admin/media_tiny.png'
      });

      ed.addCommand('spudMediaInsertSelected', function(ui, data){
        if(data.type == 'img'){
          var img = ed.dom.createHTML('img', {
            src: data.url,
            title: data.title,
            style: data.style,
            width: data.width,
            height: data.height
          });
          ed.execCommand('mceInsertContent', false, img);
        }
        else{
          var link = ed.dom.createHTML('a', {
            href: data.url,
            target: data.target
          }, data.text);
          ed.execCommand('mceInsertContent', false, link);
        }
      });

      /*
      * Add a node change handler, selects the button in the UI when a image is selected
      * @param {tinymce.Editor} ed Editor
      * @param {tinymce.ControlManager} cm
      * @param {node} n
      */
      // ed.onNodeChange.add(function(ed, cm, n) {
      //   cm.setActive('spud_media_picker', n.nodeName == 'IMG');
      // });
    },

    /**
     * Returns information about the plugin as a name/value array.
     * The current keys are longname, author, authorurl, infourl and version.
     *
     * @return {Object} Name/value array containing information about the plugin.
     */
    getInfo: function(){
      return {
        longname : 'Spud Media',
        author : 'Greg Woods, David Estes',
        authorurl : 'https://github.com/spud-grails/spud-media',
        infourl : 'https://github.com/spud-grails/spud-media',
        version : "1.0"
      };
    }
  });

  // Register plugin
  tinymce.PluginManager.add('spud_media_picker', tinymce.plugins.SpudMediaPicker);
})();
