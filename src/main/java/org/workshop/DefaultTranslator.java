package org.workshop;

import org.thirdparty.OnlineTranslator;

/**
 * By Szczepan Faber on 6/21/12
 */
public class DefaultTranslator implements Translator {
    @Override
    public TranslationResult translate(TranslationRequest request) {
        String word = request.getWord();
        String translation = translateWord(word);
        return new TranslationResult(translation, request);
    }

    String translateWord(String word) {
        return OnlineTranslator.translate(word);
    }
}
