package org.workshop.translator;

import org.workshop.model.TranslationFailed;
import org.workshop.model.TranslationRequest;
import org.workshop.model.TranslationResult;
import org.workshop.model.Translator;

/**
 * By Szczepan Faber on 6/21/12
 */
public class RetryingTranslator implements Translator {
    private final Translator translator;
    private final int maxRetries;

    public RetryingTranslator(Translator translator, int maxRetries) {
        this.translator = translator;
        this.maxRetries = maxRetries;
    }

    @Override
    public TranslationResult translate(TranslationRequest request) throws TranslationFailed {
        for(int i=1; i<=maxRetries; i++) {
            try {
                return translator.translate(request);
            } catch (TranslationFailed e) {}
        }
        throw new SubsequentTranslationFailed("Failed to translate in " + maxRetries + " attempts.", maxRetries);
    }
}
