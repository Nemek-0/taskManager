package ru.nemek.server.dao;

import ru.nemek.shared.dto.User;

import java.util.List;

public interface UserDAO {
    User getById(int id);
    void save();
    void update();
    void delete();
    List<User> getAll();
}
