package lv.initex.database;

import lv.initex.domain.VerifyMcuData;

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