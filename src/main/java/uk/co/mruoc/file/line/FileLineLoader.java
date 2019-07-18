package uk.co.mruoc.file.line;

import java.util.Collection;

public interface FileLineLoader {

    Collection<String> loadLines(String path);

}
