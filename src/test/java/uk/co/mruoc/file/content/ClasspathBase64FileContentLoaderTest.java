package uk.co.mruoc.file.content;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.FileLoadException;

import java.io.UncheckedIOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ClasspathBase64FileContentLoaderTest {

    private final FileContentLoader loader = new ClasspathBase64FileContentLoader();

    @Test
    void shouldReturnBase64EncodedFileContentFromClasspathFile() {
        String expectedContent = "Zmlyc3ROYW1lPU1JQ0hBRUwKc3VybmFtZT1SVU9DQ08=";
        String path = "test/classpath.properties";

        String content = loader.loadContent(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test
    void shouldErrorIfFileDoesNotExist() {
        String path = "invalid/classpath.properties";

        Throwable error = catchThrowable(() -> loader.loadContent(path));

        assertThat(error).isInstanceOf(FileLoadException.class)
                .hasMessageContaining(path)
                .hasCauseInstanceOf(UncheckedIOException.class);
    }

}
