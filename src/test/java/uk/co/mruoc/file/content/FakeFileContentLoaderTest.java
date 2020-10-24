package uk.co.mruoc.file.content;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FakeFileContentLoaderTest {

    private final FakeFileContentLoader loader = new FakeFileContentLoader();

    @Test
    void lastLoadedPathShouldBeNullBeforeLoadContentIsCalled() {
        assertThat(loader.getLastLoadedPath()).isNull();
    }

    @Test
    void shouldReturnLastLoadedPath() {
        String path = "/my/path";

        loader.loadContent(path);

        assertThat(loader.getLastLoadedPath()).isEqualTo(path);
    }

    @Test
    void shouldReturnNullContentIfNotSet() {
        String result = loader.loadContent("/my/path");

        assertThat(result).isNull();
    }

    @Test
    void shouldReturnContent() {
        String content = "my-content";
        loader.setContent(content);

        String result = loader.loadContent("/my/path");

        assertThat(result).isEqualTo(content);
    }

}
