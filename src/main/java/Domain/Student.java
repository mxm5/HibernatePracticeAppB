package Domain;

import Domain.base.BaseEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "student_table", schema = "Hibernate_practice_app")
public class Student extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "student_first_name")
    private String studentFirstName;
    @Column(name = "student_last_name")
    private String studentLastName;
    @Column(name = "student_code")
    private int studentCode;
    @Column(name = "student_birthday")
    private Date studentBirthday;


    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL,
    targetEntity = Teacher.class)
    private Collection<Teacher> teachers = new ArrayList<>();


    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private Collection<Address> addresses = new ArrayList<>();

    public Student() {
    }

    public Student(String studentFirstName, String studentLastName, int studentCode, Date studentBirthday) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentCode = studentCode;
        this.studentBirthday = studentBirthday;
    }

    public Student(String studentFirstName, String studentLastName, int studentCode, Date studentBirthday, Collection<Teacher> teachers) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentCode = studentCode;
        this.studentBirthday = studentBirthday;
        this.teachers = teachers;
    }


    public Student(String studentFirstName, String studentLastName, int studentCode, Date studentBirthday, Collection<Teacher> teachers, Collection<Address> addresses) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentCode = studentCode;
        this.studentBirthday = studentBirthday;
        this.teachers = teachers;
        this.addresses = addresses;
    }


    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public Date getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public Collection<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Collection<Teacher> teachers) {
        this.teachers.addAll(teachers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return studentId == that.studentId && studentCode == that.studentCode && Objects.equals(studentFirstName, that.studentFirstName) && Objects.equals(studentLastName, that.studentLastName) && Objects.equals(studentBirthday, that.studentBirthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentFirstName, studentLastName, studentCode, studentBirthday);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentFirstName='" + studentFirstName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", studentCode=" + studentCode +
                ", studentBirthday=" + studentBirthday +
                ", teachers=" + teachers +
                '}';
    }

    @Override
    public Integer getId() {
        return getStudentId();
    }

    @Override
    public void setId(Integer id) {
        this.studentId =id;
    }
}
