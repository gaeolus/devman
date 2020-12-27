package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;

import com.avaje.ebean.*;

import java.util.*;

/**
 * Created by Z on 16/1/7.
 */
public class Repairs extends Controller {
    public static Result list(int page, int pageSize) {

        List<Repair> dev = Repair.find.where()
                //.ilike("name", "%coco%")
                //.orderBy("dueDate asc")
                .findPagedList(0, 50)
                .getList();

        String s="{\"pager.totalRows\":"+dev.size()+",\"sort\":\"id\",\"rows\":";
        String e=",\"id\":\"desc\",\"pager.pageNo\":1}";
/*
 String f="{\"pager.totalRows\":48,\"sort\":\"Id\",\"rows\":[{\"Equput\":\"231124241\",\"FromTime\":\"2015-06-18 14:06\",\"EquipmentGG\":\"设备型号\",\"RepairCode\":\"2016010008\",\"DeptName\":\"设备科\",\"EquName\":\"监护仪\",\"RepairDate\":\"2016-01-07 10:50\",\"EquCode\":\"160106322\",\"Specification\":\"设备型号\",\"RepairStatus\":\"审核通过\",\"HEquName\":\"监护仪\",\"EndTime\":\"2015-06-18 14:06\",\"MaintenDate\":\"\",\"Id\":499,\"RepairPerson\":\"系统管理员\",\"FactoryName\":\"山东济南柯渡\",\"CreateName\":null,\"SupplierName\":\"BBB\",\"ReplyPerson\":\"王阳\"},{\"Equput\":\"目前摆放地点\",\"FromTime\":\"2015-06-18 14:06\",\"EquipmentGG\":\"设备型号\",\"RepairCode\":\"2016010007\",\"DeptName\":\"手术室\",\"EquName\":\"台式低速离心机\",\"RepairDate\":\"2016-01-07 10:32\",\"EquCode\":\"6801-7160107593\",\"Specification\":\"设备型号\",\"RepairStatus\":\"报修中\",\"HEquName\":\"台式低速离心机\",\"EndTime\":\"2015-06-18 14:06\",\"MaintenDate\":\"\",\"Id\":498,\"RepairPerson\":\"系统管理员\",\"FactoryName\":\"金宝\",\"CreateName\":null,\"SupplierName\":\"BBB\",\"ReplyPerson\":null},{\"Equput\":\"血透室\",\"FromTime\":\"\",\"EquipmentGG\":\"4008B\",\"RepairCode\":\"2016010006\",\"DeptName\":\"检验科\",\"EquName\":\"费森透析机\",\"RepairDate\":\"2016-01-05 13:16\",\"EquCode\":\"6845-4151120211\",\"Specification\":\"4008B\",\"RepairStatus\":\"维修完成\",\"HEquName\":\"费森透析机\",\"EndTime\":\"\",\"MaintenDate\":\"\",\"Id\":497,\"RepairPerson\":\"系统管理员\",\"FactoryName\":\"费森1\",\"CreateName\":\"系统管理员\",\"SupplierName\":null,\"ReplyPerson\":\"任现明\"},{\"Equput\":\"仓库一                                            \",\"FromTime\":\"\",\"EquipmentGG\":\"800型\",\"RepairCode\":\"2016010005\",\"DeptName\":\"放射科\",\"EquName\":\"台式低速离心机\",\"RepairDate\":\"2016-01-05 11:35\",\"EquCode\":\"6801-7151125268\",\"Specification\":\"800型\",\"RepairStatus\":\"已验收\",\"HEquName\":\"台式低速离心机\",\"EndTime\":\"\",\"MaintenDate\":\"\",\"Id\":496,\"RepairPerson\":\"手术室护士\",\"FactoryName\":\"山东济南柯渡\",\"CreateName\":\"系统管理员\",\"SupplierName\":\"迪姆软件（北京）有限公司\",\"ReplyPerson\":\"gcs\"},{\"Equput\":\"血透室\",\"FromTime\":\"\",\"EquipmentGG\":\"AK96\",\"RepairCode\":\"2016010004\",\"DeptName\":\"检验科\",\"EquName\":\"金宝透析机\",\"RepairDate\":\"2016-01-04 15:33\",\"EquCode\":\"6845-4151120532\",\"Specification\":\"AK96\",\"RepairStatus\":\"维修完成\",\"HEquName\":\"金宝透析机\",\"EndTime\":\"\",\"MaintenDate\":\"\",\"Id\":495,\"RepairPerson\":\"系统管理员\",\"FactoryName\":\"金宝\",\"CreateName\":null,\"SupplierName\":null,\"ReplyPerson\":\"任现明\"},{\"Equput\":\"设备公用库\",\"FromTime\":\"2015-06-18 14:06\",\"EquipmentGG\":\"Acupulse 40\",\"RepairCode\":\"2016010003\",\"DeptName\":\"心电图室\",\"EquName\":\"二氧化碳激光治疗系统\",\"RepairDate\":\"2016-01-04 15:29\",\"EquCode\":\"2015071435\",\"Specification\":\"Acupulse 40\",\"RepairStatus\":\"维修完成\",\"HEquName\":\"二氧化碳激光治疗系统\",\"EndTime\":\"2015-06-18 14:06\",\"MaintenDate\":\"\",\"Id\":494,\"RepairPerson\":\"系统管理员\",\"FactoryName\":\"以色列Lumenis Ltd\",\"CreateName\":null,\"SupplierName\":\"BBB\",\"ReplyPerson\":\"任现明\"},{\"Equput\":\"cs\",\"FromTime\":\"2014-11-12 16:47\",\"EquipmentGG\":\"fdsf\",\"RepairCode\":\"2016010002\",\"DeptName\":\"手术室\",\"EquName\":\"测试用\",\"RepairDate\":\"2016-01-04 15:23\",\"EquCode\":\"6801-1151201205\",\"Specification\":\"fdsf\",\"RepairStatus\":\"?????????-\",\"HEquName\":\"测试用\",\"EndTime\":\"2016-11-12 16:49\",\"MaintenDate\":\"\",\"Id\":493,\"RepairPerson\":\"系统管理员\",\"FactoryName\":\"意大利布鲁斯\",\"CreateName\":null,\"SupplierName\":\"苏泊尔电器\",\"ReplyPerson\":null},{\"Equput\":\"运动疗法治疗室（PT）\",\"FromTime\":\"\",\"EquipmentGG\":\"WOND2000F0\",\"RepairCode\":\"2016010001\",\"DeptName\":\"康复科\",\"EquName\":\"多功能神经康复诊疗系统\",\"RepairDate\":\"2016-01-04 15:20\",\"EquCode\":\"2015071404\",\"Specification\":\"WOND2000F0\",\"RepairStatus\":\"报修中\",\"HEquName\":\"多功能神经康复诊疗系统\",\"EndTime\":\"\",\"MaintenDate\":\"\",\"Id\":492,\"RepairPerson\":\"系统管理员\",\"FactoryName\":\"广州市三甲医疗信息产业有限公司\",\"CreateName\":null,\"SupplierName\":null,\"ReplyPerson\":null},{\"Equput\":\"0101\",\"FromTime\":\"2014-11-12 16:47\",\"EquipmentGG\":\"01010\",\"RepairCode\":\"2015120039\",\"DeptName\":\"测听室\",\"EquName\":\"测试设备\",\"RepairDate\":\"2015-12-31 09:46\",\"EquCode\":\"6802151230722\",\"Specification\":\"01010\",\"RepairStatus\":\"维修中\",\"HEquName\":\"测试设备\",\"EndTime\":\"2016-11-12 16:49\",\"MaintenDate\":\"\",\"Id\":491,\"RepairPerson\":\"yyy\",\"FactoryName\":\"日式机\",\"CreateName\":\"毛工\",\"SupplierName\":\"苏泊尔电器\",\"ReplyPerson\":\"王阳\"},{\"Equput\":\"设备公用库\",\"FromTime\":\"2015-06-18 14:06\",\"EquipmentGG\":\"Acupulse 40\",\"RepairCode\":\"2015120038\",\"DeptName\":\"心电图室\",\"EquName\":\"二氧化碳激光治疗系统\",\"RepairDate\":\"2015-12-30 15:33\",\"EquCode\":\"2015071435\",\"Specification\":\"Acupulse 40\",\"RepairStatus\":\"报修中\",\"HEquName\":\"二氧化碳激光治疗系统\",\"EndTime\":\"2015-06-18 14:06\",\"MaintenDate\":\"\",\"Id\":490,\"RepairPerson\":\"系统管理员\",\"FactoryName\":\"以色列Lumenis Ltd\",\"CreateName\":null,\"SupplierName\":\"BBB\",\"ReplyPerson\":null},{\"Equput\":\"运动疗法治疗室（PT）\",\"FromTime\":\"\",\"EquipmentGG\":\"WOND2000F0\",\"RepairCode\":\"2015120037\",\"DeptName\":\"康复科\",\"EquName\":\"多功能神经康复诊疗系统\",\"RepairDate\":\"2015-12-30 11:51\",\"EquCode\":\"2015071404\",\"Specification\":\"WOND2000F0\",\"RepairStatus\":\"审核通过\",\"HEquName\":\"多功能神经康复诊疗系统\",\"EndTime\":\"\",\"MaintenDate\":\"\",\"Id\":489,\"RepairPerson\":\"系统管理员\",\"FactoryName\":\"广州市三甲医疗信息产业有限公司\",\"CreateName\":null,\"SupplierName\":null,\"ReplyPerson\":\"王阳\"},{\"Equput\":\"cs\",\"FromTime\":\"2014-11-12 16:47\",\"EquipmentGG\":\"fdsf\",\"RepairCode\":\"2015120036\",\"DeptName\":\"手术室\",\"EquName\":\"测试用\",\"RepairDate\":\"2015-12-28 18:00\",\"EquCode\":\"6801-1151201205\",\"Specification\":\"fdsf\",\"RepairStatus\":\"报修中\",\"HEquName\":\"测试用\",\"EndTime\":\"2016-11-12 16:49\",\"MaintenDate\":\"2015-12-28 00:00\",\"Id\":488,\"RepairPerson\":\"sysadmin\",\"FactoryName\":\"意大利布鲁斯\",\"CreateName\":null,\"SupplierName\":\"苏泊尔电器\",\"ReplyPerson\":null},{\"Equput\":\"血透室\",\"FromTime\":\"\",\"EquipmentGG\":\"AK95S\",\"RepairCode\":\"2015120035\",\"DeptName\":\"检验科\",\"EquName\":\"金宝透析机\",\"RepairDate\":\"2015-12-08 09:42\",\"EquCode\":\"6845-4151120143\",\"Specification\":\"AK95S\",\"RepairStatus\":\"审核通过\",\"HEquName\":\"金宝透析机\",\"EndTime\":\"\",\"MaintenDate\":\"2015-12-31 09:42\",\"Id\":487,\"RepairPerson\":\"耿永亮\",\"FactoryName\":\"金宝\",\"CreateName\":\"系统管理员\",\"SupplierName\":null,\"ReplyPerson\":\"娄检华\"},{\"Equput\":\"设备公用库\",\"FromTime\":\"\",\"EquipmentGG\":\"YKX.2-1600柜式\",\"RepairCode\":\"2015120034\",\"DeptName\":\"手术室\",\"EquName\":\"医用空气净化消毒器\",\"RepairDate\":\"2015-12-22 15:54\",\"EquCode\":\"2015071436\",\"Specification\":\"YKX.2-1600柜式\",\"RepairStatus\":\"报修中\",\"HEquName\":\"医用空气净化消毒器\",\"EndTime\":\"\",\"MaintenDate\":\"2015-12-22 15:54\",\"Id\":486,\"RepairPerson\":\"李\",\"FactoryName\":\"山东新华医疗器械股份有限公司\",\"CreateName\":\"系统管理员\",\"SupplierName\":null,\"ReplyPerson\":null},{\"Equput\":\"血透室\",\"FromTime\":\"\",\"EquipmentGG\":\"AK200US\",\"RepairCode\":\"2015120033\",\"DeptName\":\"检验科\",\"EquName\":\"金宝血滤机\",\"RepairDate\":\"2015-12-22 15:47\",\"EquCode\":\"6840-1151120382\",\"Specification\":\"AK200US\",\"RepairStatus\":\"维修中\",\"HEquName\":\"金宝血滤机\",\"EndTime\":\"\",\"MaintenDate\":\"\",\"Id\":485,\"RepairPerson\":\"王艳飞\",\"FactoryName\":\"金宝\",\"CreateName\":\"王烟潍\",\"SupplierName\":null,\"ReplyPerson\":\"王烟潍\"},{\"Equput\":\"血透室\",\"FromTime\":\"\",\"EquipmentGG\":\"AK95S\",\"RepairCode\":\"2015120032\",\"DeptName\":\"检验科\",\"EquName\":\"金宝透析机\",\"RepairDate\":\"2015-12-22 15:26\",\"EquCode\":\"6840-1151120118\",\"Specification\":\"AK95S\",\"RepairStatus\":\"审核通过\",\"HEquName\":\"金宝透析机\",\"EndTime\":\"\",\"MaintenDate\":\"2015-12-22 17:30\",\"Id\":484,\"RepairPerson\":\"耿永亮\",\"FactoryName\":\"金宝\",\"CreateName\":\"王烟潍\",\"SupplierName\":null,\"ReplyPerson\":\"王烟潍\"},{\"Equput\":\"设备间\",\"FromTime\":\"\",\"EquipmentGG\":\"4mm0°\",\"RepairCode\":\"2015120031\",\"DeptName\":\"手术麻醉科\",\"EquName\":\"鼻窦镜\",\"RepairDate\":\"2015-12-22 15:11\",\"EquCode\":\"2015071452\",\"Specification\":\"4mm0°\",\"RepairStatus\":\"审核通过\",\"HEquName\":\"鼻窦镜\",\"EndTime\":\"\",\"MaintenDate\":\"2015-12-22 17:11\",\"Id\":483,\"RepairPerson\":\"Lin \",\"FactoryName\":\"美国史赛克\",\"CreateName\":\"系统管理员\",\"SupplierName\":null,\"ReplyPerson\":\"娄检华\"},{\"Equput\":\"血透室\",\"FromTime\":\"\",\"EquipmentGG\":\"AK96\",\"RepairCode\":\"2015120030\",\"DeptName\":\"检验科\",\"EquName\":\"金宝透析机\",\"RepairDate\":\"2015-12-22 15:10\",\"EquCode\":\"6845-4151120396\",\"Specification\":\"AK96\",\"RepairStatus\":\"审核通过\",\"HEquName\":\"金宝透析机\",\"EndTime\":\"\",\"MaintenDate\":\"\",\"Id\":482,\"RepairPerson\":\"李\",\"FactoryName\":\"金宝\",\"CreateName\":\"王烟潍\",\"SupplierName\":null,\"ReplyPerson\":\"王烟潍\"},{\"Equput\":null,\"FromTime\":\"\",\"EquipmentGG\":\"sc2000\",\"RepairCode\":\"2015120029\",\"DeptName\":null,\"EquName\":\"测试设备1\",\"RepairDate\":\"2015-12-22 14:05\",\"EquCode\":\"6801-2151222367\",\"Specification\":null,\"RepairStatus\":\"审核通过\",\"HEquName\":null,\"EndTime\":\"\",\"MaintenDate\":\"2015-12-22 00:00\",\"Id\":480,\"RepairPerson\":\"sysadmin\",\"FactoryName\":null,\"CreateName\":null,\"SupplierName\":null,\"ReplyPerson\":\"王烟潍\"},{\"Equput\":\"设备间\",\"FromTime\":\"\",\"EquipmentGG\":\"RF8000E\",\"RepairCode\":\"2015120028\",\"DeptName\":\"手术麻醉科\",\"EquName\":\"低温等离子手术系统\",\"RepairDate\":\"2015-12-22 10:57\",\"EquCode\":\"2015071460\",\"Specification\":\"RF8000E\",\"RepairStatus\":\"维修中\",\"HEquName\":\"低温等离子手术系统\",\"EndTime\":\"\",\"MaintenDate\":\"2015-12-22 10:58\",\"Id\":479,\"RepairPerson\":\"里\",\"FactoryName\":\"美国杰西\",\"CreateName\":\"系统管理员\",\"SupplierName\":null,\"ReplyPerson\":\"王烟潍\"}],\"Id\":\"desc\",\"pager.pageNo\":1}";
        return ok(  f );
*/
        return ok(  s+Json.toJson(dev)+e );
    }

   public static Result LookInfo(Long id) {

    
        return ok(  LookInfo.render()
        );
    }

public static Result create() {

    
        return ok(  ApplyInfo.render()
        );
    }

    public static Result edit(Long id) {


        return ok(  ApplyInfoEdit.render()
        );
    }

    public static Result save() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Experting Json Data");
        }else {

            Repair r=Json.fromJson(json,Repair.class);
            r.save();
            return ok("ok");
        }


    }

}
