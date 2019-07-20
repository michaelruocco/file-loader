package uk.co.mruoc.file;

import java.io.BufferedReader;

public class FileReaderLoader {

    private FileReaderLoader() {
        // utility class
    }

    public static BufferedReader loadReaderFromFileSystem(String path) {
        final BufferedReaderLoader loader = new FileSystemBufferedReaderLoader();
        return loader.load(path);
    }

    public static BufferedReader loadReaderFromClasspath(String path) {
        final BufferedReaderLoader loader = new ClasspathBufferedReaderLoader();
        return loader.load(path);
    }

}
