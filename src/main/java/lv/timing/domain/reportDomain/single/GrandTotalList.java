package lv.timing.domain.reportDomain.single;

import lv.timing.domain.EventSingleRegistry;

import java.math.BigDecimal;

public class GrandTotalList {

    private EventSingleRegistry eventSingleRegistry;

    private int penalty;
    private BigDecimal raceTime;
    private boolean dsqr;

    private boolean semiFinalQualified;
    private boolean finalQualified;

    private String stage;
    private BigDecimal total;
    private int rank;

    public GrandTotalList(EventSingleRegistry eventSingleRegistry) {
        this.eventSingleRegistry = eventSingleRegistry;
    }

    public EventSingleRegistry getEventSingleRegistry() {
        return eventSingleRegistry;
    }

    public void setEventSingleRegistry(EventSingleRegistry eventSingleRegistry) {
        this.eventSingleRegistry = eventSingleRegistry;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
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

    public boolean isSemiFinalQualified() {
        return semiFinalQualified;
    }

    public void setSemiFinalQualified(boolean semiFinalQualified) {
        this.semiFinalQualified = semiFinalQualified;
    }

    public boolean isFinalQualified() {
        return finalQualified;
    }

    public void setFinalQualified(boolean finalQualified) {
        this.finalQualified = finalQualified;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
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
