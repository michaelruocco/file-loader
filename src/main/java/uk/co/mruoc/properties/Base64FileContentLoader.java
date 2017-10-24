package uk.co.mruoc.properties;

public class Base64FileContentLoader implements FileContentLoader {

    private final Base64Encoder base64Encoder = new Base64Encoder();
    private final FileContentLoader contentLoader;

    public Base64FileContentLoader(FileContentLoader contentLoader) {
        this.contentLoader = contentLoader;
    }

    @Override
    public String loadContent(String path) {
        String content = contentLoader.loadContent(path);
        return base64Encoder.encode(content);
    }

}
