package com.tumingrui.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tumingrui.controller.utils.Result;
import com.tumingrui.entity.User;
import com.tumingrui.service.UserService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("{id}")
    public  Result selectAll(@PathVariable Integer id){
        return new Result(true,userService.getById(id));
    }
    @GetMapping("{currentPage}/{pageSize}")
    public Result selectPage(@PathVariable int currentPage, @PathVariable int pageSize, User user) {
        IPage<User> page = userService.getPage(currentPage, pageSize,user);
        if (currentPage > page.getPages()){
            page=userService.getPage((int)pageSize, pageSize,user);
        }
        return new Result(true, page);
    }

    @PostMapping
    public Result save(@RequestBody User user){
        return new Result(true,userService.save(user));
    }

    @PutMapping
    public Result updateById(@RequestBody User user){
        return new Result(userService.updateById(user));
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Integer id){
        return new Result(userService.removeById(id));
    }
}
