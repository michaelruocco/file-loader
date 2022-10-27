package uk.co.mruoc.file.line;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.Collection;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.FileLoadException;

class ClasspathFileLineLoaderTest {

    private final FileLineLoader loader = new ClasspathFileLineLoader();

    @Test
    void shouldReturnFileContentFromClasspathFile() {
        String path = "test/classpath.properties";

        Collection<String> lines = loader.loadLines(path);

        assertThat(lines).containsExactly("firstName=MICHAEL", "surname=RUOCCO");
    }

    @Test
    void shouldErrorIfFileDoesNotExist() {
        String path = "/invalid/classpath.properties";

        Throwable error = catchThrowable(() -> loader.loadLines(path));

        assertThat(error).isInstanceOf(FileLoadException.class).hasMessageContaining(path);
    }
}
