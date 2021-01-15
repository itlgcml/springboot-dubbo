package com.itlg.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class TbTreeVO implements Serializable {
    private Integer id;

    private String code;

    private String name;

    private Integer pid;

    private Integer sort;

    private List<TbTreeVO> treeVOList;
}
