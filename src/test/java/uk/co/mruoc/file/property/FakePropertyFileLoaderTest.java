package uk.co.mruoc.file.property;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Properties;
import org.junit.jupiter.api.Test;

class FakePropertyFileLoaderTest {

    private final FakePropertyLoader loader = new FakePropertyLoader();

    @Test
    void lastLoadedPathShouldBeNullBeforeLoadPropertiesIsCalled() {
        assertThat(loader.getLastLoadedPath()).isNull();
    }

    @Test
    void shouldReturnLastLoadedPath() {
        String path = "/my/path";

        loader.loadProperties(path);

        assertThat(loader.getLastLoadedPath()).isEqualTo(path);
    }

    @Test
    void shouldReturnNullPropertiesIfNotSet() {
        assertThat(loader.loadProperties("")).isNull();
    }

    @Test
    void shouldReturnProperties() {
        Properties properties = new Properties();
        loader.setProperties(properties);

        Properties result = loader.loadProperties("");

        assertThat(result).isEqualTo(properties);
    }
}
