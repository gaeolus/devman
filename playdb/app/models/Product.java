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

@Entity
public class Product extends Model {


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
    @Formats.DateTime(pattern="yy-MM-dd")
    public Date regperiod;
    public String mfno;

    public String type;

    public Long xh;
    public String country;
    public String unit;
    public String distribute;
//sale

    //储运条件
    public String ship;

    @Formats.DateTime(pattern="yy-MM-dd")
    public Date warranty;
    //失效期

    public Boolean measure;
    public Float period;

    public String memo;

    @CreatedTimestamp
    @Formats.DateTime(pattern="yy-MM-dd HH:mm")
    public Date created;

    @UpdatedTimestamp
    @Formats.DateTime(pattern="yy-MM-dd HH:mm")
    public Date updated;

    //属性: 植介入 一次性
@Basic(fetch=FetchType.LAZY)
    public byte[] picture;

    @OneToMany(mappedBy = "product")
    public List<OrderItem> orderItems;

    /**
     * Generic query helper for entity Device with id Long
     */
    public static Finder<Long, Product> find = new Finder<Long, Product>(Long.class, Product.class);

    public static PagedList<Product> page(int page, int pageSize, String sortBy, String order, String filter) {
        return
                find.where()
                        .ilike("name", "%" + filter + "%")
                        .orderBy(sortBy + " " + order)
                        .findPagedList(page,pageSize);

    }

}
