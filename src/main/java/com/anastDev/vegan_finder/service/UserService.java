package com.anastDev.vegan_finder.service;

import com.anastDev.vegan_finder.core.exceptions.EntityAlreadyExistsException;
import com.anastDev.vegan_finder.core.exceptions.EntityNotFoundException;
import com.anastDev.vegan_finder.dto.UserInsertDTO;
import com.anastDev.vegan_finder.dto.UserReadOnlyDTO;
import com.anastDev.vegan_finder.dto.UserUpdateDTO;
import com.anastDev.vegan_finder.mapper.Mapper;
import com.anastDev.vegan_finder.model.User;
import com.anastDev.vegan_finder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final Mapper mapper;

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public UserReadOnlyDTO saveUser(UserInsertDTO userInsertDTO) throws EntityAlreadyExistsException {
        return null;
    }

    @Override
    public UserReadOnlyDTO updateUser(UserUpdateDTO userUpdateDTO) throws EntityAlreadyExistsException, EntityNotFoundException {
        return null;
    }

    @Override
    public void deleteUser(Long id) throws EntityNotFoundException {

    }
}
