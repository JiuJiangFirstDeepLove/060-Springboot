package com.tumingrui.service.implement;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tumingrui.dao.UserDao;
import com.tumingrui.entity.User;
import com.tumingrui.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public IPage<User> getPage(int currentPage, int pageSize, User user) {
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(user.getUsername()),User::getUsername,user.getUsername());
        lqw.like(Strings.isNotEmpty(user.getSex()),User::getSex,user.getSex());
        lqw.like(Strings.isNotEmpty(user.getCls()),User::getCls,user.getCls());
        IPage page = new Page(currentPage, pageSize);
        userDao.selectPage(page, lqw);
        return page;
    }
}
