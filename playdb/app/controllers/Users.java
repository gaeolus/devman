package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.BodyParser;
import play.libs.Json;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import views.html.*;

import models.*;

import com.avaje.ebean.*;

import java.util.*;

/**
 * Manage a database of computers
 */
public class Users extends Controller {

    public static Result list() {

        List<User> u=User.find.all();

        //ObjectNode result = Json.newObject();
        //result.put("field","value");
        //return ok(result);

        String s="{\"pager.totalRows\":"+u.size()+",\"sort\":\"Id\",\"rows\":";
        String e=",\"Id\":\"desc\",\"pager.pageno\":1}";
        return ok(  s+Json.toJson(u)+e);
    }
    // Create a new body parser of class Json based on the values sent in the POST

    public static Result save() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Experting Json Data");
        }else {

            User u=Json.fromJson(json,User.class);
            u.save();
           return ok();
        }

    }

    public static Result usertree(Long deptid) {
        List<User> u=User.find.select("id, name,icon").where().eq("Dept",deptid).findList();
       // .select("name, status")
        String s="{\"ParentID\": \""+deptid+"\",\"treeNodes\": ";
        String e=" }";

        return ok( s+Json.toJson(u)+e );

    }
    /*
       {"ParentID": "1","treeNodes": [
       {"ID":1,"Name":"use1-name","Code":"use1","Pwd":"use1-pass","Dept":1,"Gender":0,"Positions":null,"Manager":null,"Mobile":null,"Tel":null,"Email":null,"Birthday":null,"Remark":null,"RoleId":null,"status":null},
       {"ID":6,"Name":"eng-name","Code":"use6","Pwd":"use6-pass","Dept":1,"Gender":0,"Positions":null,"Manager":null,"Mobile":null,"Tel":null,"Email":null,"Birthday":null,"Remark":null,"RoleId":null,"status":null}
       ]
       }

      user?getuserselecttree
      {
           "ParentID": "30019",
               "treeNodes": [
           {
               "id": 20053,
                   "name": "手术室科室主任",
                   "icon": "../libs/icons/user.png"
           },
           {
               "id": 20180,
                   "name": "内部测试",
                   "icon": "../libs/icons/user.png"
           },
           {
               "id": 20181,
                   "name": "手术室护士",
                   "icon": "../libs/icons/user.png"
           },
           {
               "id": 20187,
                   "name": "手术科主任",
                   "icon": "../libs/icons/user.png"
           },
           {
               "id": 20188,
                   "name": "手术室护士长",
                   "icon": "../libs/icons/user.png"
           }
           ]
       }
   */

    public static Result userdep() {

      /*  List<User> u=User.find.all();
        String s="{\"treeNodes\":";
        String e=" }";
        return ok( s+Json.toJson(u)+e );
*/
        String j="{\"treeNodes\":[{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"设备公共库\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30001,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"手术室\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30019,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20053,\"parentId\":30019,\"name\":\"手术室科室主任\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20180,\"parentId\":30019,\"name\":\"内部测试\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20181,\"parentId\":30019,\"name\":\"手术室护士\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20187,\"parentId\":30019,\"name\":\"手术科主任\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20188,\"parentId\":30019,\"name\":\"手术室护士长\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20194,\"parentId\":30019,\"name\":\"yyy\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"设备科\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30089,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20010,\"parentId\":30089,\"name\":\"王阳\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20061,\"parentId\":30089,\"name\":\"张三\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20062,\"parentId\":30089,\"name\":\"王亮\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20118,\"parentId\":30089,\"name\":\"郭瑞\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20119,\"parentId\":30089,\"name\":\"方占杰\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20120,\"parentId\":30089,\"name\":\"王烟潍\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20121,\"parentId\":30089,\"name\":\"苗海阔\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20122,\"parentId\":30089,\"name\":\"孙传亭\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20123,\"parentId\":30089,\"name\":\"周珊珊\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20124,\"parentId\":30089,\"name\":\"冯朝云\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20125,\"parentId\":30089,\"name\":\"黄兆坤\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20126,\"parentId\":30089,\"name\":\"王绪\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20127,\"parentId\":30089,\"name\":\"王晓晨\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20129,\"parentId\":30089,\"name\":\"郭景涛\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20130,\"parentId\":30089,\"name\":\"任晟\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20131,\"parentId\":30089,\"name\":\"吴飞\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20132,\"parentId\":30089,\"name\":\"王明明\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20133,\"parentId\":30089,\"name\":\"时雨欣\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20134,\"parentId\":30089,\"name\":\"沈燕\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20135,\"parentId\":30089,\"name\":\"马伟伟\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20136,\"parentId\":30089,\"name\":\"张艳\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20141,\"parentId\":30089,\"name\":\"淄博工程师\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20143,\"parentId\":30089,\"name\":\"医院测试\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20156,\"parentId\":30089,\"name\":\"董海锋\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20157,\"parentId\":30089,\"name\":\"薛新泽\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20158,\"parentId\":30089,\"name\":\"李英利\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20159,\"parentId\":30089,\"name\":\"张继军\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20160,\"parentId\":30089,\"name\":\"黄杰\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20161,\"parentId\":30089,\"name\":\"王贺\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20164,\"parentId\":30089,\"name\":\"毛工\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20165,\"parentId\":30089,\"name\":\"李义勇\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20168,\"parentId\":30089,\"name\":\"运维工程师\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20169,\"parentId\":30089,\"name\":\"gcs\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20178,\"parentId\":30089,\"name\":\"心电工程师\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20190,\"parentId\":30089,\"name\":\"王艳飞\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20191,\"parentId\":30089,\"name\":\"医院测试01\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20193,\"parentId\":30089,\"name\":\"耿永亮\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"院长室\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30478,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20138,\"parentId\":30478,\"name\":\"淄博院长\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20162,\"parentId\":30478,\"name\":\"张国权\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"CT室\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30480,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20145,\"parentId\":30480,\"name\":\"李瑞\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20149,\"parentId\":30480,\"name\":\"刘超\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"病理科\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30481,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20151,\"parentId\":30481,\"name\":\"李飞\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20153,\"parentId\":30481,\"name\":\"刘霞\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"彩超室\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30482,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20147,\"parentId\":30482,\"name\":\"张主任\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20148,\"parentId\":30482,\"name\":\"李丽\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20192,\"parentId\":30482,\"name\":\"李\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"测听室\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30483,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20150,\"parentId\":30483,\"name\":\"王主任\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20152,\"parentId\":30483,\"name\":\"李红\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20185,\"parentId\":30483,\"name\":\"测听室主任\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20186,\"parentId\":30483,\"name\":\"测听室护士\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"放射科\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30484,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20036,\"parentId\":30484,\"name\":\"系统管理员\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20154,\"parentId\":30484,\"name\":\"孙主任\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20155,\"parentId\":30484,\"name\":\"王一\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"喉科病房\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30485,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"急诊科\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30486,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"康复科\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30487,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"康复科病房\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30488,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"理疗室\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30489,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"内镜室\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30490,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"内科病房\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30491,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"手术麻醉科\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30492,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20040,\"parentId\":30492,\"name\":\"手术麻醉科护士\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20059,\"parentId\":30492,\"name\":\"手术麻醉科科室主任\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"外科病房\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30493,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"胃镜室\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30494,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"心电图室\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30495,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20176,\"parentId\":30495,\"name\":\"心电科室主任\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20177,\"parentId\":30495,\"name\":\"心电护士\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"眼科门诊\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30496,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"检验科\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30502,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20058,\"parentId\":30502,\"name\":\"李霞\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20114,\"parentId\":30502,\"name\":\"琳琳\"},{\"icon\":\"../libs/icons/user.gif\",\"id\":20189,\"parentId\":30502,\"name\":\"检验科护士长\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"新增1\",\"clickExpand\":true,\"parentId\":30019,\"checked\":false,\"drag\":false,\"oldParentId\":30019,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30503,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"新增2\",\"clickExpand\":true,\"parentId\":30503,\"checked\":false,\"drag\":false,\"oldParentId\":30503,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30504,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"新增3\",\"clickExpand\":true,\"parentId\":30019,\"checked\":false,\"drag\":false,\"oldParentId\":30019,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30505,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"新增1\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30506,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"新增1\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30507,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"新增2\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30508,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"新增2\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30509,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"新增1\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30510,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"},{\"drop\":null,\"icon\":\"../libs/icons/user_group.gif\",\"name\":\"新增1\",\"clickExpand\":true,\"parentId\":0,\"checked\":false,\"drag\":false,\"oldParentId\":0,\"iconClose\":\"\",\"open\":true,\"chkDisabled\":false,\"id\":30511,\"click\":\"\",\"existed\":true,\"iconOpen\":\"\"}] }";
        return ok(j);




    }

    public static Result engineer(Long rid) {

        List<User> u=User.find.select("id, name,icon").where().eq("RoleId",rid).findList();
        String s="{\"ParentID\": \"0\",\"treeNodes\": ";
        String e=" }";
        return ok( s+Json.toJson(u)+e );
    }
    /*
    {
    "ParentID": "0",
    "treeNodes": [
    {"ID":6,"Name":"eng-name","Code":"use6","Pwd":"use6-pass","Dept":1,"Gender":0,"Positions":null,"Manager":null,"Mobile":null,"Tel":null,"Email":null,"Birthday":null,"Remark":null,"RoleId":3001,"status":null}
    ] }
*/
    /*
    {
        "ParentID": "0",
            "treeNodes": [
        {
            "id": 20010,
                "name": "王阳",
                "icon": "../libs/icons/user.png"
        },
*/
      public static Result delete(Long id) {
        User.find.ref(id).delete();
        //flash("success", "User has been deleted");
        return  ok();
    }


}