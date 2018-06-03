package xiao.ze.demo.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by xiaozemaliya on 2017/4/2.
 */
@ComponentScan(basePackages = "xiao.ze.demo") //这里指定你要扫描的包及其子包子类
@SpringBootApplication
@MapperScan("xiao.ze.demo.mapper")//扫描：该包下相应的class,主要是MyBatis的持久化类.
@EnableTransactionManagement
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
