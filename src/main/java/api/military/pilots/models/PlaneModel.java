package api.military.pilots.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "planes")
public class PlaneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tuition")
    private String tuition;

    @Column(name = "name")
    private String name;

    @Column(name = "availability")
    private Integer availability;

    @Column(name = "incorporation")
    private LocalDateTime incorporation;

    @ManyToMany(mappedBy = "planes")
    private List<PilotModel> pilots;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public LocalDateTime getIncorporation() {
        return incorporation;
    }

    public void setIncorporation(LocalDateTime incorporation) {
        this.incorporation = incorporation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
