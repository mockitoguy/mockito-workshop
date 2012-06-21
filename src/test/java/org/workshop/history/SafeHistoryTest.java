package org.workshop.history;

import org.junit.Test;
import org.workshop.fixture.TestSupport;
import org.workshop.model.CannotUpdateHistory;
import org.workshop.model.History;
import org.workshop.model.TranslationRequest;
import org.workshop.model.TranslationResult;

import static org.mockito.Mockito.*;

/**
 * By Szczepan Faber on 6/21/12
 */
public class SafeHistoryTest extends TestSupport {

    History delegate = mock(History.class);
    SafeHistory history = new SafeHistory(delegate);

    @Test
    public void shouldRememberHistory() throws Exception {
        //given
        TranslationRequest request = new TranslationRequest("a");
        TranslationResult response = new TranslationResult("b");

        //when
        history.lookUpAttempted(request);
        history.lookUpCompleted(response);

        //then
        verify(delegate).lookUpAttempted(request);
        verify(delegate).lookUpCompleted(response);
    }

    @Test
    public void shouldSafelyRememberAttempts() throws Exception {
        //given:
        TranslationRequest request = new TranslationRequest("hey!");
        doThrow(new CannotUpdateHistory()).when(delegate).lookUpAttempted(request);

        //when
        history.lookUpAttempted(request);

        //then no exceptions thrown
    }

    @Test
    public void shouldSafelyRememberTranslations() throws Exception {
        //given:
        TranslationResult result = new TranslationResult("nice stuff");
        doThrow(new CannotUpdateHistory()).when(delegate).lookUpCompleted(result);

        //when
        history.lookUpCompleted(result);

        //then no exception is thrown
    }
}
