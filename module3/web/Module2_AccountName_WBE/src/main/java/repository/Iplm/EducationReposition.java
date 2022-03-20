package repository.Iplm;

import model.employee.Division;
import model.employee.Education;
import repository.IEducationReposition;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationReposition implements IEducationReposition {
    private static final String SELECT_ALL_EDUCATION = "select * from education_degree";
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Education> findAll() {
        List<Education> educationList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement(SELECT_ALL_EDUCATION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idEducation = resultSet.getInt("education_degree_id");
                String nameEducation  = resultSet.getString("education_degree_name");
                educationList.add(new Education(idEducation, nameEducation));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationList;

    }
}
