package ru.pnzgu.repositories;

import ru.pnzgu.models.User;
import ru.pnzgu.storages.JsonStorage;

import java.util.List;

/**
 * 28.09.2019
 * UsersRepositoryInJsonImpl
 *
 * @author havlong
 * @version 1.0
 */
public class UsersRepositoryJsonImpl implements UsersRepository {
    @Override
    public List<User> findAll() {
        return JsonStorage.storage().users();
    }

    @Override
    public void save(User user) {
        JsonStorage.storage().addUser(user);
    }

    @Override
    public boolean exists(String userName, String password) {
        for (User user : JsonStorage.storage().users()) {
            if (user.getUserName().equals(userName) &&
                    user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
