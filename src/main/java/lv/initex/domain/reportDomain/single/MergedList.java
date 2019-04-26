package lv.initex.domain.reportDomain.single;

import lv.initex.domain.EventSingleRegistry;

import java.math.BigDecimal;

public class MergedList {


    private EventSingleRegistry eventSingleRegistry;
    private int penaltyTotalHeatOne;
    private BigDecimal raceTimeHeatOne;
    private boolean dsqrHeatOne;
    private BigDecimal totalHeatOne;

    private int penaltyTotalHeatTwo;
    private BigDecimal raceTimeHeatTwo;
    private boolean dsqrHeatTwo;
    private BigDecimal totalHeatTwo;

    private BigDecimal total;
    private int rank;

    public MergedList(EventSingleRegistry eventSingleRegistry, BigDecimal raceTimeHeatOne
            , boolean dsqrHeatOne, BigDecimal totalHeatOne, BigDecimal raceTimeHeatTwo
            , boolean dsqrHeatTwo, BigDecimal totalHeatTwo, BigDecimal total, int rank) {
        this.eventSingleRegistry = eventSingleRegistry;
        this.raceTimeHeatOne = raceTimeHeatOne;
        this.dsqrHeatOne = dsqrHeatOne;
        this.totalHeatOne = totalHeatOne;
        this.raceTimeHeatTwo = raceTimeHeatTwo;
        this.dsqrHeatTwo = dsqrHeatTwo;
        this.totalHeatTwo = totalHeatTwo;
        this.total = total;
        this.rank = rank;
    }

    public EventSingleRegistry getEventSingleRegistry() {
        return eventSingleRegistry;
    }

    public void setEventSingleRegistry(EventSingleRegistry eventSingleRegistry) {
        this.eventSingleRegistry = eventSingleRegistry;
    }

    public int getPenaltyTotalHeatOne() {
        return penaltyTotalHeatOne;
    }

    public void setPenaltyTotalHeatOne(int penaltyTotalHeatOne) {
        this.penaltyTotalHeatOne = penaltyTotalHeatOne;
    }

    public BigDecimal getRaceTimeHeatOne() {
        return raceTimeHeatOne;
    }

    public void setRaceTimeHeatOne(BigDecimal raceTimeHeatOne) {
        this.raceTimeHeatOne = raceTimeHeatOne;
    }

    public boolean isDsqrHeatOne() {
        return dsqrHeatOne;
    }

    public void setDsqrHeatOne(boolean dsqrHeatOne) {
        this.dsqrHeatOne = dsqrHeatOne;
    }

    public BigDecimal getTotalHeatOne() {
        return totalHeatOne;
    }

    public void setTotalHeatOne(BigDecimal totalHeatOne) {
        this.totalHeatOne = totalHeatOne;
    }

    public int getPenaltyTotalHeatTwo() {
        return penaltyTotalHeatTwo;
    }

    public void setPenaltyTotalHeatTwo(int penaltyTotalHeatTwo) {
        this.penaltyTotalHeatTwo = penaltyTotalHeatTwo;
    }

    public BigDecimal getRaceTimeHeatTwo() {
        return raceTimeHeatTwo;
    }

    public void setRaceTimeHeatTwo(BigDecimal raceTimeHeatTwo) {
        this.raceTimeHeatTwo = raceTimeHeatTwo;
    }

    public boolean isDsqrHeatTwo() {
        return dsqrHeatTwo;
    }

    public void setDsqrHeatTwo(boolean dsqrHeatTwo) {
        this.dsqrHeatTwo = dsqrHeatTwo;
    }

    public BigDecimal getTotalHeatTwo() {
        return totalHeatTwo;
    }

    public void setTotalHeatTwo(BigDecimal totalHeatTwo) {
        this.totalHeatTwo = totalHeatTwo;
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
}
