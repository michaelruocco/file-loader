package uk.co.mruoc.properties;

import java.io.InputStream;

public interface StreamLoader {

    InputStream load(String path);

}
