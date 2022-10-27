package uk.co.mruoc.file.property;

import java.util.Properties;

public interface PropertyFileLoader {

    Properties load(String path);
}
