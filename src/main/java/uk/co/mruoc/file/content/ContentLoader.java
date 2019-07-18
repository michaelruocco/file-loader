package uk.co.mruoc.file.content;

import uk.co.mruoc.file.content.ClasspathBase64FileContentLoader;
import uk.co.mruoc.file.content.ClasspathFileContentLoader;
import uk.co.mruoc.file.content.FileContentLoader;
import uk.co.mruoc.file.content.FileSystemBase64FileContentLoader;
import uk.co.mruoc.file.content.FileSystemFileContentLoader;

public class ContentLoader {

    private ContentLoader() {
        // utility class
    }

    public static String loadContentFromFileSystem(String path) {
        final FileContentLoader loader = new FileSystemFileContentLoader();
        return loader.loadContent(path);
    }

    public static String loadContentFromClasspath(String path) {
        final FileContentLoader loader = new ClasspathFileContentLoader();
        return loader.loadContent(path);
    }

    public static String loadBase64EncodedContentFromFileSystem(String path) {
        final FileContentLoader loader = new FileSystemBase64FileContentLoader();
        return loader.loadContent(path);
    }

    public static String loadBase64EncodedContentFromClasspath(String path) {
        final FileContentLoader loader = new ClasspathBase64FileContentLoader();
        return loader.loadContent(path);
    }

}
