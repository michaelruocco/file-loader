package uk.co.mruoc.file.content;

public class FakeFileContentLoader implements FileContentLoader {

    private String path;
    private String content;

    @Override
    public String loadContent(String path) {
        this.path = path;
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLastLoadedPath() {
        return path;
    }

}
