package uk.co.mruoc.file.property;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.io.UncheckedIOException;
import java.util.Properties;
import org.junit.jupiter.api.Test;

class ClasspathPropertyFileLoaderTest {

    private final PropertyFileLoader loader = new ClasspathPropertyFileLoader();

    @Test
    void shouldReturnPropertiesFromClasspathFile() {
        String path = "test/classpath.properties";

        Properties properties = loader.loadProperties(path);

        assertThat(properties.get("firstName")).isEqualTo("MICHAEL");
        assertThat(properties.get("surname")).isEqualTo("RUOCCO");
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