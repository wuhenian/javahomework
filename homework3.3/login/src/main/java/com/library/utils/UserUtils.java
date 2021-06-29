package com.library.utils;

import com.library.entity.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;

public class UserUtils {
    /**
     * Load a list of User from file.
     * Hint: what about reading from database?
     */
    public static List<User> loadUser() {
        List<User> Users = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(CONSTANTS.USER_FILE))) {
            Users = stream.map(line -> {
                String[] items = line.split("\\|");
                String unum = items[0];
                String uname = items[1];
                String upass = items[2];
                return new User(unum, uname, upass);
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Users;
    }

    /**
     * add a User by append file
     * Hint: what about inserting into database?
     * Hint: this method takes too many arguments, so it is error-prone. Any good method to solve it?
     */
    public static boolean addUser(String unum, String uname, String upass) {
        List<String> data = Arrays.asList(unum, uname, upass);
        String user = String.join("|", data) + System.lineSeparator();
        try {
            Files.write(Paths.get(CONSTANTS.USER_FILE),
                    user.getBytes(), APPEND);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Hint: any good way to get a User quickly when reading from file
     */
    public static User getUserByNumAndPass(String unum, String upass) {
        List<User> User = UserUtils.loadUser();
        List<User> results = User.stream().filter(s -> s.getUnum().equals(unum) && s.getUpass().equals(upass)).collect(Collectors.toList());
        if (results.size() == 0)
            return null;
        else
            return results.get(0);
    }
}
