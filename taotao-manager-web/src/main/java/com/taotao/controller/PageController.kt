package com.taotao.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

/**
 * 页面访问控制器
 */
@Controller
class PageController {

    /**
     * 访问index.jsp
     */
    @RequestMapping("/")
    fun showIndex(): String {
        return "index"
    }

    /**
     * 访问其它页面
     */
    @RequestMapping("/{page}")
    fun showPage(@PathVariable page: String): String {
        return page
    }
}