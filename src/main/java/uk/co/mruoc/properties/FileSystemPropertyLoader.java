package uk.co.mruoc.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class FileSystemPropertyLoader extends DefaultPropertyLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemPropertyLoader.class);

    public FileSystemPropertyLoader() {
        super(new FileSystemStreamLoader());
    }

    @Override
    public Properties load(String path) {
        LOGGER.info("loading properties from file system path " + path);
        return super.load(path);
    }

}
