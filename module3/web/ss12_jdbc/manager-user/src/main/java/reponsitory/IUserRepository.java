package reponsitory;

import model.User;

import java.util.List;

public interface IUserRepository {
    List<User> AllUser();

    void saveUser(User user);

    User findById(int id);

    void updateUser(User user);

    void remove(int id);

    List<User> search(String name);
}
