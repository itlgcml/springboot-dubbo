package com.itlg.entity.bo.mybatisplus;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@TableName(value = "tb_user")
public class TbUserBO implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private Date created;

    private String salt;
}
