package controllers;

import play.libs.Json;
import play.mvc.*;

import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.FilePart;
import java.io.File;
import  play.Play;

import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;

import com.avaje.ebean.*;

import java.util.*;


/**
 * Manage a database of computers
 */
public class Equipments extends Controller {
    
 public static Result list(int page, int pageSize) {

//     PagedList<Equipment> dev=Equipment.page(page, pageSize);  //Equipment.find.all();
//     String s="{\"pager.totalRows\":"+dev.getTotalRowCount()+",\"sort\":\"id\",\"rows\":";

     List<Equipment> dev = Equipment.find.where()
             //.ilike("name", "%coco%")
             //eq("",xx).findUnique()
             //.orderBy("dueDate asc")
             .findPagedList(0, 50)
             .getList();
//	findRowCount()
//     limit {max rows} [ offset {first row} ]
     //List<Equipment> dev=Equipment.find.all();
         String s="{\"pager.totalRows\":"+dev.size()+",\"sort\":\"id\",\"rows\":";
         String e=",\"id\":\"desc\",\"pager.pageNo\":1}";
        
        return ok(  s+Json.toJson(dev)+e );
    }

    public static Result Search(int page, int pageSize,Long deptid) {

   //      DynamicForm in   = Form.form().bindFromRequest();
  //  String result    = in.get("content");

        List<Equipment> dev = Equipment.find.where()
                //.ilike("name", "%sname%")
                .eq("DepartmentID",deptid)
           //     .orderBy("dueDate asc")
                .findPagedList(0, 50)
                .getList();

        String s="{\"pager.totalRows\":"+dev.size()+",\"sort\":\"id\",\"rows\":";
        String e=",\"id\":\"desc\",\"pager.pageNo\":1}";

        return ok(  s+Json.toJson(dev)+e );
    }
 

  //jackson默认写出的时间数据为时间戳， 这里修改为相应模式的时间数据输出格式
 // mapper.getSerializationConfig().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


//date to json :1186110000000
/*
    case class User(id: Long, name: String, friends: List[User])

    implicit object UserFormat extends Format[User] {
        def reads(json: JsValue): User = User(
                (json \ "id").as[Long],
                (json \ "name").as[String],
                (json \ "friends").asOpt[List[User]].getOrElse(List()))
        def writes(u: User): JsValue = JsObject(List(
                "id" -> JsNumber(u.id),
                "name" -> JsString(u.name),
                "friends" -> JsArray(u.friends.map(fr => JsObject(List("id" -> JsNumber(fr.id),
                "name" -> JsString(fr.name)))))))
    }

    //then in a controller:
    object MyController extends Controller {
        def displayUserAsJson(id: String) = Action {
            Ok(toJson( User(id.toLong, "myName", friends: List())))
        }
        def saveUser(jsonString: String)= Action {
            val user = play.api.libs.json.parse(jsonString).as[User]
            myDataStore.save(user)
            Ok
        }
    }

    */

    public static Result EquLookInfo(Long id) {
       // Form<Equipment> EquForm = form(Equipment.class).fill(
        //        Equipment.find.byId(id) );
      Equipment Equ=Equipment.find.byId(id);
      
    
        return ok(  EquLookInfo.render(id,Equ)
        );
    }

public static Result create() {

    
        return ok(  equinfo.render("Add",null)
        );
    }

    public static Result edit(Long id) {


        return ok(  equinfo.render("Edit",id)
        );
    }

    public static Result save() {


        return ok(
        );
    }

/*
@helper.form(action = routes.Application.upload, 'enctype -> "multipart/form-data") {
    <input type="file" name="picture">
    <p>
        <input type="submit">
    </p>
}*/
    public static Result upload() {
          MultipartFormData body = request().body().asMultipartFormData();
          FilePart picture = body.getFile("picture");
          if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType(); 
            File file   = picture.getFile();
            // get the root path of the Play project
            File root = Play.application().path();
            // save file to the disk
            file.renameTo(new File(root, "/public/uploads/" + fileName));
            return ok(fileName + " " + contentType + " uploaded");
          } else {
            return badRequest("not a valid file");    
          }
    }

}