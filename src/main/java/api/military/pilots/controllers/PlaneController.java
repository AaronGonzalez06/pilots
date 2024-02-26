package api.military.pilots.controllers;

import api.military.pilots.models.PilotModel;
import api.military.pilots.models.PlaneModel;
import api.military.pilots.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlaneController {

    @Autowired
    PlaneService planeService;

    @PostMapping("/plane")
    public ResponseEntity<?> savePlane(@RequestBody PlaneModel plane) {
        return this.planeService.savePlane(plane);
    }

}
