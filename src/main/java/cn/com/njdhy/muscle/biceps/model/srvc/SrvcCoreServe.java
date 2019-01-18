package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author rain
 * @description 家装服务核心优势实体类
 * @date 2019/1/16 9:40
 */
@Getter
@Setter
public class SrvcCoreServe extends BaseModel {

    /**
     * 图片地址
     */
    private String images;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 公司id
     */
    private Integer companyId;
}
