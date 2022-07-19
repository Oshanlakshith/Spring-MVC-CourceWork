package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.customerRepo;
import lk.ijse.spring.service.customerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class customerServiceImpl implements customerService {
    @Autowired
   private customerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getCId())) {
            repo.save(mapper.map(dto, Customer.class));
        }else{
            throw new RuntimeException("Customer Already saved");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if(repo.existsById(dto.getCId())){
            repo.save(mapper.map(dto, Customer.class));
        }else {
            throw new RuntimeException("No Such customer To Update");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
        }else{
            throw new RuntimeException("No Customer for" +id+ "..!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
       if (repo.existsById(id)){
           return mapper.map(repo.findById(id).get(), CustomerDTO.class);
       }else {
           throw new RuntimeException("No Customer for" +id+ "..!");
       }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
     return mapper.map(repo.findAll(),new TypeToken<List<CustomerDTO>>(){
     }.getType());
    }
}
