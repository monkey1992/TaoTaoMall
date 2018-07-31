package com.taotao.service

import com.taotao.common.pojo.EasyUITreeNode

interface ItemCatService {

    fun getItemCatList(parentId: Long): List<EasyUITreeNode>
}