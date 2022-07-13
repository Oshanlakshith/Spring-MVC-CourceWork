package lk.ijse.spring.Controller;
import lk.ijse.spring.dto.paymentDTO;
import lk.ijse.spring.service.paymentService;
import lk.ijse.spring.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
@CrossOrigin
public class paymentController {

    @Autowired
    paymentService paymentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllPayment() {
        return new ResponceUtil(200, "AllPayment", paymentService.getAllPayment());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil savePayment(paymentDTO dto) {
        paymentService.savePayment(dto);
        return new ResponceUtil(200, "Save Payment", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updatePayment(@RequestBody paymentDTO dto) {
        paymentService.updatePayment(dto);
        return new ResponceUtil(200, "Update", null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteMapping(@RequestParam String id) {
        paymentService.deletePayment(id);
        return new ResponceUtil(200, "Delete", null);
    }
}
