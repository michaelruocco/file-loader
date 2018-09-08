package uk.co.mruoc.file;

public class ContentLoader {

    private ContentLoader() {
        // utility class with only static methods
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
