package cn.com.mfish.common.oauth.api.remote;

import cn.com.mfish.common.core.constants.ServiceConstants;
import cn.com.mfish.common.core.web.Result;
import cn.com.mfish.common.oauth.api.entity.SsoOrg;
import cn.com.mfish.common.oauth.api.fallback.RemoteOrgFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description: 组织远程接口
 * @author: mfish
 * @date: 2023/5/22 11:28
 */
@FeignClient(contextId = "remoteOrgService", value = ServiceConstants.OAUTH_SERVICE, fallbackFactory = RemoteOrgFallback.class)
public interface RemoteOrgService {

    @GetMapping("/org/{ids}")
    Result<List<SsoOrg>> queryById(@PathVariable("ids") String ids);

    @GetMapping("/org/fixCode")
    Result<List<SsoOrg>> queryByFixCode(@RequestParam("code") String code, @RequestParam("direction") String direction);
}
