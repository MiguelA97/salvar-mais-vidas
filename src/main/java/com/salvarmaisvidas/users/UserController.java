package com.salvarmaisvidas.users;

import com.salvarmaisvidas.util.PageWrapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    PageWrapper<User> getAllUsers(@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "role") String sort){
        return new PageWrapper<>(userService.getAllUsers(size, page, sort));
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable int userId){
        return userService.getUser(userId);
    }

    @PostMapping
    User newUser(@RequestBody User newUser){
        return userService.newUser(newUser);
    }

    @PutMapping("/{userId}")
    User replaceUser(@RequestBody User newUser, @PathVariable int userId){
        return userService.replaceUser(newUser, userId);
    }

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }
}

