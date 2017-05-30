package ru.kpfu.itis.group11501.shatin.politics_web_project.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Oleg Shatin
 *         11-501
 */

/*
@Entity
@Table(name = "election_results")
public class ElectionResult {
    private Election election;


    public ElectionResult(Election election, int totalBallots, List<ResultItem> ballotItems) {
        this.election = election;
        this.totalBallots = totalBallots;
        this.totalVotes = 0;
        if (ballotItems != null && !ballotItems.isEmpty()){
            for (ResultItem item:ballotItems){
                this.totalVotes+= item.getVotes();
            }
        }
        this.ballotItems = ballotItems;
    }
/*
    public Election getElection() {
        return election;
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
} */