package lv.initex.race;

import lv.initex.verifyMcuData.Observable;

import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.util.List;

public class ViewListener implements InternalFrameListener {
    private List<Observable> observableList;
    private Observer observer;

    public ViewListener(List<Observable> list, Observer o) {
        this.observableList = list;
        this.observer = o;
    }


    @Override
    public void internalFrameOpened(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        for (Observable o : observableList) {
            o.removeObserver(observer);
        }
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {

    }
}
