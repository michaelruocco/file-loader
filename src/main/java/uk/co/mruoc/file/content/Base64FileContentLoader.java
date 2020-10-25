package uk.co.mruoc.file.content;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Base64FileContentLoader implements FileContentLoader {

    private final Base64Encoder base64Encoder = new Base64Encoder();
    private final FileContentLoader contentLoader;

    @Override
    public String loadContent(String path) {
        String content = contentLoader.loadContent(path);
        String base64 = base64Encoder.encode(content);
        log.info("converted content {}} into base64 {}", content, base64);
        return base64;
    }

}
