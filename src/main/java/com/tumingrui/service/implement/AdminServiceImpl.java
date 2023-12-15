package com.tumingrui.service.implement;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tumingrui.dao.AdminDao;
import com.tumingrui.entity.Admin;
import com.tumingrui.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin login(Admin admin) {
        LambdaQueryWrapper<Admin> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Admin::getUsername, admin.getUsername()).eq(Admin::getPassword, admin.getPassword());
        Admin ad=adminDao.selectOne(lqw);
        return ad;
    }
}
