package com.taotao.mybatis.pagehelper

import com.github.pagehelper.PageHelper
import com.taotao.mapper.TbItemMapper
import com.taotao.pojo.TbItemExample
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext
import com.github.pagehelper.PageInfo

/**
 * MyBatis分页插件测试工具类
 */
class TestPageHelper {

    @Test
    fun testPageHelper() {
        // 初始化Spring容器
        val applicationContext = ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml")
        // 从容器中获得mapper代理对象
        val itemMapper = applicationContext.getBean<TbItemMapper>(TbItemMapper::class.java)
        // 执行查询
        val example = TbItemExample()
        // 查询之前进行分页处理
        PageHelper.startPage(1, 30) // 注意，分页插件仅对最近的这一次查询有效，下一次查询就无效了。怎么实现的呢？使用了LocalThread。
        val list = itemMapper.selectByExample(example)
        // 取分页信息
        System.out.println("结果集中的记录数：" + list.size)
        val pageInfo = PageInfo(list)
        System.out.println("总记录数：" + pageInfo.total)
        System.out.println("总页数：" + pageInfo.pages)
    }
}