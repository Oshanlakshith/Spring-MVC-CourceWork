package lk.ijse.spring.Controller;

import lk.ijse.spring.dto.reservationDTO;
import lk.ijse.spring.service.reservationService;
import lk.ijse.spring.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reservation")
@CrossOrigin
public class ReservationController {

    @Autowired
    reservationService reservationService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveReservation(reservationDTO reservationDTO) {
        System.out.println(reservationDTO.toString());
        reservationService.saveReservation(reservationDTO);
        return new ResponceUtil(200,"Save",null);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllReservation() {
        return new ResponceUtil(200, "AllCustomer", reservationService.reservation());
    }
    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteCustomer(@RequestParam String id) {
        reservationService.deleteReservation(id);
        return new ResponceUtil(200, "Delete", null);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateCustomer(@RequestBody reservationDTO customerDTO) {
        reservationService.updateReservation(customerDTO);
        return new ResponceUtil(200, "Update", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil searchCustomer(@PathVariable String id) {
        return new ResponceUtil(200, "Ok", reservationService.searchReservation(id));
    }
}
