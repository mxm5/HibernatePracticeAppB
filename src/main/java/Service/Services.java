package Service;

import Domain.Student;
import Domain.base.BaseEntity;
import Service.base.Service;
import antlr.ASdebug.IASDebugStream;

import java.io.Serializable;

public class
Services/*<S extends Service<E, ID>, E extends BaseEntity<ID>, ID extends Serializable> */ {

    public static final AddressService address;
    public static final StudentService student;
    public static final TeacherService teacher;



    static {
        address = new AddressService();
        student = new StudentService();
        teacher = new TeacherService();
    }




    public static void finish() {
        AddressService.getAddressRepo().closeEntityManager();
        StudentService.getStudentRepo().closeEntityManager();
        TeacherService.getTeacherRepo().closeEntityManager();
    }

}
