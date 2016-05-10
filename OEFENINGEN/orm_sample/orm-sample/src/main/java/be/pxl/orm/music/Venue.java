package be.pxl.orm.music;

import javax.persistence.*;

@Entity
@Table(name = "VENUE")
public class Venue {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private VenuePolicy policy;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STREET_NR")
    private String streetAndNr;

    @Column(name="ZIP")
    private String zipCode;

    @Column(name = "CITY")
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAndNr() {
        return streetAndNr;
    }

    public void setStreetAndNr(String streetAndNr) {
        this.streetAndNr = streetAndNr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public VenuePolicy getPolicy() {
        return policy;
    }

    public void setPolicy(VenuePolicy policy) {
        this.policy = policy;
    }
}
