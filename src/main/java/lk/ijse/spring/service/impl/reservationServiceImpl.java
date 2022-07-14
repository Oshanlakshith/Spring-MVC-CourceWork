package lk.ijse.spring.service.impl;
import lk.ijse.spring.dto.reservationDTO;
import lk.ijse.spring.entity.reservasion;
import lk.ijse.spring.repo.resrvationRepo;
import lk.ijse.spring.service.reservationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class reservationServiceImpl implements reservationService {

    @Autowired
    private resrvationRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveReservation(reservationDTO dto) {
        if(!repo.existsById(dto.getReservationId())){
            repo.save(mapper.map(dto, reservasion.class));
        }else{
            throw new RuntimeException("Already saved");
        }
    }

    @Override
    public void updateReservation(reservationDTO dto) {
        if(repo.existsById(dto.getReservationId())){
            repo.save(mapper.map(dto,reservasion.class));
        }else {
            throw new RuntimeException("No Such Id To Update");
        }
    }

    @Override
    public void deleteReservation(String id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
        }else{
            throw new RuntimeException("No Reservation for" +id+ "..!");
        }

    }

    @Override
    public reservationDTO searchReservation(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(), reservationDTO.class);
        }else {
            throw new RuntimeException("No Customer for" +id+ "..!");
        }
    }

    @Override
    public List<reservationDTO> reservation() {
        return mapper.map(repo.findAll(),new TypeToken<List<reservationDTO>>(){
        }.getType());
    }
}