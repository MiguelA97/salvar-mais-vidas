package com.salvarmaisvidas.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> getAllUsers(int pageSize, int page, String sort) {
        return userRepository.findAll(PageRequest.of(page, pageSize, Sort.by(sort)));
    }

    @Override
    public User getUser(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public User newUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User replaceUser(User newUser, int userId) {
        return userRepository.findById(userId).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setRole(newUser.getRole());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}

