package lv.initex.raceConfig.services;

import lv.initex.database.RaceConfigRepository;
import lv.initex.raceConfig.RaceConfigView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceConfigServiceDispatcher {

    private RaceConfigRepository database;
    private AddRaceConfig addRaceConfig = new AddRaceConfig();
    private DeleteRaceConfig deleteRaceConfig = new DeleteRaceConfig();

    @Autowired
    public RaceConfigServiceDispatcher(RaceConfigRepository database) {
        this.database = database;
    }

    public void initRaceConfigModel(RaceConfigView view) {
        InitRaceConfigModel.init(view, database);
    }

    public void addRaceConfig(RaceConfigView view) {
        addRaceConfig.execute(view, database);
    }

    public void deleteRaceConfig(RaceConfigView view) {
        deleteRaceConfig.execute(view, database);
    }
}
