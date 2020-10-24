package uk.co.mruoc.file.property;

import org.junit.jupiter.api.Test;

import java.io.UncheckedIOException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ClasspathPropertyLoaderTest {

    private final PropertyLoader loader = new ClasspathPropertyLoader();

    @Test
    void shouldReturnPropertiesFromClasspathFile() {
        String path = "test/classpath.properties";

        Properties properties = loader.load(path);

        assertThat(properties.get("firstName")).isEqualTo("MICHAEL");
        assertThat(properties.get("surname")).isEqualTo("RUOCCO");
    }

    @Test
    void shouldErrorIfFileDoesNotExist() {
        String path = "/invalid/classpath.properties";

        Throwable error = catchThrowable(() -> loader.load(path));

        assertThat(error).isInstanceOf(PropertiesNotFoundException.class)
                .hasMessageContaining(path)
                .hasCauseInstanceOf(UncheckedIOException.class);
    }

}
