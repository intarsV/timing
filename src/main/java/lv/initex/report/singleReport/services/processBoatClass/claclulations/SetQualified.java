package lv.initex.report.singleReport.services.processBoatClass.claclulations;

import lv.initex.database.RaceConfigRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.RaceConfig;
import lv.initex.domain.SingleBoatClass;
import lv.initex.domain.reportDomain.single.RaceResultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetQualified {

    @Autowired
    private RaceConfigRepository database;

    public void setQualified(List<RaceResultList> list, CompetitionEvent competitionEvent, SingleBoatClass boatClass) {

        Long format = competitionEvent.getEventFormat().getId();

        if (format == 2 || format == 3 || format == 6 || format == 5|| format == 7) {
            Optional<RaceConfig> raceConfig = database.getQualifiedNumber(competitionEvent, boatClass);

            if (raceConfig.isPresent()) {
                qualifyHeatOne(list, raceConfig.get().getHeat1());
                qualifyHeatTwo(list, raceConfig.get().getHeat2());
                qualifySemiFinal(list, raceConfig.get().getSemiFinal());
                qualifySumH1H2(list, raceConfig.get().getHeat2());
                qualifyBestH1H2(list, raceConfig.get().getHeat2());
            }
        }
    }

    private void qualifyHeatOne(List<RaceResultList> list, int qualified) {
        for (RaceResultList e : list) {
            if (e.getRankHeatOne() <= qualified && e.getRankHeatOne() > 0) {
                e.setHeatOneQualified(true);
            }
        }
    }

    private void qualifyHeatTwo(List<RaceResultList> list, int qualified) {
        for (RaceResultList e : list) {
            if (e.getRankHeatTwo() <= qualified && e.getRankHeatTwo() > 0) {
                e.setHeatTwoQualified(true);
            }
        }
    }

    private void qualifySemiFinal(List<RaceResultList> list, int qualified) {
        for (RaceResultList e : list) {
            if (e.getRankSemiFinal() <= qualified && e.getRankSemiFinal() > 0) {
                e.setSemiFinalQualified(true);
            }
        }
    }

    private void qualifySumH1H2(List<RaceResultList> list, int qualified) {
        for (RaceResultList e : list) {
            if (e.getRankSumH1H2() <= qualified && e.getRankHeatTwo() > 0) {
                e.setSumH1H2Qualified(true);
            }
        }
    }

    private void qualifyBestH1H2(List<RaceResultList> list, int qualified) {
        for (RaceResultList e : list) {
            if (e.getRankBestH1H2() <= qualified) {
                e.setBestH1h2Qualified(true);
            }
        }
    }
}
