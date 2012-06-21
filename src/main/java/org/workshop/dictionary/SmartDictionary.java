package org.workshop.dictionary;

import org.workshop.model.*;

/**
 * By Szczepan Faber on 6/20/12
 */
public class SmartDictionary {
    private Translator translator;
    private History history;

    public SmartDictionary(Translator translator, History history) {
        this.translator = translator;
        this.history = history;
    }

    public TranslationResult lookUp(String word) throws LookUpFailed {
        TranslationRequest request = new TranslationRequest(word);
        history.lookUpAttempted(request);

        TranslationResult result;

        try {
            result = translator.translate(request);
        } catch (TranslationFailed e) {
            throw new LookUpFailed("Unable to look up '" + word + "'.", e);
        }

        history.lookUpCompleted(result);

        return result;
    }
}