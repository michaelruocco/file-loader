package uk.co.mruoc.file.line;

import java.util.Collection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LineLoader {

    public static Collection<String> loadLinesFromFileSystem(String path) {
        final FileLineLoader loader = new FileSystemFileLineLoader();
        return loader.loadLines(path);
    }

    public static Collection<String> loadLinesFromClasspath(String path) {
        final FileLineLoader loader = new ClasspathFileLineLoader();
        return loader.loadLines(path);
    }
}
