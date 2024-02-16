package ru.specialist.spring.lab06.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("courseDao")
public class HibernateCourseDAO implements CourseDAO {
    private static final Log LOG = LogFactory.getLog(HibernateCourseDAO.class);

    private SessionFactory sessionFactory;

    public HibernateCourseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return (Course) sessionFactory.getCurrentSession().byId(Course.class).load(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Course c").list(); // HQL
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findByTitle(String title) {
        return sessionFactory.getCurrentSession().createQuery("from Course x where x.title like :search").setParameter("search", "%" + title.trim() + "%").list(); // HQL
    }

    @Override
    public void insert(Course course) {
        sessionFactory.getCurrentSession().save(course);
        LOG.info("Course saved with id: " + course.getId());
    }

    @Override
    public void update(Course course) {
        sessionFactory.getCurrentSession().update(course);
        LOG.info("Course updated with id: " + course.getId());
    }

    @Override
    public void delete(int id) {
        Course c = new Course();
        c.setId(id);
        sessionFactory.getCurrentSession().delete(c);
        LOG.info("Course deleted with id: " + c.getId());
    }

}
