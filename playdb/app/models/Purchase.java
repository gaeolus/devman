package models;

import javax.persistence.*;
import java.util.*;

import com.avaje.ebean.annotation.CreatedTimestamp;
import play.data.format.Formats;
import play.data.validation.*;

import com.avaje.ebean.*;


/**
 * Created by Z on 15/12/20.
 */

@Entity
@Table(name="purchase")
public class Purchase extends Model {

    @Id
    public Long id;

    // CascadeType.REFRESH，级联刷新。orderItems更改的时候，就重新加载orderItems
    // CascadeType.PERSIST, 级联保存。insert order insert into orderitem 。调用manager.persist(new Order())的时候才会起作用
    // CascadeType.MERGE,级联更新 。order在游离状态的时候被修改了，order中的orderItem也被修改了，update order for (update orderItem)。 调用manager.merge(order) 的时候才会起作用
    // CascadeType.REMOVE级联删除。 删除order的时候，orderItems也会被删除，没有住外键约束的时候。调用manager.remove(order)的时候才会起作用。
    // 针对实体管理器的四种方法
    // fetch =FetchType.LAZY默认是延迟加载。××tomany由一方得到多的一方的时候，默认就是延迟加载，××toone的时候，默认就是立即加载
    // 出现mappedBy的类就是关系被维护端。关系由对方里面的order属性维护
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "purchase",cascade=CascadeType.PERSIST)
    public static List<OrderItem> orderItems=new ArrayList<>(0);
    public String department;
    public String employee;
    public Float amount;
    @CreatedTimestamp
    @Formats.DateTime(pattern="yy-MM-dd HH:mm")
    public Date created;
    public String status;


    // 建立两者之间的关系
    public static void  additem(Purchase t,OrderItem item)
    {
        //item.setOrder(this);
        item.purchase=t;
        orderItems.add(item);

    }

    public static Finder<Long, Purchase> find = new Finder<Long, Purchase>(Long.class, Purchase.class);

    public static PagedList<Purchase> page(int page, int pageSize, String sortBy, String order, String filter) {
        return
                find.where()
                        .ilike("department", "%" + filter + "%")
                        .orderBy(sortBy + " " + order)
                        .findPagedList(page,pageSize);

    }
}
