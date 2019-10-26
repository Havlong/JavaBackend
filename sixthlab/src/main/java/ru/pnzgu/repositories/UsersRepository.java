package ru.pnzgu.repositories;

import ru.pnzgu.models.User;

import java.util.List;

/**
 * 28.09.2019
 * UsersRepository
 *
 * @author havlong
 * @version 1.0
 */
public interface UsersRepository {
    List<User> findAll();
    void save(User user);
    boolean exists(String userName, String password);
}
