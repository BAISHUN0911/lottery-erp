package cn.itedus.lottery.erp.interfaces;

import cn.itedus.lottery.erp.application.IActivityService;
import cn.itedus.lottery.erp.domain.activity.model.ActivityListPageReq;
import cn.itedus.lottery.erp.infrastructure.common.EasyResult;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @description: Controller层，活动配置
 * 注入Service，调用业务层代码，返回结果
 * @author: BAISHUN
 * @date: 2023/5/23
 * @Copyright: 博客：https://www.cnblogs.com/baishun666/
 */
@Controller
@RequestMapping("api/activity")
public class ActivityController {

    private Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @Resource
    private IActivityService activityService;

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("queryActivityListPage")
    @ResponseBody
    public EasyResult queryActivityListPage(String page, String rows) {
        try {
            logger.info("查询活动列表数据 page：{} rows：{}", page, rows);
            rows = null == rows ? "10" : rows;
            ActivityListPageReq req = new ActivityListPageReq(page, rows);
            req.setErpId("xiaofuge");
            return activityService.queryActivityListPage(req);
        } catch (Exception e) {
            logger.error("查询活动列表数据失败 page：{} rows：{}", page, rows, e);
            return EasyResult.buildEasyResultError(e);
        }
    }

}
