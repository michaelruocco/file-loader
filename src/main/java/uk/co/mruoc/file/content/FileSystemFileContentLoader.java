package uk.co.mruoc.file.content;

import lombok.extern.slf4j.Slf4j;
import uk.co.mruoc.file.FileSystemInputStreamLoader;

@Slf4j
public class FileSystemFileContentLoader extends DefaultFileContentLoader {

    public FileSystemFileContentLoader() {
        super(new FileSystemInputStreamLoader());
    }

    @Override
    public String loadContent(String path) {
        log.info("loading file content from file system path {}", path);
        return super.loadContent(path);
    }

}
