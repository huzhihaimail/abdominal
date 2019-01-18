package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.BannerErrorCode;
import cn.com.njdhy.muscle.biceps.exception.srvc.CoreErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCoreServe;
import cn.com.njdhy.muscle.biceps.properties.AppCommonProperties;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcCoreServeService;
import cn.com.njdhy.muscle.biceps.util.ShiroUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author rain
 * @description 家装服务核心优势模块控制层
 * @date 2019/1/16 10:44
 */
@RestController
@RequestMapping("/srvc/core")
public class CoreServeCtl {

    @Autowired
    private AppCommonProperties appCommonProperties;
    @Autowired
    private SrvcCoreServeService srvcCoreServeService;

    /**
     * 查询banner图列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 用户列表
     */
    @RequestMapping("/list")
    public Result coreServe(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageInfo<SrvcCoreServe> result=null;
        try {
            Query queryParam = new Query(params);

            queryParam.put("companyId",ShiroUtil.getUserCompanyId());
            result = srvcCoreServeService.queryList(queryParam, pageNumber, pageSize);
            List<SrvcCoreServe> list = result.getList();
            for (SrvcCoreServe srvcCoreServe : list) {
                String imagePath = appCommonProperties.getImagesPrefix()+ srvcCoreServe.getImages();
                srvcCoreServe.setImages(imagePath);
            }
            result.setList(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CoreErrorCode.SRVC_CORE_SERVE_SELECT_ERROR_CODE,CoreErrorCode.SRVC_CORE_SERVE_SELECT_ERROR_MESSAGE);
        }

        return Result.success(result.getTotal(), result.getList());
    }

    /**
     * 根据id查询信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public Result queryById(@PathVariable String id) {
        SrvcCoreServe model=null;
        try {
            //  参数校验
            if (id == null || id.length() <= 0) {
                return Result.error(CoreErrorCode.SRVC_CORE_SERVE_PARAMS_ERROR_CODE, CoreErrorCode.SRVC_CORE_SERVE_PARAMS_ERROR_MESSAGE);
            }
            model = srvcCoreServeService.queryById(id);
            if (ObjectUtils.isEmpty(model)) {
                model = new SrvcCoreServe();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CoreErrorCode.SRVC_CORE_SERVE_SELECT_ERROR_CODE,CoreErrorCode.SRVC_CORE_SERVE_SELECT_ERROR_MESSAGE);
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param srvcCoreServe 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody SrvcCoreServe srvcCoreServe) {

        try {
            // 校验参数

            // 执行入库操作
            srvcCoreServe.setCompanyId(ShiroUtil.getUserCompanyId());
            srvcCoreServeService.insert(srvcCoreServe);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(CoreErrorCode.SRVC_CORE_SERVE_SAVE_APP_ERROR_CODE, BannerErrorCode.SRVC_BANNER_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CoreErrorCode.SRVC_CORE_SERVE_SAVE_ERROR_CODE, BannerErrorCode.SRVC_BANNER_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param srvcCoreServe 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SrvcCoreServe srvcCoreServe) {

        try {
            // 校验参数

            // 执行修改
            srvcCoreServeService.update(srvcCoreServe);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Result.error(CoreErrorCode.SRVC_CORE_SERVE_UPDATE_APP_ERROR_CODE, CoreErrorCode.SRVC_CORE_SERVE_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CoreErrorCode.SRVC_CORE_SERVE_UPDATE_ERROR_CODE, CoreErrorCode.SRVC_CORE_SERVE_UPDATE_ERROR_MESSAGE);
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
            // 校验参数
            for (String id : ids) {
                if (id == null || id.length() <= 0) {
                    return Result.error(CoreErrorCode.SRVC_CORE_SERVE_PARAMS_ERROR_CODE, CoreErrorCode.SRVC_CORE_SERVE_PARAMS_ERROR_MESSAGE);
                }
            }
            srvcCoreServeService.deleteByIds(ids);
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
