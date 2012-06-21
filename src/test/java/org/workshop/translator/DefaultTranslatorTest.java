package org.workshop.translator;

import org.junit.Test;
import org.mockito.Mockito;
import org.workshop.model.TranslationRequest;
import org.workshop.model.TranslationResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * By Szczepan Faber on 6/21/12
 */
public class DefaultTranslatorTest {

    DefaultTranslator translator = new DefaultTranslator();
    DefaultTranslator spy = Mockito.spy(translator);

    @Test
    public void shouldKeepRequestWithTheResult() throws Exception {
        //given
        TranslationRequest request = new TranslationRequest("hey");
        when(spy.translateWord("hey")).thenReturn("cześć");

        //when
        TranslationResult result = spy.translate(request);

        //then
        assertEquals(request, result.getRequest());
        assertEquals("cześć", result.getTranslation());
    }
}
