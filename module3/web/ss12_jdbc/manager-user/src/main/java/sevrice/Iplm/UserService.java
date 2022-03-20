package sevrice.Iplm;

import model.User;
import reponsitory.IUserRepository;

import reponsitory.Iplm.UserRepository;
import sevrice.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository iUserRepository=new UserRepository();
    @Override
    public List<User> AllUser() {
        return iUserRepository.AllUser();
    }

    @Override
    public void saveUser(User user) {
        iUserRepository.saveUser(user);
    }

    @Override
    public User findById(int id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void updateUser(User user) {
        iUserRepository. updateUser(user);
    }

    @Override
    public void remove(int id) {
        iUserRepository.remove(id);
    }

    @Override
    public List<User> search(String name) {
        return iUserRepository.search(name);
    }
}
