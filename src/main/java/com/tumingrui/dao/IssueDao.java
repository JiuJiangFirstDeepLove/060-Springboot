package com.tumingrui.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tumingrui.entity.Issue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IssueDao extends BaseMapper<Issue> {
}
