package lv.initex.report.singleReport.services.processBoatClass;

import lv.initex.domain.reportDomain.single.GrandTotalList;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.CalcPenalty;

public class ProcessGrandTotalFormatTwoItem {

    public static void process(RaceResultList r, GrandTotalList item, int heatsRankCorrection) {
        item.setEventSingleRegistry(r.getEventSingleRegistry());

        if (r.isHeatTwoQualified() == false && r.isHeatOneQualified() == false) {
            item.setStage("Heats");
            item.setTotal(r.getHeatTwoTotal());
            item.setRaceTime(r.getHeatTwoRaceTime());
            item.setPenalty(CalcPenalty.calcPenalty(r.getHeatTwoPenaltyList()));
            if(r.getRankHeatTwo()>0) {
                item.setRank(r.getRankHeatTwo() + heatsRankCorrection);
            }
        } else {
            item.setStage("Final");
            item.setTotal(r.getFinalTotal());
            item.setFinalQualified(true);
            item.setSemiFinalQualified(true);
            item.setRank(r.getRankFinal());
            item.setRaceTime(r.getFinalRaceTime());
            item.setPenalty(CalcPenalty.calcPenalty(r.getFinalPenaltyList()));
        }
    }
}
