package lv.initex.domain.reportDomain.single;

import lv.initex.domain.EventSingleRegistry;

import java.math.BigDecimal;

public class SingleRaceStageList {

    private EventSingleRegistry eventSingleRegistry;
    private long startTime;
    private long finishTime;
    private int[] penaltyList;
    private BigDecimal raceTime;
    private boolean dsqr;
    private BigDecimal total;
    private int rank;
    private boolean qualified;
    private String subEvent;



    public SingleRaceStageList(EventSingleRegistry eventSingleRegistry, long startTime, long finishTime
            , int[] penaltyList, BigDecimal raceTime, boolean dsqr, BigDecimal total, int rank, boolean qualified, String subEvent) {
        this.eventSingleRegistry = eventSingleRegistry;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.penaltyList = penaltyList;
        this.raceTime = raceTime;
        this.dsqr = dsqr;
        this.total = total;
        this.rank = rank;
        this.qualified = qualified;
        this.subEvent =subEvent;

    }

    public  EventSingleRegistry getEventSingleRegistry() {
        return eventSingleRegistry;
    }

    public void setEventSingleRegistry(EventSingleRegistry eventSingleRegistry) {
        this.eventSingleRegistry = eventSingleRegistry;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public int[] getPenaltyList() {
        return penaltyList;
    }

    public void setPenaltyList(int[] penaltyList) {
        this.penaltyList = penaltyList;
    }

    public BigDecimal getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(BigDecimal raceTime) {
        this.raceTime = raceTime;
    }

    public boolean isDsqr() {
        return dsqr;
    }

    public void setDsqr(boolean dsqr) {
        this.dsqr = dsqr;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isQualified() {
        return qualified;
    }

    public void setQualified(boolean qualified) {
        this.qualified = qualified;
    }

    public String getSubEvent() {
        return subEvent;
    }

    public void setSubEvent(String subEvent) {
        this.subEvent = subEvent;
    }
}
