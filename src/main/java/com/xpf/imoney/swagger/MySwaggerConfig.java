package com.xpf.imoney.swagger;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//@Configuration
//@EnableSwagger // 启用 Swagger
public class MySwaggerConfig {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My Apps API Title",
                "My Apps API Description",
                "My Apps API terms of service",
                "My Apps API Contact Email",
                "My Apps API Licence Type",
                "My Apps API License URL"
        );
    }

    /*
     * Swagger 的几个常用注解：
     * @Api：表示这个类是Swagger的资源；
     * @ApiOperation：用在方法上，说明方法的作用。
     * @ApiParam：用来修饰参数，表示对参数添加元数据
     * @ApiModel：用于类，对类进行说明
     * @ApiIgnore：用于类，方法，表示这个类或方法被忽略；
     * @ApiImplicitParam：用于方法，表示单独的请求参数；
     */
}
