package org.workshop;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SmartDictionaryTest extends TestSupport {

    @Mock History history;
    @Mock Translator translator;
    @InjectMocks SmartDictionary dictionary;

    @Before
    public void before() {
        given(translator.translate(any(TranslationRequest.class)))
                .willReturn(new TranslationResult(""));
    }

    @Test
    public void shouldLookUpWords() throws Exception {
        //given
        given(translator.translate(translationRequestFor("mockito")))
                .willReturn(new TranslationResult("cool framework"));

        //when
        String translation = dictionary.lookUp("mockito");

        //then
        assertEquals("cool framework", translation);
    }

    @Test
    public void shouldMaintainHistory() throws Exception {
        //when
        dictionary.lookUp("krakow");

        //then
        verify(history).translationAttempted(translationRequestFor("krakow"));
    }

    @Test
    public void shouldBeLenientWhenHistoryCannotBeUpdated() throws Exception {
        //given
        willThrow(new CannotUpdateHistory())
                .given(history).translationAttempted(new TranslationRequest("FLL"));

        //when
        dictionary.lookUp("FLL");

        //then no exception is thrown
    }
}