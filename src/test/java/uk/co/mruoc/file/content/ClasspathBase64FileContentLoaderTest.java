package uk.co.mruoc.file.content;

import org.junit.Test;
import uk.co.mruoc.file.FileLoadException;

import static org.assertj.core.api.Assertions.assertThat;

public class ClasspathBase64FileContentLoaderTest {

    private final FileContentLoader loader = new ClasspathBase64FileContentLoader();

    @Test
    public void shouldReturnBase64EncodedFileContentFromClasspathFile() {
        String expectedContent = "Zmlyc3ROYW1lPU1JQ0hBRUwKc3VybmFtZT1SVU9DQ08=";
        String path = "test/classpath.properties";

        String content = loader.loadContent(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test(expected = FileLoadException.class)
    public void shouldErrorIfFileDoesNotExist() {
        String path = "invalid/classpath.properties";

        loader.loadContent(path);
    }

}
