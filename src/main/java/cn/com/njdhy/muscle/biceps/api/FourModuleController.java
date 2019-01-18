package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.srvc.FourModuleErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.*;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcFourModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台所需接口
 * @author rain
 * @date 2018/11/20 9:19
 **/
@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j
@Api(tags = "四大模块接口")
public class FourModuleController {

    @Autowired
    private SrvcFourModuleService srvcFourModuleService;


    /**
     * 查询三大模块信息列表
     * @return
     */
    @RequestMapping(value = "/companys/{type}",method = RequestMethod.POST)
    @ApiOperation("查询四大模块及图片列表")
    public Result companyDescQuery(@PathVariable Integer type) {
        List<SrvcFourModule> list =null;
        try {
            if(type == null){
                return Result.error(FourModuleErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_CODE,FourModuleErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE);
            }
            list = srvcFourModuleService.queryByType(type);

        }catch (Exception e){
            e.printStackTrace();
            return Result.error(FourModuleErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_CODE, FourModuleErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_MESSAGE);
        }

        return Result.success(list);
    }


}
