package uk.co.mruoc.file.line;

import org.junit.Test;
import uk.co.mruoc.file.FileLoadException;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class ClasspathFileLineLoaderTest {

    private final FileLineLoader loader = new ClasspathFileLineLoader();

    @Test
    public void shouldReturnFileContentFromClasspathFile() {
        String path = "test/classpath.properties";

        Collection<String> lines = loader.loadLines(path);

        assertThat(lines).containsExactly(
                "firstName=MICHAEL",
                "surname=RUOCCO"
        );
    }

    @Test(expected = FileLoadException.class)
    public void shouldErrorIfFileDoesNotExist() {
        String path = "/invalid/classpath.properties";

        loader.loadLines(path);
    }

}
