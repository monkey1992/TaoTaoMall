package com.taotao.common.pojo

import java.io.Serializable

/**
 * 商品列表查询结果
 */
data class EasyUIDataGridResult(val total: Long?, val rows: List<Any>?) : Serializable