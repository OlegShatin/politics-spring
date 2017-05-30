package ru.kpfu.itis.group11501.shatin.politics_web_project.entity;

import javax.persistence.*;

/**
 * @author Oleg Shatin
 *         11-501
 */
@Entity
@Table(name = "supporters")
public class Supporter {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String imageSrc;
    @ManyToOne
    private Party party;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getImageSrc() {
        return imageSrc;
    }


    public Supporter(Long id, String name, String surname, String imageSrc) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.imageSrc = imageSrc;
    }
}
