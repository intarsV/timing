package lv.initex.report.singleReport.services.processBoatClass;

import lv.initex.domain.reportDomain.single.GrandTotalList;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.CalcPenalty;

public class ProcessGrandTotalFormatThreeItem {

    public static void process(RaceResultList r, GrandTotalList item, int heatsRankCorrection) {
        item.setEventSingleRegistry(r.getEventSingleRegistry());

        if (r.isHeatTwoQualified() == false && r.isHeatOneQualified() == false) {
            item.setStage("Heats");
            item.setRaceTime(r.getHeatTwoRaceTime());
            item.setTotal(r.getHeatTwoTotal());
            item.setPenalty(CalcPenalty.calcPenalty(r.getHeatTwoPenaltyList()));
            item.setRank(r.getRankHeatTwo() + heatsRankCorrection);

        } else if (r.isHeatTwoQualified() == true && r.isSemiFinalQualified() == false || r.isHeatOneQualified() == true && r.isSemiFinalQualified() == false) {
            item.setStage("Semi-Final");
            item.setRaceTime(r.getSemiFinalRaceTime());
            item.setTotal(r.getSemiFinalTotal());
            item.setSemiFinalQualified(true);
            item.setRank(r.getRankSemiFinal());
            item.setPenalty(CalcPenalty.calcPenalty(r.getSemiFinalPenaltyList()));
        } else {
            item.setStage("Final");
            item.setRaceTime(r.getFinalRaceTime());
            item.setTotal(r.getFinalTotal());
            item.setFinalQualified(true);
            item.setSemiFinalQualified(true);
            item.setRank(r.getRankFinal());
            item.setPenalty(CalcPenalty.calcPenalty(r.getFinalPenaltyList()));
        }
    }
}
