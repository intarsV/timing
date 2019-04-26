package lv.initex.domain;

import javax.persistence.*;
import java.util.Vector;

@Entity
@Table(name="mcu_incoming")
public class VerifyMcuData {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="bib")
    private int bib;

    @Column(name="time_stamp", columnDefinition = "DOUBLE")
    private long timeStamp;

    @Column(name = "unit_id")
    private int unitId;

    @Column(name = "sub_event")
    private int subEvent;

    @Column(name = "done", columnDefinition = "TINYINT", length = 1)
    private boolean done;

    @Column(name = "accepted", columnDefinition = "TINYINT", length = 1)
    private boolean accepted;

    public VerifyMcuData(){

    }

    public VerifyMcuData(Vector row) {
        this.id = Long.valueOf(row.get(0).toString());
        this.bib= (int) row.get(1);
        this.timeStamp= (long) row.get(2);
        this.unitId= (int) row.get(3);
        this.subEvent= (int) row.get(4);
        this.done= (boolean) row.get(5);
        this.accepted= (boolean) row.get(6);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBib() {
        return bib;
    }

    public void setBib(int bib) {
        this.bib = bib;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getSubEvent() {
        return subEvent;
    }

    public void setSubEvent(int subEvent) {
        this.subEvent = subEvent;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
