package com.manage.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Community;
import com.manage.home.entities.CommunityPost;
import com.manage.student.entities.Student;

@Repository
@Qualifier("studentCommunityDAOImpl")
@Transactional("studentTransactionManager")
public class StudentCommunityDAOImpl implements StudentCommunityDAO {

    private SessionFactory sessionFactory;
    
    @Autowired
    public StudentCommunityDAOImpl(@Qualifier("studentSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public List<Community> getAllCommunitiesByStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT c FROM Community c JOIN c.members m WHERE m = :student", Community.class)
                .setParameter("student", student).list();
    }

    @Override
    public Community getCommunityById(Long communityId) {
        return sessionFactory.getCurrentSession().get(Community.class, communityId);
    }

    @Override
    public List<CommunityPost> getPostsByCommunity(Community community) {
        return sessionFactory.getCurrentSession().createQuery("FROM CommunityPost WHERE community = :community ORDER BY timestamp DESC", CommunityPost.class)
                .setParameter("community", community).list();
    }

    @Override
    public void createPost(CommunityPost post) {
        sessionFactory.getCurrentSession().save(post);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return sessionFactory.getCurrentSession().get(Student.class, studentId);
    }
}
