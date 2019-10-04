package lv.initex.report.singleReport.services.processBoatClass.convert;

import lv.initex.domain.reportDomain.single.GrandTotalList;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.report.singleReport.services.processBoatClass.ProcessGrandTotalFormatSevenItem;

import java.util.ArrayList;
import java.util.List;

public class ConvertToGrandTotalFormatSevenList {

    public static List<GrandTotalList> convert(List<RaceResultList> list) {
        List<GrandTotalList> mergedList = new ArrayList<>();
        for (RaceResultList rawData : list) {
            GrandTotalList item = new GrandTotalList(rawData.getEventSingleRegistry());
            ProcessGrandTotalFormatSevenItem.process(rawData, item);
            mergedList.add(item);
        }
        return mergedList;
    }


}
