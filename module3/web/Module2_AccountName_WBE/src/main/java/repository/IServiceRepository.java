package repository;

import model.services.Service;
import model.services.ServiceType;
import service.Iplm.ServiceIplm;

import java.util.List;

public interface IServiceRepository {

    List<Service> findAll();

    void create(Service service);
}
