package service.Iplm;

import model.employee.Division;
import repository.IDivisionRepository;
import repository.Iplm.DivisionReposition;
import service.IDivisionService;

import java.util.List;

public class DivisionService implements IDivisionService {
    private IDivisionRepository iDivisionRepository=new DivisionReposition();
    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
