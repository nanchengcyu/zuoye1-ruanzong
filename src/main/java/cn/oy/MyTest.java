package cn.oy;

import cn.oy.dao.UserMapper;
import cn.oy.pojo.User;
import cn.oy.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<User> userList=sqlSession.selectList("findAll");

        System.out.println("期末考试，全部学生的软件工程综合实践成绩");
        for (User user:userList) {

            System.out.println(user.getId()+"---"+user.getUsername()+"---"+user.getLesson()+"---"+user.getScore());
        }
        sqlSession.close();
    }

    @Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSession();
        //方法一:
        //List<User> users = session.selectList("com.wong.mapper.UserMapper.selectUser");
        //方法二:
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.findAll();

        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void getUserId(){
        SqlSession session = MybatisUtils.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        session.close();
    }

    @Test

    public void addUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int id = 0;
        String username = "michael";
        String lesson = "软件工程综合实践";
        String score = "96";
        mapper.addUser(id, username, lesson, score);
        session.commit(); // 提交事务
        session.close();

        // 打印添加的用户信息
        System.out.println("添加的学生软件工程综合实践成绩信息：");
        System.out.println("ID: " + id);
        System.out.println("用户名: " + username);
        System.out.println("课程: " + lesson);
        System.out.println("成绩: " + score);
    }

    @Test
    public void updateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int id = 6;
        String username = "Kangkang";
        String lesson = "软件工程综合实践";
        String score = "96";
        int i = mapper.updateUser(id, username, lesson, score);
        session.commit(); // 提交事务
        session.close();

        if (i > 0) {
            System.out.println("更新成功！");
            // 打印更新的用户信息
            System.out.println("更新的学生软件工程综合实践成绩信息：");
            System.out.println("ID: " + id);
            System.out.println("用户名: " + username);
            System.out.println("课程: " + lesson);
            System.out.println("成绩: " + score);
        }
    }


    @Test
    public void deleteUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int id = 6;
        int i = mapper.deleteUser(id);
        session.commit(); // 提交事务
        session.close();

        if (i > 0) {
            System.out.println("删除成功！");
            // 打印已删除用户的信息
            System.out.println("已删除用户信息：");
            System.out.println("ID: " + id);
        }
    }

}
