package org.workshop.model;

/**
 * By Szczepan Faber on 6/21/12
 */
public class TranslationResult {
    private String translation;
    private TranslationRequest request;

    public TranslationResult(String translation) {
        this.translation = translation;
    }

    public TranslationResult(String translation, TranslationRequest request) {
        this.translation = translation;
        this.request = request;
    }

    public String getTranslation() {
        return translation;
    }

    public TranslationRequest getRequest() {
        return request;
    }
}
