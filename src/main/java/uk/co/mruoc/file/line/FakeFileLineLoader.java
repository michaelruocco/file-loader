package uk.co.mruoc.file.line;

import java.util.Collection;

public class FakeFileLineLoader implements FileLineLoader {

    private String path;
    private Collection<String> lines;

    @Override
    public Collection<String> loadLines(String path) {
        this.path = path;
        return lines;
    }

    public void setLines(Collection<String> lines) {
        this.lines = lines;
    }

    public String getLastLoadedPath() {
        return path;
    }

}
