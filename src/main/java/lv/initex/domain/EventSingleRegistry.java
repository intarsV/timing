package lv.initex.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "single_event_registry")
public class EventSingleRegistry {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private CompetitionEvent competitionEvent;

    @ManyToOne
    @JoinColumn(name = "competitor_id")
    private Competitor competitor;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "boat_class_id")
    private SingleBoatClass singleBoatClass;

    @Column(name = "bib")
    private int bib;

    @OneToMany(mappedBy="eventSingleRegistry")
    private List<SingleRace> raceResult;


    public EventSingleRegistry() {
    }


    public EventSingleRegistry(List valueList) {
        this.competitionEvent = (CompetitionEvent) valueList.get(0);
        this.competitor = (Competitor) valueList.get(1);
        this.group = (Group) valueList.get(2);
        this.singleBoatClass = (SingleBoatClass) valueList.get(3);
        this.bib = Integer.parseInt(valueList.get(4).toString());
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

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public SingleBoatClass getSingleBoatClass() {
        return singleBoatClass;
    }

    public void setSingleBoatClass(SingleBoatClass singleBoatClass) {
        this.singleBoatClass = singleBoatClass;
    }

    public int getBib() {
        return bib;
    }

    public void setBib(int bib) {
        this.bib = bib;
    }

    public List<SingleRace> getRaceResult() {
        return raceResult;
    }

    public void setRaceResult(List<SingleRace> raceResult) {
        this.raceResult = raceResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventSingleRegistry eventSingleRegistry = (EventSingleRegistry) o;

        if (id != null ? !id.equals(eventSingleRegistry.id) : eventSingleRegistry.id != null) return false;
        if (bib != -1 ? bib != (eventSingleRegistry.bib) : eventSingleRegistry.bib != -1) return false;
        if (competitionEvent != null ? !competitionEvent.equals(eventSingleRegistry.competitionEvent) : eventSingleRegistry.competitionEvent != null)
            return false;
        return true;
    }
}
