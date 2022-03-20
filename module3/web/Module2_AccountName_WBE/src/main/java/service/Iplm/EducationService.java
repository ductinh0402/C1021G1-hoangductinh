package service.Iplm;

import model.employee.Education;
import repository.IEducationReposition;
import repository.Iplm.EducationReposition;
import service.IEducationService;

import java.util.List;

public class EducationService implements IEducationService {
private IEducationReposition iEducationReposition=new EducationReposition();
    @Override
    public List<Education> findAll() {
        return iEducationReposition.findAll();
    }
}
