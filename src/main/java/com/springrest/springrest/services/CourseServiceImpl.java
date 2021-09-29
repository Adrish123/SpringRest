package com.springrest.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;


@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	//List<Course> list;

	public CourseServiceImpl() {
		
		/*
		 * list = new ArrayList<>(); list.add(new
		 * Course(145,"Java","Testing is going on")); list.add(new
		 * Course(146,"SQL","Database is on the way"));
		 */}
	
	@Override
	public List<Course> getCourses() {
		
		System.out.println("Finding...");
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseID) {
		
		/*
		 * Course c = null; for (Course course : list) { if (course.getId()== courseID)
		 * { c = course; break; } }
		 */
		
		return courseDao.getOne(courseID);
	}

	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		/*
		 * list.forEach(e ->{ if(e.getId() == course.getId());
		 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription()); }
		 * );
		 */
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		//list=this.list.stream().filter(e->e.getId()!= parseLong).collect(Collectors.toList());
		System.out.println("Deleting...");
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
	
}
