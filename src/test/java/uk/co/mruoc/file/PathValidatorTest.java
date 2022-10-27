package uk.co.mruoc.file;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

class PathValidatorTest {

    private final PathValidator validator = new PathValidator();

    @Test
    void shouldThrowExceptionIfPathIsEmpty() {
        String path = "";

        Throwable error = catchThrowable(() -> validator.validate(path));

        assertThat(error).isInstanceOf(FileLoadException.class).hasMessage("path should not be null or empty");
    }

    @Test
    void shouldThrowExceptionIfPathIsNull() {
        String path = null;

        Throwable error = catchThrowable(() -> validator.validate(path));

        assertThat(error).isInstanceOf(FileLoadException.class).hasMessage("path should not be null or empty");
    }

    @Test
    void shouldDoNothingIfPathIsNotNullOrEmpty() {
        String path = "path";

        ThrowingCallable call = () -> validator.validate(path);

        assertThatCode(call).doesNotThrowAnyException();
    }
}
