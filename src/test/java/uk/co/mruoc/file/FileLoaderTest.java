package uk.co.mruoc.file;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static uk.co.mruoc.file.content.LinesConverter.joinWithNewline;

import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import org.junit.jupiter.api.Test;

class FileLoaderTest {

    @Test
    void shouldReturnFileContentFromFileSystemFile() {
        String expectedContent = joinWithNewline("firstName=michael", "surname=ruocco");
        String path = "test/file-system.properties";

        String content = FileLoader.loadContentFromFileSystem(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test
    void shouldReturnFileContentFromClasspathFile() {
        String expectedContent = joinWithNewline("firstName=MICHAEL", "surname=RUOCCO");
        String path = "test/classpath.properties";

        String content = FileLoader.loadContentFromClasspath(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test
    void shouldReturnFileContentLinesFromFileSystemFile() {
        Collection<String> expectedLines = Arrays.asList("firstName=michael", "surname=ruocco");
        String path = "test/file-system.properties";

        Collection<String> lines = FileLoader.loadContentLinesFromFileSystem(path);

        assertThat(lines).containsExactlyElementsOf(expectedLines);
    }

    @Test
    void shouldReturnFileContentLinesFromClasspathFile() {
        Collection<String> expectedLines = Arrays.asList("firstName=MICHAEL", "surname=RUOCCO");
        String path = "test/classpath.properties";

        Collection<String> lines = FileLoader.loadContentLinesFromClasspath(path);

        assertThat(lines).containsExactlyElementsOf(expectedLines);
    }

    @Test
    void shouldReturnBase64EncodedFileContentFromFileSystemFile() {
        String expectedContent = "Zmlyc3ROYW1lPW1pY2hhZWwKc3VybmFtZT1ydW9jY28=";
        String path = "test/file-system.properties";

        String content = FileLoader.loadBase64EncodedContentFromFileSystem(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test
    void shouldReturnBase64EncodedFileContentFromClasspathFile() {
        String expectedContent = "Zmlyc3ROYW1lPU1JQ0hBRUwKc3VybmFtZT1SVU9DQ08=";
        String path = "test/classpath.properties";

        String content = FileLoader.loadBase64EncodedContentFromClasspath(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test
    void shouldReturnPropertiesFromFileSystemFile() {
        String path = "test/file-system.properties";

        Properties properties = FileLoader.loadPropertiesFromFileSystem(path);

        assertThat(properties).containsExactly(entry("firstName", "michael"), entry("surname", "ruocco"));
    }

    @Test
    void shouldReturnPropertiesFromClasspathFile() {
        String path = "test/classpath.properties";

        Properties properties = FileLoader.loadPropertiesFromClasspath(path);

        assertThat(properties).containsExactly(entry("firstName", "MICHAEL"), entry("surname", "RUOCCO"));
    }
}
