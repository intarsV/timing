package lv.timing.report.teamReport;

import lv.timing.genericServices.InitCBoxEvent;
import lv.timing.genericServices.InitCBoxSingleBoatClass;
import lv.timing.genericServices.InitCBoxSubEvent;
import lv.timing.report.singleReport.services.PreviewStartListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
@Service
public class TeamRaceReportService {


//    @Autowired
//    private SingleRaceReportView view;

    @Autowired
    private InitCBoxEvent initCBoxEvent;

    @Autowired
    private InitCBoxSubEvent initCBoxSubEvent;

    @Autowired
    private InitCBoxSingleBoatClass initCBoxSingleBoatClass;

    @Autowired
    private PreviewStartListService previewStartListService;

    public void initCBoxEvent(JComboBox cBoxEvent){
        initCBoxEvent.init(cBoxEvent);
    }

    public void initCBoxSubEvent(JComboBox event,JComboBox subEvent){
        initCBoxSubEvent.init(event,subEvent);
    }

    public void initCBoxBoatClass(JComboBox comboBox){
        initCBoxSingleBoatClass.init(comboBox);
    }

    public void previewStartLis(){
        previewStartListService.execute();
    }
}
