package repository;

import model.services.RentType;

import java.util.List;

public interface IRentTypeRepository {
    List<RentType> findAll();
}
