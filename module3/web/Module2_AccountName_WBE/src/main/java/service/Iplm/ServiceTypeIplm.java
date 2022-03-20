package service.Iplm;

import model.services.ServiceType;
import repository.IServiceRepository;
import repository.IServiceTypeRepository;
import repository.Iplm.ServiceRepository;
import repository.Iplm.ServiceTypeRepository;
import service.IServiceType;

import java.util.List;


public class ServiceTypeIplm implements IServiceType {
   private IServiceTypeRepository iServiceTypeRepository=new ServiceTypeRepository();

    @Override
    public List<ServiceType> findAll() {
        return iServiceTypeRepository.findAll();
    }
}
