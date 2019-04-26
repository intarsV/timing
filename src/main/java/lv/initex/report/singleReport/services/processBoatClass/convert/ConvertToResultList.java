package lv.initex.report.singleReport.services.processBoatClass.convert;

import lv.initex.domain.EventSingleRegistry;
import lv.initex.domain.SingleRace;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.CalcRaceTime;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.CalcTotal;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.SetStartFinishPenDsqr;

import java.util.ArrayList;
import java.util.List;

public class ConvertToResultList {

    public static List<RaceResultList> convert(List<EventSingleRegistry> initialList) {
        List<RaceResultList> list = new ArrayList<>();
        for (EventSingleRegistry eventSingleRegistry : initialList) {
            RaceResultList item = new RaceResultList(eventSingleRegistry, eventSingleRegistry.getBib());

            if (item.getEventSingleRegistry().getRaceResult().size() > 0) {
                for (SingleRace s : item.getEventSingleRegistry().getRaceResult()) {
                    String heat = s.getSubEvent().getSubEvent();
                    switch (heat) {
                        case "Heat 1":
                            processHeatOne(s, item);
                            break;
                        case "Heat 2":
                            processHeatTwo(s, item);
                            break;
                        case "Semi-Final":
                            processSemiFinal(s, item);
                            break;
                        case "Final":
                            processFinal(s, item);
                            break;
                    }
                }
            }
            list.add(item);
        }
        return list;
    }

    private static void processHeatOne(SingleRace singleRace, RaceResultList item) {
        SetStartFinishPenDsqr.processHeatOne(singleRace, item);
        item.setHeatOneRaceTime(CalcRaceTime.execute(item.getHeatOneStartTime(), item.getHeatOneFinishTime()));
        item.setHeatOneTotal(CalcTotal.execute(item.getHeatOneFinishTime(), item.getHeatOneRaceTime()
                , item.getHeatOnePenaltyList(), item.isHeatOneDsqr()));
    }

    private static void processHeatTwo(SingleRace singleRace, RaceResultList item) {
        SetStartFinishPenDsqr.processHeatTwo(singleRace, item);
        item.setHeatTwoRaceTime(CalcRaceTime.execute(item.getHeatTwoStartTime(), item.getHeatTwoFinishTime()));
        item.setHeatTwoTotal(CalcTotal.execute(item.getHeatTwoFinishTime(), item.getHeatTwoRaceTime()
                , item.getHeatTwoPenaltyList(), item.isHeatTwoDsqr()));
    }

    private static void processSemiFinal(SingleRace singleRace, RaceResultList item) {
        SetStartFinishPenDsqr.processSemiFinal(singleRace, item);
        item.setSemiFinalRaceTime(CalcRaceTime.execute(item.getSemiFinalStartTime(), item.getSemiFinalFinishTime()));
        item.setSemiFinalTotal(CalcTotal.execute(item.getSemiFinalFinishTime(), item.getSemiFinalRaceTime()
                , item.getSemiFinalPenaltyList(), item.isSemiFinalDsqr()));
    }

    private static void processFinal(SingleRace singleRace, RaceResultList item) {
        SetStartFinishPenDsqr.processFinal(singleRace, item);
        item.setFinalRaceTime(CalcRaceTime.execute(item.getFinalStartTime(), item.getFinalFinishTime()));
        item.setFinalTotal(CalcTotal.execute(item.getFinalFinishTime(), item.getFinalRaceTime()
                , item.getFinalPenaltyList(), item.isFinalDsqr()));
    }
}
