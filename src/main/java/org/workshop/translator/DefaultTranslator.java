package org.workshop.translator;

import org.thirdparty.OnlineTranslator;
import org.workshop.model.TranslationRequest;
import org.workshop.model.TranslationResult;
import org.workshop.model.Translator;

/**
 * By Szczepan Faber on 6/20/12
 */
public class DefaultTranslator implements Translator {

    @Override
    public TranslationResult translate(TranslationRequest request) {
        String translation = translateWord(request.getWord());
        return new TranslationResult(translation, request);
    }

    String translateWord(String word) {
        return OnlineTranslator.translate(word);
    }
}
