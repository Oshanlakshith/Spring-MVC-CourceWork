package lk.ijse.spring.service.impl;
import lk.ijse.spring.dto.driverDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.driverServise;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class driverServiseImpl implements driverServise {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void saveDriver(driverDTO dto) {
        if (!repo.existsById(dto.getDId())) {
            repo.save(mapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("Driver save Alredy");
        }
    }

    @Override
    public void updateDriver(driverDTO dto) {
        if (repo.existsById(dto.getDId())) {
            repo.save(mapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("Check The Id");
        }
    }

    @Override
    public driverDTO searchDriver(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), driverDTO.class);
        } else {
            throw new RuntimeException("Check The Id.." + id + "..!");
        }
    }

    @Override
    public void deleteDrivers(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Check The Id.." + id + "..!");
        }
    }

    @Override
    public List<driverDTO> getAllDrivers() {
        return mapper.map(repo.findAll(), new TypeToken<List<driverDTO>>() {
        }.getType());
    }
}
