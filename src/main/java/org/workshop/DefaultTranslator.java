package org.workshop;

import org.thirdparty.OnlineTranslator;

/**
 * by Szczepan Faber, created at: 12/2/11
 */
public class DefaultTranslator implements Translator {
    public TranslationResult translate(TranslationRequest request) {
        String translation = OnlineTranslator.translate(request.getWord());
        return new TranslationResult(translation);
    }
}
