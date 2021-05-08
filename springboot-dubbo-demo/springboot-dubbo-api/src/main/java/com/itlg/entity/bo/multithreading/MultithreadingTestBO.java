package com.itlg.entity.bo.multithreading;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@Data
@TableName(value = "multithreading_test")
public class MultithreadingTestBO implements Serializable {

    private Long id;

    private Long num;
}
