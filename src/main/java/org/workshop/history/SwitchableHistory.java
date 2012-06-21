package org.workshop.history;

import org.workshop.model.History;
import org.workshop.model.TranslationRequest;
import org.workshop.model.TranslationResult;

/**
 * By Szczepan Faber on 6/21/12
 */
public class SwitchableHistory implements History {
    private History delegate;
    private boolean enabled;

    public SwitchableHistory(History delegate, boolean enabled) {
        this.delegate = delegate;
        this.enabled = enabled;
    }

    @Override
    public void lookUpAttempted(TranslationRequest request) {
        if (enabled) {
            delegate.lookUpAttempted(request);
        }
    }

    @Override
    public void lookUpCompleted(TranslationResult result) {
        if (enabled) {
            delegate.lookUpCompleted(result);
        }
    }
}
