package me.huangjing.lab.springcloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Eatgrass on 2017/9/19.
 */
@FeignClient("config-client")
public interface FooClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String getFoo();

    @RequestMapping(method = RequestMethod.GET, value = "/encrypted")
    String getDecrypted();
}
