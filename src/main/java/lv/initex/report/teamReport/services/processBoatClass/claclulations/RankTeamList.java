package lv.initex.report.teamReport.services.processBoatClass.claclulations;

import lv.initex.domain.reportDomain.team.TeamRaceResultList;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class RankTeamList {

    public static void rank(List<TeamRaceResultList> list) {
        rankHeatOne(list);
    }

    private static void rankHeatOne(List<TeamRaceResultList> list) {
        list.sort(Comparator.comparing(TeamRaceResultList::getHeatOneTotal));

        int rankInitialValue = 1;
        int rankValueTwin = 1;
        BigDecimal control = new BigDecimal(0.00);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getHeatOneStartTime() > 0 && list.get(i).getHeatOneFinishTime() > 0 && list.get(i).isHeatOneDsqr() == false) {
                    if (!control.equals(list.get(i).getHeatOneTotal())) {
                        list.get(i).setRankHeatOne(rankInitialValue);
                        control = list.get(i).getHeatOneTotal();
                        rankValueTwin = rankInitialValue;
                        rankInitialValue++;
                    } else {
                        list.get(i).setRankHeatOne(rankValueTwin);
                        control = list.get(i).getHeatOneTotal();
                        rankInitialValue++;
                    }
                }
            }
        }
    }
}
