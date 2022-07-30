package uk.co.mruoc.file.property;

import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import uk.co.mruoc.file.FileSystemInputStreamLoader;

@Slf4j
public class FileSystemPropertyLoader extends DefaultPropertyLoader {

    public FileSystemPropertyLoader() {
        super(new FileSystemInputStreamLoader());
    }

    @Override
    public Properties load(String path) {
        log.debug("loading file from file system path {}", path);
        return super.load(path);
    }
}
