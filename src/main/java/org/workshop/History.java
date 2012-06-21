package org.workshop;

/**
 * By Szczepan Faber on 6/21/12
 */
public interface History {

    /**
     * Must be called before {@link #lookUpCompleted(TranslationResult)}  }
     * @param request
     * @throws HistoryUpdateFailure
     */
    void lookUpAttempted(TranslationRequest request) throws HistoryUpdateFailure;

    /**
     * Must be called after {@link #lookUpAttempted(TranslationRequest)}
     * @param result
     * @throws HistoryUpdateFailure
     */
    void lookUpCompleted(TranslationResult result) throws HistoryUpdateFailure;
}
