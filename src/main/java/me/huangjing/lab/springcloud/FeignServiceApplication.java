package me.huangjing.lab.springcloud;

import me.huangjing.lab.springcloud.feign.FooClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class FeignServiceApplication {

	@Autowired
	private FooClient fooClient;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FeignServiceApplication.class, args);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity remoteCallFoo() {
		String response = fooClient.getDecrypted() + ", " +fooClient.getFoo();
		return ResponseEntity.ok(response);
	}
}
