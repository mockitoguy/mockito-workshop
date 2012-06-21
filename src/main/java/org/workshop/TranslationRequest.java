package org.workshop;

import java.util.Date;

/**
 * By Szczepan Faber on 6/22/12
 */
public class TranslationRequest {

    private String word;
    private Date requestDate = new Date();

    public TranslationRequest(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TranslationRequest request = (TranslationRequest) o;

        if (requestDate != null ? !requestDate.equals(request.requestDate) : request.requestDate != null) return false;
        if (word != null ? !word.equals(request.word) : request.word != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result + (requestDate != null ? requestDate.hashCode() : 0);
        return result;
    }
}
