package lv.timing.report.singleReport.services.processBoatClass.claclulations;

public class CalcPenalty {

    public static int calcPenalty(int[] penalties) {
        int j = 0;
        for (int i : penalties) {
            j = j + i;
        }
        return j;
    }
}
