package it.ph.com.cn.service.Ipml;

import it.ph.com.cn.dao.VideoMapper;
import it.ph.com.cn.model.Video;
import it.ph.com.cn.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 视频业务实现类
 *
 * @author penghai
 * @type Class
 * @date 2022年01月13日 16:33
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Video findById(int videoId) {
        return videoMapper.findById(videoId);
    }
}
