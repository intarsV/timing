package lv.timing.database;

import lv.timing.domain.VerifyMcuData;

import java.util.List;

public interface VerifyMcuDataRepository {

    List<VerifyMcuData> startList();

    List<VerifyMcuData> finishList();

    List<VerifyMcuData> getListWithAccepted();

    int countStartLine();

    int countFinishLine();

    boolean updateStartLine(VerifyMcuData verifyMcuData);

    boolean updateFinishLine(VerifyMcuData verifyMcuData);

    boolean update(VerifyMcuData verifyMcuData);

}