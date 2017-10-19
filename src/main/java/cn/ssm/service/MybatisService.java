package cn.ssm.service;

import cn.ssm.dao.MybatisDao;
import cn.ssm.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MybatisService {
    public void add(Emp emp);
    public void delete(Emp emp);
    public void update(Emp emp);
    public List<Emp> findAll();
    public Emp findById(int id);
    public Emp findByEmp(Emp emp);

}
