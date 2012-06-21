package org.workshop;

import org.thirdparty.OnlineTranslator;

/**
 * By Szczepan Faber on 6/21/12
 */
public class DefaultTranslator implements Translator {
    @Override
    public String translate(String word) {
        return OnlineTranslator.translate(word);
    }
}
