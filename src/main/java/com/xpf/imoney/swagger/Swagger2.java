package com.xpf.imoney.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Vance on 2019/07/09 :)
 * Function:
 * <p>
 * - Swagger 的几个常用注解：
 * - @Api：表示这个类是Swagger的资源；
 * - @ApiOperation：用在方法上，说明方法的作用。
 * - @ApiParam：用来修饰参数，表示对参数添加元数据
 * - @ApiModel：用于类，对类进行说明
 * - @ApiIgnore：用于类，方法，表示这个类或方法被忽略；
 * - @ApiImplicitParam：用于方法，表示单独的请求参数；
 */
@Configuration
@EnableSwagger2 // 启用 Swagger
@EnableWebMvc
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.xpf.imoney"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 api 文档的详细信息函数，注意这里的注解引用的是哪个
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("SSM Application [iMoney] Swagger2 RESTFul API")
                // 创建人
                .contact(new Contact("Vance", "https://www.vance.xin", "542270559@qq.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("This is [iMoney] API doc")
                .build();
    }
}
