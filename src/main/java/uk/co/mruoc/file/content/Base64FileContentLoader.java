package uk.co.mruoc.file.content;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base64FileContentLoader implements FileContentLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(Base64FileContentLoader.class);

    private final Base64Encoder base64Encoder = new Base64Encoder();
    private final FileContentLoader contentLoader;

    public Base64FileContentLoader(FileContentLoader contentLoader) {
        this.contentLoader = contentLoader;
    }

    @Override
    public String loadContent(String path) {
        String content = contentLoader.loadContent(path);
        String base64 = base64Encoder.encode(content);
        LOGGER.info("converted content {}} into base64 {}", content, base64);
        return base64;
    }

}
