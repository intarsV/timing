package lv.timing.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "race_config")
public class RaceConfig {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private CompetitionEvent competitionEvent;

    @ManyToOne
    @JoinColumn(name = "boat_class_id")
    private SingleBoatClass singleBoatClass;

    @Column(name = "heat_1")
    private int heat1;

    @Column(name = "heat_2")
    private int heat2;

    @Column(name = "semi_final")
    private int semiFinal;

    public RaceConfig() {

    }

    public RaceConfig(Long id, CompetitionEvent competitionEvent, SingleBoatClass singleBoatClass, int heat1, int heat2, int semiFinal) {
        this.id = id;
        this.competitionEvent = competitionEvent;
        this.singleBoatClass = singleBoatClass;
        this.heat1 = heat1;
        this.heat2 = heat2;
        this.semiFinal = semiFinal;
    }

    public RaceConfig(List valueList) {
        this.competitionEvent = (CompetitionEvent) valueList.get(0);
        this.singleBoatClass = (SingleBoatClass) valueList.get(1);
        this.heat1 = Integer.parseInt(valueList.get(2).toString());
        this.heat2 = Integer.parseInt(valueList.get(3).toString());
        this.semiFinal = Integer.parseInt(valueList.get(4).toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompetitionEvent getCompetitionEvent() {
        return competitionEvent;
    }

    public void setCompetitionEvent(CompetitionEvent competitionEvent) {
        this.competitionEvent = competitionEvent;
    }

    public SingleBoatClass getSingleBoatClass() {
        return singleBoatClass;
    }

    public void setSingleBoatClass(SingleBoatClass singleBoatClass) {
        this.singleBoatClass = singleBoatClass;
    }

    public int getHeat1() {
        return heat1;
    }

    public void setHeat1(int heat1) {
        this.heat1 = heat1;
    }

    public int getHeat2() {
        return heat2;
    }

    public void setHeat2(int heat2) {
        this.heat2 = heat2;
    }

    public int getSemiFinal() {
        return semiFinal;
    }

    public void setSemiFinal(int semiFinal) {
        this.semiFinal = semiFinal;
    }
}
