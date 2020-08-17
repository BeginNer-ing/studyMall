package studyMall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Auther: Yanis_CC
 * @CreateDate: 2020-08-17 15:41
 **/
@Configuration
@MapperScan("org.study.studyMall.mbg.mapper")
public class MyBatisConfig {
}
