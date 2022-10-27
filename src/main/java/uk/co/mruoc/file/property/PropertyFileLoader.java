package uk.co.mruoc.file.property;

import java.util.Properties;

public interface PropertyFileLoader {

    Properties loadProperties(String path);
}
