package org.workshop.history;

import org.workshop.model.History;
import org.workshop.model.TranslationRequest;
import org.workshop.model.TranslationResult;

/**
 * By Szczepan Faber on 6/21/12
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
        } catch (Exception e) {
            //too bad
        }
    }

    @Override
    public void lookUpCompleted(TranslationResult result) {
        try {
            delegate.lookUpCompleted(result);
        } catch (Exception e) {
            //too bad
        }
    }
}
