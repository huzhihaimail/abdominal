package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 十大模块实体类
 * @author rain
 * @date 2018/11/17 18:44
 **/
@Getter
@Setter
public class SrvcModule extends BaseModel{

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 内容
     */
    private String content;
    /**
     * 模块logo
     */
    private String imageUrl;
    /**
     *
     */
    private Integer companyId;
}
