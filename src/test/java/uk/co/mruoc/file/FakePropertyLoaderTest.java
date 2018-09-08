package uk.co.mruoc.file;

import org.junit.Test;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class FakePropertyLoaderTest {

    private final FakePropertyLoader loader = new FakePropertyLoader();

    @Test
    public void lastLoadedPathShouldBeNullBeforeLoadPropertiesIsCalled() {
        assertThat(loader.getLastLoadedPath()).isNull();
    }

    @Test
    public void shouldReturnLastLoadedPath() {
        String path = "/my/path";

        loader.load(path);

        assertThat(loader.getLastLoadedPath()).isEqualTo(path);
    }

    @Test
    public void shouldReturnNullPropertiesIfNotSet() {
        assertThat(loader.load("")).isNull();
    }

    @Test
    public void shouldReturnProperties() {
        Properties properties = new Properties();
        loader.setProperties(properties);

        Properties result = loader.load("");

        assertThat(result).isEqualTo(properties);
    }

}
