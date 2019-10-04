package lv.initex.verifyMcuData;

import lv.initex.race.Observer;

public interface Observable {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
