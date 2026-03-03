package com.example.marketplace.controller;

import com.example.marketplace.model.Role;
import com.example.marketplace.model.User;
import jakarta.servlet.http.HttpSession;

public final class AdminChecker {

    public static User getAdmin(HttpSession session) {
        Object obj = session.getAttribute("loggedUser");
        if (obj == null) return null;

        User user = (User) obj;
        if (user.getRole() == Role.ADMIN) {
            return user;
        } else {
            return null;
        }
    }
}