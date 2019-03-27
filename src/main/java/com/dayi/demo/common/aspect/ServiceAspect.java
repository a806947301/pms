package com.dayi.demo.common.aspect;

import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.util.IdUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Service切面
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-18
 */
@Component
@Aspect
public class ServiceAspect {

    /**
     * 添加切入点，所有Service上的add*(BaseEntity...)方法切入点
     */
    @Pointcut("execution(* com.dayi.demo.*.service.impl.*Impl.add*(com.dayi.demo.common.entity.BaseEntity+,..))")
    public void addPointCut() { }

    /**
     * 更新切入点，所有Service上的update*(BaseEntity...)方法切入点
     */
    @Pointcut("execution(* com.dayi.demo.*.service.impl.*Impl.update*(com.dayi.demo.common.entity.BaseEntity+,..))")
    public void updatePointCut() { }

    /**
     * 在添加切入点前增强：给entity添加id、addTime、updateTime
     *
     * @param point
     */
    @Before("addPointCut()")
    public void beforeAdd(JoinPoint point) {
        //给entity添加Id、addTime、updateTime
        BaseEntity entity = (BaseEntity) point.getArgs()[0];
        entity.setId(IdUtil.getPrimaryKey());
        entity.setAddTime(new Date());
        entity.setUpdateTime(new Date());
    }

    /**
     * 在更新切入点前增强：给entity增加updateTime
     *
     * @param point
     */
    @Before("updatePointCut()")
    public void beforeUpdate(JoinPoint point) {
        //给entity添加updateTime
        BaseEntity entity = (BaseEntity) point.getArgs()[0];
        entity.setUpdateTime(new Date());
    }


}
