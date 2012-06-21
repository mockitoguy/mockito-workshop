package org.workshop;

/**
 * By Szczepan Faber on 6/22/12
 */
public class SafeHistory implements History {
    private History delegate;

    public SafeHistory(History delegate) {
        this.delegate = delegate;
    }

    @Override
    public void lookUpAttempted(TranslationRequest request) {
        try {
            delegate.lookUpAttempted(request);
        } catch (HistoryUpdateFailure e) {
            //ignore
        }
    }

    @Override
    public void lookUpCompleted(TranslationResult result) {
        try {
            delegate.lookUpCompleted(result);
        } catch (HistoryUpdateFailure e) {
            //ignore
        }
    }
}
