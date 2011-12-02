package org.workshop;

/**
 * by Szczepan Faber, created at: 12/2/11
 */
public class SmartDictionary {
    private final Translator translator;
    private final History history;

    public SmartDictionary(Translator translator, History history) {
        this.translator = translator;
        this.history = history;
    }

    public String lookUp(String word) {
        TranslationRequest request = new TranslationRequest(word);
        try {
            history.translationAttempted(request);
        } catch (CannotUpdateHistory cannotUpdateHistory) {
            //ignore
        }
        TranslationResult result = translator.translate(request);
        return result.getTranslation();
    }
}
