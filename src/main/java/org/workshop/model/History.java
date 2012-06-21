package org.workshop.model;

/**
 * By Szczepan Faber on 6/21/12
 */
public interface History {

    /**
     * Must happen before {@link #lookUpCompleted(TranslationResult)}
     * @param request
     */
    void lookUpAttempted(TranslationRequest request);

    /**
     * May not happen.
     * @param result
     */
    void lookUpCompleted(TranslationResult result);
}
