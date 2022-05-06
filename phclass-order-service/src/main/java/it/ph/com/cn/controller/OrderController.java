package it.ph.com.cn.controller;

import it.ph.com.cn.client.OrderByVideoServiceClient;
import it.ph.com.cn.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单接口（调取视频服务）
 *
 * @author penghai
 * @type Class
 * @date 2022年01月13日 17:33
 */
@RestController
@RequestMapping("api/v1/video_order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    //nacos取服务
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private OrderByVideoServiceClient orderByVideoServiceClient;

    /**
     * 通过restTemplate调取视频服务，查询视频信息
     *
     * @param videoId 视频id
     * @return
     */
    @RequestMapping("/orderFindByVideoId")
    public Video orderFindByVideoId(@RequestParam("videoId") int videoId) {
        //RestTemplate方式调用
        //Video forObject = restTemplate.getForObject("http://127.0.0.1:9010/api/v1/video/find_by_id?videoId=" + videoId, Video.class);
        //服务集群时取到的是所有的服务
        /*   List<ServiceInstance> instances = discoveryClient.getInstances("phclass-video-service");
        ServiceInstance serviceInstance = instances.get(0);*/
        //Video forObject = restTemplate.getForObject("http://phclass-video-service/api/v1/video/find_by_id?videoId=" + videoId, Video.class);
  /*      if (videoId == 30) {
            throw new RuntimeException();
        }*/
        Video forObject = orderByVideoServiceClient.findById(videoId);
        return forObject;
    }

    /**
     * @param video
     * @return
     */
    @PostMapping("/save")
    public Object save(@RequestBody Video video) {
        int rows = orderByVideoServiceClient.save(video);
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", rows);
        return map;
    }

    int temp = 0;

    @RequestMapping("/map")
    public Map entinelText(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //TimeUnit.SECONDS.sleep(4);
        temp++;
        if (temp % 3 == 0) {
            throw new RuntimeException();
        }
        map.put("title1", "ALibabaCloud学习");
        map.put("title2", "微服务学习");
        map.put("port", request.getServerPort() + "");
        return map;
    }
}
