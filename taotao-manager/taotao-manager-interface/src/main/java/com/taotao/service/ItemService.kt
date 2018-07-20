package com.taotao.service

import com.taotao.common.pojo.EasyUIDataGridResult
import com.taotao.pojo.TbItem

interface ItemService {

    /**
     * 根据商品id获取商品
     *
     * @param itemId 商品id
     * @return 商品
     */
    fun getItemById(itemId: Long): TbItem

    /**
     * 获取商品列表
     *
     * @param page 页数
     * @param rows 每一页多少条数据
     * return [EasyUIDataGridResult]对象
     */
    fun getItemList(page: Int, rows: Int): EasyUIDataGridResult
}