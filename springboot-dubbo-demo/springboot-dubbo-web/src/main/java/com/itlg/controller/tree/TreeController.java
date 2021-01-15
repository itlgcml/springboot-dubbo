package com.itlg.controller.tree;

import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.entity.vo.TbTreeVO;
import com.itlg.exception.R;
import com.itlg.service.mybatisplus.TbUserService;
import com.itlg.service.mybatisplus.UserOrderBOService;
import com.itlg.service.tree.TbTreeOrderBOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tree")
@Api(tags = "树形实例")
public class TreeController {
    @Autowired
    private TbTreeOrderBOService treeOrderBOService;


    @GetMapping(value = "/all")
    @ApiOperation(value = "查询树形结构")
    public R<List<TbTreeVO>> all() {
        return treeOrderBOService.getTbTree();
    }
}
