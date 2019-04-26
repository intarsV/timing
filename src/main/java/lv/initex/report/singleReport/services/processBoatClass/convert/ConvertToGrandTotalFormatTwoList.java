package lv.initex.report.singleReport.services.processBoatClass.convert;

import lv.initex.domain.reportDomain.single.GrandTotalList;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.report.singleReport.services.processBoatClass.ProcessGrandTotalFormatTwoItem;

import java.util.ArrayList;
import java.util.List;

public class ConvertToGrandTotalFormatTwoList {

    public static List<GrandTotalList> convert(List<RaceResultList> list) {
        List<GrandTotalList> mergedList = new ArrayList<>();
        int heatsRankCorrection = countH2Q(list);
        for (RaceResultList rawData : list) {
            GrandTotalList item = new GrandTotalList(rawData.getEventSingleRegistry());
            ProcessGrandTotalFormatTwoItem.process(rawData, item, heatsRankCorrection);
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
