package lv.initex.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Vector;

@Entity
@Table(name = "event")
public class CompetitionEvent {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "event")
    private String eventName;

    @ManyToOne
    @JoinColumn(name = "competition_event_format_id")
    private CompetitionFormat eventFormat;

    @Column(name = "place_date")
    private String placeDate;

    @Column(name = "deleted", columnDefinition = "TINYINT", length = 1)
    private boolean deleted;

    public CompetitionEvent() {
    }

    public CompetitionEvent(Long id, String eventName, CompetitionFormat eventFormat, String placeDate, boolean deleted) {
        this.id = id;
        this.eventName = eventName;
        this.eventFormat = eventFormat;
        this.placeDate = placeDate;
        this.deleted = deleted;
    }

    public CompetitionEvent(Vector row) {
        this.id = Long.parseLong(row.get(0).toString());
        this.eventName = row.get(1).toString();
        this.eventFormat = (CompetitionFormat) row.get(2);
        this.placeDate = row.get(3).toString();
    }

    public CompetitionEvent(List list) {
        this.eventName = list.get(0).toString();
        this.eventFormat = (CompetitionFormat) list.get(1);
        this.placeDate = list.get(2).toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getPlaceDate() {
        return placeDate;
    }

    public void setPlaceDate(String placeDate) {
        this.placeDate = placeDate;
    }

    public CompetitionFormat getEventFormat() {
        return eventFormat;
    }

    public void setEventFormat(CompetitionFormat eventFormat) {
        this.eventFormat = eventFormat;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
