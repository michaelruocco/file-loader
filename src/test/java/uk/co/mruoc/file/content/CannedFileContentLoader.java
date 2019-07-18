package uk.co.mruoc.file.content;

import uk.co.mruoc.file.content.FileContentLoader;

public class CannedFileContentLoader implements FileContentLoader {

    @Override
    public String loadContent(String path) {
        return "canned file content";
    }

}
