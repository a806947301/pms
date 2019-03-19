package com.dayi.demo.common.aspect;

import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.util.IdUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Service切面
 *
 * @author WuTong<wut       @       pvc123.com>
 * @date 2019-03-18
 */
@Component
@Aspect
public class ServiceAspect {

    /**
     * 在Service add前
     *
     * @param point
     */
    @Before("execution(* com.dayi.demo.*.service.impl.*Impl.add(..))")
    public void beforeAdd(JoinPoint point) {
        //给entity添加Id、addTime、updateTime
        BaseEntity entity = (BaseEntity) point.getArgs()[0];
        entity.setId(IdUtil.getPrimaryKey());
        entity.setAddTime(new Date());
        entity.setUpdateTime(new Date());
    }
}
