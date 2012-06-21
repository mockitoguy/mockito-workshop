package org.workshop;

/**
 * By Szczepan Faber on 6/21/12
 */
public class SmartDictionary {
    private Translator translator;
    private History history;

    public SmartDictionary(Translator translator, History history) {
        this.translator = translator;
        this.history = history;
    }

    public String lookUp(String word) {
        TranslationRequest request = new TranslationRequest(word);

        TranslationResult result = translator.translate(request);
        history.lookUpAttempted(request);
        history.lookUpCompleted(result);

        return result.getTranslation();
    }
}
