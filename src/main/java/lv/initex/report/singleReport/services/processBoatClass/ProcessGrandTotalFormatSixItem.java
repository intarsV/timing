package lv.initex.report.singleReport.services.processBoatClass;

import lv.initex.domain.reportDomain.single.GrandTotalList;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.CalcPenalty;

public class ProcessGrandTotalFormatSixItem {

    public static void process(RaceResultList r, GrandTotalList item) {
        item.setEventSingleRegistry(r.getEventSingleRegistry());

        if (r.isHeatOneQualified() == false) {
            item.setStage("Heats");
            item.setTotal(r.getHeatOneTotal());
            item.setPenalty(CalcPenalty.calcPenalty(r.getHeatOnePenaltyList()));
            item.setRank(r.getRankHeatOne());

        } else {
            item.setTotal(r.getFinalTotal());
            item.setStage("Final");
            item.setFinalQualified(true);
            item.setRank(r.getRankFinal());
            item.setPenalty(CalcPenalty.calcPenalty(r.getFinalPenaltyList()));
        }
    }
}
