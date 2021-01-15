package com.itlg.serviceImpl.tree;

import com.itlg.entity.bo.tree.TbTreeOrderBO;
import com.itlg.entity.vo.TbTreeVO;
import com.itlg.exception.R;
import com.itlg.mapper.tree.TbTreeOrderMapper;
import com.itlg.service.tree.TbTreeOrderBOService;
import com.itlg.unit.TreeToolUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service("tbTreeOrderBOService")
public class TbTreeOrderBOServiceImpl implements TbTreeOrderBOService {

    @Autowired
    private TbTreeOrderMapper treeOrderMapper;

    @Override
    public R<List<TbTreeVO>> getTbTree() {
        List<TbTreeOrderBO> treeOrderBOList = treeOrderMapper.selectList(null);
        List<TbTreeVO> rootList = new ArrayList<>();
        List<TbTreeVO> bodyList = new ArrayList<>();
        treeOrderBOList.forEach(e -> {
            TbTreeVO temp = new TbTreeVO();
            BeanUtils.copyProperties(e, temp);
            if (ObjectUtils.isEmpty(e.getPid())) {
                rootList.add(temp);
            } else {
                bodyList.add(temp);
            }
        });
        TreeToolUtils treeToolUtils = new TreeToolUtils(rootList, bodyList);
        return R.success(treeToolUtils.getTree());
    }
}
