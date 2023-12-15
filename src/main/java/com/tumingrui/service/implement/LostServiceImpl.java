package com.tumingrui.service.implement;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tumingrui.dao.LostDao;
import com.tumingrui.dao.UserDao;
import com.tumingrui.entity.Lost;
import com.tumingrui.entity.User;
import com.tumingrui.service.LostService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LostServiceImpl extends ServiceImpl<LostDao, Lost> implements LostService {
    @Autowired
    private LostDao lostDao;
    @Override
    public IPage<Lost> getPage(int currentPage, int pageSize, Lost lost) {
        LambdaQueryWrapper<Lost> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(lost.getType()),Lost::getType,lost.getType());
        lqw.like(Strings.isNotEmpty(lost.getPlace()),Lost::getPlace,lost.getPlace());
        lqw.like(Strings.isNotEmpty(lost.getDate()),Lost::getDate,lost.getDate());
        lqw.isNull(Lost::getUsername);
        IPage page = new Page(currentPage, pageSize);
        lostDao.selectPage(page, lqw);
        return page;
    }
    @Override
    public IPage<Lost> selectPage(int currentPage, int pageSize, Lost lost) {
        LambdaQueryWrapper<Lost> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(lost.getType()),Lost::getType,lost.getType());
        lqw.like(Strings.isNotEmpty(lost.getDetails()),Lost::getDetails,lost.getDetails());
        lqw.isNotNull(Lost::getUsername);
        IPage page = new Page(currentPage, pageSize);
        lostDao.selectPage(page, lqw);
        return page;
    }
}
