package lv.initex.domain;

import javax.persistence.*;

@Entity
@Table(name="competition_event_format")
public class CompetitionFormat {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="competition_event_format")
    private String formatName;

    public CompetitionFormat() {
    }

    public CompetitionFormat(Long id, String formatName) {
        this.id = id;
        this.formatName = formatName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }
}
