package com.belykh.finalProj.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class CommandException.
 */
public class CommandException extends Exception {
    
    /**
     * Instantiates a new command exception.
     */
    public CommandException() {
    }

    /**
     * Instantiates a new command exception.
     *
     * @param s the s
     */
    public CommandException(String s) {
        super(s);
    }

    /**
     * Instantiates a new command exception.
     *
     * @param s the s
     * @param throwable the throwable
     */
    public CommandException(String s, Throwable throwable) {
        super(s, throwable);
    }

    /**
     * Instantiates a new command exception.
     *
     * @param throwable the throwable
     */
    public CommandException(Throwable throwable) {
        super(throwable);
    }
}
