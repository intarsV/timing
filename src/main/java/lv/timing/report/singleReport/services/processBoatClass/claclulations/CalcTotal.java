package lv.timing.report.singleReport.services.processBoatClass.claclulations;

import java.math.BigDecimal;

public class CalcTotal {

    public static BigDecimal execute( long finishTime, BigDecimal raceTime, int[] penaltyList, boolean dsqr) {
        int penaltySeconds = 0;

        if (finishTime == 0) {
            return new BigDecimal(8888);    //8888=DNF
        }
        if (dsqr == true) {
            return new BigDecimal(10000);   //10000=DSQR
        }

        for (int i : penaltyList) {
            penaltySeconds = penaltySeconds + i;
        }
        return new BigDecimal((long) penaltySeconds).add(raceTime);
    }
}
