package uk.co.mruoc.file.property;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import java.io.UncheckedIOException;
import java.util.Properties;
import org.junit.jupiter.api.Test;

class ClasspathPropertyFileLoaderTest {

    private final PropertyFileLoader loader = new ClasspathPropertyFileLoader();

    @Test
    void shouldReturnPropertiesFromClasspathFile() {
        String path = "test/classpath.properties";

        Properties properties = loader.loadProperties(path);

        assertThat(properties).containsExactly(entry("firstName", "michael"), entry("surname", "ruocco"));
    }

    @Test
    void shouldErrorIfFileDoesNotExist() {
        String path = "/invalid/classpath.properties";

        Throwable error = catchThrowable(() -> loader.loadProperties(path));

        assertThat(error)
                .isInstanceOf(PropertiesNotFoundException.class)
                .hasMessageContaining(path)
                .hasCauseInstanceOf(UncheckedIOException.class);
    }
}
