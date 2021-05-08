package com.itlg.entity.bo.multithreading;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
@TableName(value = "multithreading_test")
public class MultithreadingTestDTO {

    private Long id;

    private AtomicLong num;
}
