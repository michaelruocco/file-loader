package uk.co.mruoc.file.line;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.io.UncheckedIOException;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.FileLoadException;

class FileSystemFileLineLoaderTest {

    private final FileLineLoader loader = new FileSystemFileLineLoader();

    @Test
    void shouldReturnFileContentFromFileSystemFile() {
        String path = "test/file-system.properties";

        Collection<String> lines = loader.loadLines(path);

        assertThat(lines).containsExactly("firstName=michael", "surname=ruocco");
    }

    @Test
    void shouldErrorIfFileDoesNotExist() {
        String path = "invalid/file-system.properties";

        Throwable error = catchThrowable(() -> loader.loadLines(path));

        assertThat(error)
                .isInstanceOf(FileLoadException.class)
                .hasMessageContaining(path)
                .hasCauseInstanceOf(UncheckedIOException.class);
    }
}
