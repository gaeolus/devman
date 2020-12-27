package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
//import play.data.validation.*;

//import play.db.ebean.*;
import com.avaje.ebean.*;

/**
 * Created by Z on 15/11/16.
 */

/**
 * Checklist entity managed by Ebean
 
 import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

  @CreatedTimestamp
  Timestamp whenCreated;

  @UpdatedTimestamp
  Timestamp whenUpdated
 */

// public enum UserStatus {
//     ACTIVE, INACTIVE
// }   0        1

@Entity
//@Table(name="eg_customer")
public class Checklist extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    public Long id;

    public int yjxh;

    public String tjhm;

    public String brxz; //pat type

     //public UserStatus brxz;
    //UserStatus.ACTIVE.name()  UserStatus.ACTIVE.ordinal()

    public String mzhm;

    public String zyhm;

    public String brxm;  //pat name

    public int brid;

    @Formats.DateTime(pattern="yyyy-MM-dd HH:mm")
    public Date kdrq;

//    @ManyToOne
//    public Doctor kdys;
    public String kdys;  //doc_name

    public String ksmc;  //doctor_dep

    @Formats.DateTime(pattern="yyyy-MM-dd HH:mm")
    public Date jcrq;

    public String jcks;  //doctor_dep

    public int zxpb; //check or no

    @Formats.DateTime(pattern="yyyy-MM-dd HH:mm")
    public Date zxrq;

    public String zxysxm;  //doctor_name

    @ManyToOne
    public Doctor doctor;
//    public String zxys;  //doctor_id

    public int sybz;  //1 mz 2 zy

    public String fymc;

    public int fyxh;

    //@ManyToOne
    //@JoinColumn(name="xx_id")
    //public Device device;
    //关系的维护端都是在多的那一面，多的一面为主控方，拥有指向对方的外键
    public Long dev; //int sbxh;

    public String sbmc;

    //@OneToMany(cascade=CascadeType.PERSIST)
    //@JoinColumn(name="checklist_id") //注释的是另一个表fee指向本表ck的外键。
    //public List<Fee> fee;
   

    /**
     * Generic query helper for entity Checklist with id Long
     */
    public static Finder<Long, Checklist> cfind = new Finder<Long, Checklist>(Long.class, Checklist.class);

    /**
     * Return a page of computer
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Device property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    //public static Page<Checklist> page(int page, int pageSize, String sortBy, String order, String filter) {
    public static PagedList<Checklist> page(int page, int pageSize, String sortBy, String order, String filter,String zxrq) {
            return
                cfind.where()
                        .ilike("sbmc", "%" + filter + "%")
                        .ge("jcrq",zxrq)
                        .orderBy(sortBy + " " + order)
                        .fetch("doctor")

                        //.setFetchAhead(false)
                        //.findPagingList(pageSize)
                        //.getPage(page);
                        .findPagedList(page,pageSize);
    }


    


}
