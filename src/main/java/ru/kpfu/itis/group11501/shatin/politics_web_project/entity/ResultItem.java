package ru.kpfu.itis.group11501.shatin.politics_web_project.entity;

import javax.persistence.*;

@Entity
@Table(name = "result_items")
public class ResultItem {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Candidate candidate;
    @Column
    private int votes;
    @ManyToOne
    private Election election;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public int getVotes() {
        return votes;
    }

    public ResultItem(){};
    public ResultItem(Candidate candidate, int votes) {
        this.candidate = candidate;
        this.votes = votes;
    }
}
