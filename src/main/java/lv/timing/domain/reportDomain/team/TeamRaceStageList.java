package lv.timing.domain.reportDomain.team;

import lv.timing.domain.EventTeamRegistry;

import java.math.BigDecimal;

public class TeamRaceStageList {


    private EventTeamRegistry eventTeamRegistry;
    private long startTime;
    private long finishTime;
    private int[] penaltyList;
    private BigDecimal raceTime;
    private boolean dsqr;
    private BigDecimal total;
    private int rank;
    private String subEvent;


    public TeamRaceStageList(EventTeamRegistry eventTeamRegistry, long startTime, long finishTime
            , int[] penaltyList, BigDecimal raceTime, boolean dsqr, BigDecimal total, int rank, String subEvent) {
        this.eventTeamRegistry = eventTeamRegistry;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.penaltyList = penaltyList;
        this.raceTime = raceTime;
        this.dsqr = dsqr;
        this.total = total;
        this.rank = rank;
        this.subEvent = subEvent;

    }

    public EventTeamRegistry getEventTeamRegistry() {
        return eventTeamRegistry;
    }

    public void setEventTeamRegistry(EventTeamRegistry eventTeamRegistry) {
        this.eventTeamRegistry = eventTeamRegistry;
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

    public String getSubEvent() {
        return subEvent;
    }

    public void setSubEvent(String subEvent) {
        this.subEvent = subEvent;
    }
}
