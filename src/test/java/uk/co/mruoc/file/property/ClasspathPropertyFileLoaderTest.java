package uk.co.mruoc.file.property;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import java.util.Properties;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.FileLoadException;

class ClasspathPropertyFileLoaderTest {

    private final PropertyFileLoader loader = new ClasspathPropertyFileLoader();

    @Test
    void shouldReturnPropertiesFromClasspathFile() {
        String path = "test/classpath.properties";

        Properties properties = loader.loadProperties(path);

        assertThat(properties).containsExactly(entry("firstName", "MICHAEL"), entry("surname", "RUOCCO"));
    }

    @Test
    void shouldErrorIfFileDoesNotExist() {
        String path = "/invalid/classpath.properties";

        Throwable error = catchThrowable(() -> loader.loadProperties(path));

        assertThat(error).isInstanceOf(FileLoadException.class).hasMessageContaining(path);
    }
}
