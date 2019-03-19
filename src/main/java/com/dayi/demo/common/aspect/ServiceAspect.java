package com.dayi.demo.common.aspect;

import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.util.IdUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-03-18
 */
@Component
@Aspect
public class ServiceAspect {

    @Before("execution(* com.dayi.demo.*.service.impl.*Impl.add(..))")
    public void beforeAdd(JoinPoint point) {
        BaseEntity entity = (BaseEntity) point.getArgs()[0];
        entity.setId(IdUtil.getPrimaryKey());
        entity.setAddTime(new Date());
        entity.setUpdateTime(new Date());
    }
}
