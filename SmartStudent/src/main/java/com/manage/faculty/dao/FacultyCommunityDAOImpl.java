package com.manage.faculty.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.entities.Faculty;
import com.manage.home.entities.Community;
import com.manage.home.entities.CommunityPost;
import com.manage.student.entities.Student;

@Repository
@Qualifier("facultyCommunityDAOImpl")
@Transactional("facultyTransactionManager")
public class FacultyCommunityDAOImpl implements FacultyCommunityDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public FacultyCommunityDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createCommunity(Community community) {
		Session session = sessionFactory.getCurrentSession();
		session.save(community);
	}

	@Override
	public List<Community> getAllCommunitiesByFaculty(Faculty faculty) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Community WHERE createdBy = :faculty", Community.class)
				.setParameter("faculty", faculty).list();
	}

	@Override
	public Community getCommunityById(Long communityId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Community.class, communityId);
	}

	@Override
	public void deleteCommunity(Long communityId) {
		Session session = sessionFactory.getCurrentSession();
		Community community = session.get(Community.class, communityId);
		if (community != null) {
			session.delete(community);
		}
	}

	@Override
	public void addStudentToCommunity(Community community, Student student) {
		community.getMembers().add(student);
		sessionFactory.getCurrentSession().update(community);
	}

	@Override
	public void removeStudentFromCommunity(Community community, Student student) {
		community.getMembers().remove(student);
		sessionFactory.getCurrentSession().update(community);
	}

	@Override
	public void createPost(CommunityPost post) {
		Session session = sessionFactory.getCurrentSession();
		session.save(post);
	}

	@Override
	public List<CommunityPost> getPostsByCommunity(Community community) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM CommunityPost WHERE community = :community ORDER BY timestamp DESC",
				CommunityPost.class).setParameter("community", community).list();
	}

	@Override
	public List<Student> getAllStudents() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Student", Student.class).list(); // Fetch all students
	}

	@Override
	public Student getStudentById(Long studentId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Student.class, studentId);
	}

}
