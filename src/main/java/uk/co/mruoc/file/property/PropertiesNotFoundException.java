package uk.co.mruoc.file.property;

public class PropertiesNotFoundException extends RuntimeException {

    public PropertiesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
