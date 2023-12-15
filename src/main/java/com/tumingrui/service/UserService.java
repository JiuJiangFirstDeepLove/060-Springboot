package com.tumingrui.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tumingrui.entity.User;

public interface UserService extends IService<User> {
    IPage<User> getPage(int currentPage, int pageSize, User user);
}
