package lv.initex.report.singleReport.services.processBoatClass.convert;

import lv.initex.domain.reportDomain.single.MergedList;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.CalcPenalty;

import java.util.ArrayList;
import java.util.List;

public class ConvertToMergedBestList {

    public static List<MergedList> convert(List<RaceResultList> list) {
        List<MergedList> mergedList = new ArrayList<>();
        for (RaceResultList r : list) {
            MergedList item = new MergedList(r.getEventSingleRegistry(), r.getHeatOneRaceTime(), r.isHeatOneDsqr(), r.getHeatOneTotal()
                    , r.getHeatTwoRaceTime(), r.isHeatTwoDsqr(), r.getHeatTwoTotal(), r.getBestH1H2(),r.getRankBestH1H2());
            item.setPenaltyTotalHeatOne(CalcPenalty.calcPenalty(r.getHeatOnePenaltyList()));
            item.setPenaltyTotalHeatTwo(CalcPenalty.calcPenalty(r.getHeatTwoPenaltyList()));
            mergedList.add(item);
        }
        return mergedList;
    }


}
