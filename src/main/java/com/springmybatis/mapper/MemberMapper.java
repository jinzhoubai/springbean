package com.springmybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    @Select("select 'member'")
    String selectById();
}
