package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.to.UserTo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsersUtil {

    public static final List<User> users = Arrays.asList(
            new User(null, "Name5", "email1", "password1", Role.USER),
            new User(null, "Name5", "email2", "password1", Role.USER),
            new User(null, "Name7", "email2", "password2", Role.USER),
            new User(null, "Name4", "email3", "password3", Role.USER),
            new User(null, "Name9", "email4", "password4", Role.USER),
            new User(null, "Name1", "email5", "password5", Role.USER),
            new User(null, "Name2", "email6", "password6", Role.USER),
            new User(null, "Name6", "email7", "password7", Role.USER)
    );

    public static List<UserTo> getTos(Collection<User> users) {
        return sortingUsers(users);
    }

    private static List<UserTo> sortingUsers(Collection<User> users) {
        return users.stream()
                .sorted(new UserComparator())
                .map(UsersUtil::createTo)
                .collect(Collectors.toList());
    }

    private static UserTo createTo(User user) {
        return new UserTo(user.getId(), user.getName(), user.getEmail(), user.getPassword(), Role.USER);
    }

    static class UserComparator implements Comparator<User> {
        public int compare(User a, User b) {
            return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
        }
    }
}
