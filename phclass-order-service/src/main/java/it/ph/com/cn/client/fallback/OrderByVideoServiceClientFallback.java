package it.ph.com.cn.client.fallback;

import it.ph.com.cn.client.OrderByVideoServiceClient;
import it.ph.com.cn.model.Video;
import org.springframework.stereotype.Service;

/**
 * 服务降级实现类
 *
 * @author penghai
 * @type Class
 * @date 2022年01月24日 15:33
 */
@Service
public class OrderByVideoServiceClientFallback implements OrderByVideoServiceClient {
    @Override
    public Video findById(int videoId) {
        Video video = new Video();
        video.setTitle("服务降级测试——视频查询");
        return video;
    }

    @Override
    public int save(Video video) {
        return 0;
    }
}
