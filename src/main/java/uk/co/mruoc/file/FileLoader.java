package uk.co.mruoc.file;

import java.util.Collection;
import java.util.Properties;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uk.co.mruoc.file.content.ClasspathBase64FileContentLoader;
import uk.co.mruoc.file.content.ClasspathFileContentLoader;
import uk.co.mruoc.file.content.FileContentLoader;
import uk.co.mruoc.file.content.FileSystemBase64FileContentLoader;
import uk.co.mruoc.file.content.FileSystemFileContentLoader;
import uk.co.mruoc.file.line.ClasspathFileLineLoader;
import uk.co.mruoc.file.line.FileLineLoader;
import uk.co.mruoc.file.line.FileSystemFileLineLoader;
import uk.co.mruoc.file.property.ClasspathPropertyFileLoader;
import uk.co.mruoc.file.property.FileSystemPropertyFileLoader;
import uk.co.mruoc.file.property.PropertyFileLoader;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileLoader {

    public static String loadContentFromFileSystem(String path) {
        FileContentLoader loader = new FileSystemFileContentLoader();
        return loader.loadContent(path);
    }

    public static String loadContentFromClasspath(String path) {
        FileContentLoader loader = new ClasspathFileContentLoader();
        return loader.loadContent(path);
    }

    public static Collection<String> loadContentLinesFromFileSystem(String path) {
        FileLineLoader loader = new FileSystemFileLineLoader();
        return loader.loadLines(path);
    }

    public static Collection<String> loadContentLinesFromClasspath(String path) {
        FileLineLoader loader = new ClasspathFileLineLoader();
        return loader.loadLines(path);
    }

    public static String loadBase64EncodedContentFromFileSystem(String path) {
        FileContentLoader loader = new FileSystemBase64FileContentLoader();
        return loader.loadContent(path);
    }

    public static String loadBase64EncodedContentFromClasspath(String path) {
        FileContentLoader loader = new ClasspathBase64FileContentLoader();
        return loader.loadContent(path);
    }

    public static Properties loadPropertiesFromFileSystem(String path) {
        PropertyFileLoader loader = new FileSystemPropertyFileLoader();
        return loader.loadProperties(path);
    }

    public static Properties loadPropertiesFromClasspath(String path) {
        PropertyFileLoader loader = new ClasspathPropertyFileLoader();
        return loader.loadProperties(path);
    }
}
