package com.integrator.test.user.controller;

import com.integrator.test.user.service.UserService;
import com.integrator.test.user.view.UserListOutView;
import com.integrator.test.user.view.UserView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "UserController")
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @ApiOperation(value = "Получение сотрудника по идентификатору", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public UserView getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @ApiOperation(value = "Получение списка сотрудников согласно параметрам", httpMethod = "POST")
    @PostMapping(value = "/list")
    public List<UserListOutView> getListOfUsers(@RequestBody UserView userListInView){
        return userService.getListOfUsers(userListInView);
    }

    @ApiOperation(value = "Обновление сотрудника", httpMethod = "POST")
    @PostMapping(value = "/update")
    public void updateUser(@RequestBody UserView user){
        userService.updateUser(user);
    }

    @ApiOperation(value = "Добавление сотрудника", httpMethod = "POST")
    @PostMapping(value = "/save")
    public void saveUser(@RequestBody UserView user){
        userService.saveUser(user);
    }

}
