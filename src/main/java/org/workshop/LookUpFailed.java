package org.workshop;

/**
 * By Szczepan Faber on 6/22/12
 */
public class LookUpFailed extends RuntimeException {
    public LookUpFailed(String message) {
        super(message);
    }
}
