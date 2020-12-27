package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

//import play.db.ebean.*;
import com.avaje.ebean.*;

/**
 * Created by Z on 16/1/7.
 */
@Entity
public class Repair extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    public Long id;

    public Long DepartmentID;
    public String EquCode;  //系统编号
    public String EquName;
    public String EquipmentGG;  //设备型号
//    public Long FactoryID;
    public String FaultDescription;
    public Date RepairDate;  //报修日期
    public String RepairPerson;  //报修人
    public String RepairTel;
    public Date MaintenDate;  //维修期限
    public String RepairStatus; //故障描述
    public String Remark;
    public String CreateName;



    public static Finder<Long, Repair> find = new Finder<Long, Repair>(Long.class, Repair.class);

}
