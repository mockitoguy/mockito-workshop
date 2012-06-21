package org.workshop.fixture;

import org.hamcrest.Description;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.workshop.model.TranslationRequest;

/**
 * By Szczepan Faber on 6/21/12
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class TestSupport {

    public static TranslationRequest translationRequestFor(final String expectedWord) {
        return Mockito.argThat(new ArgumentMatcher<TranslationRequest>() {
            @Override
            public boolean matches(Object o) {
                TranslationRequest actual = (TranslationRequest) o;
                return actual.getWord().equals(expectedWord);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("TranslationRequest for ").appendValue(expectedWord);
            }
        });
    }
}
