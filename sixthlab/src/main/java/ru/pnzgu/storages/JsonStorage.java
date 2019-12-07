package ru.pnzgu.storages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.pnzgu.models.User;

import java.io.*;
import java.util.List;
import java.util.Locale;

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
    private static final String FILE_PATH = "/home/havlong/Documents/users.json";

    static {
        storage = new JsonStorage();
        mapper = new ObjectMapper();
        userList = new TypeReference<List<User>>() {};
    }

    private JsonStorage() {
        if (!new File(FILE_PATH).exists())
            writeJson(List.of());
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
        users.add(user);
        writeJson(users);
    }

    private void writeJson(List<User> users) {
        try (
                PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))
        ) {
            if (users == null)
                users = List.of();
            mapper.setLocale(Locale.getDefault());
            mapper.writeValue(writer, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<User> readJson() {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))
        ) {
            StringBuilder jsonBuilder = new StringBuilder();
            reader.lines().forEach(jsonBuilder::append);
            if (jsonBuilder.toString().isBlank())
                jsonBuilder.append("[]");
            return mapper.readValue(jsonBuilder.toString(), userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
