package service.Iplm;

import model.services.Service;
import repository.IServiceRepository;
import repository.Iplm.ServiceRepository;
import service.IService;


import java.util.List;

public class ServiceIplm implements IService {
    private IServiceRepository iServiceRepository=new ServiceRepository();
    @Override
    public List<Service> findAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public void create(Service service) {
        iServiceRepository.create(service);
    }
}
