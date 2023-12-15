package com.tumingrui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tumingrui.entity.Admin;

public interface AdminService extends IService<Admin> {
    Admin login(Admin admin);
}
