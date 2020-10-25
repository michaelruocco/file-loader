package uk.co.mruoc.file.property;

import lombok.extern.slf4j.Slf4j;
import uk.co.mruoc.file.ClasspathInputStreamLoader;

import java.util.Properties;

@Slf4j
public class ClasspathPropertyLoader extends DefaultPropertyLoader {

    public ClasspathPropertyLoader() {
        super(new ClasspathInputStreamLoader());
    }

    @Override
    public Properties load(String path) {
        log.info("loading file from classpath using path {}", path);
        return super.load(path);
    }

}
