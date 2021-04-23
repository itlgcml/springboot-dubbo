package com.itlg.entity.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ExcelVO implements Serializable {

    @ExcelIgnore
    private Integer num;

    @ExcelProperty(value = "年龄", index = 0)
    private Integer age;

    @ExcelProperty(value = "姓名", index = 1)
    private String name;
}
