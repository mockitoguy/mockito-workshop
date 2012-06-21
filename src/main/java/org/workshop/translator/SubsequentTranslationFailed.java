package org.workshop.translator;

import org.workshop.model.TranslationFailed;

/**
 * By Szczepan Faber on 6/21/12
 */
public class SubsequentTranslationFailed extends TranslationFailed {
    private int attemptCount;

    public SubsequentTranslationFailed(String message, int attemptCount) {
        super(message);
        this.attemptCount = attemptCount;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
