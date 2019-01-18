package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.FourModuleErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcFourModule;
import cn.com.njdhy.muscle.biceps.properties.AppCommonProperties;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcFourModuleService;
import cn.com.njdhy.muscle.biceps.util.ShiroUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 三大模块控制器
 *
 * @author rain
 * @date 2018/11/17 22:18
 **/
@RestController
@RequestMapping("/srvc/four/module")
@Log4j2
public class FourModuleCtl {

    @Autowired
    private AppCommonProperties appCommonProperties;
    @Autowired
    private SrvcFourModuleService srvcFourModuleService;

    /**
     * 查询三大模块列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 用户列表
     */
    @RequestMapping("/list")
    public Result banner(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageInfo<SrvcFourModule> result=null;
        try {
            params.put("companyId",ShiroUtil.getUserCompanyId());
            Query queryParam = new Query(params);
            result = srvcFourModuleService.queryList(queryParam, pageNumber, pageSize);
            List<SrvcFourModule> list = result.getList();
            for (SrvcFourModule srvcFourModule : list) {
                String imgUrl = appCommonProperties.getImagesPrefix() + srvcFourModule.getImageUrl();
                srvcFourModule.setImageUrl(imgUrl);
            }
            result.setList(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(FourModuleErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_CODE,FourModuleErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_MESSAGE);
        }

        return Result.success(result.getTotal(), result.getList());
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户ID
     * @return 用户实体
     */
    @RequestMapping("/{id}")
    public Result queryById(@PathVariable String id) {
        SrvcFourModule model=null;
        try {
            if (id==null){
                return Result.error(FourModuleErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_CODE,FourModuleErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE);
            }
            model = srvcFourModuleService.queryById(id);
            if (ObjectUtils.isEmpty(model)) {
                model = new SrvcFourModule();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(FourModuleErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_CODE,FourModuleErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_MESSAGE);
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param srvcFourModule 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody SrvcFourModule srvcFourModule) {

        try {
            // 执行入库操作
            srvcFourModule.setCompanyId(ShiroUtil.getUserCompanyId());
            srvcFourModuleService.insert(srvcFourModule);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(FourModuleErrorCode.SRVC_COMPANYDESC_SAVE_APP_ERROR_CODE, FourModuleErrorCode.SRVC_COMPANYDESC_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(FourModuleErrorCode.SRVC_COMPANYDESC_SAVE_ERROR_CODE, FourModuleErrorCode.SRVC_COMPANYDESC_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param srvcFourModule 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SrvcFourModule srvcFourModule) {

        try {
            // 校验参数
            if(null == srvcFourModule){
                return Result.error(FourModuleErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_CODE,FourModuleErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE);
            }
            // 执行修改
            srvcFourModuleService.update(srvcFourModule);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Result.error(FourModuleErrorCode.SRVC_COMPANYDESC_UPDATE_APP_ERROR_CODE, FourModuleErrorCode.SRVC_COMPANYDESC_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(FourModuleErrorCode.SRVC_COMPANYDESC_UPDATE_ERROR_CODE, FourModuleErrorCode.SRVC_COMPANYDESC_UPDATE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 删除多个记录
     *
     * @param ids 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/delete")
    public Result deleteByIds(@RequestBody List<String> ids) {

        try {
            for (String id : ids) {
                if (id == null || id.length() <= 0) {
                    return Result.error(FourModuleErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_CODE, FourModuleErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE);
                }
            }
            srvcFourModuleService.deleteByIds(ids);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }

        return Result.success();
    }
}
