package com.codegym.huy_c08.entity;

import java.util.List;

public interface AdminPermission {
    void changeNormalUserPassword(User user, List<User> userList, String newPassword);

    void deleteUser(User user, List<User> userList);
}
