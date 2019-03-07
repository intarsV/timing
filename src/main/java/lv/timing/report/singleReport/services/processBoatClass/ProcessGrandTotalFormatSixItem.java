package lv.timing.report.singleReport.services.processBoatClass;

import lv.timing.domain.reportDomain.GrandTotalList;
import lv.timing.domain.reportDomain.RaceResultList;
import lv.timing.report.singleReport.services.processBoatClass.claclulations.CalcPenalty;

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
