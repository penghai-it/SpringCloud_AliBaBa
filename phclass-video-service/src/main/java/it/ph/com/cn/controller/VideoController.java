package it.ph.com.cn.controller;

import it.ph.com.cn.model.Video;
import it.ph.com.cn.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 视频业务接口
 *
 * @author penghai
 * @type Class
 * @date 2022年01月13日 16:30
 */
@RestController
@RequestMapping("api/v1/video")
@RefreshScope //用于是实时获取Nacos配置中心的数据（没有这个注解需要重启服务再能获取到Nacos配置文件中最新的配置数据）
public class VideoController {
    @Autowired
    private VideoService videoService;
    //获取Nacos配置中心配置文件中title的值
    //@Value("${video.title}")
    private String videoTitle;

    @RequestMapping("/find_by_id")
    public Video findById(@RequestParam("videoId") int videoId, HttpServletRequest request) {
        Video video = videoService.findById(videoId);
        video.setServeInfo(request.getServerName() + ":" + request.getServerPort());
        return video;
    }

    /**
     * @param video
     * @return
     */
    @PostMapping("save")
    public int save(@RequestBody Video video) {
        System.out.println(video.getTitle());
        return 1;
    }
}
