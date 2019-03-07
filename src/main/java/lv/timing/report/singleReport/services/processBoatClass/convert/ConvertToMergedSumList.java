package lv.timing.report.singleReport.services.processBoatClass.convert;

import lv.timing.domain.reportDomain.MergedList;
import lv.timing.domain.reportDomain.RaceResultList;
import lv.timing.report.singleReport.services.processBoatClass.claclulations.CalcPenalty;

import java.util.ArrayList;
import java.util.List;

public class ConvertToMergedSumList {

    public static List<MergedList> convert(List<RaceResultList> list) {
        List<MergedList> mergedList = new ArrayList<>();
        for (RaceResultList r : list) {
            MergedList item = new MergedList(r.getEventSingleRegistry(), r.getHeatOneRaceTime(), r.isHeatOneDsqr(), r.getHeatOneTotal()
                    , r.getHeatTwoRaceTime(), r.isHeatTwoDsqr(), r.getHeatTwoTotal(), r.getSumH1H2(), r.getRankSumH1H2());
            item.setPenaltyTotalHeatOne(CalcPenalty.calcPenalty(r.getHeatOnePenaltyList()));
            item.setPenaltyTotalHeatTwo(CalcPenalty.calcPenalty(r.getHeatTwoPenaltyList()));
            mergedList.add(item);
        }
        return mergedList;
    }


}
