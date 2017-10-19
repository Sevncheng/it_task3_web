package cn.ssm.controller;

import cn.ssm.entity.Emp;
import cn.ssm.service.MybatisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping(value = "/Desk")
public class FirstDemo {

    @Autowired
    public MybatisService mybatisService;


    //处理登录成功后跳转到展示方法
    @RequestMapping(value = "/Emplogin",method = RequestMethod.POST)
    public String login(HttpServletRequest request,Emp emp){
        String str = "/login.jsp";
        try {
            Emp temp = mybatisService.findByEmp(emp);
            if (temp!=null) {
                //验证登录成功后,将temp放入session域中
                request.getSession().setAttribute("emplogin",emp);
                str = "/Desk/EmpList";
            }
        }catch (Exception e){}
        return str;
    }
    //处理注册请求后跳转至登录页面
    @RequestMapping(value = "/Emp",method = RequestMethod.POST)
    public String addEmp(Emp emp){
        if (emp!=null){
            mybatisService.add(emp);
        }
        return "redirect:/login.jsp";
    }

    //展示方法,获取所有用户并跳转至展示页面
    @RequestMapping(value = "/EmpList")
    public String listEmp(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Emp> list = mybatisService.findAll();
        model.addAttribute("emplist", list);
        return "/WEB-INF/list.jsp";
    }

    //处理跳转至更新页面请求
    @RequestMapping(value = "/Emp/UpdateUI",method = RequestMethod.GET)
    public String updateUI(Model model,int id){
       Emp emp = mybatisService.findById(id);
       model.addAttribute("emp",emp);

       return "/updateUI.jsp";
    }

    //处理更新请求并跳转至展示方法
    @RequestMapping(value = "/Emp/Update",method = RequestMethod.POST)
    public String updateEmp(Model model,Emp emp){
       mybatisService.update(emp);

       return "/Desk/EmpList";
    }

    //处理删除用户请求并跳回展示方法
    @RequestMapping(value = "/Emp/Delete",method = RequestMethod.GET)
    public String deleteEmp(int id){
        Emp emp = mybatisService.findById(id);
        mybatisService.delete(emp);

        return "/Desk/EmpList";
    }
}
