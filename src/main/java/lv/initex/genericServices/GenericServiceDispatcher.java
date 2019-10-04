package lv.initex.genericServices;

import lv.initex.database.GenericServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class GenericServiceDispatcher {

    private GenericServicesRepository database;
    private InitCBoxCompetitors initCBoxCompetitors = new InitCBoxCompetitors();
    private InitCBoxEvent initCBoxEvent = new InitCBoxEvent();
    private InitCBoxGroup initCBoxGroup = new InitCBoxGroup();
    private InitCBoxSingleBoatClass initCBoxSingleBoatClass = new InitCBoxSingleBoatClass();
    private InitCBoxSubEvent initCBoxSubEvent = new InitCBoxSubEvent();
    private InitCBoxTeamBoatClass initCBoxTeamBoatClass = new InitCBoxTeamBoatClass();

    @Autowired
    public GenericServiceDispatcher(GenericServicesRepository database) {
        this.database = database;
    }

    public void initCBoxCompetitors(JComboBox cBoxCompetitors) {
        initCBoxCompetitors.init(cBoxCompetitors, database);
    }

    public void initCBoxEvent(JComboBox cBoxEvent) {
        initCBoxEvent.init(cBoxEvent, database);
    }

    public void initCBoxGroup(JComboBox cBoxGroup) {
        initCBoxGroup.init(cBoxGroup, database);
    }

    public void initCBoxSingleBoatClass(JComboBox cBoxSingleBoatClass) {
        initCBoxSingleBoatClass.init(cBoxSingleBoatClass, database);
    }

    public void initCBoxSubEvent(JComboBox cBoxEvent, JComboBox cBoxSubEvent) {
        initCBoxSubEvent.init(cBoxEvent, cBoxSubEvent, database);
    }

    public void initCBoxTeamBoatClass(JComboBox cBoxTeamBoatClass) {
        initCBoxTeamBoatClass.init(cBoxTeamBoatClass, database);
    }
}
