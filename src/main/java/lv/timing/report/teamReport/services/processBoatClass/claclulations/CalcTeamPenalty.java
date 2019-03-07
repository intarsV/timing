package lv.timing.report.teamReport.services.processBoatClass.claclulations;

public class CalcTeamPenalty {

    public static int calcPenalty(int[] penalties) {
        int j = 0;
        for (int i : penalties) {
            j = j + i;
        }
        return j;
    }
}
