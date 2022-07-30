package uk.co.mruoc.file.content;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContentLoader {

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
