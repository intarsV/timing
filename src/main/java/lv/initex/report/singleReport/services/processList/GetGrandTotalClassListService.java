package lv.initex.report.singleReport.services.processList;

import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.Logo;
import lv.initex.domain.LogoImage;
import lv.initex.domain.reportDomain.single.GrandTotalList;
import lv.initex.domain.reportDomain.single.MergedList;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.report.singleReport.services.jasperFrame.CreateGrandTotal;
import lv.initex.report.singleReport.services.jasperFrame.CreateGrandTotalFormatOneAndFourFrame;
import lv.initex.report.singleReport.services.processBoatClass.convert.*;

import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GetGrandTotalClassListService {

    public static void process(List<RaceResultList> list, CompetitionEvent event) {
        String reportUrlOneAndFour = "/reportTemplates/GrandTotalMergedList.jasper";
        String reportUrl = "/reportTemplates/GrandTotal.jasper";

        String eventFormatName = event.getEventFormat().getFormatName();
        switch (eventFormatName) {
            case "H1&&H2->best":
                List<MergedList> formatOne = ConvertToMergedBestList.convert(list);
                CreateGrandTotalFormatOneAndFourFrame.previewList(formatOne, reportUrlOneAndFour);
                break;
            case "H1->H2->Final":
                List<GrandTotalList> formatTwo = ConvertToGrandTotalFormatTwoList.convert(list);
                List<GrandTotalList> rankedFormatTwo = formatTwo.stream()
                        .sorted(Comparator.comparing(GrandTotalList::isFinalQualified).reversed())
                        .collect(Collectors.toList());
                CreateGrandTotal.previewList(rankedFormatTwo, reportUrl);
                break;
            case "H1->H2->SF->Final":
                List<GrandTotalList> formatThree = ConvertToGrandTotalFormatThreeList.convert(list);
                List<GrandTotalList> rankedFormatThree = formatThree.stream()
                        .sorted(Comparator.comparing(GrandTotalList::isFinalQualified).thenComparing(GrandTotalList::isSemiFinalQualified).reversed().thenComparing(GrandTotalList::getTotal))
                        .collect(Collectors.toList());
                CreateGrandTotal.previewList(rankedFormatThree, reportUrl);
                break;
            case "Sum of H1&H2":
                List<MergedList> formatFour = ConvertToMergedSumList.convert(list);
                CreateGrandTotalFormatOneAndFourFrame.previewList(formatFour, reportUrlOneAndFour);
                break;
            case "H1&&H2->best->Final":
                List<GrandTotalList> formatFive = ConvertToGrandTotalFormatFiveList.convert(list);
                List<GrandTotalList> rankedFormatFive = formatFive.stream()
                        .sorted(Comparator.comparing(GrandTotalList::isFinalQualified).reversed().thenComparing(GrandTotalList::getTotal))
                        .collect(Collectors.toList());
                CreateGrandTotal.previewList(rankedFormatFive, reportUrl);
                break;
            case "H1->Final":
                List<GrandTotalList> formatSix = ConvertToGrandTotalFormatSixList.convert(list);
                List<GrandTotalList> rankedFormatSix = formatSix.stream()
                        .sorted(Comparator.comparing(GrandTotalList::isFinalQualified).thenComparing(GrandTotalList::isSemiFinalQualified).reversed().thenComparing(GrandTotalList::getTotal))
                        .collect(Collectors.toList());
                CreateGrandTotal.previewList(rankedFormatSix, reportUrl);
                break;
            case "Sum of H1&H2->Final":
                List<GrandTotalList> sevenFive = ConvertToGrandTotalFormatSevenList.convert(list);
                List<GrandTotalList> rankedFormatSeven = sevenFive.stream()
                        .sorted(Comparator.comparing(GrandTotalList::isFinalQualified).reversed().thenComparing(GrandTotalList::getTotal))
                        .collect(Collectors.toList());
                CreateGrandTotal.previewList(rankedFormatSeven, reportUrl);
                break;
        }
    }
}
