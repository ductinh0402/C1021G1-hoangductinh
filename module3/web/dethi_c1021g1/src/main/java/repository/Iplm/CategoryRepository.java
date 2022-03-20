package repository.Iplm;


import model.Category;
import repository.ICategoryRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private BaseRepository baseRepository=new BaseRepository();
    @Override
    public List<Category> findAll() {
        List<Category> categoryList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=this.baseRepository.getConnection().prepareStatement("select * from category");
            ResultSet resultSet=preparedStatement.executeQuery();
            Category category;
            while (resultSet.next()){
                category=new Category();
                category.setIdCategory(resultSet.getInt("id_category"));
                category.setNameCategory(resultSet.getString("name_category"));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;

    }
}
