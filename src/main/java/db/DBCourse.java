package db;

import models.Course;
import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCourse {

    private static Transaction transaction;
    private static Session session;


    public static void addStudentToCourse(Course course, Student student){
        course.addStudent(student);

    }

    public static void addLessonToCourse(Course course, Lesson lesson){
        course.addLesson(lesson);
    }

    public static List<Student> getStudents(Course course) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> students = null;
        try {
            students = null;
            Criteria cr = session.createCriteria(Student.class);
            cr.add(Restrictions.eq("course", course));
            students = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return students;

    }   public static List<Lesson> getLesson(Course course) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> lessons = null;
        try {
            lessons = null;
            Criteria cr = session.createCriteria(Lesson.class);
            cr.add(Restrictions.eq("course", course));
            lessons = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return lessons;

    }
}
