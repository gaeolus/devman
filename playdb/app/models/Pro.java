package models;


import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import play.data.format.*;
import play.data.validation.*;

//import play.db.ebean.*;
import com.avaje.ebean.*;


/**
 * Created by Z on 15/12/20.
 */


public class Pro extends Model {


    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    public String cname;
    public String ename;
    public String manufacturer;
    public String address;

    public String model;

    public String catalog;

    @Column(name="regno")
    public String regno;
    public Date regperiod;
    public String mfno;

    public String type;

    public String xh;
    public String country;
    public String unit;
    public String distribute;
//sale

    //储运条件
    public String ship;

    public float warranty;
    //失效期

    public Boolean measure;
    public float period;

    public String memo;

    @CreatedTimestamp
    public Date created;

    @UpdatedTimestamp
    public Date updated;

    //属性: 植介入 一次性
    @Basic(fetch=FetchType.LAZY)
    public byte[] picture;

    /**
     * Generic query helper for entity Device with id Long
     */
    public static Finder<Long, Pro> find = new Finder<Long, Pro>(Long.class, Pro.class);

    public static PagedList<Pro> page(int page, int pageSize, String sortBy, String order, String filter) {
        return
                find.where()
                        .ilike("name", "%" + filter + "%")
                        .orderBy(sortBy + " " + order)
                        .findPagedList(page,pageSize);

    }

}
