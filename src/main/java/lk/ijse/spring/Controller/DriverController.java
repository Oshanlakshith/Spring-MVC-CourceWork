package lk.ijse.spring.Controller;

import lk.ijse.spring.dto.driverDTO;
import lk.ijse.spring.service.driverServise;
import lk.ijse.spring.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("driver")
@CrossOrigin
public class DriverController {

    @Autowired
    driverServise driverServise;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllDrivers() {
        return new ResponceUtil(200, "Save",   driverServise.getAllDrivers());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveDriver(driverDTO driverDTO) {
        driverServise.saveDriver(driverDTO);
        return new ResponceUtil(200, "Save", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateDriver(@RequestBody driverDTO driverDTO) {
        driverServise.updateDriver(driverDTO);
        return new ResponceUtil(200, "Update", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteDriver(@RequestParam String id) {
        driverServise.deleteDrivers(id);
        return new ResponceUtil(200, "Delete", null);
    }

}
