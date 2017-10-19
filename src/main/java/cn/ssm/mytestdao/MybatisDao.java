package cn.ssm.mytestdao;

import cn.ssm.entity.Emp;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class MybatisDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public void add(Emp emp){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.emp.add", emp);
        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(Emp emp){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.emp.delete", emp);
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(Emp emp){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.emp.update", emp);
        sqlSession.commit();
        sqlSession.close();
    }

    public List<Emp> findAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Emp> list = sqlSession.selectList("test.emp.findAll");
        return list;
    }

    public Emp findById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp emp = sqlSession.selectOne("test.emp.findById", id);
        return emp;
    }

    public Emp findByEmp (Emp emp){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp  temp = sqlSession.selectOne("test.emp.findByEmp",emp);
        return temp;
    }

}
