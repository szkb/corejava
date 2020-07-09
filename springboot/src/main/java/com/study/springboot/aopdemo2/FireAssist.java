package com.study.springboot.aopdemo2;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FireAssist {

    /*记录开火时间*/
    @Before("execution(* *.attack(..))")
    public void ActionLog() throws Throwable {
        System.out.println("开火时间："
                + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                .format(new Date()));
    }

    /*报告已完成开火*/
    @After("execution(* *.attack(..))")
    public void ReportComplete() throws Throwable {
        System.out.println("报告长官：打完收工！");
    }
}
