package org.workshop;

/**
 * By Szczepan Faber on 6/21/12
 */
public interface History {
    void lookUpAttempted(TranslationRequest word) throws HistoryUpdateFailure;

    void lookUpCompleted(String word) throws HistoryUpdateFailure;
}
