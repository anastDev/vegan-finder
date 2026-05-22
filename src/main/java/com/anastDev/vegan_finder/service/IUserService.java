package com.anastDev.vegan_finder.service;

import com.anastDev.vegan_finder.core.exceptions.EntityAlreadyExistsException;
import com.anastDev.vegan_finder.core.exceptions.EntityNotFoundException;
import com.anastDev.vegan_finder.dto.UserInsertDTO;
import com.anastDev.vegan_finder.dto.UserReadOnlyDTO;
import com.anastDev.vegan_finder.dto.UserUpdateDTO;
import com.anastDev.vegan_finder.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();
    UserReadOnlyDTO saveUser(UserInsertDTO userInsertDTO) throws EntityAlreadyExistsException;
    UserReadOnlyDTO updateUser(UserUpdateDTO userUpdateDTO) throws EntityAlreadyExistsException, EntityNotFoundException;
    void deleteUser(Long id) throws EntityNotFoundException;
}
