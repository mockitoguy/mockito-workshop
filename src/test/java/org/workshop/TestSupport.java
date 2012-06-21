package org.workshop;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.mockito.Mockito;

/**
 * By Szczepan Faber on 6/22/12
 */
public class TestSupport {
    public static TranslationRequest translationRequestFor(String word) {
        return Mockito.argThat(translationFor(word));
    }

    public static BaseMatcher<TranslationRequest> translationFor(final String word) {
        return new BaseMatcher<TranslationRequest>() {
            @Override
            public boolean matches(Object actual) {
                TranslationRequest request = (TranslationRequest) actual;
                return request.getWord().equals(word);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(new TranslationRequest(word).toString());
            }
        };
    }
}
