package Domain;

import Domain.base.BaseEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address_table", schema = "Hibernate_practice_app")
public class Address/*<E extends Address<E>>*/ extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "address_number")
    private int addressNumber;

    @Column(name = "address_state")
    private String addressState;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name = "address_postal_address")
    private String addressPostalAddress;

    @Column(name = "address_postal_code")
    private int addressPostalCode;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "stuendt_address",referencedColumnName = "student_id")
    private Student student;


    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    private Teacher teacher;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Address() {
    }

    public Address(int addressNumber, String addressState, String addressCity, String addressPostalAddress, int addressPostalCode) {
        this.addressNumber = addressNumber;
        this.addressState = addressState;
        this.addressCity = addressCity;
        this.addressPostalAddress = addressPostalAddress;
        this.addressPostalCode = addressPostalCode;
    }

    public Address(int addressNumber, String addressState, String addressCity, String addressPostalAddress, int addressPostalCode, Student student) {
        this.addressNumber = addressNumber;
        this.addressState = addressState;
        this.addressCity = addressCity;
        this.addressPostalAddress = addressPostalAddress;
        this.addressPostalCode = addressPostalCode;
        this.student = student;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressPostalAddress() {
        return addressPostalAddress;
    }

    public void setAddressPostalAddress(String addressPostalAddress) {
        this.addressPostalAddress = addressPostalAddress;
    }

    public int getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(int addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId == address.addressId && addressNumber == address.addressNumber && addressPostalCode == address.addressPostalCode && Objects.equals(addressState, address.addressState) && Objects.equals(addressCity, address.addressCity) && Objects.equals(addressPostalAddress, address.addressPostalAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, addressNumber, addressState, addressCity, addressPostalAddress, addressPostalCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", addressNumber=" + addressNumber +
                ", addressState='" + addressState + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressPostalAddress='" + addressPostalAddress + '\'' +
                ", addressPostalCode=" + addressPostalCode +
                '}';
    }

    @Override
    public Integer getId() {
        return getAddressId();
    }

    @Override
    public void setId(Integer id) {
        this.addressId =id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
