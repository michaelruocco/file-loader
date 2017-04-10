package uk.co.mruoc.properties;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Properties;

public class InputStreamConverter {

    public Properties toProperties(InputStream stream) throws IOException {
        Properties properties = new Properties();
        properties.load(stream);
        return properties;
    }

    public String toString(InputStream stream) throws IOException {
        return IOUtils.toString(stream, Charset.defaultCharset());
    }

}
