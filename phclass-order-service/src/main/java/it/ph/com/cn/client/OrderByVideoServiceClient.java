package it.ph.com.cn.client;

import it.ph.com.cn.client.fallback.OrderByVideoServiceClientFallback;
import it.ph.com.cn.model.Video;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign服务调层，
 * fallback 服务降级后调用的方法(注意：方法名和参数都需要一样)
 *
 * @author penghai
 * @type Class
 * @date 2022年01月14日 14:23
 */
@FeignClient(name = "phclass-video-service", fallback = OrderByVideoServiceClientFallback.class)
public interface OrderByVideoServiceClient {
    //GET方式请求
    @GetMapping("api/v1/video/find_by_id")
    Video findById(@RequestParam("videoId") int videoId);

    //Post方式请求
    @PostMapping("api/v1/video/save")
    int save(@RequestBody Video video);
}
