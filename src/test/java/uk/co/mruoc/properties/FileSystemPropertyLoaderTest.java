package uk.co.mruoc.properties;

import org.junit.Test;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSystemPropertyLoaderTest {

    private final PropertyLoader loader = new FileSystemPropertyLoader();

    @Test
    public void shouldReturnProperties() {
        String path = "test/file-system.properties";

        Properties properties = loader.load(path);

        assertThat(properties.get("firstName")).isEqualTo("michael");
        assertThat(properties.get("surname")).isEqualTo("ruocco");
    }

    @Test(expected = PropertiesNotFoundException.class)
    public void shouldErrorIfFileDoesNotExist() {
        String path = "invalid/file-system.properties";

        loader.load(path);
    }

}
