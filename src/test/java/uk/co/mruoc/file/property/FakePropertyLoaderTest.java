package uk.co.mruoc.file.property;

import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

class FakePropertyLoaderTest {

    private final FakePropertyLoader loader = new FakePropertyLoader();

    @Test
    void lastLoadedPathShouldBeNullBeforeLoadPropertiesIsCalled() {
        assertThat(loader.getLastLoadedPath()).isNull();
    }

    @Test
    void shouldReturnLastLoadedPath() {
        String path = "/my/path";

        loader.load(path);

        assertThat(loader.getLastLoadedPath()).isEqualTo(path);
    }

    @Test
    void shouldReturnNullPropertiesIfNotSet() {
        assertThat(loader.load("")).isNull();
    }

    @Test
    void shouldReturnProperties() {
        Properties properties = new Properties();
        loader.setProperties(properties);

        Properties result = loader.load("");

        assertThat(result).isEqualTo(properties);
    }

}
