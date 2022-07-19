package lk.ijse.spring.Controller;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.service.PurchasOrderService;
import lk.ijse.spring.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orderForm")
@CrossOrigin
public class purchesOrderController {

    @Autowired
    PurchasOrderService poService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllOrders() {
        return new ResponceUtil(200, "GetOrder", poService.getAllOrders());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveOrder(@RequestBody OrdersDTO ordersDTO) {
        System.out.println(ordersDTO.toString());
        poService.purchaseOrder(ordersDTO);
        return new ResponceUtil(200, "Save", null);
    }

}
