package service.Iplm;

import model.employee.Position;
import repository.IDivisionRepository;
import repository.IPositionReposition;
import repository.Iplm.DivisionReposition;
import repository.Iplm.PositionReposition;
import service.IPositionService;

import java.util.List;

public class PositionService implements IPositionService {
    private IPositionReposition iPositionReposition=new PositionReposition();
    @Override
    public List<Position> findAll() {
        return iPositionReposition.findAll();
    }
}
