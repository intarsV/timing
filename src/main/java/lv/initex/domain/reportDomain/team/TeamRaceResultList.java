package lv.initex.domain.reportDomain.team;

import lv.initex.domain.EventTeamRegistry;

import java.math.BigDecimal;


public class TeamRaceResultList {


    private EventTeamRegistry eventTeamRegistry;

    private int bib = 0;

    private long heatOneStartTime = 0;
    private long heatOneFinishTime = 0;
    private int[] heatOnePenaltyList = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private BigDecimal heatOneRaceTime = new BigDecimal(0);
    private boolean heatOneDsqr = false;
    private BigDecimal heatOneTotal = new BigDecimal(9999);     //Default 9999=DNS
    private int rankHeatOne = 0;


    public TeamRaceResultList(EventTeamRegistry eventTeamRegistry, int bib) {
        this.eventTeamRegistry = eventTeamRegistry;
        this.bib = bib;
    }

    public EventTeamRegistry getEventTeamRegistry() {
        return eventTeamRegistry;
    }

    public void setEventTeamRegistry(EventTeamRegistry eventTeamRegistry) {
        this.eventTeamRegistry = eventTeamRegistry;
    }

    public int getBib() {
        return bib;
    }

    public void setBib(int bib) {
        this.bib = bib;
    }

    public long getHeatOneStartTime() {
        return heatOneStartTime;
    }

    public void setHeatOneStartTime(long heatOneStartTime) {
        this.heatOneStartTime = heatOneStartTime;
    }

    public long getHeatOneFinishTime() {
        return heatOneFinishTime;
    }

    public void setHeatOneFinishTime(long heatOneFinishTime) {
        this.heatOneFinishTime = heatOneFinishTime;
    }

    public int[] getHeatOnePenaltyList() {
        return heatOnePenaltyList;
    }

    public void setHeatOnePenaltyList(int[] heatOnePenaltyList) {
        this.heatOnePenaltyList = heatOnePenaltyList;
    }

    public BigDecimal getHeatOneRaceTime() {
        return heatOneRaceTime;
    }

    public void setHeatOneRaceTime(BigDecimal heatOneRaceTime) {
        this.heatOneRaceTime = heatOneRaceTime;
    }

    public boolean isHeatOneDsqr() {
        return heatOneDsqr;
    }

    public void setHeatOneDsqr(boolean heatOneDsqr) {
        this.heatOneDsqr = heatOneDsqr;
    }

    public BigDecimal getHeatOneTotal() {
        return heatOneTotal;
    }

    public void setHeatOneTotal(BigDecimal heatOneTotal) {
        this.heatOneTotal = heatOneTotal;
    }

    public int getRankHeatOne() {
        return rankHeatOne;
    }

    public void setRankHeatOne(int rankHeatOne) {
        this.rankHeatOne = rankHeatOne;
    }
}
