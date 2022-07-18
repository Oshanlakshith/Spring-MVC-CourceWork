package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.carDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.carRepo;
import lk.ijse.spring.service.carService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class carServiceImpl implements carService {

    @Autowired
    carRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCar(carDTO dto) {
        if (!repo.existsById(dto.getCarId())) {
            repo.save(mapper.map(dto, Car.class));
        } else {
            throw new RuntimeException("Car already save");
        }
    }

    @Override
    public void updateCar(carDTO dto) {
        if (repo.existsById(dto.getCarId())) {
            repo.save(mapper.map(dto, Car.class));
        } else {
            throw new RuntimeException("Check The Id");

        }
    }

    @Override
    public carDTO searchCar(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), carDTO.class);
        } else {
            throw new RuntimeException("Check The Id");
        }
    }

    @Override
    public void deleteCar(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Check The Id Not Delete");
        }
    }

    @Override
    public List<carDTO> getAllCar() {
        return mapper.map(repo.findAll(), new TypeToken<List<carDTO>>() {
        }.getType());
    }
}
