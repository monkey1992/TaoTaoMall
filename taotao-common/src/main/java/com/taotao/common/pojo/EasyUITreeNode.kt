package com.taotao.common.pojo

import java.io.Serializable

/**
 * EasyUI异步树控件
 *
 * @param id    节点ID
 * @param text  节点名称
 * @param state 节点是否展开，
 */
data class EasyUITreeNode(val id: Long, val text: String?, val state: String?) : Serializable