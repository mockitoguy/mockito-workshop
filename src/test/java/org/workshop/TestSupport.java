package org.workshop;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.argThat;

/**
 * by Szczepan Faber, created at: 12/2/11
 */
abstract public class TestSupport extends BDDMockito {
    public static TranslationRequest translationRequestFor(final String word) {
        return argThat(isTranslationRequest(word));
    }

    public static BaseMatcher<TranslationRequest> isTranslationRequest(final String word) {
        return new BaseMatcher<TranslationRequest>() {
            public boolean matches(Object other) {
                TranslationRequest o = (TranslationRequest) other;
                return o != null && o.getWord().equals(word);
            }

            public void describeTo(Description description) {}
        };
    }
}
