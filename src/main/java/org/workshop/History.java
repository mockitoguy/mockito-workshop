package org.workshop;

/**
 * by Szczepan Faber, created at: 12/2/11
 */
public interface History {
    void translationAttempted(TranslationRequest word) throws CannotUpdateHistory;
}
