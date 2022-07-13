package lk.ijse.spring.Controller;

import lk.ijse.spring.dto.carDTO;

import lk.ijse.spring.service.carService;
import lk.ijse.spring.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car")
@CrossOrigin
public class CarController {
    @Autowired
    carService carService;

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveCustomer(carDTO carDTO) {
        carService.saveCar(carDTO);
        return new ResponceUtil(200, "Save Car", null);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllDrivers() {
        return new ResponceUtil(200, "AllCar", carService.getAllCar());

    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateDriver(@RequestBody carDTO carDTO) {
        carService.updateCar(carDTO);
        return new ResponceUtil(200, "Update", null);
    }
    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteDriver(@RequestParam String id) {
        carService.deleteCar(id);
        return new ResponceUtil(200, "Delete", null);
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil searchCustomer(@PathVariable String id) {
        return new ResponceUtil(200, "Ok", carService.searchCar(id));
    }
}
