package uk.co.mruoc.file;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;

import static org.assertj.core.api.Assertions.assertThat;

class FileReaderLoaderTest {

    @Test
    void shouldReturnFileContentFromFileSystemFile() {
        String path = "test/file-system.properties";

        BufferedReader reader = FileReaderLoader.loadReaderFromFileSystem(path);

        assertThat(reader.lines()).containsExactly(
                "firstName=michael",
                "surname=ruocco"
        );
    }

    @Test
    void shouldReturnFileContentFromClasspathFile() {
        String path = "test/classpath.properties";

        BufferedReader reader = FileReaderLoader.loadReaderFromClasspath(path);

        assertThat(reader.lines()).containsExactly(
                "firstName=MICHAEL",
                "surname=RUOCCO"
        );
    }

}
