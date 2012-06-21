package org.workshop.model;

/**
 * By Szczepan Faber on 6/21/12
 */
public class TranslationFailed extends RuntimeException {
    public TranslationFailed() {
        super("Translation failed.");
    }

    public TranslationFailed(String message) {
        super(message);
    }
}
