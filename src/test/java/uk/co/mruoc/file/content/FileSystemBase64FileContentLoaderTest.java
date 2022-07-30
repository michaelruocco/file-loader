package uk.co.mruoc.file.content;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.io.UncheckedIOException;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.FileLoadException;

class FileSystemBase64FileContentLoaderTest {

    private final FileContentLoader loader = new FileSystemBase64FileContentLoader();

    @Test
    void shouldReturnBase64EncodedFileContentFromFileSystemFile() {
        String expectedContent = "Zmlyc3ROYW1lPW1pY2hhZWwKc3VybmFtZT1ydW9jY28=";
        String path = "test/file-system.properties";

        String content = loader.loadContent(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test
    void shouldErrorIfFileDoesNotExist() {
        String path = "/invalid/file-system.properties";

        Throwable error = catchThrowable(() -> loader.loadContent(path));

        assertThat(error)
                .isInstanceOf(FileLoadException.class)
                .hasMessageContaining(path)
                .hasCauseInstanceOf(UncheckedIOException.class);
    }
}
