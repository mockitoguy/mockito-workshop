package org.workshop;

/**
 * by Szczepan Faber, created at: 12/2/11
 */
public class TranslationRequest {
    private final String word;

    public TranslationRequest(String word) {
        assert word != null;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TranslationRequest)) return false;

        TranslationRequest that = (TranslationRequest) o;

        if (word != null ? !word.equals(that.word) : that.word != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }
}
