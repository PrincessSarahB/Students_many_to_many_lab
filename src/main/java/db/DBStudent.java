package db;

import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import static db.DBHelper.save;


public class DBStudent {

    private static Session session;

    public static void addLessonToStudent(Lesson lesson, Student student) {
        lesson.addStudents(student);
        student.addLessons(lesson);
        save(lesson);
    }

    public static List<Lesson> getStudentsLessons(Student student){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> lessons = null;
        try {
            Criteria cr = session.createCriteria(Lesson.class);
            cr.createAlias("students", "individual_student");
            cr.add(Restrictions.eq("individual_student.id", student.getId()));
           lessons = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
        } session.close();
        return lessons;
    }

}
