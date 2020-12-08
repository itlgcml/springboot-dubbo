package com.itlg.controller.mybatisplus;

import com.baomidou.mybatisplus.extension.api.R;
import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.service.mybatisplus.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbUserController {

    @Autowired
    private TbUserService tbuserService;

    @RequestMapping(value = "/e")
    public R<List<TbUserBO>> demo1() {
        return tbuserService.findAllUser();
    }
}
