package uk.co.mruoc.file.content;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.FileLoadException;

import java.io.UncheckedIOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class FileSystemFileContentLoaderTest {

    private static final String NEW_LINE = System.lineSeparator();
    private final FileContentLoader loader = new FileSystemFileContentLoader();

    @Test
    void shouldReturnFileContentFromFileSystemFile() {
        String expectedContent = "firstName=michael" + NEW_LINE + "surname=ruocco";
        String path = "test/file-system.properties";

        String content = loader.loadContent(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test
    void shouldErrorIfFileDoesNotExist() {
        String path = "invalid/file-system.properties";

        Throwable error = catchThrowable(() -> loader.loadContent(path));

        assertThat(error).isInstanceOf(FileLoadException.class)
                .hasMessageContaining(path)
                .hasCauseInstanceOf(UncheckedIOException.class);
    }

}
