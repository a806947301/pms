package com.dayi.demo.common.exception.handler;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.util.JsonUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * 全局异常处理器
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-14
 */
@ControllerAdvice
public class GlobalExceptionResolver{

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    /**
     * 没有权限异常信息
     *
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public JSONObject haveNotPremission(Exception e) {
        return JsonUtil.packageJson(false, "", "你没有权限");
    }

    /**
     * 数据库异常
     *
     * @return
     */
    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    public JSONObject sqlException(Exception e) {
        logger.error(GlobalExceptionResolver.class.toString() + "_" + e.getMessage(), e);
        return JsonUtil.packageJson(false, "", "数据库出现异常");
    }

    /**
     * 文件上传异常
     *
     * @return
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    public JSONObject maxUploadException() {
        return JsonUtil.packageJson(false, "", "文件过大");
    }

    /**
     * 其他异常
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JSONObject otherException(Exception e) {
        logger.error(GlobalExceptionResolver.class.toString() + "_" + e.getMessage(), e);
        return JsonUtil.packageJson(false, "", "其他异常");
    }
}
