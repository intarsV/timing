package lv.timing.report.singleReport.services.processBoatClass.claclulations;

import lv.timing.domain.reportDomain.RaceResultList;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class RankList {

    public static void rank(List<RaceResultList> list) {
        rankHeatOne(list);
        rankHeatTwo(list);
        rankSemiFinal(list);
        rankFinal(list);
        rankBestH1H2(list);
        rankSumH1H2(list);
    }

    private static void rankHeatOne(List<RaceResultList> list) {
        list.sort(Comparator.comparing(RaceResultList::getHeatOneTotal));

        int rankInitialValue = 1;
        int rankValueTwin = 1;
        BigDecimal control = new BigDecimal(0.00);
        if (list.size() > 0 ) {
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

    private static void rankHeatTwo(List<RaceResultList> list) {
        list.sort(Comparator.comparing(RaceResultList::getHeatTwoTotal));

        int rankInitialValue = 1;
        int rankValueTwin = 1;
        BigDecimal control = new BigDecimal(0.00);
        if (list.size() > 0 ) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getHeatTwoStartTime() > 0 && list.get(i).getHeatTwoFinishTime() > 0 && list.get(i).isHeatTwoDsqr() == false) {
                    if (!control.equals(list.get(i).getHeatTwoTotal())) {
                        list.get(i).setRankHeatTwo(rankInitialValue);
                        control = list.get(i).getHeatTwoTotal();
                        rankValueTwin = rankInitialValue;
                        rankInitialValue++;
                    } else {
                        list.get(i).setRankHeatTwo(rankValueTwin);
                        control = list.get(i).getHeatTwoTotal();
                        rankInitialValue++;
                    }
                }
            }
        }
    }

    private static void rankSemiFinal(List<RaceResultList> list) {
        list.sort(Comparator.comparing(RaceResultList::getSemiFinalTotal));

        int rankInitialValue = 1;
        int rankValueTwin = 1;
        BigDecimal control = new BigDecimal(0.00);
        if (list.size() > 0 ) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getSemiFinalStartTime() > 0 && list.get(i).getSemiFinalFinishTime() > 0 && list.get(i).isSemiFinalDsqr() == false) {
                    if (!control.equals(list.get(i).getSemiFinalTotal())) {
                        list.get(i).setRankSemiFinal(rankInitialValue);
                        control = list.get(i).getSemiFinalTotal();
                        rankValueTwin = rankInitialValue;
                        rankInitialValue++;
                    } else {
                        list.get(i).setRankSemiFinal(rankValueTwin);
                        control = list.get(i).getSemiFinalTotal();
                        rankInitialValue++;
                    }
                }
            }
        }
    }

    private static void rankFinal(List<RaceResultList> list) {
        list.sort(Comparator.comparing(RaceResultList::getFinalTotal));

        int rankInitialValue = 1;
        int rankValueTwin = 1;
        BigDecimal control = new BigDecimal(0.00);
        if (list.size() > 0 ) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getFinalStartTime() > 0 && list.get(i).getFinalFinishTime() > 0 && list.get(i).isFinalDsqr() == false) {
                    if (!control.equals(list.get(i).getFinalTotal())) {
                        list.get(i).setRankFinal(rankInitialValue);
                        control = list.get(i).getFinalTotal();
                        rankValueTwin = rankInitialValue;
                        rankInitialValue++;
                    } else {
                        list.get(i).setRankFinal(rankValueTwin);
                        control = list.get(i).getFinalTotal();
                        rankInitialValue++;
                    }
                }
            }
        }
    }

    private static void rankSumH1H2(List<RaceResultList> list) {
        list.sort(Comparator.comparing(RaceResultList::getSumH1H2));

        int rankInitialValue = 1;
        int rankValueTwin = 1;
        BigDecimal control = new BigDecimal(0.00);
        if (list.size() > 0 ) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getSumH1H2().compareTo(new BigDecimal(0))==1 ) {
                    if (!control.equals(list.get(i).getSumH1H2())) {
                        list.get(i).setRankSumH1H2(rankInitialValue);
                        control = list.get(i).getSumH1H2();
                        rankValueTwin = rankInitialValue;
                        rankInitialValue++;
                    } else {
                        list.get(i).setRankSumH1H2(rankValueTwin);
                        control = list.get(i).getSumH1H2();
                        rankInitialValue++;
                    }
                }
            }
        }
    }

    private static void rankBestH1H2(List<RaceResultList> list) {
        list.sort(Comparator.comparing(RaceResultList::getBestH1H2));

        int rankInitialValue = 1;
        int rankValueTwin = 1;
        BigDecimal control = new BigDecimal(0.00);
        if (list.size() > 0 ) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getBestH1H2().compareTo(new BigDecimal(0))==1 ) {
                    if (!control.equals(list.get(i).getBestH1H2())) {
                        list.get(i).setRankBestH1H2(rankInitialValue);
                        control = list.get(i).getBestH1H2();
                        rankValueTwin = rankInitialValue;
                        rankInitialValue++;
                    } else {
                        list.get(i).setRankBestH1H2(rankValueTwin);
                        control = list.get(i).getBestH1H2();
                        rankInitialValue++;
                    }
                }
            }
        }
    }
}
