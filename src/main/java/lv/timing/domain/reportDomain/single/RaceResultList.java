package lv.timing.domain.reportDomain.single;

import lv.timing.domain.EventSingleRegistry;

import java.math.BigDecimal;


public class RaceResultList {


    private EventSingleRegistry eventSingleRegistry;

    private int bib = 0;

    private long heatOneStartTime = 0;
    private long heatOneFinishTime = 0;
    private int[] heatOnePenaltyList = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private BigDecimal heatOneRaceTime = new BigDecimal(0);
    private boolean heatOneDsqr = false;
    private BigDecimal heatOneTotal = new BigDecimal(9999);     //Default 9999=DNS
    private int rankHeatOne = 0;
    private boolean heatOneQualified = false;

    private long heatTwoStartTime = 0;
    private long heatTwoFinishTime = 0;
    private int[] heatTwoPenaltyList = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private BigDecimal heatTwoRaceTime = new BigDecimal(0);
    private boolean heatTwoDsqr = false;
    private BigDecimal heatTwoTotal = new BigDecimal(9999);     //Default 9999=DNS
    private int rankHeatTwo = 0;
    private boolean heatTwoQualified = false;

    private long SemiFinalStartTime = 0;
    private long SemiFinalFinishTime = 0;
    private int[] SemiFinalPenaltyList = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private BigDecimal SemiFinalRaceTime = new BigDecimal(0);
    private boolean semiFinalDsqr = false;
    private BigDecimal SemiFinalTotal = new BigDecimal(9999);    //Default 9999=DNS
    private int rankSemiFinal = 0;
    private boolean semiFinalQualified = false;

    private long FinalStartTime = 0;
    private long FinalFinishTime = 0;
    private int[] FinalPenaltyList = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private BigDecimal FinalRaceTime = new BigDecimal(0);
    private boolean finalDsqr = false;
    private BigDecimal FinalTotal = new BigDecimal(9999);         //Default 9999=DNS
    private int rankFinal = 0;

    private BigDecimal bestH1H2 = new BigDecimal(9999);             //Default 9999=DNS
    private BigDecimal sumH1H2 = new BigDecimal(9999);              //Default 9999=DNS

    private int rankBestH1H2 = 0;
    private boolean bestH1h2Qualified = false;
    private int rankSumH1H2 = 0;
    private boolean sumH1H2Qualified = false;

    public RaceResultList(EventSingleRegistry eventSingleRegistry, int bib) {
        this.eventSingleRegistry = eventSingleRegistry;
        this.bib = bib;
    }

    public EventSingleRegistry getEventSingleRegistry() {
        return eventSingleRegistry;
    }

    public void setEventSingleRegistry(EventSingleRegistry eventSingleRegistry) {
        this.eventSingleRegistry = eventSingleRegistry;
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

    public long getHeatTwoStartTime() {
        return heatTwoStartTime;
    }

    public void setHeatTwoStartTime(long heatTwoStartTime) {
        this.heatTwoStartTime = heatTwoStartTime;
    }

    public long getHeatTwoFinishTime() {
        return heatTwoFinishTime;
    }

    public void setHeatTwoFinishTime(long heatTwoFinishTime) {
        this.heatTwoFinishTime = heatTwoFinishTime;
    }

    public int[] getHeatTwoPenaltyList() {
        return heatTwoPenaltyList;
    }

    public void setHeatTwoPenaltyList(int[] heatTwoPenaltyList) {
        this.heatTwoPenaltyList = heatTwoPenaltyList;
    }

    public BigDecimal getHeatTwoRaceTime() {
        return heatTwoRaceTime;
    }

    public void setHeatTwoRaceTime(BigDecimal heatTwoRaceTime) {
        this.heatTwoRaceTime = heatTwoRaceTime;
    }

    public BigDecimal getHeatTwoTotal() {
        return heatTwoTotal;
    }

    public void setHeatTwoTotal(BigDecimal heatTwoTotal) {
        this.heatTwoTotal = heatTwoTotal;
    }

    public int getRankHeatTwo() {
        return rankHeatTwo;
    }

    public void setRankHeatTwo(int rankHeatTwo) {
        this.rankHeatTwo = rankHeatTwo;
    }

    public long getSemiFinalStartTime() {
        return SemiFinalStartTime;
    }

    public void setSemiFinalStartTime(long semiFinalStartTime) {
        SemiFinalStartTime = semiFinalStartTime;
    }

    public long getSemiFinalFinishTime() {
        return SemiFinalFinishTime;
    }

    public void setSemiFinalFinishTime(long semiFinalFinishTime) {
        SemiFinalFinishTime = semiFinalFinishTime;
    }

    public int[] getSemiFinalPenaltyList() {
        return SemiFinalPenaltyList;
    }

    public void setSemiFinalPenaltyList(int[] semiFinalPenaltyList) {
        SemiFinalPenaltyList = semiFinalPenaltyList;
    }

    public BigDecimal getSemiFinalRaceTime() {
        return SemiFinalRaceTime;
    }

    public void setSemiFinalRaceTime(BigDecimal semiFinalRaceTime) {
        SemiFinalRaceTime = semiFinalRaceTime;
    }

    public BigDecimal getSemiFinalTotal() {
        return SemiFinalTotal;
    }

    public void setSemiFinalTotal(BigDecimal semiFinalTotal) {
        SemiFinalTotal = semiFinalTotal;
    }

    public int getRankSemiFinal() {
        return rankSemiFinal;
    }

    public void setRankSemiFinal(int rankSemiFinal) {
        this.rankSemiFinal = rankSemiFinal;
    }

    public long getFinalStartTime() {
        return FinalStartTime;
    }

    public void setFinalStartTime(long finalStartTime) {
        FinalStartTime = finalStartTime;
    }

    public long getFinalFinishTime() {
        return FinalFinishTime;
    }

    public void setFinalFinishTime(long finalFinishTime) {
        FinalFinishTime = finalFinishTime;
    }

    public int[] getFinalPenaltyList() {
        return FinalPenaltyList;
    }

    public void setFinalPenaltyList(int[] finalPenaltyList) {
        FinalPenaltyList = finalPenaltyList;
    }

    public BigDecimal getFinalRaceTime() {
        return FinalRaceTime;
    }

    public void setFinalRaceTime(BigDecimal finalRaceTime) {
        FinalRaceTime = finalRaceTime;
    }

    public BigDecimal getFinalTotal() {
        return FinalTotal;
    }

    public void setFinalTotal(BigDecimal finalTotal) {
        FinalTotal = finalTotal;
    }

    public int getRankFinal() {
        return rankFinal;
    }

    public void setRankFinal(int rankFinal) {
        this.rankFinal = rankFinal;
    }

    public boolean isHeatOneDsqr() {
        return heatOneDsqr;
    }

    public void setHeatOneDsqr(boolean heatOneDsqr) {
        this.heatOneDsqr = heatOneDsqr;
    }

    public boolean isHeatTwoDsqr() {
        return heatTwoDsqr;
    }

    public void setHeatTwoDsqr(boolean heatTwoDsqr) {
        this.heatTwoDsqr = heatTwoDsqr;
    }

    public boolean isSemiFinalDsqr() {
        return semiFinalDsqr;
    }

    public void setSemiFinalDsqr(boolean semiFinalDsqr) {
        this.semiFinalDsqr = semiFinalDsqr;
    }

    public boolean isFinalDsqr() {
        return finalDsqr;
    }

    public void setFinalDsqr(boolean finalDsqr) {
        this.finalDsqr = finalDsqr;
    }

    public boolean isHeatOneQualified() {
        return heatOneQualified;
    }

    public void setHeatOneQualified(boolean heatOneQualified) {
        this.heatOneQualified = heatOneQualified;
    }

    public boolean isHeatTwoQualified() {
        return heatTwoQualified;
    }

    public void setHeatTwoQualified(boolean heatTwoQualified) {
        this.heatTwoQualified = heatTwoQualified;
    }

    public boolean isSemiFinalQualified() {
        return semiFinalQualified;
    }

    public void setSemiFinalQualified(boolean semiFinalQualified) {
        this.semiFinalQualified = semiFinalQualified;
    }

    public BigDecimal getBestH1H2() {
        return bestH1H2;
    }

    public void setBestH1H2(BigDecimal bestH1H2) {
        this.bestH1H2 = bestH1H2;
    }

    public BigDecimal getSumH1H2() {
        return sumH1H2;
    }

    public void setSumH1H2(BigDecimal sumH1H2) {
        this.sumH1H2 = sumH1H2;
    }

    public int getRankSumH1H2() {
        return rankSumH1H2;
    }

    public void setRankSumH1H2(int rankSumH1H2) {
        this.rankSumH1H2 = rankSumH1H2;
    }

    public int getRankBestH1H2() {
        return rankBestH1H2;
    }

    public void setRankBestH1H2(int rankBestH1H2) {
        this.rankBestH1H2 = rankBestH1H2;
    }

    public boolean isBestH1h2Qualified() {
        return bestH1h2Qualified;
    }

    public void setBestH1h2Qualified(boolean bestH1h2Qualified) {
        this.bestH1h2Qualified = bestH1h2Qualified;
    }

    public boolean isSumH1H2Qualified() {
        return sumH1H2Qualified;
    }

    public void setSumH1H2Qualified(boolean sumH1H2Qualified) {
        this.sumH1H2Qualified = sumH1H2Qualified;
    }
}
