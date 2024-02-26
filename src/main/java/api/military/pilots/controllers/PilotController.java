package api.military.pilots.controllers;

import api.military.pilots.models.PilotModel;
import api.military.pilots.services.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PilotController {

    @Autowired
    PilotService pilotService;

    @PostMapping("/pilot")
    public ResponseEntity<?> savePilot(@RequestBody PilotModel pilot) {
        return this.pilotService.savePilot(pilot);
    }

    @GetMapping(path="/assignPlane/{dni}/{tuition}")
    public ResponseEntity<?> assignPlane(@PathVariable String dni,@PathVariable String tuition){
        return this.pilotService.assignPlane(dni,tuition);
    }
}
