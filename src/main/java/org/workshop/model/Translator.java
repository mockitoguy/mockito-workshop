package org.workshop.model;

/**
 * By Szczepan Faber on 6/20/12
 */
public interface Translator {
    TranslationResult translate(TranslationRequest request) throws TranslationFailed;
}