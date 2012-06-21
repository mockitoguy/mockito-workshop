package org.thirdparty;

/**
 * By Szczepan Faber on 6/21/12
 */
public class DefaultTranslator implements Translator {
    @Override
    public String translate(TranslationRequest request) {
        return OnlineTranslator.translate(request.getWord());
    }
}
