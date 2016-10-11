package org.workshop;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;


/**
 * By Szczepan Faber on 6/21/12
 */
//@RunWith(MockitoJUnitRunner.class)
public class SmartDictionaryTest {

    @Mock Translator translator;
    @Mock History history;
    @InjectMocks SmartDictionary dictionary;

    @Rule public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void shouldLookUpWords() throws Exception {
        //given
        willReturn("cool stuff").given(translator).translate(new TranslationRequest("mockito"));

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
        verify(history).lookUpAttempted("uberconf");
    }

    @Test
    public void shouldBeLenientIfHistoryFails() throws Exception {
        //given
        Mockito.doThrow(new HistoryUpdateFailure()).when(history).lookUpAttempted("Denver");

        //when
        dictionary.lookUp("Denver");

        //then no exception is thrown
    }
}
