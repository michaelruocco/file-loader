package uk.co.mruoc.file;

import java.io.InputStream;

public class FakeInputStreamLoader implements InputStreamLoader {

    private String path;
    private InputStream inputStream;

    @Override
    public InputStream load(String path) {
        this.path = path;
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getLastLoadedPath() {
        return path;
    }
}
