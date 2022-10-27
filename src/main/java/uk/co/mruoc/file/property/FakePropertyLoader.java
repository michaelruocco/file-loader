package uk.co.mruoc.file.property;

import java.util.Properties;

public class FakePropertyLoader implements PropertyFileLoader {

    private String path;
    private Properties properties;

    @Override
    public Properties load(String path) {
        this.path = path;
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getLastLoadedPath() {
        return path;
    }
}
