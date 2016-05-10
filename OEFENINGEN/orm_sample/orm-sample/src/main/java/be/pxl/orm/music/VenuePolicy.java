package be.pxl.orm.music;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "POLICY")
public class VenuePolicy {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "policy")
    private Venue venue;

    @Column(name = "MINIMUM_AGE")
    private int minimumAge;

    @Column(name = "CLOSING_TIME")
    @Temporal(TemporalType.TIME)
    private Date mustCloseAt;

    @Column(name = "COORDINATOR_NAME")
    private String securityCoordinator;

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public Date getMustCloseAt() {
        return mustCloseAt;
    }

    public void setMustCloseAt(Date mustCloseAt) {
        this.mustCloseAt = mustCloseAt;
    }

    public String getSecurityCoordinator() {
        return securityCoordinator;
    }

    public void setSecurityCoordinator(String securityCoordinator) {
        this.securityCoordinator = securityCoordinator;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
