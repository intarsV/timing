package lv.timing.race.teamRace.services;

import lv.timing.database.TeamRaceRepository;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SubEvent;
import lv.timing.domain.TeamRace;
import lv.timing.genericServices.GetObjectFromCBoxEvent;
import lv.timing.genericServices.GetObjectFromCBoxSubEvent;
import lv.timing.race.teamRace.abstractClass.TeamView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class GetTeamRaceList {

    @Autowired
    private TeamRaceRepository database;

    public void getTeamRaceList(boolean isEditMode, TeamView view) {
        JComboBox cBoxEvent = view.getComboBoxEvent();
        JComboBox cBoxSubEvent = view.getComboBoxSubEvent();

        if (view.getComboBoxEvent().getSelectedIndex() > 0 && view.getComboBoxSubEvent().getSelectedIndex() > 0) {
            try {
                view.getModel().setRowCount(0);
                CompetitionEvent selectedEvent = GetObjectFromCBoxEvent.getObject(cBoxEvent);

                SubEvent selectedSubEvent = GetObjectFromCBoxSubEvent.getObject(cBoxSubEvent);

                List<TeamRace> teamRaceList;

                if (isEditMode) {
                    teamRaceList = database.teamRaceListDone(selectedEvent, selectedSubEvent);
                } else {
                    teamRaceList = database.teamRaceListNotDone(selectedEvent, selectedSubEvent);
                }

                for (TeamRace teamRace : teamRaceList) {
                    Object[] o = {teamRace.getId().intValue()
                            , teamRace.getEventTeamRegistry().getBib()
                            , teamRace.getStartTime()
                            , teamRace.getFinishTime()
                            , teamRace.getG1()
                            , teamRace.getG2()
                            , teamRace.getG3()
                            , teamRace.getG4()
                            , teamRace.getG5()
                            , teamRace.getG6()
                            , teamRace.getG7()
                            , teamRace.getG8()
                            , teamRace.getG9()
                            , teamRace.getG10()
                            , teamRace.getG11()
                            , teamRace.getG12()
                            , teamRace.getG13()
                            , teamRace.getG14()
                            , teamRace.getG15()
                            , teamRace.getG16()
                            , teamRace.getG17()
                            , teamRace.getG18()
                            , teamRace.getG19()
                            , teamRace.getG20()
                            , teamRace.getG21()
                            , teamRace.getG22()
                            , teamRace.getG23()
                            , teamRace.getG24()
                            , teamRace.getP15()
                            , teamRace.getEventTeamRegistry()
                            ,teamRace.getCompetitionEvent()
                            , teamRace.getSubEvent()
                            , teamRace.isDsqr()
                            , teamRace.isDone()};
                    view.getModel().addRow(o);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR getting team race list");
            }
        } else {
            view.getModel().setRowCount(0);
        }
    }
}
