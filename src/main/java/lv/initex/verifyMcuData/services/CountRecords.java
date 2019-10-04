package lv.initex.verifyMcuData.services;

import lv.initex.database.VerifyMcuDataRepository;

public class CountRecords {

    public int countRecords(boolean forStart, VerifyMcuDataRepository database) {
        if (forStart) {
            return database.countStartLine();
        } else return database.countFinishLine();
    }
}
