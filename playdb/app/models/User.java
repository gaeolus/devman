package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.*;




@Entity
public class User extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String Name;

    public String Code;
    public String Pwd;

    public Long Dept;
    public Integer Gender;
    public Integer Positions;
    public Long Manager;
    public String Mobile;
    public String Tel;
    public String Email;
    public String Birthday;
    public String Remark;
    public Long RoleId;

    public String status;




//@ManyToOne
    // @JoinColumn(name="")
//public Department department;

    /**
     * Generic query helper for entity Company with id Long
     */
    public static Model.Finder<Long,User> find = new Model.Finder<Long,User>(Long.class, User.class);

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(User c: User.find.orderBy("name").findList()) {
            options.put(c.id.toString(), c.Name);
        }
        return options;
    }

}

