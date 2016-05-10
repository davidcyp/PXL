package be.pxl.orm.music;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "PARTY")
// @NamedQuery(name="Party.findAll", query="SELECT p FROM Party p, Venue v WHERE  ")
public class Party {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany
    @JoinTable(name = "FEESTNEUZEN")

    private Collection<Deejay> deejays = new ArrayList<Deejay>();

    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Venue venue;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "DOORS_OPEN")
    @Temporal(TemporalType.TIME)
    private Date doorsOpenAt;

    public Collection<Deejay> getDeejays() {
        return deejays;
    }

    public void setDeejays(Collection<Deejay> deejays) {
        this.deejays = deejays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDoorsOpenAt() {
        return doorsOpenAt;
    }

    public void setDoorsOpenAt(Date doorsOpenAt) {
        this.doorsOpenAt = doorsOpenAt;
    }
}
