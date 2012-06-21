package org.workshop;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * By Szczepan Faber on 6/22/12
 */
public class TranslationRequestTest {

    @Test
    public void shouldKnowRequestDate() throws Exception {
        TranslationRequest request = new TranslationRequest("mockito");
        assertNotNull(request.getRequestDate());
    }
}
