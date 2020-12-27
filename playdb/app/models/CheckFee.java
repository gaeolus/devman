package models;

/**
 * Created by Z on 15/11/28.
 */
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.avaje.ebean.*;
import com.avaje.ebean.annotation.Sql;

/**
 * An example of an Aggregate object.
 *
 * Note the @Sql indicates to Ebean that this bean is not based on a table but
 * instead uses RawSql.
 *
 */
@Entity
@Sql
public class CheckFee {

    @OneToOne
    public Checklist cl;

    //@OneToOne
    //Fee fee;

    public Double totalAmount;
    //public Long deviceId;
    //public Long deviceid;

    public Double totalFee;

    public int mon;
    public int week;

    //public String toString() {
    //    return " totalAmount:" + totalAmount + " totalItems:" + totalItems;
    //}

    public Checklist getChecklist() {
        return cl;
    }

    public void setChecklist(Checklist cl) {
        this.cl = cl;
    }



    /*   create table checklist (
            id                        bigint not null,
            device_id                 bigint not null,
            yjxh                      integer,
            tjhm                      varchar(255),
    brxz                      varchar(255),
    mzhm                      varchar(255),
    zyhm                      varchar(255),
    brxm                      varchar(255),
    brid                      integer,
    kdrq                      timestamp,
    kdys                      varchar(255),
    ksmc                      varchar(255),
    jcrq                      timestamp,
    jcks                      varchar(255),
    zxpb                      integer,
    zxrq                      timestamp,
    zxysxm                    varchar(255),
    doctor_id                 bigint,
    sybz                      integer,
    fymc                      varchar(255),
    fyxh                      integer,
    sbmc                      varchar(255),
    constraint pk_checklist primary key (id))
    ;
*/
    public static PagedList<CheckFee> fee(int page, int pageSize, String sortBy, String order, String filter,String zxrq,Long devid){

        String sql;
        sql
                = " select a.id, a.dev,a.sbmc,a.brxz,a.sybz,a.brxm,a.kdrq,a.kdys,a.ksmc,a.jcrq,a.jcks,a.zxrq,a.zxysxm,a.fymc," +
                "b.hjje as totalAmount" + " from checklist a " + " join fee b on b.sjid=a.yjxh and b.ylxh=a.fyxh ";
        if (devid >0 ) {
            sql
                    = sql+" where a.dev=:devid";
        }
        else {


        }

        RawSql rawSql =
                RawSqlBuilder
                        .parse(sql)

                        .tableAliasMapping("a", "cl")
                        .create();

        Query<CheckFee> query = Ebean.find(CheckFee.class);

        query.setRawSql(rawSql)
                .where() //.gt("order.id", 0)
                .ilike("cl.sbmc", "%" + filter + "%")
                .ge("cl.jcrq", zxrq)
                .orderBy(sortBy + " " + order);


        if (devid >0 ) {
            query.setParameter("devid", devid);
        }
        else {

        }
        return query.findPagedList(page,10);


    }


  

    public static Double tfee(Long devid) {
        String sql
                = " select sum(b.hjje) as totalFee" + " from checklist a "
                + " join fee b on b.sjid = a.yjxh and b.ylxh=a.fyxh " + " where a.dev=:devid";

        SqlRow bug = Ebean.createSqlQuery(sql)
                .setParameter("devid", devid.toString())
                .findUnique();
        return bug.getDouble("totalFee");
    }


       public static List<SqlRow> monthdevfee(Long devid,int week) {
        String sql
                = " select week(a.zxrq) as week,sum(b.hjje) as totalFee" + " from checklist a "
                + " join fee b on b.sjid = a.yjxh and b.ylxh=a.fyxh " + " where a.dev=:devid group by week(a.zxrq)";

        return  Ebean.createSqlQuery(sql)
                .setParameter("devid", devid.toString())
                .findList();
        
    }
}



