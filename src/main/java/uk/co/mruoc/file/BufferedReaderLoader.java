package uk.co.mruoc.file;

import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RequiredArgsConstructor
public class BufferedReaderLoader {

    private final InputStreamLoader streamLoader;

    public BufferedReader load(String path) {
        InputStreamReader streamReader = new InputStreamReader(streamLoader.load(path));
        return new BufferedReader(streamReader);
    }

}
