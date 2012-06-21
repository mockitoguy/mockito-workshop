package org.workshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void shouldLookUpWords() throws Exception {
        //given
        when(translator.translate(translationRequestFor("mockito")))
                .thenReturn("cool stuff");

        //when
        String result = dictionary.lookUp("mockito");

        //then
        assertEquals("cool stuff", result);
    }

    @Test
    public void shouldKeepHistory() throws Exception {
        //when
        dictionary.lookUp("uberconf");

        //then
        verify(history).lookUpAttempted(new TranslationRequest("uberconf"));
    }

    @Test
    public void shouldBeLenientIfHistoryFails() throws Exception {
        //given
        TranslationRequest request = new TranslationRequest("Denver");
        Mockito.doThrow(new HistoryUpdateFailure())
                .when(history).lookUpAttempted(request);

        //when
        dictionary.lookUp("Denver");

        //then no exception is thrown
    }
}
