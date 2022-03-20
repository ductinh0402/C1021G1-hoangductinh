package service.Iplm;

import model.Category;
import model.Product;
import repository.ICategoryRepository;
import repository.Iplm.CategoryRepository;
import service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryRepository iCategoryRepository=new CategoryRepository();
    @Override
    public List<Category> findAll() {
        List<Category> categoryList=iCategoryRepository.findAll();
        if (categoryList.size() == 0) {
            return null;
        }else {
            return categoryList ;
        }
    }
}
