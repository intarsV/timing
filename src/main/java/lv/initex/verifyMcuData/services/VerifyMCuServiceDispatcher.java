package lv.initex.verifyMcuData.services;

import lv.initex.database.VerifyMcuDataRepository;
import lv.initex.verifyMcuData.VerifyMcuDataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.TableModelEvent;

@Service
public class VerifyMCuServiceDispatcher {

    private VerifyMcuDataRepository database;
    private UpdateStart updateStart = new UpdateStart();
    private UpdateFinish updateFinish = new UpdateFinish();
    private InitMcuModel initMcuModel = new InitMcuModel();
    private CountRecords countRecords = new CountRecords();

    @Autowired
    public VerifyMCuServiceDispatcher(VerifyMcuDataRepository database) {
        this.database = database;
    }

    public void updateStart(TableModelEvent tme, VerifyMcuDataView view) {
        updateStart.execute(tme, view, database);
    }

    public void updateFinish(TableModelEvent tme, VerifyMcuDataView view) {
        updateFinish.execute(tme, view, database);
    }

    public void initMcuModel(boolean forStart, VerifyMcuDataView view) {
        initMcuModel.init(forStart, view, database);
    }

    public int countRecords(boolean forStart) {
        return countRecords.countRecords(forStart, database);
    }
}
