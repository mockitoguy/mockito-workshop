package org.workshop;

/**
 * By Szczepan Faber on 6/21/12
 */
public class SmartDictionary {
    private Translator translator;

    public SmartDictionary(Translator translator) {
        this.translator = translator;
    }

    public String lookUp(String word) {
        return translator.translate(word);
    }
}
