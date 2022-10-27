package uk.co.mruoc.file.property;

import java.util.Properties;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertiesLoader {

    public static Properties loadPropertiesFromFileSystem(String path) {
        PropertyFileLoader loader = new FileSystemPropertyFileLoader();
        return loader.load(path);
    }

    public static Properties loadPropertiesFromClasspath(String path) {
        PropertyFileLoader loader = new ClasspathPropertyFileLoader();
        return loader.load(path);
    }
}
