package com.neitdisc.demo.web;

import com.neitdisc.demo.entity.NetdiscInfo;
import com.neitdisc.demo.entity.pojo.Response;
import com.neitdisc.demo.service.NetdiscInfoService;
import com.neitdisc.demo.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author WHLiang
 * @date 2019/8/21 9:57
 */
@Controller
public class WebSiteControl {

    private NetdiscInfoService netdiscInfoService;

    @Autowired
    public WebSiteControl(NetdiscInfoService netdiscInfoService) {
        this.netdiscInfoService = netdiscInfoService;
    }

    @GetMapping("/list")
    @ResponseBody
    public Response index(@PageableDefault Pageable page, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        packageParam(request, params);
        Page<NetdiscInfo> netdiscInfos = netdiscInfoService.queryPage(page, params);
        return Response.success(netdiscInfos.getContent(), netdiscInfos.getNumber(),
                (int) netdiscInfos.getTotalElements());
    }

    /**
     * 将传过来的所有参数封装为Map
     *
     * @param request request
     * @param params  params
     */
    private void packageParam(HttpServletRequest request, Map<String, Object> params) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            params.put(stringEntry.getKey(), stringEntry.getValue()[0]);
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public Response delete(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        packageParam(request, params);
        Object guid = params.get("GUID");
        if (StringUtils.isEmpty(guid)) {
            return Response.error("请选择需要删除的项!");
        }
        return netdiscInfoService.deleteByIds(Arrays.asList(guid.toString().split(",")));
    }

    @PostMapping("/update")
    @ResponseBody
    public Response update(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        packageParam(request, params);
        Object guid = params.get("GUID");
        if(StringUtils.isEmpty(guid)){
            params.put("GUID", UUID.randomUUID().toString());
        }
        return netdiscInfoService.update(params);
    }


}
