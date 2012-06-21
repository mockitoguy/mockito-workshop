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
    public String toString() {
        return "TranslationRequest{" +
                "word='" + word + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }
}
