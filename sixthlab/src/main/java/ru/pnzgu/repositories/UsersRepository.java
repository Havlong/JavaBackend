package ru.pnzgu.repositories;

import ru.pnzgu.models.User;

import java.util.List;

/**
 * 28.09.2019
 * UsersRepository
 *
 * Интерфейс, описывающий взаимодействие с моделями пользователей
 *
 * @author havlong
 * @version 1.0
 */
public interface UsersRepository {
    /**
     * Получить список всех пользователей
     * @return список моделей пользователей
     */
    List<User> findAll();

    /**
     * Добавить пользователя или обновить его данные
     * @param user модель пользователя
     */
    void save(User user);

    /**
     * Проверка существования пользователя с переданными учётными данными
     * @param userName логин
     * @param password пароль
     * @return true, если пользователь существует, иначе false
     */
    boolean exists(String userName, String password);

    /**
     * Проверка существования пользователя с переданным логином
     * @param userName логин
     * @return true, если пользователь с таким логином существует, иначе false
     */
    boolean exists(String userName);
}
