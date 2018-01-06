package com.belykh.finalProj.exception;

/**
 * Created by panda on 6.12.17.
 */
public class CommandException extends Exception {
    public CommandException() {
    }

    public CommandException(String s) {
        super(s);
    }

    public CommandException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CommandException(Throwable throwable) {
        super(throwable);
    }
}
