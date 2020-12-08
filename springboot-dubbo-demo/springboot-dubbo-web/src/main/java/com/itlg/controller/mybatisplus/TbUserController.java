package com.itlg.controller.mybatisplus;

import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.exception.R;
import com.itlg.service.mybatisplus.TbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/mybatisPlus")
@Api(tags = "mybatisPlus实例")
public class TbUserController {

    @Autowired
    private TbUserService tbuserService;

    @GetMapping(value = "/all")
    @ApiOperation(value = "查询所有用户")
    public R<List<TbUserBO>> demo() {
        return tbuserService.findAllUser();
    }
}
