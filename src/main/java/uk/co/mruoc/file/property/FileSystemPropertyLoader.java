package uk.co.mruoc.file.property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.mruoc.file.FileSystemInputStreamLoader;

import java.util.Properties;

public class FileSystemPropertyLoader extends DefaultPropertyLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemPropertyLoader.class);

    public FileSystemPropertyLoader() {
        super(new FileSystemInputStreamLoader());
    }

    @Override
    public Properties load(String path) {
        LOGGER.info("loading file from file system path {}", path);
        return super.load(path);
    }

}
