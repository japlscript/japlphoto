/*
 * =================================================
 * Copyright 2021 tagtraum industries incorporated
 * All rights reserved.
 * =================================================
 */
package com.tagtraum.macos.photos;

import com.tagtraum.japlscript.JaplScript;
import com.tagtraum.japlscript.execution.Timeout;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * TestApplication.
 *
 * @author <a href="mailto:hs@tagtraum.com">Hendrik Schreiber</a>
 */
public class TestApplication {

    @BeforeClass
    public static void beforeClass() {
        // Photos can be extra slow to respond.
        JaplScript.addGlobalAspect(new Timeout(600));
    }

    @Test
    public void testVersion() {
        final Application application = Application.getInstance();
        final String version = application.getVersion();
        assertNotNull(version);
        assertFalse(version.trim().isEmpty());
    }

    @Test
    public void testLibraryPhotoCount() {
        final Application application = Application.getInstance();
        System.out.println("Media items: " + application.countMediaItems());
    }

    @Test
    public void testGetAlbumNames() {
        final Application application = Application.getInstance();
        final Album[] albums = application.getAlbums();
        for (final Album album : albums) {
            System.out.println(album.getName() + ", size=" + album.countMediaItems());
        }
    }

    @Test
    public void testLocation() {
        // this is more of a demo than a test
        final Application application = Application.getInstance();
        final Album[] albums = application.getAlbums();
        for (final Album album : albums) {
            // ensure we don't look through super large collections,
            // because Photos (via AppleScript) sucks at that.
            if (album.countMediaItems() < 100) {
                final MediaItem[] mediaItems = album.getMediaItems("altitude > 10");
                for (final MediaItem mediaItem : mediaItems) {
                    final double[] location = mediaItem.getLocation();
                    System.out.println("Altitude: " + mediaItem.getAltitude() + ", Location: " + Arrays.toString(location));
                    return;
                }
            }
        }
    }
}
