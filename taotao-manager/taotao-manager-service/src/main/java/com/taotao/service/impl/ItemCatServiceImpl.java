package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TbItemCatMapper itemCatMapper;

    @NotNull
    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            EasyUITreeNode node = new EasyUITreeNode(tbItemCat.getId(),
                    tbItemCat.getName(),
                    tbItemCat.getIsParent() ? "closed" : "open");
            resultList.add(node);
        }

        return resultList;
    }
}
