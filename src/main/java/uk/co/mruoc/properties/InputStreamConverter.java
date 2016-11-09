package uk.co.mruoc.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class InputStreamConverter {

    public Properties toInputStream(InputStream stream) throws IOException {
        Properties properties = new Properties();
        properties.load(stream);
        return properties;
    }

}
