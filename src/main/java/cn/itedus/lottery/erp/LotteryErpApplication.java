package cn.itedus.lottery.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @description: 启动类
 * @author: BAISHUN
 * @date: 2023/5/23
 * @Copyright: 博客：https://www.cnblogs.com/baishun666/
 */
@SpringBootApplication
public class LotteryErpApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LotteryErpApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(LotteryErpApplication.class, args);
    }

}
