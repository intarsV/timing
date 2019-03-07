package lv.timing.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team_event_registry")
public class EventTeamRegistry {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private CompetitionEvent competitionEvent;

    @ManyToOne
    @JoinColumn(name = "competitor_one_id")
    private Competitor competitorOne;

    @ManyToOne
    @JoinColumn(name = "competitor_two_id")
    private Competitor competitorTwo;

    @ManyToOne
    @JoinColumn(name = "competitor_three_id")
    private Competitor competitorThree;

    @ManyToOne
    @JoinColumn(name = "boat_class_id")
    private TeamBoatClass teamBoatClass;

    @Column(name = "bib")
    private int bib;

    @OneToMany(mappedBy="eventTeamRegistry")
    private List<TeamRace> raceResult;

    public EventTeamRegistry() {
    }

    public EventTeamRegistry(List valueList) {
        this.competitionEvent = (CompetitionEvent) valueList.get(0);
        this.competitorOne = (Competitor) valueList.get(1);
        this.competitorTwo = (Competitor) valueList.get(2);
        this.competitorThree = (Competitor) valueList.get(3);
        this.teamBoatClass = (TeamBoatClass) valueList.get(4);
        this.bib = Integer.parseInt(valueList.get(5).toString());
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

    public Competitor getCompetitorOne() {
        return competitorOne;
    }

    public void setCompetitorOne(Competitor competitorOne) {
        this.competitorOne = competitorOne;
    }

    public Competitor getCompetitorTwo() {
        return competitorTwo;
    }

    public void setCompetitorTwo(Competitor competitorTwo) {
        this.competitorTwo = competitorTwo;
    }

    public Competitor getCompetitorThree() {
        return competitorThree;
    }

    public void setCompetitorThree(Competitor competitorThree) {
        this.competitorThree = competitorThree;
    }

    public TeamBoatClass getSingleBoatClass() {
        return teamBoatClass;
    }

    public void setSingleBoatClass(TeamBoatClass teamBoatClass) {
        this.teamBoatClass = teamBoatClass;
    }

    public int getBib() {
        return bib;
    }

    public void setBib(int bib) {
        this.bib = bib;
    }

    public TeamBoatClass getTeamBoatClass() {
        return teamBoatClass;
    }

    public void setTeamBoatClass(TeamBoatClass teamBoatClass) {
        this.teamBoatClass = teamBoatClass;
    }

    public List<TeamRace> getRaceResult() {
        return raceResult;
    }

    public void setRaceResult(List<TeamRace> raceResult) {
        this.raceResult = raceResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventTeamRegistry eventTeamRegistry = (EventTeamRegistry) o;

        if (id != null ? !id.equals(eventTeamRegistry.id) : eventTeamRegistry.id != null) return false;
        if (bib != -1 ? bib != (eventTeamRegistry.bib) : eventTeamRegistry.bib != -1) return false;
        if (competitionEvent != null ? !competitionEvent.equals(eventTeamRegistry.competitionEvent) : eventTeamRegistry.competitionEvent != null)
            return false;
        return true;
    }


}
