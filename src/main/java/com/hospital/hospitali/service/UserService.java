package com.hospital.hospitali.service;


import com.hospital.hospitali.dto.UserDto;
import com.hospital.hospitali.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}

