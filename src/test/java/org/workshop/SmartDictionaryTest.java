package org.workshop;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.workshop.TestSupport.translationRequestFor;

/**
 * By Szczepan Faber on 6/21/12
 */
@RunWith(MockitoJUnitRunner.class)
public class SmartDictionaryTest {

    @Mock
    Translator translator;
    @Mock
    History history;
    @InjectMocks
    SmartDictionary dictionary;

    @Before public void before() {
        when(translator.translate(any(TranslationRequest.class)))
                .thenReturn(new TranslationResult("foo"));
    }

    @Test
    public void shouldLookUpWords() throws Exception {
        //given
        when(translator.translate(translationRequestFor("mockito")))
                .thenReturn(new TranslationResult("cool stuff"));

        //when
        String result = dictionary.lookUp("mockito");

        //then
        assertEquals("cool stuff", result);
    }

    @Test
    public void shouldKeepHistoryOfRequests() throws Exception {
        //when
        dictionary.lookUp("uberconf");

        //then
        verify(history).lookUpAttempted(translationRequestFor("uberconf"));
    }

    @Test
    public void shouldKeepHistoryOfResults() throws Exception {
        TranslationResult result = new TranslationResult("nice place");
        when(translator.translate(translationRequestFor("Denver")))
                .thenReturn(result);

        //when
        dictionary.lookUp("Denver");

        //then
        verify(history).lookUpCompleted(result);
    }
}
