package uk.co.mruoc.file.line;

import java.util.Collection;

public class LineLoader {

    private LineLoader() {
        // utility class
    }

    public static Collection<String> loadLinesFromFileSystem(String path) {
        final FileLineLoader loader = new FileSystemFileLineLoader();
        return loader.loadLines(path);
    }

    public static Collection<String> loadLinesFromClasspath(String path) {
        final FileLineLoader loader = new ClasspathFileLineLoader();
        return loader.loadLines(path);
    }

}
