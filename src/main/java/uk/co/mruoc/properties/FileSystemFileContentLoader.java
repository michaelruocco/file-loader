package uk.co.mruoc.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSystemFileContentLoader extends DefaultFileContentLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemFileContentLoader.class);

    public FileSystemFileContentLoader() {
        super(new FileSystemInputStreamLoader());
    }

    @Override
    public String loadContent(String path) {
        LOGGER.info("loading file content from file system path " + path);
        return super.loadContent(path);
    }

}
