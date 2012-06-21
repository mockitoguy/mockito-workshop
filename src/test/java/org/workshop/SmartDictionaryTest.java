package org.workshop;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * By Szczepan Faber on 6/21/12
 */
public class SmartDictionaryTest {

    @Test
    public void shouldLookUpWords() throws Exception {
        //given
        Translator translator = Mockito.mock(Translator.class);
        SmartDictionary dictionary = new SmartDictionary(translator);

        Mockito.when(translator.translate("mockito")).thenReturn("cool stuff");

        //when
        String result = dictionary.lookUp("mockito");

        //then
        assertEquals("cool stuff", result);
    }
}
