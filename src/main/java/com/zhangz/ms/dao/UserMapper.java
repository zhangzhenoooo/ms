package com.zhangz.ms.dao;

import com.zhangz.ms.domain.MiaoShaUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/9
 * @time: 23:18
 */
@Mapper
public interface UserMapper {
    @Select("select * from miaosha_user where id=#{id}")
    public MiaoShaUser getUserById(@Param("id") int userCode);

    @Insert("insert into miaosha_user (id,nickname) values (#{id},#{name})")
    void inser(MiaoShaUser miaoShaUser);
    @Select("select * from miaosha_user where nickname=#{nickname}")
    MiaoShaUser getUserByNickname(String nickname);
}
