package geolocalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeoController {

    private final GeolocalizationRepository geolocalizationRepository;

    @Autowired
    GeoController(GeolocalizationRepository geolocalizationRepository){
        this.geolocalizationRepository = geolocalizationRepository;
    }

    @RequestMapping(value = "/localization", method = RequestMethod.POST)
    public ResponseEntity<?> add(double altitude, double latitude) {
        this.geolocalizationRepository.save(new Geolocalization(altitude, latitude));

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/localization", method = RequestMethod.GET)
    public ResponseEntity<?> read() {
        List<Geolocalization> result = geolocalizationRepository.findAll();

        return ResponseEntity.ok(result);
    }

}
