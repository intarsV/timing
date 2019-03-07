package lv.timing.verifyMcuData.services;

import lv.timing.database.VerifyMcuDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountRecords {

    @Autowired
    private VerifyMcuDataRepository database;

    public int countRecords(boolean forStart) {
        if (forStart) {
            int countStartLine = database.countStartLine();
            return countStartLine;
        } else {
            int countFinishLine = database.countFinishLine();
            return countFinishLine;
        }
    }
}
