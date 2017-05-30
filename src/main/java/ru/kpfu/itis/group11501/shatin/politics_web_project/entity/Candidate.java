package ru.kpfu.itis.group11501.shatin.politics_web_project.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Oleg Shatin
 *         11-501
 */
@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String info;
    @Column
    private String achievements;
    @Column
    private String electionProgram;
    @Column
    private String imageSrc;
    @OneToOne(mappedBy = "candidate")
    private User agent;
    @OneToOne(mappedBy = "candidate")
    private Party party;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "candidate")
    private List<ResultItem> results;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public void setElectionProgram(String electionProgram) {
        this.electionProgram = electionProgram;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public User getAgent() {
        return agent;
    }

    public void setAgent(User agent) {
        this.agent = agent;
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

    public String getInfo() {
        return info;
    }

    public String getAchievements() {
        return achievements;
    }

    public String getElectionProgram() {
        return electionProgram;
    }

    public String getImageSrc() {
        return imageSrc;
    }



    public Party getParty() {
        return party;
    }

    public Candidate(){};
    public Candidate(Long id, String name, String info, String achievements, String electionProgram, String imageSrc, User agent, Party party) {

        this.id = id;
        this.name = name;
        this.info = info;
        this.achievements = achievements;
        this.electionProgram = electionProgram;
        this.imageSrc = imageSrc;
        this.agent = agent;
        this.party = party;
    }
}
