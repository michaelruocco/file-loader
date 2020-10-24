package uk.co.mruoc.file.content;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Base64FileContentLoaderTest {

    private final FileContentLoader cannedLoader = new CannedFileContentLoader();
    private final FileContentLoader loader = new Base64FileContentLoader(cannedLoader);

    @Test
    void shouldReturnBase64EncodedFileContent() {
        String expectedContent = "Y2FubmVkIGZpbGUgY29udGVudA==";

        String content = loader.loadContent("any/path");

        assertThat(content).isEqualTo(expectedContent);
    }

}
