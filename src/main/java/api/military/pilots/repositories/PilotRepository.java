package api.military.pilots.repositories;

import api.military.pilots.models.PilotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotRepository extends JpaRepository<PilotModel, Integer> {

    @Query("SELECT p FROM PilotModel p WHERE p.dni = :dni")
    PilotModel pilotDni(@Param("dni") String dni);
}
