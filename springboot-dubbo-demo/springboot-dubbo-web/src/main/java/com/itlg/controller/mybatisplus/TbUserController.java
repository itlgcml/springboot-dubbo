package com.itlg.controller.mybatisplus;

import com.itlg.config.SpringBeanTool;
import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.entity.bo.mybatisplus.UserOrderBO;
import com.itlg.excepion.R;
import com.itlg.service.mybatisplus.TbUserService;
import com.itlg.service.mybatisplus.UserOrderBOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/mybatisPlus")
@Api(tags = "mybatisPlus实例,查询所有用户含有aop")
public class TbUserController {

    @Autowired
    private TbUserService tbuserService;

    @Autowired
    private UserOrderBOService userOrderBOService;

    @Autowired
    private SpringBeanTool springBeanTool;

    @GetMapping(value = "/all")
    @ApiOperation(value = "查询所有用户")
    public R<List<TbUserBO>> all() {
        return tbuserService.findAllUser();
    }

    @GetMapping(value = "/testGrowth")
    @ApiOperation(value = "测试自增长")
    public R testGrowth() {
        return tbuserService.testGrowth();
    }

    @GetMapping(value = "/allUserOrder")
    @ApiOperation(value = "mybatis一对多-查询所有用户以及其下订单")
    public R<List<UserOrderBO>> allUserOrder() {
        return userOrderBOService.allUserOrder();
    }

    @GetMapping(value = "/address")
    @ApiOperation(value = "项目中获取路径的两种方式")
    public R<List<String>> address() {
        ServletContext servletContext = springBeanTool.getServletContext();
        URL url = TbUserController.class.getClassLoader().getResource("");
        String realPath = servletContext.getRealPath("");
        String file = url.getFile();
        List<String> list = new ArrayList<>();
        list.add(realPath);
        list.add(file);
        return R.success(list);
    }
}
