package com.belykh.finalProj.util.exception;

/**
 * Created by panda on 16.11.17.
 */
public class UtilCourseProjException extends Exception {
    public UtilCourseProjException() {
    }

    public UtilCourseProjException(String s) {
        super(s);
    }

    public UtilCourseProjException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UtilCourseProjException(Throwable throwable) {
        super(throwable);
    }
}
