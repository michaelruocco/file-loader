package uk.co.mruoc.file.content;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static uk.co.mruoc.file.content.LinesConverter.joinWithNewline;

import java.io.UncheckedIOException;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.FileLoadException;

class FileSystemFileContentLoaderTest {

    private final FileContentLoader loader = new FileSystemFileContentLoader();

    @Test
    void shouldReturnFileContentFromFileSystemFile() {
        String expectedContent = joinWithNewline("firstName=michael", "surname=ruocco");
        String path = "test/file-system.properties";

        String content = loader.loadContent(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test
    void shouldErrorIfFileDoesNotExist() {
        String path = "invalid/file-system.properties";

        Throwable error = catchThrowable(() -> loader.loadContent(path));

        assertThat(error)
                .isInstanceOf(FileLoadException.class)
                .hasMessageContaining(path)
                .hasCauseInstanceOf(UncheckedIOException.class);
    }
}
