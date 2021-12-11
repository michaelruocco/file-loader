package uk.co.mruoc.file.content;


public class CannedFileContentLoader implements FileContentLoader {

    @Override
    public String loadContent(String path) {
        return "canned file content";
    }

}
