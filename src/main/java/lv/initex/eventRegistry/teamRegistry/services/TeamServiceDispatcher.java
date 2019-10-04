package lv.initex.eventRegistry.teamRegistry.services;

import lv.initex.database.TeamEventRegistryRepository;
import lv.initex.eventRegistry.teamRegistry.EventTeamRegistryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceDispatcher {

    private TeamEventRegistryRepository database;
    private DeleteFromRegistryTeam deleteFromRegistryTeam = new DeleteFromRegistryTeam();
    private UpdateToRegistryTeam updateToRegistryTeam = new UpdateToRegistryTeam();
    private AddTeamRegistry addTeamRegistry = new AddTeamRegistry();

    @Autowired
    public TeamServiceDispatcher(TeamEventRegistryRepository database) {
        this.database = database;
    }

    public void initModel(EventTeamRegistryView view) {
        InitEventTeamRegistryModel.init(view, database);
    }

    public void deleteFromRegistryTeam(EventTeamRegistryView view) {
        deleteFromRegistryTeam.execute(view, database);
    }

    public void updateToRegistryTeam(EventTeamRegistryView view) {
        updateToRegistryTeam.execute(view, database);
    }

    public void addTeamRegistry(EventTeamRegistryView view) {
        addTeamRegistry.execute(view, database);
    }
}
