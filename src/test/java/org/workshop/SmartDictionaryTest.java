package org.workshop;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        when(translator.translate(Mockito.argThat(translationFor("mockito"))))
                .thenReturn("cool stuff");

        //when
        String result = dictionary.lookUp("mockito");

        //then
        assertEquals("cool stuff", result);
    }

    private BaseMatcher<TranslationRequest> translationFor(final String word) {
        return new BaseMatcher<TranslationRequest>() {
            @Override
            public boolean matches(Object actual) {
                TranslationRequest request = (TranslationRequest) actual;
                return request.getWord().equals(word);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
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
