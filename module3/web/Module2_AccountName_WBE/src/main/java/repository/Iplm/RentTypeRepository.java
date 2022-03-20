package repository.Iplm;

import model.services.RentType;
import model.services.ServiceType;
import repository.IRentTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository {


    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<RentType> findAll() {
        List<RentType> rentTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("select * from rent_type");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idRent = resultSet.getInt("rent_type_id");
                String nameRent = resultSet.getString("rent_type_name");
                double costRent=resultSet.getDouble("rent_type_cost");
                rentTypeList.add(new RentType(idRent, nameRent,costRent));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypeList;
    }
}
