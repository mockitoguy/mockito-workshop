package org.workshop.model;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * By Szczepan Faber on 6/21/12
 */
public class TranslationRequestTest {

    @Test
    public void shouldKnowTheRequestDate() throws Exception {
        assertNotNull(new TranslationRequest("foo").getRequestDate());
    }
}
