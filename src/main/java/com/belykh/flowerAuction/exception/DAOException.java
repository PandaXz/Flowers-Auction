package com.belykh.flowerAuction.exception;

/**
 * The Class DAOException.
 */
public class DAOException extends Exception {
    
    /**
     * Instantiates a new DAO exception.
     */
    public DAOException() {
    }

    /**
     * Instantiates a new DAO exception.
     *
     * @param s the s
     */
    public DAOException(String s) {
        super(s);
    }

    /**
     * Instantiates a new DAO exception.
     *
     * @param s the s
     * @param throwable the throwable
     */
    public DAOException(String s, Throwable throwable) {
        super(s, throwable);
    }

    /**
     * Instantiates a new DAO exception.
     *
     * @param throwable the throwable
     */
    public DAOException(Throwable throwable) {
        super(throwable);
    }
}
