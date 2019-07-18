package uk.co.mruoc.file.content;

import org.junit.Test;
import uk.co.mruoc.file.FileLoadException;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSystemFileContentLoaderTest {

    private static final String NEW_LINE = System.lineSeparator();
    private final FileContentLoader loader = new FileSystemFileContentLoader();

    @Test
    public void shouldReturnFileContentFromFileSystemFile() {
        String expectedContent = "firstName=michael" + NEW_LINE + "surname=ruocco";
        String path = "test/file-system.properties";

        String content = loader.loadContent(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test(expected = FileLoadException.class)
    public void shouldErrorIfFileDoesNotExist() {
        String path = "invalid/file-system.properties";

        loader.loadContent(path);
    }

}
