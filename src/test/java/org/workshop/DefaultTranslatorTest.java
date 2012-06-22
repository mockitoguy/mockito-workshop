package org.workshop;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * By Szczepan Faber on 6/22/12
 */
public class DefaultTranslatorTest {

    DefaultTranslator translator = new DefaultTranslator();
    DefaultTranslator spy = Mockito.spy(translator);

    @Test
    public void shouldReturnResultThatContainsRequest() throws Exception {
        //given
        TranslationRequest request = new TranslationRequest("foo");
        when(spy.translateWord("foo")).thenReturn("bar");

        //when
        TranslationResult result = spy.translate(request);

        //then
        assertEquals("bar", result.getTranslation());
        assertEquals(request, result.getRequest());
    }
}
