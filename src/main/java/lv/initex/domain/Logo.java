package lv.initex.domain;


import javax.persistence.*;
import java.awt.*;

//@Entity
//@Table(name = "logo")
public class Logo {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "name")
    private String name;

    @Column(name = "selected", columnDefinition = "TINYINT", length = 1)
    private boolean selected;

    public Logo() {
    }

    public Logo(Long id, byte[] image, String name, boolean selected) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.selected = selected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
