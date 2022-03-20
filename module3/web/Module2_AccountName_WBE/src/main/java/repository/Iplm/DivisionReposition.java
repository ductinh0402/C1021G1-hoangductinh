package repository.Iplm;
import model.employee.Division;
import repository.IDivisionRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionReposition implements IDivisionRepository {
    private static final String SELECT_ALL_DIVISION = "select * from `division` ";
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Division> findAll() {
        List<Division> divisionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDivision = resultSet.getInt("division_id");
                String nameDivision  = resultSet.getString("division_name");
                divisionList.add(new Division(idDivision, nameDivision));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;

    }
}
