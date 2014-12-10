# Spud Grails Media

The `spud-media` grails plugin adds support for media file management to your spud content management site.
Using selfie and karman, spud can support uploading to both your local filesystem as well as s3 and more to come as karman expands.

**Features:**

* Configurable Storage
* Add-on for Wysiwyg tiny-mce
* Protected File Support (Coming Soon)
* On the fly cropping (Coming Soon)
* MultiSite compatible

## Installation

Add the `spud-media` module to your grails app  (works optimally with other spud moduels like spud-cms).

```groovy
repositories {
  //NO MORE CUSTOM REPO
}
plugins {
  compile ':spud-media:0.6.6'
}
```

## Configuration

This plugin supports several configuration options for setting up your media storage.

The default storage settings place your files in the current directories `storage` folder. This can be configured via the grails [selfie](http://grails.org/plugins/selfie) plugin.

The default values should get you started, but as you can see it's definitely customizable for your needs.

### Using an Alternative DataSource

Spud supports running on a different datasource than your primary. This can be done by adding the following config example:

```groovy
spud {
	core {
		//By default this uses the DEFAULT datasource
		datasource = 'spud' //Set datasource name here
	}
}
```

## Usage

Simply point your browser to the spud admin dashboard (i.e. `http://localhost:8080/myapp/spud/admin`),
and you should see a Media module on your dashboard (depending on which is enabled via config).


## Additional Resources

* Write your blog posts with [spud-blog](http://github.com/spud-grails/spud-blog)!
* Drop into a content management system with [spud-cms](http://github.com/spud-grails/spud-cms)!
