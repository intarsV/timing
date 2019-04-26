package lv.initex.report.singleReport.services.processBoatClass;

import lv.initex.domain.SubEvent;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.domain.reportDomain.single.SingleRaceStageList;

import java.util.ArrayList;
import java.util.List;

public class ProcessStageBoatClassList {

    public static List<SingleRaceStageList> prepareList(List<RaceResultList> list, SubEvent subevent) {
        List<SingleRaceStageList> previewList = new ArrayList<>();
        for (RaceResultList item : list) {
            switch (subevent.getSubEvent()) {

                case "Heat 1":
                    previewList.add(new SingleRaceStageList(item.getEventSingleRegistry(), item.getHeatOneStartTime()
                            , item.getHeatOneFinishTime(), item.getHeatOnePenaltyList(), item.getHeatOneRaceTime()
                            , item.isHeatOneDsqr(), item.getHeatOneTotal(), item.getRankHeatOne(), item.isHeatOneQualified()
                            , subevent.getSubEvent()));
                    break;
                case "Heat 2":
                    previewList.add(new SingleRaceStageList(item.getEventSingleRegistry(), item.getHeatTwoStartTime()
                            , item.getHeatTwoFinishTime(), item.getHeatTwoPenaltyList(), item.getHeatTwoRaceTime()
                            , item.isHeatTwoDsqr(), item.getHeatTwoTotal(), item.getRankHeatTwo(), item.isHeatTwoQualified()
                            , subevent.getSubEvent()));
                    break;
                case "Semi-Final":
                    previewList.add(new SingleRaceStageList(item.getEventSingleRegistry(), item.getSemiFinalStartTime()
                            , item.getSemiFinalFinishTime(), item.getSemiFinalPenaltyList(), item.getSemiFinalRaceTime()
                            , item.isSemiFinalDsqr(), item.getSemiFinalTotal(), item.getRankSemiFinal(), item.isSemiFinalQualified()
                            , subevent.getSubEvent()));
                    break;
                case "Final":
                    previewList.add(new SingleRaceStageList(item.getEventSingleRegistry(), item.getFinalStartTime()
                            , item.getFinalFinishTime(), item.getFinalPenaltyList(), item.getFinalRaceTime()
                            , item.isFinalDsqr(), item.getFinalTotal(), item.getRankFinal(), false
                            , subevent.getSubEvent()));
                    break;
            }

        }
        return previewList;
    }
}
