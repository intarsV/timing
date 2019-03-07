package lv.timing.report.teamReport.services.processBoatClass.claclulations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcTeamRaceTime {

    public static BigDecimal execute(long startTime, long finishTime) {
        if (startTime > 0 && finishTime > 0) {
            BigDecimal raceTime = new BigDecimal((finishTime - startTime)).divide(new BigDecimal(1000)).setScale(2, RoundingMode.HALF_UP);
            return raceTime;
        }
        return new BigDecimal(0.00);
    }
}
