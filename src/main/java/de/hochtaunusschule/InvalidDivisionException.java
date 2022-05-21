package de.hochtaunusschule;

/**
 * @author BlueTeaWolf
 */
public class InvalidDivisionException extends RuntimeException{

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
