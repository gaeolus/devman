package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

//import play.db.ebean.*;
import com.avaje.ebean.*;

/**
 * Device entity managed by Ebean
 */
@Entity 
public class Equipment extends Model {

    private static final long serialVersionUID = 1L;
  
	@Id
    @GeneratedValue
    public Long id;
    
    @Constraints.Required
    public String EquName;  //name;

    public String cname;
    public String FactoryName;  //manufacturer;
    public Long FactoryID;
    public String regno;
    public String Specification; //设备型号 model;

    public String udi;
 
    public Date Manufacturedate;
       public String SerialNumber;  //sn;设备序列号
        public String OSNumber; //厂家系统编号

           public String IBNumber; //系统编号
    public String EquNo; //hudi;资产编码

    public String record;
    public Long xh;
    public String country;
     
     public Date created;  //rk
    public Date updated;
    public String unit;
    public String bar;  //12

    public String saler;


    //da; //档案号
    //xh; 序号
 
       public String WordName;  //显微外科手术器械
    public Long CategoryID;  //Long catalog;
   
   @Formats.DateTime(pattern="yy-MM-dd")
    public Date warranty;

   public String EquipmentDisuse; //报废年限 10年

    public String IsWarranty; // 是否原厂在保
    public String RepairStatus; //在保|原厂在保|合同在保
  public Long SupplierID;
  public String SupplierName; //维修供应商
     @Formats.DateTime(pattern="yy-MM-dd")
    public Date ServiceBegin; 
       @Formats.DateTime(pattern="yy-MM-dd")
        public Date ServiceEnd;  //warranty;


     public String StatusName;  //status; 设备状态 正常使用

      public String  State;  //维修中

   @Formats.DateTime(pattern="yyyy-MM-dd")
   public Date installdate;
  @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date discontinued;

    public String disno;
      
    //Hospital
      // 
     public Float  BuyMoney;  //price; 
     // Aftertaxprice
     // DepreciationRate 年折旧率
    //  MonthDepreciation
  //  DepreciationPrice //折旧

//SalvageValue 残值

//lastYearC
//NowYearC
//NowMonthC
//TotalMoenyC

//lastYear
//NowYear
//NowMonth
//TotalMoeny


    public String DeptName;  //jcks;
    public Long DepartmentID;
    public String Equput;   //posit

    //关系的维护端都是在多的那一面，多的一面为主控方，拥有指向对方的外键
    //@ManyToOne
    public String DepartPerson;  //Doctor doctor;科室保管负责人
  public String  DepartPersonTel;  //保管负责人电话

public String remark;


    /**
     * Generic query helper for entity Device with id Long
     */
    public static Finder<Long, Equipment> find = new Finder<Long, Equipment>(Long.class, Equipment.class);

 public static PagedList<Equipment> page(int page, int pageSize) {
        return 
            find.where()  
              .findPagedList(page,pageSize);

    }
/*
    public static List<Person> findAll() {
        return find.all();
    }
    
    public static Person findByName (String name) {
        return find.where().eq("name", name).findUnique();
    }
    */

}

