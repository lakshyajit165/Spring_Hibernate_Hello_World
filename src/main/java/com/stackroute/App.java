package com.stackroute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PointDaoImpl pointDaoImpl = (PointDaoImpl)context.getBean("pointDaoImpl", PointDaoImpl.class);
        System.out.println(pointDaoImpl.getPoint());

        Points p = new Points(2,20, 10);
        pointDaoImpl.insertPoints(p);
        System.out.println(pointDaoImpl.getPoint());
    }
}