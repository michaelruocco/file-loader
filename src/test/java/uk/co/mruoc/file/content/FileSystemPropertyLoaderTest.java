package uk.co.mruoc.file.content;

import org.junit.Test;
import uk.co.mruoc.file.property.FileSystemPropertyLoader;
import uk.co.mruoc.file.property.PropertiesNotFoundException;
import uk.co.mruoc.file.property.PropertyLoader;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSystemPropertyLoaderTest {

    private final PropertyLoader loader = new FileSystemPropertyLoader();

    @Test
    public void shouldReturnPropertiesFromFileSystemFile() {
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
