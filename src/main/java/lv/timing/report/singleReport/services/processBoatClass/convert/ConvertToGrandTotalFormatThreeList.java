package lv.timing.report.singleReport.services.processBoatClass.convert;

import lv.timing.domain.reportDomain.GrandTotalList;
import lv.timing.domain.reportDomain.RaceResultList;
import lv.timing.report.singleReport.services.processBoatClass.ProcessGrandTotalFormatThreeItem;

import java.util.ArrayList;
import java.util.List;

public class ConvertToGrandTotalFormatThreeList {

    public static List<GrandTotalList> convert(List<RaceResultList> list) {
        List<GrandTotalList> mergedList = new ArrayList<>();
        int heatsRankCorrection = countH2Q(list);
        for (RaceResultList rawData : list) {
            GrandTotalList item = new GrandTotalList(rawData.getEventSingleRegistry());
            ProcessGrandTotalFormatThreeItem.process(rawData, item, heatsRankCorrection);
            mergedList.add(item);
        }
        return mergedList;
    }

    private static int countH2Q(List<RaceResultList> list) {
        int heatOneQuality = 0;
        for (RaceResultList i : list) {
            if (i.isHeatOneQualified() == true) {
                heatOneQuality++;
            }
        }
        return heatOneQuality;
    }
}
