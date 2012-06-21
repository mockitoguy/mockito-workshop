package org.workshop.history;

import org.workshop.model.History;
import org.workshop.model.TranslationRequest;
import org.workshop.model.TranslationResult;

/**
 * By Szczepan Faber on 6/21/12
 */
public class DatabaseHistory implements History {
    @Override
    public void lookUpAttempted(TranslationRequest request) {
        //writes to db
    }

    @Override
    public void lookUpCompleted(TranslationResult result) {
        //writes to db
    }
}
