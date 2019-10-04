package lv.initex.eventRegistry.singleRegistry.services;

import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.eventRegistry.singleRegistry.EventSingleRegistryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingleRegServiceDispatcher {

    private SingleEventRegistryRepository database;
    private DeleteFromRegistry deleteFromRegistry = new DeleteFromRegistry();
    private UpdateToRegistry updateToRegistry = new UpdateToRegistry();
    private AddSingleRegistry addSingleRegistry = new AddSingleRegistry();

    @Autowired
    public SingleRegServiceDispatcher(SingleEventRegistryRepository database) {
        this.database = database;
    }

    public void initModel(EventSingleRegistryView view) {
        InitEventSingleRegistryModel.init(view, database);
    }

    public void deleteFromRegistry(EventSingleRegistryView view) {
        deleteFromRegistry.execute(view, database);
    }

    public void updateToRegistry(EventSingleRegistryView view) {
        updateToRegistry.execute(view, database);
    }

    public void addSingleRegistry(EventSingleRegistryView view) {
        addSingleRegistry.execute(view, database);
    }
}
