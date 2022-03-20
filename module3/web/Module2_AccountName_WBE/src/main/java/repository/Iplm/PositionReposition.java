package repository.Iplm;

import model.employee.Education;
import model.employee.Position;
import repository.IPositionReposition;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionReposition implements IPositionReposition {
    private static final String SELECT_ALL_POSITION = "select * from position";
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Position> findAll() {
        List<Position> positionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idPosition = resultSet.getInt("position_id");
                String namePosition  = resultSet.getString("position_name");
                positionList.add(new Position(idPosition, namePosition));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;

    }
}
