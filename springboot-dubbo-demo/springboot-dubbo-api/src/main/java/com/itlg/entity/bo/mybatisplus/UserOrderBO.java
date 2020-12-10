package com.itlg.entity.bo.mybatisplus;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserOrderBO implements Serializable{
    private Long id;

    private String username;

    private String password;

    private String phone;

    private Date created;

    private String salt;

    private List<TbOrderBO> orderList;
}
