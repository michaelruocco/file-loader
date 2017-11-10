package uk.co.mruoc.properties;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeFileContentLoaderTest {

    private final FakeFileContentLoader loader = new FakeFileContentLoader();

    @Test
    public void lastLoadedPathShouldBeNullBeforeLoadContentIsCalled() {
        assertThat(loader.getLastLoadedPath()).isNull();
    }

    @Test
    public void shouldReturnLastLoadedPath() {
        String path = "/my/path";

        loader.loadContent(path);

        assertThat(loader.getLastLoadedPath()).isEqualTo(path);
    }

    @Test
    public void shouldReturnNullContentIfNotSet() {
        String result = loader.loadContent("");

        assertThat(result).isNull();
    }

    @Test
    public void shouldReturnContent() {
        String content = "my-content";
        loader.setContent(content);

        String result = loader.loadContent("");

        assertThat(result).isEqualTo(content);
    }
    
}
