package api.military.pilots.repositories;

import api.military.pilots.models.PlaneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<PlaneModel, Integer> {

    @Query("SELECT p FROM PlaneModel p WHERE p.tuition = :tuition")
    PlaneModel planeTuition(@Param("tuition") String tuition);
}
