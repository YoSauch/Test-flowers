package flowers.exceptions;

import java.io.IOException;

public class FlowersDaoException extends IOException {
    private static final String DEFAULT_EXCEPTION_MESSAGE = "Exception when trying read and process data. ";

    public FlowersDaoException(){
        super(DEFAULT_EXCEPTION_MESSAGE);
    }

    public FlowersDaoException(String message) {
        super(DEFAULT_EXCEPTION_MESSAGE + message);
    }

}
