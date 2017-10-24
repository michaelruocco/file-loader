package uk.co.mruoc.properties;

public class CannedFileContentLoader implements FileContentLoader {

    @Override
    public String loadContent(String path) {
        return "canned file content";
    }

}
