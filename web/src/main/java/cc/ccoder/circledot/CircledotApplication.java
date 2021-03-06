package cc.ccoder.circledot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chencong
 */
@SpringBootApplication
@MapperScan("cc.ccoder.circledot.core.dal.mapper")
public class CircledotApplication {



    public static void main(String[] args) {
        SpringApplication.run(CircledotApplication.class, args);
    }

}
