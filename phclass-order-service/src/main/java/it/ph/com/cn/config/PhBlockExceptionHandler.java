package it.ph.com.cn.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * sentinel返回抛出的异常信息配置
 *
 * @author penghai
 * @type Class
 * @date 2022年01月24日 11:38
 */

@Component//用来让spring扫描，并注入springIoc容器中
public class PhBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        Map<String, Object> info = new HashMap<>();
        //instanceof 用来判断一个对象是否为一个类的实例
        if (e instanceof FlowException) {
            info.put("code", -1);
            info.put("msg", "限流异常");
        } else if (e instanceof DegradeException) {
            info.put("code", -2);
            info.put("msg", "降级异常");
        } else if (e instanceof ParamFlowException) {
            info.put("code", -3);
            info.put("msg", "参数限流异常");
        } else if (e instanceof SystemBlockException) {
            info.put("code", "-4");
            info.put("msg", "系统负载异常");
        } else if (e instanceof AuthorityException) {
            info.put("code", -5);
            info.put("msg", "授权异常");
        }
        //设置返回状态码
        httpServletResponse.setStatus(200);
        //设置返回的数据类型
        httpServletResponse.setHeader("content-type", "application/json;charset=UTF-8");
        //设置返回参数
        httpServletResponse.getWriter().write(JSON.toJSONString(info));
    }
}
