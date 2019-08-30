package com.stackroute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PointDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Points> getPoint(){

        String hql = new String("from Points");
        Query query = sessionFactory.openSession().createQuery(hql);
        return ((List<Points>) query.list());
    }

    public void insertPoints(Points point){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(point);
        session.getTransaction().commit();
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}