package uk.co.mruoc.properties;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClasspathBase64FileContentLoaderTest {

    private final FileContentLoader loader = new ClasspathBase64FileContentLoader();

    @Test
    public void shouldReturnFileContent() {
        String expectedContent = "Zmlyc3ROYW1lPU1JQ0hBRUwKc3VybmFtZT1SVU9DQ08=";
        String path = "/test/classpath.properties";

        String content = loader.loadContent(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test(expected = FileContentLoadException.class)
    public void shouldErrorIfFileDoesNotExist() {
        String path = "/invalid/file-system.properties";

        loader.loadContent(path);
    }

}
