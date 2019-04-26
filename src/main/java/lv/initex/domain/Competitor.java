package lv.initex.domain;


import javax.persistence.*;
import java.util.List;
import java.util.Vector;

@Entity
@Table(name = "competitors")
public class Competitor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "competitor_name")
    private String competitorName;

    @Column(name = "birth_year")
    private int birthYear;

    @Column(name = "club")
    private String club;

    @Column(name = "country")
    private String country;

    @Column(name = "deleted", columnDefinition = "TINYINT", length = 1)
    private boolean deleted;

    public Competitor() {
    }

    public Competitor(Long id, String competitorName, int birthYear, String club, String country, boolean deleted) {
        this.id = id;
        this.competitorName = competitorName;
        this.birthYear = birthYear;
        this.club = club;
        this.country = country;
        this.deleted = deleted;
    }

    public Competitor(Vector row) {
        this.id = Long.parseLong(row.get(0).toString());
        this.competitorName = row.get(1).toString();
        this.birthYear = Integer.parseInt(row.get(2).toString());
        this.club = row.get(3).toString();
        this.country = row.get(4).toString();
    }

    public Competitor(List list) {
        this.competitorName = list.get(0).toString();
        this.birthYear = Integer.parseInt(list.get(1).toString());
        this.club = list.get(2).toString();
        this.country = list.get(3).toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(String competitorName) {
        this.competitorName = competitorName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
