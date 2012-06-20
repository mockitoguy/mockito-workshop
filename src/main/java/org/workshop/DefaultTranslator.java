package org.workshop;

import org.thirdparty.OnlineTranslator;

/**
 * by Szczepan Faber, created at: 12/2/11
 */
public class DefaultTranslator implements Translator {
    public String translate(String word) {
        return OnlineTranslator.translate(word);
    }
}
