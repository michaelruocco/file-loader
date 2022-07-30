package uk.co.mruoc.file;

import java.io.BufferedReader;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileReaderLoader {

    public static BufferedReader loadReaderFromFileSystem(String path) {
        BufferedReaderLoader loader = new FileSystemBufferedReaderLoader();
        return loader.load(path);
    }

    public static BufferedReader loadReaderFromClasspath(String path) {
        BufferedReaderLoader loader = new ClasspathBufferedReaderLoader();
        return loader.load(path);
    }
}
