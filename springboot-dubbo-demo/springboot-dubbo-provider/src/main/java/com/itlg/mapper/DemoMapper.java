package com.itlg.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itlg.entity.bo.Message;

import java.util.List;

public interface DemoMapper extends BaseMapper {

    public List<Message> findMessage();

}
