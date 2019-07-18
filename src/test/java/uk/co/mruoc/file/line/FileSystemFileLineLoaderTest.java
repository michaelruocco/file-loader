package uk.co.mruoc.file.line;

import org.junit.Test;
import uk.co.mruoc.file.FileLoadException;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSystemFileLineLoaderTest {

    private final FileLineLoader loader = new FileSystemFileLineLoader();

    @Test
    public void shouldReturnFileContentFromFileSystemFile() {
        String path = "test/file-system.properties";

        Collection<String> lines = loader.loadLines(path);

        assertThat(lines).containsExactly(
                "firstName=michael",
                "surname=ruocco"
        );
    }

    @Test(expected = FileLoadException.class)
    public void shouldErrorIfFileDoesNotExist() {
        String path = "invalid/file-system.properties";

        loader.loadLines(path);
    }

}
