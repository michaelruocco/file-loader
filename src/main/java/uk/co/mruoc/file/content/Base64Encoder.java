package uk.co.mruoc.file.content;

import java.util.Base64;

public class Base64Encoder {

    public String encode(String input) {
        byte[] bytes = Base64.getEncoder().encode(input.getBytes());
        return new String(bytes);
    }
}
