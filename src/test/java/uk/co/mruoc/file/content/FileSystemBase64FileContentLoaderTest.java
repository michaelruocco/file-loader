package uk.co.mruoc.file.content;

import org.junit.Test;
import uk.co.mruoc.file.FileLoadException;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSystemBase64FileContentLoaderTest {

    private final FileContentLoader loader = new FileSystemBase64FileContentLoader();

    @Test
    public void shouldReturnBase64EncodedFileContentFromFileSystemFile() {
        String expectedContent = "Zmlyc3ROYW1lPW1pY2hhZWwKc3VybmFtZT1ydW9jY28=";
        String path = "test/file-system.properties";

        String content = loader.loadContent(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test(expected = FileLoadException.class)
    public void shouldErrorIfFileDoesNotExist() {
        String path = "/invalid/file-system.properties";

        loader.loadContent(path);
    }

}
