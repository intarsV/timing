package lv.initex.report.singleReport.services.processBoatClass;

import lv.initex.domain.reportDomain.single.GrandTotalList;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.CalcPenalty;

public class ProcessGrandTotalFormatFiveItem {

    public static void process(RaceResultList r, GrandTotalList item) {
        item.setEventSingleRegistry(r.getEventSingleRegistry());

        if (r.isBestH1h2Qualified() == false) {
            int compare = r.getHeatOneTotal().compareTo(r.getHeatTwoTotal());
            item.setStage("Heats");
            if (compare == 1) {
                item.setRaceTime(r.getHeatTwoRaceTime());
                item.setTotal(r.getHeatTwoTotal());
                item.setPenalty(CalcPenalty.calcPenalty(r.getHeatTwoPenaltyList()));
                item.setRank(r.getRankBestH1H2());
            } else {
                item.setRaceTime(r.getHeatOneRaceTime());
                item.setTotal(r.getHeatOneTotal());
                item.setPenalty(CalcPenalty.calcPenalty(r.getHeatOnePenaltyList()));
                item.setRank(r.getRankBestH1H2());
            }
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
