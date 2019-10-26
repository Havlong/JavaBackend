package ru.pnzgu.storages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.pnzgu.models.User;

import java.io.*;
import java.util.List;

/**
 * 28.09.2019
 * JsonStorage
 *
 * @author havlong
 * @version 1.0
 */
public class JsonStorage {
    private static final JsonStorage storage;
    private static final ObjectMapper mapper;
    private static final TypeReference userList;

    static {
        storage = new JsonStorage();
        mapper = new ObjectMapper();
        userList = new TypeReference<List<User>>() {};
    }

    private JsonStorage() {

    }

    public static JsonStorage storage() {
        return storage;
    }

    public List<User> users() {
        return readJson();
    }

    public void addUser(User user) {
        List<User> users = readJson();
        assert users != null;
        assert user != null;
        if (!users.contains(user)) {
            users.add(user);
        }
        writeJson(users);
    }

    private void writeJson(List<User> users) {
        try (
                PrintWriter writer = new PrintWriter(new FileWriter("users.json"));
        ) {
            mapper.writeValue(writer, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<User> readJson() {
        try (
                BufferedReader reader = new BufferedReader(new FileReader("users.json"));
        ) {
            StringBuilder jsonBuilder = new StringBuilder();
            reader.lines().forEach(jsonBuilder::append);
            return mapper.readValue(jsonBuilder.toString(), userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
