package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.paymentDTO;
import lk.ijse.spring.entity.payment;
import lk.ijse.spring.repo.paymentRepo;
import lk.ijse.spring.service.paymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class paymentServiceImpl implements paymentService {
    @Autowired
    paymentRepo repo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void savePayment(paymentDTO dto) {
        if(!repo.existsById(dto.getPcid())){
            repo.save(mapper.map(dto, payment.class));
        }else {
            throw new RuntimeException("Already save payment Id");
        }
    }

    @Override
    public void deletePayment(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Check The Id.." + id + "..!");
        }
    }

    @Override
    public void updatePayment(paymentDTO dto) {
        if (repo.existsById(dto.getPcid())) {
            repo.save(mapper.map(dto, payment.class));
        } else {
            throw new RuntimeException("Check The Id");
        }
    }

    @Override
    public List<paymentDTO> getAllPayment() {
        return mapper.map(repo.findAll(), new TypeToken<List<paymentDTO>>() {
        }.getType());
    }
}
