package Service.base;

import Domain.Student;
import Domain.base.BaseEntity;

import java.io.Serializable;

public abstract class Service<E extends BaseEntity<ID>,ID extends Serializable> implements ServiceApi<E,ID>{


}
