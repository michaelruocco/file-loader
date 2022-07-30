package uk.co.mruoc.file;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class FakeInputStreamLoaderTest {

    private final FakeInputStreamLoader loader = new FakeInputStreamLoader();

    @Test
    void lastLoadedPathShouldBeNullBeforeLoadIsCalled() {
        assertThat(loader.getLastLoadedPath()).isNull();
    }

    @Test
    void shouldReturnLastLoadedPath() {
        String path = "/my/path";

        loader.load(path);

        assertThat(loader.getLastLoadedPath()).isEqualTo(path);
    }

    @Test
    void shouldReturnNullStreamIfNotSet() {
        InputStream stream = loader.load("/my/path");

        assertThat(stream).isNull();
    }

    @Test
    void shouldReturnStream() {
        InputStream expectedStream = new ByteArrayInputStream("stubbedStream".getBytes());
        loader.setInputStream(expectedStream);

        InputStream stream = loader.load("/my/path");

        assertThat(stream).isEqualTo(expectedStream);
    }
}
