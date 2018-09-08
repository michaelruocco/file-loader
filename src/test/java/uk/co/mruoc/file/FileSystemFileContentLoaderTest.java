package uk.co.mruoc.file;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSystemFileContentLoaderTest {

    private static final String NEW_LINE = System.lineSeparator();
    private final FileContentLoader loader = new FileSystemFileContentLoader();

    @Test
    public void shouldReturnProperties() {
        String expectedContent = "firstName=michael" + NEW_LINE + "surname=ruocco";
        String path = "test/file-system.properties";

        String content = loader.loadContent(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test(expected = FileContentLoadException.class)
    public void shouldErrorIfFileDoesNotExist() {
        String path = "invalid/file-system.properties";

        loader.loadContent(path);
    }

}
