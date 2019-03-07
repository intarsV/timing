package lv.timing.report.singleReport.services.processBoatClass;

import lv.timing.domain.reportDomain.GrandTotalList;
import lv.timing.domain.reportDomain.RaceResultList;
import lv.timing.report.singleReport.services.processBoatClass.claclulations.CalcPenalty;

public class ProcessGrandTotalFormatThreeItem {

    public static void process(RaceResultList r, GrandTotalList item, int heatsRankCorrection) {
        item.setEventSingleRegistry(r.getEventSingleRegistry());

        if (r.isHeatTwoQualified() == false && r.isHeatOneQualified() == false) {
            item.setStage("Heats");
            item.setTotal(r.getHeatTwoTotal());
            item.setPenalty(CalcPenalty.calcPenalty(r.getHeatTwoPenaltyList()));
            item.setRank(r.getRankHeatTwo() + heatsRankCorrection);

        } else if (r.isHeatTwoQualified() == true && r.isSemiFinalQualified() == false || r.isHeatOneQualified() == true && r.isSemiFinalQualified() == false) {
            item.setStage("Semi-Final");
            item.setTotal(r.getSemiFinalTotal());
            item.setSemiFinalQualified(true);
            item.setRank(r.getRankSemiFinal());
            item.setPenalty(CalcPenalty.calcPenalty(r.getSemiFinalPenaltyList()));
        } else {
            item.setStage("Final");
            item.setTotal(r.getFinalTotal());
            item.setFinalQualified(true);
            item.setSemiFinalQualified(true);
            item.setRank(r.getRankFinal());
            item.setPenalty(CalcPenalty.calcPenalty(r.getFinalPenaltyList()));
        }
    }
}
