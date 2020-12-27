package models;

import javax.persistence.*;
import java.util.*;
import com.avaje.ebean.*;
import play.data.format.*;
import play.data.validation.*;

/**
 * Created by Z on 15/12/21.
 */
@Entity
public class Department extends Model {

    @Id
    public Long id;
    
    public String name;
   
    public Long ManagerId;
    public String NurseStationTel;

     public Long EngineerId;

    public String icon="/assets/libs/icons/user_group.gif";
    public Long ParentId=0L;

     public Integer Ord;
     public String Remark;
    //dep:
   // @OneToMany(mappedBy="department")
   // @OrderBy("name ASC")
   //private List<Doctor> doctors;
 public static Finder<Long, Department> find = new Finder<Long, Department>(Long.class, Department.class);
}

