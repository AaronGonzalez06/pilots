package api.military.pilots.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pilots_planes")
public class PilotPlane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_pilot")
    private PilotModel pilot;

    @ManyToOne
    @JoinColumn(name = "id_plane")
    private PlaneModel plane;

    @Column(name = "exited")
    private LocalDateTime exited;

    @Column(name = "arrival")
    private LocalDateTime arrival;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PilotModel getPilot() {
        return pilot;
    }

    public void setPilot(PilotModel pilot) {
        this.pilot = pilot;
    }

    public PlaneModel getPlane() {
        return plane;
    }

    public void setPlane(PlaneModel plane) {
        this.plane = plane;
    }

    public LocalDateTime getExited() {
        return exited;
    }

    public void setExited(LocalDateTime exited) {
        this.exited = exited;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }
}
