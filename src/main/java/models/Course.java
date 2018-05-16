package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {
    private int id;
    private String title;
    private LevelType level;
    private Set<Lesson> lessons;
    private Set<Student> students;

    public Course() {
    }

    public Course(String title, LevelType level) {
        this.title = title;
        this.level = level;
        this.students = new HashSet<Student>();
        this.lessons = new HashSet<Lesson>();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="level")
    public LevelType getLevel() {
        return level;
    }

    public void setLevel(LevelType level) {
        this.level = level;
    }

    @OneToMany(mappedBy = "course")
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    @OneToMany(mappedBy = "course")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
    }
}
