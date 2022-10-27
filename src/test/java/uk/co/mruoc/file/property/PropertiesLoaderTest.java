package uk.co.mruoc.file.property;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.Properties;
import org.junit.jupiter.api.Test;

class PropertiesLoaderTest {

    @Test
    void shouldReturnPropertiesFromFileSystemFile() {
        String path = "test/file-system.properties";

        Properties properties = PropertiesLoader.loadPropertiesFromFileSystem(path);

        assertThat(properties)
                .hasSize(2)
                .contains(entry("firstName", "michael"))
                .contains(entry("surname", "ruocco"));
    }

    @Test
    void shouldReturnPropertiesFromClasspathFile() {
        String path = "test/classpath.properties";

        Properties properties = PropertiesLoader.loadPropertiesFromClasspath(path);

        assertThat(properties)
                .hasSize(2)
                .contains(entry("firstName", "MICHAEL"))
                .contains(entry("surname", "RUOCCO"));
    }
}
