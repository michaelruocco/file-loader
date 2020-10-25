package uk.co.mruoc.file.line;

import lombok.extern.slf4j.Slf4j;
import uk.co.mruoc.file.FileSystemBufferedReaderLoader;

import java.util.Collection;

@Slf4j
public class FileSystemFileLineLoader extends DefaultFileLineLoader {

    public FileSystemFileLineLoader() {
        super(new FileSystemBufferedReaderLoader());
    }

    @Override
    public Collection<String> loadLines(String path) {
        log.info("loading file lines from classpath using path {}", path);
        return super.loadLines(path);
    }

}
