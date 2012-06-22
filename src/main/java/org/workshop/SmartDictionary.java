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
        history.lookUpAttempted(request);

        TranslationResult result;
        try {
            result = translator.translate(request);
        } catch (TranslationFailed e) {
            throw new LookUpFailed("Unable to look up word: '" + word + "'.");
        }
        history.lookUpCompleted(result);

        return result.getTranslation();
    }
}
