package uk.co.mruoc.properties;

import org.junit.Test;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class ClasspathPropertyLoaderTest {

    private final PropertyLoader loader = new ClasspathPropertyLoader();

    @Test
    public void shouldReturnProperties() {
        String path = "/test/classpath.properties";

        Properties properties = loader.load(path);

        assertThat(properties.get("firstName")).isEqualTo("MICHAEL");
        assertThat(properties.get("surname")).isEqualTo("RUOCCO");
    }

    @Test(expected = PropertiesNotFoundException.class)
    public void shouldErrorIfFileDoesNotExist() {
        String path = "/invalid/file-system.properties";

        loader.load(path);
    }

}
