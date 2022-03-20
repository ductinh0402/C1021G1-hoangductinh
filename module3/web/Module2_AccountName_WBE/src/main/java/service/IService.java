package service;

import model.services.Service;
import service.Iplm.ServiceIplm;

import java.util.List;

public interface IService {
    List<Service> findAll();

    void create(Service service);
}
