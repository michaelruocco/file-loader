package uk.co.mruoc.properties;

import org.junit.Test;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertyLoaderTest {

    private final PropertyLoader loader = new PropertyLoader();

    @Test
    public void shouldReturnPropertiesFromFilePath() {
        String path = "test/file-system.properties";

        Properties properties = loader.load(path);

        assertThat(properties.get("firstName")).isEqualTo("michael");
        assertThat(properties.get("surname")).isEqualTo("ruocco");
    }

    @Test(expected = PropertiesNotFoundException.class)
    public void shouldErrorIfFileDoesNotExistAtPath() {
        String path = "invalid/file-system.properties";

        loader.load(path);
    }

    @Test
    public void shouldReturnPropertiesFromClasspath() {
        String path = "/test/classpath.properties";

        Properties properties = loader.loadFromClasspath(path);

        assertThat(properties.get("firstName")).isEqualTo("MICHAEL");
        assertThat(properties.get("surname")).isEqualTo("RUOCCO");
    }

    @Test(expected = PropertiesNotFoundException.class)
    public void shouldErrorIfFileDoesNotExistOnClasspath() {
        String path = "/invalid/file-system.properties";

        loader.loadFromClasspath(path);
    }

}
