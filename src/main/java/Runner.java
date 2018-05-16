import db.*;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("Drama", LevelType.BA);
        DBHelper.save(course1);
        Course course2 = new Course("Human Biology", LevelType.BSC);
        DBHelper.save(course2);

        Instructor instructor = new Instructor("Lois Griffin");
        DBHelper.save(instructor);

        Lesson lesson1 = new Lesson("Life Drawing", 12, course2, instructor);
        DBHelper.save(lesson1);
        Lesson lesson2 = new Lesson("DNA", 11, course2, instructor);
        DBHelper.save(lesson2);
        Lesson lesson3 = new Lesson("Improv", 14, course1, instructor);

        Student student1 = new Student("Meg Griffin", 19, 123, course1);
        DBHelper.save(student1);
        Student student2 = new Student("Glenn Quagmire", 44, 321, course2);
        DBHelper.save(student2);
        Student student3 = new Student("Cleveland Brown", 44, 234, course1);
        DBHelper.save(student3);

        DBLesson.addStudentToLesson(student1, lesson3);
        DBLesson.addStudentToLesson(student3, lesson3);

        DBStudent.addLessonToStudent(lesson2, student2);
        DBStudent.addLessonToStudent(lesson1, student2);

        List<Student> studentsOnCourse = DBCourse.getStudents(course1);
        List<Lesson> lessonsOnCourse = DBCourse.getLesson(course2);
        List<Student> studentsinLesson = DBLesson.getStudentsinLesson(lesson3);
        List<Lesson> studentsLessons = DBStudent.getStudentsLessons(student2);
        List<Lesson> lessonsInstructorTeaches = DBInstructor.getLesson(instructor);


    }
}
