package com.itlg.unit;

import com.itlg.entity.vo.TbTreeVO;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeToolUtils {
    private List<TbTreeVO> rootList;//根节点
    private List<TbTreeVO> bodyList;//子节点

    public TreeToolUtils(List<TbTreeVO> rootList, List<TbTreeVO> bodyList) {
        this.rootList = rootList;
        this.bodyList = bodyList;
    }

    public List<TbTreeVO> getTree() {//初始化该对象后获得树
        if (!ObjectUtils.isEmpty(bodyList)) {
            Map<String, String> map = new HashMap<String, String>(bodyList.size());
            rootList.forEach(beanTree -> getChild(beanTree, map));
            return rootList;
        }
        return rootList;
    }

    private void getChild(TbTreeVO beanTree, Map<String, String> map) {
        List<TbTreeVO> childList = new ArrayList<>();
        bodyList.stream().filter(c -> !map.containsKey(c.getId()))
                .filter(c -> c.getPid().equals(beanTree.getId()))
                .forEach(c -> {
                    map.put(String.valueOf(c.getId()), c.getName());
                    getChild(c, map);
                    childList.add(c);
                });
        beanTree.setTreeVOList(childList);
    }
}
