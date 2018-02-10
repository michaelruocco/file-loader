package uk.co.mruoc.properties;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeInputStreamLoaderTest {

    private final FakeInputStreamLoader loader = new FakeInputStreamLoader();

    @Test
    public void lastLoadedPathShouldBeNullBeforeLoadIsCalled() {
        assertThat(loader.getLastLoadedPath()).isNull();
    }

    @Test
    public void shouldReturnLastLoadedPath() {
        String path = "/my/path";

        loader.load(path);

        assertThat(loader.getLastLoadedPath()).isEqualTo(path);
    }

    @Test
    public void shouldReturnNullStreamIfNotSet() {
        InputStream stream = loader.load("/my/path");

        assertThat(stream).isNull();
    }

    @Test
    public void shouldReturnStream() {
        InputStream expectedStream = new ByteArrayInputStream("stubbedStream".getBytes());
        loader.setInputStream(expectedStream);

        InputStream stream = loader.load("/my/path");

        assertThat(stream).isEqualTo(expectedStream);
    }

}
