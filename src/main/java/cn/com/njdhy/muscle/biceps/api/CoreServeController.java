package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.srvc.CoreErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCoreServe;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcCoreServeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author rain
 * @description
 * @date 2019/1/16 16:02
 */
@RestController
@RequestMapping("/api")
@Slf4j
@Api(tags = "家装服务核心优势模块接口")
public class CoreServeController {
    @Autowired
    private SrvcCoreServeService srvcCoreServeService;

    /**
     * 查询核心优势模块所有内容
     * @return
     */
    @RequestMapping(value = "/cores/{companyId}",method = RequestMethod.GET)
    @ApiOperation("更加公司id查询核心优势模块所有内容列表")
    public Result coreServeQuery(@PathVariable Integer companyId) {
        List<SrvcCoreServe> list = null;
        try {
            list = srvcCoreServeService.selectByCompanyId(companyId);
        } catch (Exception e) {
            return Result.error(CoreErrorCode.SRVC_CORE_SERVE_SELECT_ERROR_CODE,CoreErrorCode.SRVC_CORE_SERVE_SELECT_ERROR_MESSAGE);
        }

        return Result.success(list);
    }
}
