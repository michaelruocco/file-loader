package uk.co.mruoc.file.line;

import org.junit.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class LineLoaderTest {

    @Test
    public void shouldReturnFileLinesFromFileSystemFile() {
        String path = "test/file-system.properties";

        Collection<String> lines = LineLoader.loadLinesFromFileSystem(path);

        assertThat(lines).containsExactly(
                "firstName=michael",
                "surname=ruocco"
        );
    }

    @Test
    public void shouldReturnFileLinesFromClasspathFile() {
        String path = "test/classpath.properties";

        Collection<String> lines = LineLoader.loadLinesFromClasspath(path);

        assertThat(lines).containsExactly(
                "firstName=MICHAEL",
                "surname=RUOCCO"
        );
    }

}
