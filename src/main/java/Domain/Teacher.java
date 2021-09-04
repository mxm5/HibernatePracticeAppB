package Domain;

import Domain.base.BaseEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teacher_table", schema = "Hibernate_practice_app")
public class Teacher extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "teacher_first_name")
    private String teacherFirstName;
    @Column(name = "teacher_last_name")
    private String teacherLastName;
    @Column(name = "teacher_code")
    private int teacherCode;
    @Column(name = "teacher_salary")
    private double teacherSalary;
    @Column(name = "teacher_birthday")
    private Date teacherBirthday;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id"/*,referencedColumnName = "address_id"*/)
    private Address address;


    @ManyToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "teacher_id",referencedColumnName = "student_id")
    @JoinTable(joinColumns = @JoinColumn(name = "fk_teacher_id"), inverseJoinColumns = @JoinColumn(name = "fk_student_id"))
    private Collection<Student> students = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String teacherFirstName, String teacherLastName, int teacherCode, double teacherSalary, Date teacherBirthday) {
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.teacherCode = teacherCode;
        this.teacherSalary = teacherSalary;
        this.teacherBirthday = teacherBirthday;
    }

    public Teacher(String teacherFirstName, String teacherLastName, int teacherCode, double teacherSalary, Date teacherBirthday, Address address) {
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.teacherCode = teacherCode;
        this.teacherSalary = teacherSalary;
        this.teacherBirthday = teacherBirthday;
        this.address = address;
    }

    public Teacher(String teacherFirstName, String teacherLastName, int teacherCode, double teacherSalary, Date teacherBirthday, Address address, Collection<Student> students) {
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.teacherCode = teacherCode;
        this.teacherSalary = teacherSalary;
        this.teacherBirthday = teacherBirthday;
        this.address = address;
        this.students = students;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
//        this.students = students;
        this.students.addAll(students);
    }


    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public int getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(int teacherCode) {
        this.teacherCode = teacherCode;
    }

    public double getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(double teacherSalary) {
        this.teacherSalary = teacherSalary;
    }

    public Date getTeacherBirthday() {
        return teacherBirthday;
    }

    public void setTeacherBirthday(Date teacherBirthday) {
        this.teacherBirthday = teacherBirthday;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher that = (Teacher) o;
        return teacherId == that.teacherId && teacherCode == that.teacherCode && Double.compare(that.teacherSalary, teacherSalary) == 0 && Objects.equals(teacherFirstName, that.teacherFirstName) && Objects.equals(teacherLastName, that.teacherLastName) && Objects.equals(teacherBirthday, that.teacherBirthday) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, teacherFirstName, teacherLastName, teacherCode, teacherSalary, teacherBirthday, address);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherFirstName='" + teacherFirstName + '\'' +
                ", teacherLastName='" + teacherLastName + '\'' +
                ", teacherCode=" + teacherCode +
                ", teacherSalary=" + teacherSalary +
                ", teacherBirthday=" + teacherBirthday +
                ", address=" + address +
                '}';
    }

    @Override
    public Integer getId() {
        if (this.teacherId == null)
            return null;
        else
            return this.teacherId;
    }

    @Override
    public void setId(Integer id) {
        this.teacherId = id;
    }
}
