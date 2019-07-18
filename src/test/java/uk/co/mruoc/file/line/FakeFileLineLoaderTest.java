package uk.co.mruoc.file.line;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeFileLineLoaderTest {

    private final FakeFileLineLoader loader = new FakeFileLineLoader();

    @Test
    public void lastLoadedPathShouldBeNullBeforeLoadContentIsCalled() {
        assertThat(loader.getLastLoadedPath()).isNull();
    }

    @Test
    public void shouldReturnLastLoadedPath() {
        String path = "/my/path";

        loader.loadLines(path);

        assertThat(loader.getLastLoadedPath()).isEqualTo(path);
    }

    @Test
    public void shouldReturnNullLinesIfNotSet() {
        Collection<String> result = loader.loadLines("/my/path");

        assertThat(result).isNull();
    }

    @Test
    public void shouldReturnLines() {
        Collection<String> lines = Arrays.asList(
                "my-line-1",
                "my-line-2"
        );
        loader.setLines(lines);

        Collection<String> result = loader.loadLines("/my/path");

        assertThat(result).containsExactlyElementsOf(lines);
    }

}
