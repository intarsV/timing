package lv.timing.report.singleReport.services.processBoatClass;

import lv.timing.domain.reportDomain.single.GrandTotalList;
import lv.timing.domain.reportDomain.single.RaceResultList;
import lv.timing.report.singleReport.services.processBoatClass.claclulations.CalcPenalty;

public class ProcessGrandTotalFormatTwoItem {

    public static void process(RaceResultList r, GrandTotalList item, int heatsRankCorrection) {
        item.setEventSingleRegistry(r.getEventSingleRegistry());

        if (r.isHeatTwoQualified() == false && r.isHeatOneQualified() == false) {
            item.setStage("Heats");
            item.setTotal(r.getHeatTwoTotal());
            item.setPenalty(CalcPenalty.calcPenalty(r.getHeatTwoPenaltyList()));
            item.setRank(r.getRankHeatTwo() + heatsRankCorrection);

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
