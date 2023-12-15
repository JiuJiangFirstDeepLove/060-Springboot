package com.tumingrui.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tumingrui.controller.utils.Result;
import com.tumingrui.entity.Issue;
import com.tumingrui.entity.Lost;
import com.tumingrui.entity.User;
import com.tumingrui.service.IssueService;
import com.tumingrui.service.LostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    public IssueService issueService;

    @GetMapping("{id}")
    public  Result selectAll(@PathVariable Integer id){
        return new Result(true,issueService.getById(id));
    }
    @GetMapping("/{currentPage}/{pageSize}")
    public Result selectPage(@PathVariable int currentPage, @PathVariable int pageSize, Issue issue) {
        IPage<Issue> page = issueService.getPage(currentPage,pageSize,issue);
        if (currentPage > page.getPages()){
            page=issueService.getPage((int)pageSize, pageSize,issue);
        }
        return new Result(true, page);
    }

    @PostMapping
    public Result save(@RequestBody Issue issue){
        return new Result(true,issueService.save(issue));
    }

    @PutMapping
    public Result updateById(@RequestBody Issue issue){
        return new Result(issueService.updateById(issue));
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Integer id){
        return new Result(issueService.removeById(id));
    }
}
