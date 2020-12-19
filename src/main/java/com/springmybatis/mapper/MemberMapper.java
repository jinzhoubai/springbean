package com.springmybatis.mapper;

import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
    @Select("select 'member'")
    String selectById();
}
