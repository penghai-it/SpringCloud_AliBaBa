package it.ph.com.cn.service;

import it.ph.com.cn.model.Video;

/**
 * 视频业务接口
 *
 * @author penghai
 * @type Class
 * @date 2022年01月13日 16:32
 */

public interface VideoService {
    Video findById(int videoId);
}
