package uk.co.mruoc.file.content;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.io.UncheckedIOException;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.property.FileSystemPropertyFileLoader;
import uk.co.mruoc.file.property.PropertiesNotFoundException;
import uk.co.mruoc.file.property.PropertyFileLoader;

class FileSystemPropertyFileLoaderTest {

    private final PropertyFileLoader loader = new FileSystemPropertyFileLoader();

    @Test
    void shouldReturnPropertiesFromFileSystemFile() {
        String path = "test/file-system.properties";

        Properties properties = loader.loadProperties(path);

        assertThat(properties.get("firstName")).isEqualTo("michael");
        assertThat(properties.get("surname")).isEqualTo("ruocco");
    }

    @Test
    void shouldErrorIfFileDoesNotExist() {
        String path = "invalid/file-system.properties";

        Throwable error = catchThrowable(() -> loader.loadProperties(path));

        assertThat(error)
                .isInstanceOf(PropertiesNotFoundException.class)
                .hasMessageContaining(path)
                .hasCauseInstanceOf(UncheckedIOException.class);
    }
}
