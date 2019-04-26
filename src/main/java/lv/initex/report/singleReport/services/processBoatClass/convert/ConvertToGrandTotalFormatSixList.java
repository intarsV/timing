package lv.initex.report.singleReport.services.processBoatClass.convert;

import lv.initex.domain.reportDomain.single.GrandTotalList;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.report.singleReport.services.processBoatClass.ProcessGrandTotalFormatSixItem;

import java.util.ArrayList;
import java.util.List;

public class ConvertToGrandTotalFormatSixList {

    public static List<GrandTotalList> convert(List<RaceResultList> list) {
        List<GrandTotalList> mergedList = new ArrayList<>();
        for (RaceResultList rawData : list) {
            GrandTotalList item = new GrandTotalList(rawData.getEventSingleRegistry());
            ProcessGrandTotalFormatSixItem.process(rawData, item);
            mergedList.add(item);
        }
        return mergedList;
    }
}
