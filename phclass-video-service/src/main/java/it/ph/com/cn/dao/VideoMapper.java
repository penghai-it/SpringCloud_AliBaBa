package it.ph.com.cn.dao;

import it.ph.com.cn.model.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author penghai
 * @type Interface
 * @date 2022年01月13日 16:41
 */
@Repository
//@Mapper
public interface VideoMapper {
    @Select("select * from video where id=#{videoId}")
    Video findById(@Param("videoId") int videoId);

}
