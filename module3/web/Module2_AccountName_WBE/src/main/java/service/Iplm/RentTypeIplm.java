package service.Iplm;

import model.services.RentType;
import repository.IRentTypeRepository;
import repository.Iplm.RentTypeRepository;
import service.IRentType;
import service.IService;
import service.IServiceType;

import java.util.List;

public class RentTypeIplm implements IRentType {

    private IRentTypeRepository iRentTypeRepository=new RentTypeRepository();

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
