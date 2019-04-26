package lv.initex.database.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

abstract class Repository {

    @Autowired
    private SessionFactory session;

    protected Session session() {
        return session.getCurrentSession();
    }
}
