[![LGPL 2.1](https://img.shields.io/badge/License-LGPL_2.1-blue.svg)](https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.tagtraum/japlphoto/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.tagtraum/japlphoto)
[![Build and Test](https://github.com/japlscript/japlphoto/workflows/Build%20and%20Test/badge.svg)](https://github.com/japlscript/japlphoto/actions)


# Japlphoto

*Japlphoto* is a Java API for the Apple Photos app (macOS) based on
[JaplScript](https://github.com/japlscript/japlscript).


## Installation

Japlphoto is released via [Maven](https://maven.apache.org).
You can install it via the following dependency:

```xml
<dependency>
    <groupId>com.tagtraum</groupId>
    <artifactId>japlphoto</artifactId>
</dependency>
```

The Maven artifacts also contain sources and javadocs. 

If you are using [modules](https://en.wikipedia.org/wiki/Java_Platform_Module_System),
its name is `tagtraum.japlphoto`.


## Usage
                           
To use the generated code, do something like this:

```java
import com.tagtraum.macos.photos.Application;

public class AllAlbumNames {

    public static void main(final String[] args) {
        // get application
        final Application application = Application.getInstance();
        // get albums
        final Album[] albums = application.getAlbums();
        
        for (final Album album : albums) {
            // print name and size
            System.out.println(album.getName() + ", size=" + album.countMediaItems());
        }
    }
}
```

## API

You can find the complete [API here](https://japlscript.github.io/japlphoto/com/tagtraum/macos/photos/package-summary.html). 


## Shipping

For information about shipping apps with this library, please see
the corresponding notes about signing, notarization etc. in the
[JaplScript documentation](https://github.com/japlscript/japlscript/blob/main/README.md).
