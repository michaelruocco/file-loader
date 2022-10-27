package uk.co.mruoc.file.content;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

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

        assertThat(properties).containsExactly(entry("firstName", "michael"), entry("surname", "ruocco"));
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
