package uk.co.mruoc.file.content;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Base64EncoderTest {

    private final Base64Encoder encoder = new Base64Encoder();

    @Test
    void shouldBase64EncodeValue() {
        String input = "this is my test string";

        String result = encoder.encode(input);

        assertThat(result).isEqualTo("dGhpcyBpcyBteSB0ZXN0IHN0cmluZw==");
    }
}
