package com.itlg.entity.bo.tree;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName(value = "tb_tree_order")
public class TbTreeOrderBO implements Serializable {
    private Integer id;

    private String code;

    private String name;

    private Integer pid;

    private Integer sort;
}
