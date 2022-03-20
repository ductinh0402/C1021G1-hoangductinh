package repository.Iplm;

import model.services.Service;
import repository.IServiceRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    private static final String SELECT_ALL_SERVICE = " SELECT * FROM service join service_type" +
            " on service.service_type_id= service_type.service_type_id " +
            "join rent_type on service.rent_type_id=rent_type.rent_type_id";
    private static final String INSERT_SERVICE = "insert into service(service_id,service_name,service_area,service_cost," +
            "service_max_people,standard_room,description_other_convenience,pool_area,number_of_floors," +
            "rent_type_id,service_type_id) values(?,?,?,?,?,?,?,?,?,?,?) ";
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Service> findAll() {
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idService = resultSet.getInt("service_id");
                String codeService = checkId(idService);
                String nameService = resultSet.getString("service_name");
                int areaService = resultSet.getInt("service_area");
                double costService = resultSet.getDouble("service_cost");
                String maxPeopleService = resultSet.getString("service_max_people");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                double pollArea = resultSet.getDouble("pool_area");
                int floors = resultSet.getInt("number_of_floors");
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentName = resultSet.getString("rent_type_name");
                double rentCost = resultSet.getDouble("rent_type_cost");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceList.add(new model.services.Service(idService, codeService, nameService, areaService, costService, maxPeopleService
                        , standardRoom, description, pollArea, floors, rentTypeId, rentName, rentCost, serviceTypeId, serviceTypeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    private String checkId(int idService) {
        if (idService < 10) {
            return "DV-000"+idService;
        }
        if (idService < 100) {
            return "DV-00"+idService;
        }
        if (idService < 1000) {
            return "DV-0"+idService;
        }
        return "DV-";
    }

    @Override
    public void create(Service service) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_SERVICE);
            preparedStatement.setInt(1, service.getIdService());
            preparedStatement.setString(2, service.getNameService());
            preparedStatement.setInt(3, service.getArea());
            preparedStatement.setDouble(4, service.getCost());
            preparedStatement.setString(5, service.getServiceMaxPeople());
            preparedStatement.setString(6, service.getStandardRoom());
            preparedStatement.setString(7, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(8, service.getPoolArea());
            preparedStatement.setInt(9, service.getNumberOfFloors());
            preparedStatement.setInt(10, service.getRentTypeId());
            preparedStatement.setInt(11, service.getServiceTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
