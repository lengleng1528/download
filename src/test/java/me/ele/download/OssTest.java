package me.ele.download;


import com.alibaba.excel.EasyExcel;
import me.ele.download.pojo.Order;
import me.ele.download.service.OrderService;
import me.ele.download.service.impl.OssfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DownloadApplication.class)
public class OssTest {

    @Autowired
    private OrderService orderService;


    @Autowired
    private OssfileService ossfileService;


    @Test
    public void test1() throws IOException {
        //List<Order> orders = orderService.listOrderByVo(orderSearch);
        List<Order> orders = orderService.getAllOrders();
        //logger.info("task : {} 执行导出任务", JSON.toJSONString(task));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String fileName = "订单导出表" + new Random().nextInt(10000) + System.currentTimeMillis()+".xlsx";
        //生成excel
        EasyExcel.write(out, Order.class).sheet("订单表").doWrite(orders);

        //上传到oss
        String url = ossfileService.uploadExcel2OSS(new ByteArrayInputStream(out.toByteArray()),fileName);
        //该url可直接返回给前端下载
        String returnUrl = url.substring(0,url.lastIndexOf("?"))+".xlsx";
        System.out.println(returnUrl);
    }
}
