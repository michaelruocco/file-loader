package uk.co.mruoc.file;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderLoader {

    private final InputStreamLoader streamLoader;

    public BufferedReaderLoader(final InputStreamLoader streamLoader) {
        this.streamLoader = streamLoader;
    }

    public BufferedReader load(String path) {
        final InputStreamReader streamReader = new InputStreamReader(streamLoader.load(path));
        return new BufferedReader(streamReader);
    }

}
