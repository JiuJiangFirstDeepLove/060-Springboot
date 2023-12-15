package com.tumingrui.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tumingrui.entity.Issue;
import com.tumingrui.entity.Lost;
import com.tumingrui.entity.User;

public interface IssueService extends IService<Issue> {
    IPage<Issue> getPage(int currentPage, int pageSize, Issue issue);
}
