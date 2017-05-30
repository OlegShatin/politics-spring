package ru.kpfu.itis.group11501.shatin.politics_web_project.entity;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Shatin
 *         11-501
 */
@Entity
@Table(name = "elections")
public class Election {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private OffsetDateTime finishTime;
    private ElectionType type;
    @Column
    private OffsetDateTime startTime;
    @Column
    private int totalBallots;
    @Column
    private int totalVotes;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "election")
    private List<ResultItem> ballotItems;

    public void setId(int id) {
        this.id = id;
    }

    public void setFinishTime(OffsetDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public void setType(ElectionType type) {
        this.type = type;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public void setTotalBallots(int totalBallots) {
        this.totalBallots = totalBallots;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public void setBallotItems(List<ResultItem> ballotItems) {
        this.ballotItems = ballotItems;
    }

    public Election() {};
    public Election(int id, ElectionType type, OffsetDateTime startTime, OffsetDateTime finishTime) {
        this.id = id;
        this.type = type;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }



    public OffsetDateTime getFinishTime() {
        return finishTime;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    public ElectionType getType() {
        return type;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public Long getId() {
        return id;
    }

    public int getTotalBallots() {
        return totalBallots;
    }

    public int getSpoiledBallots() {
        return totalBallots - totalVotes;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public List<ResultItem> getBallotItems() {
        return ballotItems;
    }
}
