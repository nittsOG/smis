package com.manage.home.entities;

import java.util.Set;
import javax.persistence.*;

import com.manage.faculty.entities.Faculty;
import com.manage.student.entities.Student;

@Entity
@Table(name = "community")
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_id")
    private Long communityId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty createdBy; // Faculty who created the community

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "community_members",
            joinColumns = @JoinColumn(name = "community_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> members; // Students part of the community

	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Faculty getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Faculty createdBy) {
		this.createdBy = createdBy;
	}

	public Set<Student> getMembers() {
		return members;
	}

	public void setMembers(Set<Student> members) {
		this.members = members;
	}
    
    
}
