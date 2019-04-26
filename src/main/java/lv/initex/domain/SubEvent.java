package lv.initex.domain;

import javax.persistence.*;

@Entity
@Table(name="sub_event")
public class SubEvent {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "competition_event_format_id")
    private CompetitionFormat eventFormat;

    @Column(name="sub_event")
    private String subEvent;

    public SubEvent( ) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompetitionFormat getEventFormat() {
        return eventFormat;
    }

    public void setEventFormat(CompetitionFormat eventFormat) {
        this.eventFormat = eventFormat;
    }

    public String getSubEvent() {
        return subEvent;
    }

    public void setSubEvent(String subEvent) {
        this.subEvent = subEvent;
    }
}
