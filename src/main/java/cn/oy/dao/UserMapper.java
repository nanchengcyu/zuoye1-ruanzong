package cn.oy.dao;

import cn.oy.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface UserMapper {
    //获取全部查询
    @Select("select * from user")
    List<User> findAll();

    //根据id查询用户
    @Select("select * from user where id= #{id}")
    User getUserById(@Param("id") int id);

    //insert 一个用户
    @Insert("insert into user(id,username,lesson,score) values (#{id},#{username},#{lesson},#{score})")
    int addUser(@Param("id") int id,@Param("username")String username,@Param("lesson")String lesson,@Param("score")String score);

    //修改信息
    @Update(" update user set username=#{username},lesson=#{lesson},score=#{score} where id=#{id}")
    int updateUser(@Param("id") int id,@Param("username")String username,@Param("lesson")String lesson,@Param("score")String score);

    //删除用户
    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id") int id);
}
