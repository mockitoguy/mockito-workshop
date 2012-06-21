package org.workshop.translator;

import org.junit.Test;
import org.mockito.Mock;
import org.workshop.fixture.TestSupport;
import org.workshop.model.TranslationFailed;
import org.workshop.model.TranslationRequest;
import org.workshop.model.TranslationResult;
import org.workshop.model.Translator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

/**
 * By Szczepan Faber on 6/21/12
 */
public class RetryingTranslatorTest extends TestSupport {

    @Mock
    Translator delegate;

    @Test
    public void shouldRetryTranslations() throws Exception {
        //given:
        RetryingTranslator translator = new RetryingTranslator(delegate, 3);
        TranslationResult result = new TranslationResult("nice place");
        when(delegate.translate(translationRequestFor("Denver")))
                .thenThrow(new TranslationFailed())
                .thenThrow(new TranslationFailed())
                .thenReturn(result);

        //when
        TranslationResult actualResult = translator.translate(new TranslationRequest("Denver"));

        //then
        assertEquals(result, actualResult);
    }

    @Test
    public void shouldRetryTranslationUpToXTimes() throws Exception {
        //given
        RetryingTranslator translator = new RetryingTranslator(delegate, 3);
        TranslationRequest request = new TranslationRequest("foo");
        when(translator.translate(request)).thenThrow(new TranslationFailed());

        try {
            //when
            translator.translate(request);
            //then
            fail();
        } catch (SubsequentTranslationFailed e) {
            assertEquals(3, e.getAttemptCount());
        }
    }
}