package com.tumingrui.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tumingrui.entity.Lost;
import com.tumingrui.entity.User;

public interface LostService extends IService<Lost> {
    IPage<Lost> getPage(int currentPage, int pageSize, Lost lost);
    IPage<Lost> selectPage(int currentPage, int pageSize, Lost lost);
}
