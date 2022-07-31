package lk.ijse.spring.Controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.customerService;
import lk.ijse.spring.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    customerService customerService;

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveCustomer(CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        System.out.println(customerDTO);
        return new ResponceUtil(200, "Save Customer", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllCustomers() {
        return new ResponceUtil(200, "AllCustomer", customerService.getAllCustomers());
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return new ResponceUtil(200, "Delete", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateCustomer(@RequestBody CustomerDTO customer) {
        customerService.updateCustomer(customer);
        return new ResponceUtil(200, "Update", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil searchCustomer(@PathVariable String id) {
        return new ResponceUtil(200, "Ok", customerService.searchCustomer(id));
    }
}