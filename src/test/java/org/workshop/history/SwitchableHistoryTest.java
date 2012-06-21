package org.workshop.history;

import org.junit.Test;
import org.mockito.Mock;
import org.workshop.fixture.TestSupport;
import org.workshop.model.History;
import org.workshop.model.TranslationRequest;
import org.workshop.model.TranslationResult;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * By Szczepan Faber on 6/21/12
 */
public class SwitchableHistoryTest extends TestSupport {

    @Mock History delegate;
    TranslationRequest request = new TranslationRequest("a");
    TranslationResult result = new TranslationResult("b");

    @Test
    public void shouldKeepHistory() throws Exception {
        //given
        SwitchableHistory history = new SwitchableHistory(delegate, true);

        //when
        history.lookUpAttempted(request);
        history.lookUpCompleted(result);

        //then
        verify(delegate).lookUpAttempted(request);
        verify(delegate).lookUpCompleted(result);
    }

    @Test
    public void shouldNotKeepHistory() throws Exception {
        //given
        SwitchableHistory history = new SwitchableHistory(delegate, false);

        //when
        history.lookUpAttempted(request);
        history.lookUpCompleted(result);

        //then
        verifyZeroInteractions(delegate);
    }
}
