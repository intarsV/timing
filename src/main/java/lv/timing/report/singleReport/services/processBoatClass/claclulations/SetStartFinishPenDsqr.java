package lv.timing.report.singleReport.services.processBoatClass.claclulations;

import lv.timing.domain.SingleRace;
import lv.timing.domain.reportDomain.single.RaceResultList;

public class SetStartFinishPenDsqr {

    public static void processHeatOne(SingleRace singleRace, RaceResultList item){
        item.setHeatOneStartTime(singleRace.getStartTime());
        item.setHeatOneFinishTime(singleRace.getFinishTime());
        item.setHeatOnePenaltyList(singleRace.getPenaltyList());
        item.setHeatOneDsqr(singleRace.isDsqr());
    }

    public static void processHeatTwo(SingleRace singleRace, RaceResultList item){
        item.setHeatTwoStartTime(singleRace.getStartTime());
        item.setHeatTwoFinishTime(singleRace.getFinishTime());
        item.setHeatTwoPenaltyList(singleRace.getPenaltyList());
        item.setHeatTwoDsqr(singleRace.isDsqr());
    }

    public static void processSemiFinal(SingleRace singleRace, RaceResultList item){
        item.setSemiFinalStartTime(singleRace.getStartTime());
        item.setSemiFinalFinishTime(singleRace.getFinishTime());
        item.setSemiFinalPenaltyList(singleRace.getPenaltyList());
        item.setSemiFinalDsqr(singleRace.isDsqr());
    }

    public static void processFinal(SingleRace singleRace, RaceResultList item){
        item.setFinalStartTime(singleRace.getStartTime());
        item.setFinalFinishTime(singleRace.getFinishTime());
        item.setFinalPenaltyList(singleRace.getPenaltyList());
        item.setFinalDsqr(singleRace.isDsqr());
    }
}
