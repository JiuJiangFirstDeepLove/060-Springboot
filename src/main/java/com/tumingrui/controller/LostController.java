package com.tumingrui.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tumingrui.controller.utils.Result;
import com.tumingrui.entity.Lost;
import com.tumingrui.entity.User;
import com.tumingrui.service.LostService;
import com.tumingrui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lost")
public class LostController {
    @Autowired
    public LostService lostService;
    @GetMapping("{id}")
    public  Result selectAll(@PathVariable Integer id){
        return new Result(true,lostService.getById(id));
    }

    @GetMapping("/get/{currentPage}/{pageSize}")
    public Result selectPage(@PathVariable int currentPage, @PathVariable int pageSize, Lost lost) {
        IPage<Lost> page = lostService.getPage(currentPage,pageSize,lost);
        if (currentPage > page.getPages()){
            page=lostService.getPage((int)pageSize, pageSize,lost);
        }
        return new Result(true, page);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result selectUserPage(@PathVariable int currentPage, @PathVariable int pageSize, Lost lost) {
        IPage<Lost> page = lostService.selectPage(currentPage,pageSize,lost);
        if (currentPage > page.getPages()){
            page=lostService.getPage((int)pageSize, pageSize,lost);
        }
        return new Result(true, page);
    }

    @PostMapping
    public Result save(@RequestBody Lost lost){
        return new Result(true,lostService.save(lost));
    }

    @PutMapping
    public Result updateById(@RequestBody Lost lost){
        return new Result(lostService.updateById(lost));
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Integer id){
        return new Result(lostService.removeById(id));
    }
}
