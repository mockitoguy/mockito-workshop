package org.workshop.app;

import org.workshop.dictionary.SmartDictionary;
import org.workshop.history.DatabaseHistory;
import org.workshop.history.SafeHistory;
import org.workshop.history.SwitchableHistory;
import org.workshop.model.History;
import org.workshop.model.Translator;
import org.workshop.translator.DefaultTranslator;
import org.workshop.translator.RetryingTranslator;

/**
 * By Szczepan Faber on 6/21/12
 */
public class SmartDictionaryFactory {

    public SmartDictionary createDictionary() {
        Translator translator = new RetryingTranslator(new DefaultTranslator(), 5);
        History history = new SwitchableHistory(new SafeHistory(new DatabaseHistory()), true);
        return new SmartDictionary(translator, history);
    }
}
