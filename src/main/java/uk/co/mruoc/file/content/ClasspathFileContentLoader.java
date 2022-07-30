package uk.co.mruoc.file.content;

import lombok.extern.slf4j.Slf4j;
import uk.co.mruoc.file.ClasspathInputStreamLoader;

@Slf4j
public class ClasspathFileContentLoader extends DefaultFileContentLoader {

    public ClasspathFileContentLoader() {
        super(new ClasspathInputStreamLoader());
    }

    @Override
    public String loadContent(String path) {
        log.debug("loading file content from classpath using path {}", path);
        return super.loadContent(path);
    }
}
