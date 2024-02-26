package api.military.pilots.services;

import api.military.pilots.models.PlaneModel;
import api.military.pilots.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

@Service
public class PlaneService {

    @Autowired
    PlaneRepository planeRepository;

    public ResponseEntity<?> savePlane(PlaneModel plane) {
        try {
            LocalDateTime date = LocalDate.now().atStartOfDay();
            plane.setIncorporation(date);
            planeRepository.save(plane);
            Map<String, PlaneModel> response = Collections.singletonMap("Plane",plane );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            String errorMessage = "Error when adding new plane.";
            Map<String, String> errorResponse = Collections.singletonMap("message", errorMessage);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

}
