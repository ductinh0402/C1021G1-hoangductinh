package repository.Iplm;

import model.person.CustomerType;
import repository.ICustomerTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static String SELECT_ALL_CUSTOMER_TYPE = "SELECT * FROM customer_type";
    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerType customerType;
            while (resultSet.next()){
                customerType=new CustomerType();
                customerType.setIdCustomerType(resultSet.getInt("customer_type_id"));
                customerType.setNameCustomerType(resultSet.getString("customer_type_name"));
                customerList.add(customerType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }
}
