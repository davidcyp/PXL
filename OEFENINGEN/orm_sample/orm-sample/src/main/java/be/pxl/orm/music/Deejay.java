package be.pxl.orm.music;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEEJAYS")
public class Deejay {

    @Id
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "HOURLY_RATE")
    private Long hourlyRate;

    // private Collection<String> genres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Long hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
