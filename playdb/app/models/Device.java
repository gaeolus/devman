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
public class Device extends Model {

    private static final long serialVersionUID = 1L;
    public Product product;

	@Id
    @GeneratedValue
    public Long id;
    
    @Constraints.Required
    public String name;
    public String cname;
    public String manufacturer;

    public String regno;
    public String model;

    public String udi;
    public String hudi;
    public String sn;
    public String status;

    public Float price;

    public Long catalog;

    @Formats.DateTime(pattern="yy-MM-dd")
    public Date warranty;
    //失效期

    public Boolean measure;

    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date introduced;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date discontinued;


    public String jcks;

    //关系的维护端都是在多的那一面，多的一面为主控方，拥有指向对方的外键
    @ManyToOne
    public Doctor doctor;
   
    /**
     * Generic query helper for entity Device with id Long
     */
    public static Finder<Long, Device> find = new Finder<Long, Device>(Long.class, Device.class);



    /**
     * Return a page of computer
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Device property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    public static PagedList<Device> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("name", "%" + filter + "%")
                .orderBy(sortBy + " " + order)
                .fetch("doctor")
                .findPagedList(page,pageSize);

    }
    
}

