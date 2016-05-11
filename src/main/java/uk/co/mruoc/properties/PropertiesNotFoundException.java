package uk.co.mruoc.properties;

class PropertiesNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -9085992062876379337L;

    PropertiesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
