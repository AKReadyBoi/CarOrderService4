package com.innowise.ryabov.cos4.request;

import com.innowise.ryabov.cos4.entity.Users;

public record UserRequest(String firstname, String lastname) {
    public Users convertToUser() {
        Users user = new Users();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        return user;
    }
}
