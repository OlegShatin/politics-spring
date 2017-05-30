package ru.kpfu.itis.group11501.shatin.politics_web_project.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.List;

/**
 * @author Oleg Shatin
 *         11-501
 */
@Entity
@Table(name = "parties")
public class Party {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int seatsInParliament;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "party")
    private List<Supporter> supporters;
    @OneToOne(mappedBy = "party")
    private Candidate candidate;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatsInParliament() {
        return seatsInParliament;
    }

    public void setSeatsInParliament(int seatsInParliament) {
        this.seatsInParliament = seatsInParliament;
    }

    public List<Supporter> getSupporters() {
        return supporters;
    }

    public void setSupporters(List<Supporter> supporters) {
        this.supporters = supporters;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Party(){};
    public Party(Long partyId, int seatsInParliament, List<Supporter> supporters) {

        this.id = partyId;
        this.seatsInParliament = seatsInParliament;
        this.supporters = supporters;
    }
}
