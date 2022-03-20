package repository.Iplm;


import model.services.ServiceType;
import repository.IServiceTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository implements IServiceTypeRepository {
    private static final String SELECT_ALL_SERVICE_TYPE ="select * from service_type" ;
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<ServiceType> findAll() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement(SELECT_ALL_SERVICE_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idServiceType = resultSet.getInt("service_type_id");
                String nameServiceType = resultSet.getString("service_type_name");
                serviceTypeList.add(new ServiceType(idServiceType, nameServiceType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }

}
