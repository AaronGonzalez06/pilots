package api.military.pilots.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pilots")
public class PilotModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "dni")
    private String dni;

    @Column(name = "age")
    private Integer age;

    @Column(name = "availability")
    private Integer availability;

    @Column(name = "incorporation")
    private LocalDateTime incorporation;


    //pruebas

    @JoinTable(
            name = "pilots_planes", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "id_pilot"), // Columna que referencia a esta entidad
            inverseJoinColumns = @JoinColumn(name = "id_plane") // Columna que referencia a la otra entidad
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<PlaneModel> planes;

    public void addPlane(PlaneModel plane){
        if(this.planes == null){
            this.planes = new ArrayList<>();
        }

        this.planes.add(plane);
    }

    //fin pruebas



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}
