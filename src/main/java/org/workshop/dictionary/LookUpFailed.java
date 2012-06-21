package org.workshop.dictionary;

/**
 * By Szczepan Faber on 6/21/12
 */
public class LookUpFailed extends RuntimeException {
    public LookUpFailed(String message, Throwable cause) {
        super(message, cause);
    }
}
