package org.workshop.dictionary;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.workshop.fixture.TestSupport;
import org.workshop.model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * By Szczepan Faber on 6/20/12
 */
public class SmartDictionaryTest extends TestSupport {

    @Mock
    Translator translator;
    @Mock
    History history;

    @InjectMocks
    SmartDictionary dictionary;

    @Test
    public void shouldLookUpWords() throws Exception {
        //given
        when(translator.translate(translationRequestFor("mockito"))).thenReturn(new TranslationResult("tasty"));

        //when
        TranslationResult result = dictionary.lookUp("mockito");

        //then
        assertEquals("tasty", result.getTranslation());
    }

    @Test
    public void shouldKeepHistory() throws Exception {
        //given
        TranslationResult result = new TranslationResult("cool conf");
        when(translator.translate(translationRequestFor("UberConf"))).thenReturn(result);

        //when
        dictionary.lookUp("UberConf");

        //then
        InOrder inOrder = Mockito.inOrder(history);
        inOrder.verify(history).lookUpAttempted(translationRequestFor("UberConf"));
        inOrder.verify(history).lookUpCompleted(result);
    }

    @Test
    public void shouldInformIfTranslationIsNotPossible() throws Exception {
        //given:
        TranslationFailed translationFailed = new TranslationFailed();
        when(translator.translate(any(TranslationRequest.class))).thenThrow(translationFailed);

        //when
        try {
            dictionary.lookUp("Denver");
            //then
            fail();
        } catch (LookUpFailed e) {
            assertEquals(translationFailed, e.getCause());
        }
    }

    @Test
    public void shouldNotifyHistoryWhenLookUpFailed() throws Exception {
        //given:
        when(translator.translate(any(TranslationRequest.class))).thenThrow(new TranslationFailed());

        //when
        try {
            dictionary.lookUp("Denver");
            //then
            fail();
        } catch (LookUpFailed e) {}

        verify(history, times(1)).lookUpAttempted(any(TranslationRequest.class));
        verify(history, never()).lookUpCompleted(any(TranslationResult.class));
    }
}