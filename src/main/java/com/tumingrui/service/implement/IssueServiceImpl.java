package com.tumingrui.service.implement;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tumingrui.dao.IssueDao;
import com.tumingrui.dao.LostDao;
import com.tumingrui.entity.Issue;
import com.tumingrui.entity.Lost;
import com.tumingrui.entity.User;
import com.tumingrui.service.IssueService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl extends ServiceImpl<IssueDao, Issue>implements IssueService {
    @Autowired
    private IssueDao issueDao;
    @Override
    public IPage<Issue> getPage(int currentPage, int pageSize, Issue issue) {
        LambdaQueryWrapper<Issue> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(issue.getType()),Issue::getType,issue.getType());
        IPage page = new Page(currentPage, pageSize);
        issueDao.selectPage(page, lqw);
        return page;
    }
}
