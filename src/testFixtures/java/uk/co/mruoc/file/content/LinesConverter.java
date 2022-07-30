package uk.co.mruoc.file.content;

import java.util.Arrays;
import java.util.Collection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LinesConverter {

    private static final String NEW_LINE = System.lineSeparator();

    public static String joinWithNewline(String... lines) {
        return joinWithNewline(Arrays.asList(lines));
    }

    public static String joinWithNewline(Collection<String> lines) {
        return String.join(NEW_LINE, lines);
    }
}
