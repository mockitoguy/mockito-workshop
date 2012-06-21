package org.thirdparty;

/**
 * By Szczepan Faber on 6/21/12
 */
public interface History {
    void lookUpAttempted(String word) throws HistoryUpdateFailure;
}
