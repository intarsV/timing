package lv.initex.race.singleRace.services;

import lv.initex.database.SingleRaceRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.SingleRace;
import lv.initex.domain.SubEvent;
import lv.initex.genericServices.GetObjectFromCBoxEvent;
import lv.initex.genericServices.GetObjectFromCBoxSubEvent;
import lv.initex.race.singleRace.abstractClass.SingleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class InitSingleRaceModel {

    @Autowired
    private SingleRaceRepository database;

    public void init(boolean isEditMode, SingleView view) {
        JComboBox cBoxEvent = view.getComboBoxEvent();
        JComboBox cBoxSubEvent = view.getComboBoxSubEvent();

        if (cBoxEvent.getSelectedIndex() > 0 && cBoxSubEvent.getSelectedIndex() > 0) {
            try {
                view.getModel().setRowCount(0);
                CompetitionEvent selectedEvent = GetObjectFromCBoxEvent.getObject(cBoxEvent);

                SubEvent selectedSubEvent = GetObjectFromCBoxSubEvent.getObject(cBoxSubEvent);
                List<SingleRace> singleRaceList;
                if (isEditMode) {
                    singleRaceList = database.singleRaceListDone(selectedEvent, selectedSubEvent);
                } else {
                    singleRaceList = database.singleRaceListNotDone(selectedEvent, selectedSubEvent);
                }

                for (SingleRace singleRace : singleRaceList) {
                    Object[] o = {singleRace.getId().intValue()
                            , singleRace.getEventSingleRegistry().getBib()
                            , singleRace.getStartTime()
                            , singleRace.getFinishTime()
                            , singleRace.getG1()
                            , singleRace.getG2()
                            , singleRace.getG3()
                            , singleRace.getG4()
                            , singleRace.getG5()
                            , singleRace.getG6()
                            , singleRace.getG7()
                            , singleRace.getG8()
                            , singleRace.getG9()
                            , singleRace.getG10()
                            , singleRace.getG11()
                            , singleRace.getG12()
                            , singleRace.getG13()
                            , singleRace.getG14()
                            , singleRace.getG15()
                            , singleRace.getG16()
                            , singleRace.getG17()
                            , singleRace.getG18()
                            , singleRace.getG19()
                            , singleRace.getG20()
                            , singleRace.getG21()
                            , singleRace.getG22()
                            , singleRace.getG23()
                            , singleRace.getG24()
                            , singleRace.getEventSingleRegistry()
                            , singleRace.getCompetitionEvent()
                            , singleRace.getSubEvent()
                            , singleRace.isDsqr()
                            , singleRace.isDone()};
                    view.getModel().addRow(o);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR getting single race list");
            }
        } else {
            view.getModel().setRowCount(0);
        }
    }
}
