package api.military.pilots.services;

import api.military.pilots.models.PilotModel;
import api.military.pilots.models.PlaneModel;
import api.military.pilots.repositories.PilotRepository;
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
public class PilotService {

    @Autowired
    PilotRepository pilotRepository;

    @Autowired
    PlaneRepository planeRepository;

    public ResponseEntity<?> savePilot(PilotModel pilot) {
        try {
            LocalDateTime date = LocalDate.now().atStartOfDay();
            pilot.setIncorporation(date);
            pilotRepository.save(pilot);
            Map<String, PilotModel> response = Collections.singletonMap("Pilot",pilot );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            String errorMessage = "Error when adding new pilot.";
            Map<String, String> errorResponse = Collections.singletonMap("message", errorMessage);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    public ResponseEntity<?> assignPlane(String dni,String tuition) {
        try {
            //pilot
            PilotModel assignPilot = pilotRepository.pilotDni(dni);
            LocalDateTime date = LocalDate.now().atStartOfDay();

            //plane
            PlaneModel plane = planeRepository.planeTuition(tuition);
            assignPilot.addPlane(plane);
            assignPilot.setAvailability(0);
            pilotRepository.save(assignPilot);
            Map<String, String> response = Collections.singletonMap("Pilot","the pilot is assigned a plane" );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            String errorMessage = "Error when adding new pilot.";
            Map<String, String> errorResponse = Collections.singletonMap("message", errorMessage);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

}
