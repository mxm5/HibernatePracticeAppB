package Domain.base;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity
        <ID extends Serializable> implements Serializable
{

public abstract ID getId();
public abstract void setId(ID id);

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private ID id;
//
//    public ID getId() {
//        return id;
//    }
//
//    public void setId(ID id) {
//        this.id = id;
//    }
}
