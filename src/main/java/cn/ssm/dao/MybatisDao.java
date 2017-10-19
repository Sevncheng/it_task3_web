package cn.ssm.dao;

import cn.ssm.entity.Emp;

import java.util.List;

public interface MybatisDao {
    public void add(Emp emp);
    public void delete(Emp emm);
    public void update(Emp emp);
    public List<Emp> findAll();
    public Emp findById(int id);
    public Emp findByEmp(Emp emp);
}