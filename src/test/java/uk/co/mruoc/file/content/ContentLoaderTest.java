package uk.co.mruoc.file.content;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.file.content.LinesConverter.joinWithNewline;

import org.junit.jupiter.api.Test;

class ContentLoaderTest {

    @Test
    void shouldReturnFileContentFromFileSystemFile() {
        String expectedContent = joinWithNewline("firstName=michael", "surname=ruocco");
        String path = "test/file-system.properties";

        String content = ContentLoader.loadContentFromFileSystem(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test
    void shouldReturnFileContentFromClasspathFile() {
        String expectedContent = joinWithNewline("firstName=MICHAEL", "surname=RUOCCO");
        String path = "test/classpath.properties";

        String content = ContentLoader.loadContentFromClasspath(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test
    void shouldReturnBase64EncodedFileContentFromFileSystemFile() {
        String expectedContent = "Zmlyc3ROYW1lPW1pY2hhZWwKc3VybmFtZT1ydW9jY28=";
        String path = "test/file-system.properties";

        String content = ContentLoader.loadBase64EncodedContentFromFileSystem(path);

        assertThat(content).isEqualTo(expectedContent);
    }

    @Test
    void shouldReturnBase64EncodedFileContentFromClasspathFile() {
        String expectedContent = "Zmlyc3ROYW1lPU1JQ0hBRUwKc3VybmFtZT1SVU9DQ08=";
        String path = "test/classpath.properties";

        String content = ContentLoader.loadBase64EncodedContentFromClasspath(path);

        assertThat(content).isEqualTo(expectedContent);
    }
}
