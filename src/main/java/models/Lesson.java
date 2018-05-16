package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="lessons")
public class Lesson {

    private int id;
    private String title;
    private int roomNumber;
    private Course course;
    private Set<Student> students;
    private Instructor instructor;

    public Lesson() {
    }

    public Lesson(String title, int roomNumber, Course course, Instructor instructor) {
        this.title = title;
        this.roomNumber = roomNumber;
        this.course = course;
        this.instructor = instructor;
        this.students = new HashSet<Student>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "room_number")
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @ManyToOne
    @JoinColumn(name="course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_lesson",
            joinColumns = {@JoinColumn(name = "lesson_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "student_id", nullable = false, updatable = false)}
    )
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudents(Student student){
        this.students.add(student);
    }

    @ManyToOne
    @JoinColumn(name="lesson_id", nullable = false)
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
