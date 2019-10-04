package lv.initex.report.singleReport.services.processBoatClass;

import lv.initex.domain.reportDomain.single.GrandTotalList;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.CalcPenalty;

import java.math.BigDecimal;

public class ProcessGrandTotalFormatSevenItem {

    public static void process(RaceResultList r, GrandTotalList item) {
        item.setEventSingleRegistry(r.getEventSingleRegistry());

        if (r.isSumH1H2Qualified() == false) {
            item.setStage("Heats");
            if (r.getHeatTwoTotal().compareTo(BigDecimal.valueOf(8887)) == 1 && r.getHeatTwoTotal().compareTo(BigDecimal.valueOf(8888)) == 1) {
                item.setRaceTime(r.getHeatOneTotal().add(r.getHeatTwoTotal()));
            } else if (r.getHeatOneTotal().compareTo(BigDecimal.valueOf(8887)) == 1) {
                item.setRaceTime(r.getHeatOneTotal().add(r.getHeatTwoRaceTime()));
            } else if (r.getHeatTwoTotal().compareTo(BigDecimal.valueOf(8887)) == 1) {
                item.setRaceTime(r.getHeatOneRaceTime().add(r.getHeatTwoTotal()));
            } else {
                item.setRaceTime(r.getHeatOneRaceTime().add(r.getHeatTwoRaceTime()));
            }
            item.setTotal(r.getHeatOneTotal().add(r.getHeatTwoTotal()));
            item.setPenalty(CalcPenalty.calcPenalty(r.getHeatOnePenaltyList()) + CalcPenalty.calcPenalty(r.getHeatTwoPenaltyList()));
            item.setRank(r.getRankSumH1H2());
        } else {
            item.setTotal(r.getFinalTotal());
            item.setRaceTime(r.getFinalRaceTime());
            item.setStage("Final");
            item.setFinalQualified(true);
            item.setRank(r.getRankFinal());
            item.setPenalty(CalcPenalty.calcPenalty(r.getFinalPenaltyList()));
        }
    }
}
