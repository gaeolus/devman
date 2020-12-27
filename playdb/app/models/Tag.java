package models;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;

import play.data.validation.*;

import com.avaje.ebean.*;


/**
 * Created by Z on 15/12/20.
 */
@Entity
public class Tag extends Model {
    @Id
    public Long id;
    public String name;
    public List<Product> devices;

}
