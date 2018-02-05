package com.belykh.flowerAuction.exception;

/**
 * The Class ServiceException.
 */
public class ServiceException extends Exception {
    
    /**
     * Instantiates a new service exception.
     */
    public ServiceException() {
    }

    /**
     * Instantiates a new service exception.
     *
     * @param s the s
     */
    public ServiceException(String s) {
        super(s);
    }

    /**
     * Instantiates a new service exception.
     *
     * @param s the s
     * @param throwable the throwable
     */
    public ServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    /**
     * Instantiates a new service exception.
     *
     * @param throwable the throwable
     */
    public ServiceException(Throwable throwable) {
        super(throwable);
    }
}
