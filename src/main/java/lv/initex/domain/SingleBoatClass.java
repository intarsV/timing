package lv.initex.domain;

import javax.persistence.*;

@Entity
@Table(name = "single_boat_class")
public class SingleBoatClass {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "boat_class")
    private String boatClass;

    @Column(name = "deleted", columnDefinition = "TINYINT", length = 1)
    private boolean deleted;

    @Column(name = "sort_index")
    private int sortIndex;

    public SingleBoatClass() {
    }

    public SingleBoatClass(Long id, String boatClass, boolean deleted, int sortindex) {
        this.id = id;
        this.boatClass = boatClass;
        this.deleted = deleted;
        this.sortIndex = sortindex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoatClass() {
        return boatClass;
    }

    public void setBoatClass(String boatClass) {
        this.boatClass = boatClass;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }
}
