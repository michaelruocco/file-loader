package uk.co.mruoc.file;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Properties;
import java.util.stream.Collectors;

public class InputStreamConverter {

    public Properties toProperties(InputStream stream) throws IOException {
        Properties properties = new Properties();
        properties.load(stream);
        return properties;
    }

    public String toString(InputStream stream) throws IOException {
        return IOUtils.toString(stream, Charset.defaultCharset());
    }

    public Collection<String> toLines(InputStream stream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            return reader.lines().collect(Collectors.toList());
        }
    }

}
