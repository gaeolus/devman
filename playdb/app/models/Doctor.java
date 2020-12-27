package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.*;



/**
 * Company entity managed by Ebean
 */
@Entity 
public class Doctor extends Model {

    private static final long serialVersionUID = 1L;

	@Id
	public Long id;
    
    @Constraints.Required
    public String name;


//@ManyToOne
   // @JoinColumn(name="")
//public Department department;



    public String department;
    
    /**
     * Generic query helper for entity Company with id Long
     */
    public static Model.Finder<Long,Doctor> find = new Model.Finder<Long,Doctor>(Long.class, Doctor.class);

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Doctor c: Doctor.find.orderBy("name").findList()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }

}

