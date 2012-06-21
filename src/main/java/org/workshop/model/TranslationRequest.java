package org.workshop.model;

import java.util.Date;

/**
 * By Szczepan Faber on 6/21/12
 */
public class TranslationRequest {
    private String word;
    private Date requestDate;

    public TranslationRequest(String word) {
        this.word = word;
        requestDate = new Date();
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
