package com.belykh.finalProj.exception;

/**
 * Created by panda on 15.11.17.
 */
public class DAOException extends Exception {
    public DAOException() {
    }

    public DAOException(String s) {
        super(s);
    }

    public DAOException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DAOException(Throwable throwable) {
        super(throwable);
    }
}
