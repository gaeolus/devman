package controllers;

import play.libs.Json;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;

import com.avaje.ebean.*;

import java.util.*;

/**
 * Manage a database of computers
 */
public class Devices extends Controller {
    
    /**
     * This result directly redirect to application home.
     */
    public static Result GO_HOME = redirect(
        routes.Devices.list(0, "id", "asc", "")
    );
    


    /**
     * Display the paginated list of computers.
     *
     * @param page Current page number (starts from 0)
     * @param sortBy Column to be sorted
     * @param order Sort order (either asc or desc)
     * @param filter Filter applied on computer names
     */
    public static Result list(int page, String sortBy, String order, String filter) {
        return ok(
            list.render(
                Device.page(page, 10, sortBy, order, filter),
                sortBy, order, filter
            )
        );
    }

    public static Result devlist() {
        return ok(
                devlist.render()
        );
    }

    

    public static Result equlists() {

        List<Device> dev=Device.find.all();
      //  return ok( "{\"Rows\":" + Json.toJson(dev) + ",\"Total\":"+dev.size()+"}"
        return ok(  Json.toJson(dev)
        );
    }

public static Result test() {

    
        return ok(  EquLookInfo.render()
        );
    }

    public static Result WordBook() {
        String j ="{\"treeNodes\":[{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"基础外科手术器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10000,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6801\",\"oldParentId\":10000,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10073,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"医用缝合针(不带线)\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10073,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6801-1\",\"oldParentId\":10073,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10120,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"新增1\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10120,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"\",\"oldParentId\":10120,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10525,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"基础外科用刀\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10073,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6801-2\",\"oldParentId\":10073,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10121,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"基础外科用剪\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10073,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6801-3\",\"oldParentId\":10073,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10122,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"基础外科用钳\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10073,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"\",\"oldParentId\":10073,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10123,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"基础外科用镊夹\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10073,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6801-5\",\"oldParentId\":10073,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10124,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"基础外科用针、钩\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10073,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6801-6\",\"oldParentId\":10073,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10125,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"基础外科其它器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10073,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6801-7\",\"oldParentId\":10073,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10126,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"显微外科手术器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10000,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6802\",\"oldParentId\":10000,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10074,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"显微外科用刀、凿\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10074,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6802-1\",\"oldParentId\":10074,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10127,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"显微外科用剪\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10074,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6802-2\",\"oldParentId\":10074,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10128,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"显微外科用钳\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10074,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6802-3\",\"oldParentId\":10074,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10129,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"显微外科用镊、夹\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10074,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6802-4\",\"oldParentId\":10074,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10130,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"显微外科用针、钩\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10074,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6802-5\",\"oldParentId\":10074,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10131,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"显微外科用其他器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10074,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6802-6\",\"oldParentId\":10074,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10132,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"神经外科手术器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10000,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6803\",\"oldParentId\":10000,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10075,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"神经外科脑内用钩、刮\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10075,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6803-4\",\"oldParentId\":10075,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10136,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"神经外科脑内用其他器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10075,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6803-5\",\"oldParentId\":10075,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10137,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"神经外科脑内用刀\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10075,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6803-1\",\"oldParentId\":10075,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10133,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"神经外科脑内用钳\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10075,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6803-2\",\"oldParentId\":10075,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10134,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"神经外科脑内用镊\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10075,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6803-3\",\"oldParentId\":10075,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10135,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"眼科手术器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10000,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6804\",\"oldParentId\":10000,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10076,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"眼科手术用剪\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10076,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6804-1\",\"oldParentId\":10076,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10138,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"眼科手术用钳\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10076,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6804-2\",\"oldParentId\":10076,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10139,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"眼科手术用镊、夹\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10076,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6804-3\",\"oldParentId\":10076,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10140,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"眼科手术用钩、针\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10076,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6804-4\",\"oldParentId\":10076,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10141,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"眼科手术用其他器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10076,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6804-5\",\"oldParentId\":10076,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10142,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"耳鼻喉科手术器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10000,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6805\",\"oldParentId\":10000,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10077,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"耳鼻喉科用刀、凿\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10077,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6805-1\",\"oldParentId\":10077,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10143,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"耳鼻喉科用剪\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10077,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6805-2\",\"oldParentId\":10077,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10144,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"耳鼻喉科用钳\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10077,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6805-3\",\"oldParentId\":10077,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10145,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"耳鼻喉科用镊、夹\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10077,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6805-4\",\"oldParentId\":10077,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10146,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"耳鼻喉科用钩、针\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10077,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6805-5\",\"oldParentId\":10077,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10147,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"耳鼻喉科用其他器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10077,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6805-6\",\"oldParentId\":10077,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10148,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"口腔科手术器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10000,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6806\",\"oldParentId\":10000,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10078,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"口腔用刀、凿\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10078,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6806-1\",\"oldParentId\":10078,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10149,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"口腔用剪\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10078,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6806-2\",\"oldParentId\":10078,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10150,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"口腔用钳\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10078,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6806-3\",\"oldParentId\":10078,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10151,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"口腔用镊、夹\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10078,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6806-4\",\"oldParentId\":10078,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10152,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"口腔用钩、针\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10078,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6806-5\",\"oldParentId\":10078,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10153,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"口腔用其它器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10078,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6806-6\",\"oldParentId\":10078,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10154,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"胸腔心血管外科手术器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10000,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6807\",\"oldParentId\":10000,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10079,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"胸腔心血管外科用刀\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10079,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6807-1\",\"oldParentId\":10079,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10155,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"胸腔心血管外科用剪\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10079,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6807-2\",\"oldParentId\":10079,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10156,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"胸腔心血管外科用钳\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10079,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6807-3\",\"oldParentId\":10079,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10157,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"胸腔心血管外科用镊、夹\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10079,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6807-4\",\"oldParentId\":10079,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10158,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"胸腔心血管外科用钩、针\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10079,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6807-5\",\"oldParentId\":10079,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10159,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"胸腔心血管外科用其他器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10079,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6807-6\",\"oldParentId\":10079,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10160,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"胸腔心血管外科用吸引器\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10079,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6807-7\",\"oldParentId\":10079,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10161,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"腹部外科手术器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10000,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6808\",\"oldParentId\":10000,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10080,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"腹部外科用剪\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10080,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6808-1\",\"oldParentId\":10080,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10162,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"腹部外科用钳\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10080,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6808-3\",\"oldParentId\":10080,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10163,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"腹部外科用钩、针\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10080,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6808-4\",\"oldParentId\":10080,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10164,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"腹部外科用其他器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10080,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6808-6\",\"oldParentId\":10080,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10165,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"泌尿肛肠外科手术器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10000,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6809\",\"oldParentId\":10000,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10081,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"泌尿肛肠科用剪\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10081,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6809-2\",\"oldParentId\":10081,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10166,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"泌尿肛肠科用钳\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10081,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6809-3\",\"oldParentId\":10081,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10167,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"泌尿肛肠科用钩、针\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10081,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6809-5\",\"oldParentId\":10081,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10168,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"泌尿肛肠科用其他器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10081,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6809-6\",\"oldParentId\":10081,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10169,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"矫形外科（骨科）手术器械\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10000,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6810\",\"oldParentId\":10000,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10082,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"矫形（骨科）外科用刀、锥\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10082,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6810-1\",\"oldParentId\":10082,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10170,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"矫形（骨科）外科用剪\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10082,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6810-2\",\"oldParentId\":10082,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10171,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"矫形（骨科）外科用钳\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10082,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6810-3\",\"oldParentId\":10082,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10172,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"},{\"drop\":false,\"icon\":\"../libs/icons/folder.png\",\"name\":\"矫形（骨科）外科用锯、凿、锉\",\"clickExpand\":false,\"url\":\"\",\"parentId\":10082,\"Ord\":0,\"checked\":false,\"drag\":false,\"Note\":\"6810-4\",\"oldParentId\":10082,\"iconClose\":\"\",\"open\":false,\"target\":\"\",\"chkDisabled\":false,\"id\":10173,\"click\":\"\",\"existed\":true,\"iconOpen\":\"../libs/icons/folder-open.png\"}] }";

                return ok(j);
    }

    public static Result Factory() {
        String j = "{\"list\":[{\"value\":188,\"suggest\":\"费森\",\"key\":\"费森\"},{\"value\":187,\"suggest\":\"金宝\",\"key\":\"金宝\"},{\"value\":186,\"suggest\":\"日式机\",\"key\":\"日式机\"},{\"value\":184,\"suggest\":\"山东济南柯渡\",\"key\":\"山东济南柯渡\"},{\"value\":183,\"suggest\":\"天津迈达医学科技股份有限公司\",\"key\":\"天津迈达医学科技股份有限公司\"},{\"value\":182,\"suggest\":\"淄博科创医疗仪器有限公司\",\"key\":\"淄博科创医疗仪器有限公司\"},{\"value\":181,\"suggest\":\"重庆西山科技有限公司\",\"key\":\"重庆西山科技有限公司\"},{\"value\":180,\"suggest\":\"重庆航天火箭电子技术有限公司\",\"key\":\"重庆航天火箭电子技术有限公司\"},{\"value\":179,\"suggest\":\"郑州基波新科技有限公司\",\"key\":\"郑州基波新科技有限公司\"},{\"value\":178,\"suggest\":\"意大利布鲁斯\",\"key\":\"意大利布鲁斯\"},{\"value\":177,\"suggest\":\"意大利\",\"key\":\"意大利\"},{\"value\":176,\"suggest\":\"以色列lumenis ltd\",\"key\":\"以色列Lumenis Ltd\"},{\"value\":175,\"suggest\":\"杨州亨利医疗器械有限公司\",\"key\":\"杨州亨利医疗器械有限公司\"},{\"value\":174,\"suggest\":\"新华手术器械有限公司\",\"key\":\"新华手术器械有限公司\"},{\"value\":173,\"suggest\":\"希森美康医用电子有限公司\",\"key\":\"希森美康医用电子有限公司\"},{\"value\":172,\"suggest\":\"武汉天瑞医疗科技有限公司\",\"key\":\"武汉天瑞医疗科技有限公司\"},{\"value\":171,\"suggest\":\"潍坊三江电子科技有限公司\",\"key\":\"潍坊三江电子科技有限公司\"},{\"value\":170,\"suggest\":\"威海威高齐全医疗设备有限公司\",\"key\":\"威海威高齐全医疗设备有限公司\"},{\"value\":169,\"suggest\":\"通用电气医疗系统信息技术有限公司\",\"key\":\"通用电气医疗系统信息技术有限公司\"},{\"value\":168,\"suggest\":\"通用电气医疗系统(中国)有限公司\",\"key\":\"通用电气医疗系统(中国)有限公司\"},{\"value\":167,\"suggest\":\"通用电气\",\"key\":\"通用电气\"},{\"value\":166,\"suggest\":\"天津市医疗器械二厂\",\"key\":\"天津市医疗器械二厂\"},{\"value\":165,\"suggest\":\"天津市同业科技发展有限公司\",\"key\":\"天津市同业科技发展有限公司\"},{\"value\":164,\"suggest\":\"天津市圣宁生物科技有限公司\",\"key\":\"天津市圣宁生物科技有限公司\"},{\"value\":163,\"suggest\":\"天津市利迈豪工贸有限公司\",\"key\":\"天津市利迈豪工贸有限公司\"},{\"value\":162,\"suggest\":\"天津航空机电公司\",\"key\":\"天津航空机电公司\"},{\"value\":161,\"suggest\":\"泰安市泰医医疗器械有限公司\",\"key\":\"泰安市泰医医疗器械有限公司\"},{\"value\":160,\"suggest\":\"太仓市康辉科技发展有限公司\",\"key\":\"太仓市康辉科技发展有限公司\"},{\"value\":159,\"suggest\":\"台湾三丰\",\"key\":\"台湾三丰\"},{\"value\":158,\"suggest\":\"苏州六六视觉科技股份有限公司\",\"key\":\"苏州六六视觉科技股份有限公司\"},{\"value\":157,\"suggest\":\"苏州虎丘影像设备有限公司\",\"key\":\"苏州虎丘影像设备有限公司\"},{\"value\":156,\"suggest\":\"沈阳市新达医疗器械厂\",\"key\":\"沈阳市新达医疗器械厂\"},{\"value\":155,\"suggest\":\"深圳市越华科技发展有限公司\",\"key\":\"深圳市越华科技发展有限公司\"},{\"value\":154,\"suggest\":\"深圳市迈瑞生物医疗电子器械有限公司\",\"key\":\"深圳市迈瑞生物医疗电子器械有限公司\"},{\"value\":153,\"suggest\":\"深圳市金科威实业有限公司\",\"key\":\"深圳市金科威实业有限公司\"},{\"value\":152,\"suggest\":\"上海医疗器械高技术公司\",\"key\":\"上海医疗器械高技术公司\"},{\"value\":151,\"suggest\":\"上海医疗器械（集团）有限公司手术器械厂\",\"key\":\"上海医疗器械（集团）有限公司手术器械厂\"},{\"value\":150,\"suggest\":\"上海伊部电器有限公司\",\"key\":\"上海伊部电器有限公司\"},{\"value\":149,\"suggest\":\"上海手术器械厂\",\"key\":\"上海手术器械厂\"},{\"value\":148,\"suggest\":\"上海南洋医用材料有限公司\",\"key\":\"上海南洋医用材料有限公司\"},{\"value\":147,\"suggest\":\"上海民桥医疗器械有限公司\",\"key\":\"上海民桥医疗器械有限公司\"},{\"value\":146,\"suggest\":\"上海徕卡仪器有限公司\",\"key\":\"上海徕卡仪器有限公司\"},{\"value\":145,\"suggest\":\"上海科华实验系统有限公司\",\"key\":\"上海科华实验系统有限公司\"},{\"value\":144,\"suggest\":\"上海晶杰医疗器械有限公司\",\"key\":\"上海晶杰医疗器械有限公司\"},{\"value\":143,\"suggest\":\"上海沪通电子有限公司\",\"key\":\"上海沪通电子有限公司\"},{\"value\":142,\"suggest\":\"上海光电医用电子仪器有限公司\",\"key\":\"上海光电医用电子仪器有限公司\"},{\"value\":141,\"suggest\":\"上海德尔格医疗器械有限公司\",\"key\":\"上海德尔格医疗器械有限公司\"},{\"value\":140,\"suggest\":\"上海安亭科学仪器厂\",\"key\":\"上海安亭科学仪器厂\"},{\"value\":139,\"suggest\":\"山东新华医疗器械股份有限公司\",\"key\":\"山东新华医疗器械股份有限公司\"},{\"value\":138,\"suggest\":\"山东瑞得通圆医疗仪器有限公司\",\"key\":\"山东瑞得通圆医疗仪器有限公司\"},{\"value\":137,\"suggest\":\"山东华宸高压容器有限公司\",\"key\":\"山东华宸高压容器有限公司\"},{\"value\":136,\"suggest\":\"山东宝力好医疗器械有限公司\",\"key\":\"山东宝力好医疗器械有限公司\"},{\"value\":135,\"suggest\":\"三丰医疗器械有限公司\",\"key\":\"三丰医疗器械有限公司\"},{\"value\":134,\"suggest\":\"日立\",\"key\":\"日立\"},{\"value\":133,\"suggest\":\"日本中西\",\"key\":\"日本中西\"},{\"value\":132,\"suggest\":\"日本希森美康株式会社\",\"key\":\"日本希森美康株式会社\"},{\"value\":131,\"suggest\":\"日本光电工业株式会社\",\"key\":\"日本光电工业株式会社\"},{\"value\":130,\"suggest\":\"日本东芝\",\"key\":\"日本东芝\"},{\"value\":129,\"suggest\":\"日本东曹株式会社\",\"key\":\"日本东曹株式会社\"},{\"value\":128,\"suggest\":\"日本奥林巴斯\",\"key\":\"日本奥林巴斯\"},{\"value\":127,\"suggest\":\"青岛海尔特种电器有限公司\",\"key\":\"青岛海尔特种电器有限公司\"},{\"value\":126,\"suggest\":\"南京医恩特仪器有限责任公司\",\"key\":\"南京医恩特仪器有限责任公司\"},{\"value\":125,\"suggest\":\"南京基蛋生物科技有限公司\",\"key\":\"南京基蛋生物科技有限公司\"},{\"value\":124,\"suggest\":\"南昌凯马有限公司\",\"key\":\"南昌凯马有限公司\"},{\"value\":123,\"suggest\":\"美国卓尔医学产品公司\",\"key\":\"美国卓尔医学产品公司\"},{\"value\":122,\"suggest\":\"美国视可尼\",\"key\":\"美国视可尼\"},{\"value\":121,\"suggest\":\"美国史赛克\",\"key\":\"美国史赛克\"},{\"value\":120,\"suggest\":\"美国史塞克\",\"key\":\"美国史塞克\"},{\"value\":119,\"suggest\":\"美国实验仪器公司\",\"key\":\"美国实验仪器公司\"},{\"value\":118,\"suggest\":\"美国模斯\",\"key\":\"美国模斯\"},{\"value\":117,\"suggest\":\"美国美敦力公司\",\"key\":\"美国美敦力公司\"},{\"value\":116,\"suggest\":\"美国杰西\",\"key\":\"美国杰西\"},{\"value\":115,\"suggest\":\"美国安捷伦科技公司\",\"key\":\"美国安捷伦科技公司\"},{\"value\":114,\"suggest\":\"美国philips medical systems公司\",\"key\":\"美国Philips Medical Systems公司\"},{\"value\":113,\"suggest\":\"美国masimo公司\",\"key\":\"美国MASIMO公司\"},{\"value\":112,\"suggest\":\"金坛市晶玻试验仪器厂\",\"key\":\"金坛市晶玻试验仪器厂\"},{\"value\":111,\"suggest\":\"江阴市健仕福器械有限公司\",\"key\":\"江阴市健仕福器械有限公司\"},{\"value\":110,\"suggest\":\"江苏鱼跃医疗设备股份有限公司\",\"key\":\"江苏鱼跃医疗设备股份有限公司\"},{\"value\":109,\"suggest\":\"江苏苏云医疗器材有限公司\",\"key\":\"江苏苏云医疗器材有限公司\"},{\"value\":108,\"suggest\":\"江苏巨光光电科技有限公司\",\"key\":\"江苏巨光光电科技有限公司\"},{\"value\":107,\"suggest\":\"华图医疗器械（上海）有限公司\",\"key\":\"华图医疗器械（上海）有限公司\"},{\"value\":106,\"suggest\":\"荷兰威图科学公司\",\"key\":\"荷兰威图科学公司\"},{\"value\":105,\"suggest\":\"荷兰纽迪希亚\",\"key\":\"荷兰纽迪希亚\"},{\"value\":104,\"suggest\":\"合肥美菱股份有限公司\",\"key\":\"合肥美菱股份有限公司\"},{\"value\":103,\"suggest\":\"合肥凯利光电科技有限公司 \",\"key\":\"合肥凯利光电科技有限公司 \"},{\"value\":102,\"suggest\":\"杭州天创净水设备有限公司\",\"key\":\"杭州天创净水设备有限公司\"},{\"value\":101,\"suggest\":\"杭州迈迪克仪器有限公司\",\"key\":\"杭州迈迪克仪器有限公司\"},{\"value\":100,\"suggest\":\"韩国丹纳公司\",\"key\":\"韩国丹纳公司\"},{\"value\":99,\"suggest\":\"海尔集团青岛电冰柜总厂\",\"key\":\"海尔集团青岛电冰柜总厂\"},{\"value\":98,\"suggest\":\"桂州优利特医疗电子有限公司\",\"key\":\"桂州优利特医疗电子有限公司\"},{\"value\":97,\"suggest\":\"广州一康医疗设备实业有限公司\",\"key\":\"广州一康医疗设备实业有限公司\"},{\"value\":96,\"suggest\":\"广州市章和电器设备有限公司\",\"key\":\"广州市章和电器设备有限公司\"},{\"value\":95,\"suggest\":\"广州市三甲医疗信息产业有限公司\",\"key\":\"广州市三甲医疗信息产业有限公司\"},{\"value\":94,\"suggest\":\"广东宝莱特医用科技股份有限公司\",\"key\":\"广东宝莱特医用科技股份有限公司\"},{\"value\":93,\"suggest\":\"格兰德医用设备（天津）有限公司\",\"key\":\"格兰德医用设备（天津）有限公司\"},{\"value\":92,\"suggest\":\"富士能株式会社\",\"key\":\"富士能株式会社\"},{\"value\":91,\"suggest\":\"飞利浦\",\"key\":\"飞利浦\"},{\"value\":90,\"suggest\":\"东芝医疗系统株式会社\",\"key\":\"东芝医疗系统株式会社\"},{\"value\":89,\"suggest\":\"德国普美康公司\",\"key\":\"德国普美康公司\"},{\"value\":88,\"suggest\":\"德国菲兹曼医用电子公司\",\"key\":\"德国菲兹曼医用电子公司\"},{\"value\":87,\"suggest\":\"德国德尔格公司\",\"key\":\"德国德尔格公司\"},{\"value\":86,\"suggest\":\"德国艾克松\",\"key\":\"德国艾克松\"},{\"value\":85,\"suggest\":\"德国艾伯\",\"key\":\"德国艾伯\"},{\"value\":84,\"suggest\":\"德国iem公司\",\"key\":\"德国IEM公司\"},{\"value\":83,\"suggest\":\"德尔格医疗设备（上海）有限公司\",\"key\":\"德尔格医疗设备（上海）有限公司\"},{\"value\":82,\"suggest\":\"丹麦尔听美\",\"key\":\"丹麦尔听美\"},{\"value\":81,\"suggest\":\"成都老肯科技股份有限公司\",\"key\":\"成都老肯科技股份有限公司\"},{\"value\":80,\"suggest\":\"成都肯格王三氧电器设备有限公司\",\"key\":\"成都肯格王三氧电器设备有限公司\"},{\"value\":79,\"suggest\":\"成都肯格王电子科技有限公司\",\"key\":\"成都肯格王电子科技有限公司\"},{\"value\":78,\"suggest\":\"常州书奥博康复器材科\",\"key\":\"常州书奥博康复器材科\"},{\"value\":77,\"suggest\":\"常州市雅博电子设备有限公司\",\"key\":\"常州市雅博电子设备有限公司\"},{\"value\":76,\"suggest\":\"常州市赛博康复器材科\",\"key\":\"常州市赛博康复器材科\"},{\"value\":75,\"suggest\":\"常州市钱璟康复器材有限公司\",\"key\":\"常州市钱璟康复器材有限公司\"},{\"value\":74,\"suggest\":\"常州市奥博康复器材科技有限公司\",\"key\":\"常州市奥博康复器材科技有限公司\"},{\"value\":73,\"suggest\":\"贝克曼库尔特商贸（中国）有限公司\",\"key\":\"贝克曼库尔特商贸（中国）有限公司\"},{\"value\":72,\"suggest\":\"北京医用离心机厂\",\"key\":\"北京医用离心机厂\"},{\"value\":71,\"suggest\":\"北京拓普康医疗器械有限公司\",\"key\":\"北京拓普康医疗器械有限公司\"},{\"value\":70,\"suggest\":\"北京思路高医疗科技有限公司\",\"key\":\"北京思路高医疗科技有限公司\"},{\"value\":69,\"suggest\":\"北京市永光明医疗器械有限公司\",\"key\":\"北京市永光明医疗器械有限公司\"},{\"value\":68,\"suggest\":\"北京赛科希德科技发展有限公司\",\"key\":\"北京赛科希德科技发展有限公司\"},{\"value\":67,\"suggest\":\"北京科力建元医疗科技有限公司\",\"key\":\"北京科力建元医疗科技有限公司\"},{\"value\":66,\"suggest\":\"北京福田电子医疗仪器有限公司\",\"key\":\"北京福田电子医疗仪器有限公司\"},{\"value\":65,\"suggest\":\"北京凡星光电医疗设备有限公司\",\"key\":\"北京凡星光电医疗设备有限公司\"},{\"value\":64,\"suggest\":\"北京达能医疗及电子仪器设备有限公司\",\"key\":\"北京达能医疗及电子仪器设备有限公司\"},{\"value\":63,\"suggest\":\"北京长城光学仪器厂\",\"key\":\"北京长城光学仪器厂\"},{\"value\":62,\"suggest\":\"北京百诺代医疗器械有限责任公司\",\"key\":\"北京百诺代医疗器械有限责任公司\"},{\"value\":61,\"suggest\":\"北京白洋医疗器械有限公司\",\"key\":\"北京白洋医疗器械有限公司\"},{\"value\":60,\"suggest\":\"reck-technik gmbh&go.kg\",\"key\":\"RECK-Technik GmbH&Go.kG\"},{\"value\":59,\"suggest\":\"parigmbh\",\"key\":\"PARIGMBH\"},{\"value\":58,\"suggest\":\"novotec medical gmbh\",\"key\":\"Novotec Medical GmbH\"},{\"value\":57,\"suggest\":\"2222\",\"key\":\"2222\"},{\"value\":56,\"suggest\":\"aaa\",\"key\":\"AAA\"},{\"value\":53,\"suggest\":\"123,467./changjia-厂家\",\"key\":\"123,467./changjia-厂家\"},{\"value\":52,\"suggest\":\"森井616\",\"key\":\"森井616\"},{\"value\":51,\"suggest\":\"scout.pro\",\"key\":\"Scout.pro\"},{\"value\":50,\"suggest\":\"scientificinoustries\",\"key\":\"SCIENTIFICINOUSTRIES\"},{\"value\":49,\"suggest\":\"nikon\",\"key\":\"Nikon\"},{\"value\":48,\"suggest\":\"nihonkohden光电\",\"key\":\"NIHONKOHDEN光电\"},{\"value\":47,\"suggest\":\"nellcor\",\"key\":\"NELLCOR\"},{\"value\":46,\"suggest\":\"msnot（博美）\",\"key\":\"msnot（博美）\"},{\"value\":41,\"suggest\":\"auto non-contact\",\"key\":\"auto non-contact\"},{\"value\":40,\"suggest\":\"sunrise\",\"key\":\"SUNRISE\"},{\"value\":39,\"suggest\":\"sysmex\",\"key\":\"Sysmex\"},{\"value\":38,\"suggest\":\"浙江史密斯医学仪器有限公司\",\"key\":\"浙江史密斯医学仪器有限公司\"},{\"value\":37,\"suggest\":\"德尔格\",\"key\":\"德尔格\"},{\"value\":36,\"suggest\":\"韩国hanaumedcal.co.ltd\",\"key\":\"韩国HANAUMEDCAL.CO.LTD\"},{\"value\":32,\"suggest\":\"德国melag\",\"key\":\"德国MELAG\"},{\"value\":31,\"suggest\":\"珠海美华\",\"key\":\"珠海美华\"},{\"value\":27,\"suggest\":\"珠海丽拓\",\"key\":\"珠海丽拓\"},{\"value\":26,\"suggest\":\"limbs＆things ltd\",\"key\":\"LIMBS＆THINGS LTD\"}]}";
        return ok(j);


    }
    public static Result HospitalEquipment() {
        String j="{\"pager.totalRows\":267,\"sort\":\"id\",\"rows\":[{\"NowMonthC\":0,\"SerialNumber\":\"001\",\"ServiceEnd\":\"2015-12-22 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"\",\"Equput\":\"01010\",\"DeptName\":\"CT室\",\"EquName\":\"眼科器械\",\"WordName\":\"眼科手术用其他器械\",\"CategoryID\":\"10142\",\"SupplierID\":\"\",\"RepairStatus\":\"\",\"OSNumber\":\"\",\"EquipmentDisuse\":\"0年\",\"Hospital\":\"\",\"BuyMoeny\":\"元\",\"SalvageValue\":\"0元\",\"DepreciationRate\":\"0%\",\"InstallDate\":\"2015-12-30\",\"NowYearC\":0,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"否\",\"SupplierName\":\"\",\"StatusName\":\"\",\"lastYearC\":0,\"DepartPerson\":\"\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"在用\",\"NowMonth\":0,\"IBNumber\":\"6804-5151230158\",\"lastYear\":0,\"Aftertaxprice\":\"6804-5151230158\",\"FactoryID\":\"186\",\"FactoryName\":\"日式机\",\"DepartmentID\":\"30480\",\"Id\":\"1496\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-12-16 00:00\",\"Specification\":\"0001\",\"EquNo\":\"\",\"Manufacturedate\":\"2015-12-30 00:00\"},{\"NowMonthC\":0,\"SerialNumber\":\"0110\",\"ServiceEnd\":\"2015-12-30 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"10086\",\"Equput\":\"0101\",\"DeptName\":\"测听室\",\"EquName\":\"测试设备\",\"WordName\":\"显微外科手术器械\",\"CategoryID\":\"10074\",\"SupplierID\":\"27\",\"RepairStatus\":\"\",\"OSNumber\":\"777\",\"EquipmentDisuse\":\"0年\",\"Hospital\":\"齐鲁医院\",\"BuyMoeny\":\"777.0000元\",\"SalvageValue\":\"777元\",\"DepreciationRate\":\"0%\",\"InstallDate\":\"2015-12-30\",\"NowYearC\":0,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"否\",\"SupplierName\":\"苏泊尔电器\",\"StatusName\":\"正常使用\",\"lastYearC\":0,\"DepartPerson\":\"测听室主任\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"维修中\",\"NowMonth\":0,\"IBNumber\":\"6802151230722\",\"lastYear\":0,\"Aftertaxprice\":\"6802151230722\",\"FactoryID\":\"186\",\"FactoryName\":\"日式机\",\"DepartmentID\":\"30483\",\"Id\":\"1495\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-12-23 00:00\",\"Specification\":\"01010\",\"EquNo\":\"001\",\"Manufacturedate\":\"2015-12-30 00:00\"},{\"NowMonthC\":0.0000,\"SerialNumber\":\"00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"\",\"Equput\":\"55\",\"DeptName\":\"院长室\",\"EquName\":\"监护仪\",\"WordName\":\"基础外科用钳\",\"CategoryID\":\"10123\",\"SupplierID\":\"\",\"RepairStatus\":\"\",\"OSNumber\":\"00\",\"EquipmentDisuse\":\"年\",\"Hospital\":\"\",\"BuyMoeny\":\"40000.0000元\",\"SalvageValue\":\"40000元\",\"DepreciationRate\":\"%\",\"InstallDate\":\"2013-05-20\",\"NowYearC\":0.0000,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"否\",\"SupplierName\":\"\",\"StatusName\":\"正常使用\",\"lastYearC\":0.0000,\"DepartPerson\":\"\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"在用\",\"NowMonth\":0,\"IBNumber\":\"151229600\",\"lastYear\":0,\"Aftertaxprice\":\"151229600\",\"FactoryID\":\"187\",\"FactoryName\":\"金宝\",\"DepartmentID\":\"30478\",\"Id\":\"1494\",\"TotalMoenyC\":0.0000,\"Specification\":\"00\",\"EquNo\":\"000\",\"Manufacturedate\":\"\"},{\"NowMonthC\":0,\"SerialNumber\":\"145\",\"ServiceEnd\":\"2015-12-31 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"12345678901\",\"Equput\":\"手术室\",\"DeptName\":\"手术室\",\"EquName\":\"监护仪\",\"WordName\":\"基础外科用钳\",\"CategoryID\":\"10123\",\"SupplierID\":\"21\",\"RepairStatus\":\"\",\"OSNumber\":\"418\",\"EquipmentDisuse\":\"10年\",\"Hospital\":\"齐鲁医院\",\"BuyMoeny\":\"100000.0000元\",\"SalvageValue\":\"100000元\",\"DepreciationRate\":\"10%\",\"InstallDate\":\"2015-12-24\",\"NowYearC\":0,\"MonthDepreciation\":\"833.333333333333元\",\"IsWarranty\":\"否\",\"SupplierName\":\"艾康生物技术（杭州）有限公司\",\"StatusName\":\"待维修\",\"lastYearC\":0,\"DepartPerson\":\"手术室科室主任\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"在用\",\"NowMonth\":0,\"IBNumber\":\"151225036\",\"lastYear\":0,\"Aftertaxprice\":\"151225036\",\"FactoryID\":\"184\",\"FactoryName\":\"山东济南柯渡\",\"DepartmentID\":\"30019\",\"Id\":\"1493\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-12-01 00:00\",\"Specification\":\"7852\",\"EquNo\":\"3787\",\"Manufacturedate\":\"2015-12-15 00:00\"},{\"NowMonthC\":0,\"SerialNumber\":\"1223\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"12345678901\",\"Equput\":\"手术室\",\"DeptName\":\"手术室\",\"EquName\":\"麻醉机\",\"WordName\":\"基础外科其它器械\",\"CategoryID\":\"10126\",\"SupplierID\":\"\",\"RepairStatus\":\"\",\"OSNumber\":\"3333\",\"EquipmentDisuse\":\"年\",\"Hospital\":\"\",\"BuyMoeny\":\"元\",\"SalvageValue\":\"0元\",\"DepreciationRate\":\"%\",\"InstallDate\":\"2015-04-22\",\"NowYearC\":0,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"否\",\"SupplierName\":\"\",\"StatusName\":\"正常使用\",\"lastYearC\":0,\"DepartPerson\":\"手术室科室主任\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"在用\",\"NowMonth\":0,\"IBNumber\":\"6801-7151222080\",\"lastYear\":0,\"Aftertaxprice\":\"6801-7151222080\",\"FactoryID\":\"187\",\"FactoryName\":\"金宝\",\"DepartmentID\":\"30019\",\"Id\":\"1491\",\"TotalMoenyC\":0,\"Specification\":\"ddhh\",\"EquNo\":\"\",\"Manufacturedate\":\"\"},{\"NowMonthC\":0.0000,\"SerialNumber\":\"no-001\",\"ServiceEnd\":\"2016-12-01 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"\",\"Equput\":\"喉科病房\",\"DeptName\":\"喉科病房\",\"EquName\":\"测试用\",\"WordName\":\"医用缝合针(不带线)\",\"CategoryID\":\"10120\",\"SupplierID\":\"22\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"bh-001\",\"EquipmentDisuse\":\"10年\",\"Hospital\":\"齐鲁医院\",\"BuyMoeny\":\"10000.0000元\",\"SalvageValue\":\"10000元\",\"DepreciationRate\":\"10%\",\"InstallDate\":\"2015-12-01\",\"NowYearC\":0.0000,\"MonthDepreciation\":\"83.3333333333333元\",\"IsWarranty\":\"是\",\"SupplierName\":\"123testAA供应商\",\"StatusName\":\"正常使用\",\"lastYearC\":0.0000,\"DepartPerson\":\"\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"维修中\",\"NowMonth\":0,\"IBNumber\":\"6801-1151209390\",\"lastYear\":0,\"Aftertaxprice\":\"6801-1151209390\",\"FactoryID\":\"188\",\"FactoryName\":\"费森\",\"DepartmentID\":\"30485\",\"Id\":\"1490\",\"TotalMoenyC\":0.0000,\"ServiceBegin\":\"2015-12-01 00:00\",\"Specification\":\"xh-001\",\"EquNo\":\"111\",\"Manufacturedate\":\"2015-11-01 00:00\"},{\"NowMonthC\":0.0000,\"SerialNumber\":\"11111\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"12345678901\",\"Equput\":\"123\",\"DeptName\":\"手术室\",\"EquName\":\"眼科器械\",\"WordName\":\"眼科手术用其他器械\",\"CategoryID\":\"10142\",\"SupplierID\":\"\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"\",\"EquipmentDisuse\":\"年\",\"Hospital\":\"\",\"BuyMoeny\":\"元\",\"SalvageValue\":\"0元\",\"DepreciationRate\":\"%\",\"InstallDate\":\"2015-12-08\",\"NowYearC\":0.0000,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"是\",\"SupplierName\":\"\",\"StatusName\":\"正常使用\",\"lastYearC\":0.0000,\"DepartPerson\":\"手术室科室主任\",\"TotalMoeny\":400.0000,\"NowYear\":0,\"State\":\"维修中\",\"NowMonth\":0,\"IBNumber\":\"6804-5151208009\",\"lastYear\":400.0000,\"Aftertaxprice\":\"6804-5151208009\",\"FactoryID\":\"188\",\"FactoryName\":\"费森\",\"DepartmentID\":\"30019\",\"Id\":\"1489\",\"TotalMoenyC\":0.0000,\"ServiceBegin\":\"2015-12-08 00:00\",\"Specification\":\"aa\",\"EquNo\":\"\",\"Manufacturedate\":\"\"},{\"NowMonthC\":0,\"SerialNumber\":\"B-9870001\",\"ServiceEnd\":\"2016-11-29 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"\",\"Equput\":\"急诊科\",\"DeptName\":\"急诊科\",\"EquName\":\"设备a\",\"WordName\":\"诊断仪器\",\"CategoryID\":\"10253\",\"SupplierID\":\"\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"\",\"EquipmentDisuse\":\"年\",\"Hospital\":\"\",\"BuyMoeny\":\"1000.0000元\",\"SalvageValue\":\"1000元\",\"DepreciationRate\":\"%\",\"InstallDate\":\"2015-11-29\",\"NowYearC\":0,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"是\",\"SupplierName\":\"\",\"StatusName\":\"正常使用\",\"lastYearC\":0,\"DepartPerson\":\"\",\"TotalMoeny\":600.0000,\"NowYear\":0,\"State\":\"维修中\",\"NowMonth\":0,\"IBNumber\":\"6827-1151202183\",\"lastYear\":600.0000,\"Aftertaxprice\":\"6827-1151202183\",\"FactoryID\":\"187\",\"FactoryName\":\"金宝\",\"DepartmentID\":\"30486\",\"Id\":\"1488\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-11-29 00:00\",\"Specification\":\"B-9870\",\"EquNo\":\"\",\"Manufacturedate\":\"2015-12-02 00:00\"},{\"NowMonthC\":0.0000,\"SerialNumber\":\"dfasfds\",\"ServiceEnd\":\"2016-01-01 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"12345678901\",\"Equput\":\"cs\",\"DeptName\":\"手术室\",\"EquName\":\"测试用\",\"WordName\":\"医用缝合针(不带线)\",\"CategoryID\":\"10120\",\"SupplierID\":\"21\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"sdfsa\",\"EquipmentDisuse\":\"0年\",\"Hospital\":\"齐鲁医院\",\"BuyMoeny\":\"10000.0000元\",\"SalvageValue\":\"10000元\",\"DepreciationRate\":\"0%\",\"InstallDate\":\"2015-12-01\",\"NowYearC\":0.0000,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"是\",\"SupplierName\":\"艾康生物技术（杭州）有限公司\",\"StatusName\":\"正常使用\",\"lastYearC\":536380.0000,\"DepartPerson\":\"手术室科室主任\",\"TotalMoeny\":1000.0000,\"NowYear\":0,\"State\":\"维修中\",\"NowMonth\":0,\"IBNumber\":\"6801-1151201205\",\"lastYear\":1000.0000,\"Aftertaxprice\":\"6801-1151201205\",\"FactoryID\":\"178\",\"FactoryName\":\"意大利布鲁斯\",\"DepartmentID\":\"30019\",\"Id\":\"1487\",\"TotalMoenyC\":642180.0000,\"ServiceBegin\":\"2015-11-01 00:00\",\"Specification\":\"fdsf\",\"EquNo\":\"zc11\",\"Manufacturedate\":\"2015-11-01 00:00\"},{\"NowMonthC\":0.0000,\"SerialNumber\":\"23065\",\"ServiceEnd\":\"2017-01-01 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"12345678901\",\"Equput\":\"大厅\",\"DeptName\":\"手术室\",\"EquName\":\"麻醉机\",\"WordName\":\"基础外科其它器械\",\"CategoryID\":\"10126\",\"SupplierID\":\"27\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"dgrfhg\",\"EquipmentDisuse\":\"10年\",\"Hospital\":\"齐鲁医院\",\"BuyMoeny\":\"200000.0000元\",\"SalvageValue\":\"200000元\",\"DepreciationRate\":\"10%\",\"InstallDate\":\"2015-11-23\",\"NowYearC\":0.0000,\"MonthDepreciation\":\"1666.66666666667元\",\"IsWarranty\":\"是\",\"SupplierName\":\"苏泊尔电器\",\"StatusName\":\"正常使用\",\"lastYearC\":2300.0000,\"DepartPerson\":\"手术室科室主任\",\"TotalMoeny\":300.0000,\"NowYear\":0,\"State\":\"维修中\",\"NowMonth\":0,\"IBNumber\":\"6801-7151130555\",\"lastYear\":300.0000,\"Aftertaxprice\":\"6801-7151130555\",\"FactoryID\":\"188\",\"FactoryName\":\"费森\",\"DepartmentID\":\"30019\",\"Id\":\"1486\",\"TotalMoenyC\":2300.0000,\"ServiceBegin\":\"2014-01-01 00:00\",\"Specification\":\"MHJ-111B\",\"EquNo\":\"abc123\",\"Manufacturedate\":\"2014-11-01 00:00\"},{\"NowMonthC\":0,\"SerialNumber\":\"SHCJJY007\",\"ServiceEnd\":\"2015-12-25 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"\",\"Equput\":\"仓库一\",\"DeptName\":\"放射科\",\"EquName\":\"台式低速离心机\",\"WordName\":\"基础外科其它器械\",\"CategoryID\":\"10126\",\"SupplierID\":\"17\",\"RepairStatus\":\"\",\"OSNumber\":\"asdf11\",\"EquipmentDisuse\":\"5年\",\"Hospital\":\"齐鲁医院\",\"BuyMoeny\":\"10000.0000元\",\"SalvageValue\":\"10000元\",\"DepreciationRate\":\"10%\",\"InstallDate\":\"2015-11-01\",\"NowYearC\":0,\"MonthDepreciation\":\"83.3333333333333元\",\"IsWarranty\":\"否\",\"SupplierName\":\"迪姆软件（北京）有限公司\",\"StatusName\":\"正常使用\",\"lastYearC\":0,\"DepartPerson\":\"\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"在用\",\"NowMonth\":0,\"IBNumber\":\"6801-7151125268\",\"lastYear\":0,\"Aftertaxprice\":\"6801-7151125268\",\"FactoryID\":\"184\",\"FactoryName\":\"山东济南柯渡\",\"DepartmentID\":\"30484\",\"Id\":\"1485\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-10-25 00:00\",\"Specification\":\"800型\",\"EquNo\":\"1a\",\"Manufacturedate\":\"2015-10-25 00:00\"},{\"NowMonthC\":0.0000,\"SerialNumber\":\"71152-01\",\"ServiceEnd\":\"2016-12-01 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"12345678901\",\"Equput\":\"血透室\",\"DeptName\":\"手术室\",\"EquName\":\"日机透析机\",\"WordName\":\"血液净化设备和血液净化器具\",\"CategoryID\":\"10302\",\"SupplierID\":\"5\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"bh-001\",\"EquipmentDisuse\":\"10年\",\"Hospital\":\"齐鲁医院\",\"BuyMoeny\":\"10000.0000元\",\"SalvageValue\":\"10000元\",\"DepreciationRate\":\"5%\",\"InstallDate\":\"2015-12-10\",\"NowYearC\":0.0000,\"MonthDepreciation\":\"41.6666666666667元\",\"IsWarranty\":\"是\",\"SupplierName\":\"东魅\",\"StatusName\":\"正常使用\",\"lastYearC\":460.0000,\"DepartPerson\":\"手术室科室主任\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"维修中\",\"NowMonth\":0,\"IBNumber\":\"6845-4151120260\",\"lastYear\":0,\"Aftertaxprice\":\"6845-4151120260\",\"FactoryID\":\"186\",\"FactoryName\":\"日式机\",\"DepartmentID\":\"30019\",\"Id\":\"1484\",\"TotalMoenyC\":460.0000,\"ServiceBegin\":\"2015-12-01 00:00\",\"Specification\":\"DBB-27\",\"EquNo\":\"bm-001\",\"Manufacturedate\":\"2015-12-01 00:00\"},{\"NowMonthC\":0,\"SerialNumber\":\"3451760\",\"ServiceEnd\":\"2016-11-01 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"456\",\"Equput\":\"血透室\",\"DeptName\":\"检验科\",\"EquName\":\"费森透析机\",\"WordName\":\"血液净化设备和血液净化器具\",\"CategoryID\":\"10302\",\"SupplierID\":\"\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"\",\"EquipmentDisuse\":\"0年\",\"Hospital\":\"\",\"BuyMoeny\":\"元\",\"SalvageValue\":\"0元\",\"DepreciationRate\":\"0%\",\"InstallDate\":\"1900-01-01\",\"NowYearC\":0,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"是\",\"SupplierName\":\"\",\"StatusName\":\"正常使用\",\"lastYearC\":0,\"DepartPerson\":\"琳琳\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"维修中\",\"NowMonth\":0,\"IBNumber\":\"6845-4151120211\",\"lastYear\":0,\"Aftertaxprice\":\"6845-4151120211\",\"FactoryID\":\"188\",\"FactoryName\":\"费森\",\"DepartmentID\":\"30502\",\"Id\":\"1483\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-11-02 00:00\",\"Specification\":\"4008B\",\"EquNo\":\"\",\"Manufacturedate\":\"\"},{\"NowMonthC\":0,\"SerialNumber\":\"71136-05\",\"ServiceEnd\":\"2016-11-01 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"456\",\"Equput\":\"血透室\",\"DeptName\":\"检验科\",\"EquName\":\"日机透析机\",\"WordName\":\"血液净化设备和血液净化器具\",\"CategoryID\":\"10302\",\"SupplierID\":\"\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"\",\"EquipmentDisuse\":\"0年\",\"Hospital\":\"齐鲁医院\",\"BuyMoeny\":\"元\",\"SalvageValue\":\"0元\",\"DepreciationRate\":\"0%\",\"InstallDate\":\"2015-11-02\",\"NowYearC\":0,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"是\",\"SupplierName\":\"\",\"StatusName\":\"正常使用\",\"lastYearC\":0,\"DepartPerson\":\"琳琳\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"在用\",\"NowMonth\":0,\"IBNumber\":\"6845-4151120201\",\"lastYear\":0,\"Aftertaxprice\":\"6845-4151120201\",\"FactoryID\":\"186\",\"FactoryName\":\"日式机\",\"DepartmentID\":\"30502\",\"Id\":\"1482\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-11-02 00:00\",\"Specification\":\"DBB-27\",\"EquNo\":\"\",\"Manufacturedate\":\"\"},{\"NowMonthC\":0,\"SerialNumber\":\"71034-04\",\"ServiceEnd\":\"2016-11-01 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"456\",\"Equput\":\"血透室\",\"DeptName\":\"检验科\",\"EquName\":\"日机透析机\",\"WordName\":\"血液净化设备和血液净化器具\",\"CategoryID\":\"10302\",\"SupplierID\":\"\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"\",\"EquipmentDisuse\":\"年\",\"Hospital\":\"\",\"BuyMoeny\":\"元\",\"SalvageValue\":\"0元\",\"DepreciationRate\":\"%\",\"InstallDate\":\"1900-01-01\",\"NowYearC\":0,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"是\",\"SupplierName\":\"\",\"StatusName\":\"正常使用\",\"lastYearC\":0,\"DepartPerson\":\"琳琳\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"维修中\",\"NowMonth\":0,\"IBNumber\":\"6845-4151120269\",\"lastYear\":0,\"Aftertaxprice\":\"6845-4151120269\",\"FactoryID\":\"186\",\"FactoryName\":\"日式机\",\"DepartmentID\":\"30502\",\"Id\":\"1481\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-11-02 00:00\",\"Specification\":\"DBB-27\",\"EquNo\":\"\",\"Manufacturedate\":\"\"},{\"NowMonthC\":0,\"SerialNumber\":\"14036-2013\",\"ServiceEnd\":\"2016-11-01 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"\",\"Equput\":\"血透室\",\"DeptName\":\"院长室\",\"EquName\":\"金宝透析机\",\"WordName\":\"血液净化设备和血液净化器具\",\"CategoryID\":\"10302\",\"SupplierID\":\"\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"\",\"EquipmentDisuse\":\"0年\",\"Hospital\":\"\",\"BuyMoeny\":\"元\",\"SalvageValue\":\"0元\",\"DepreciationRate\":\"0%\",\"InstallDate\":\"1900-01-01\",\"NowYearC\":0,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"是\",\"SupplierName\":\"\",\"StatusName\":\"正常使用\",\"lastYearC\":0,\"DepartPerson\":\"\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"在用\",\"NowMonth\":0,\"IBNumber\":\"6845-4151120231\",\"lastYear\":0,\"Aftertaxprice\":\"6845-4151120231\",\"FactoryID\":\"187\",\"FactoryName\":\"金宝\",\"DepartmentID\":\"30478\",\"Id\":\"1479\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-11-02 00:00\",\"Specification\":\"AK96\",\"EquNo\":\"\",\"Manufacturedate\":\"\"},{\"NowMonthC\":0,\"SerialNumber\":\"18857-2013\",\"ServiceEnd\":\"2016-11-01 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"456\",\"Equput\":\"血透室\",\"DeptName\":\"检验科\",\"EquName\":\"金宝透析机\",\"WordName\":\"血液净化设备和血液净化器具\",\"CategoryID\":\"10302\",\"SupplierID\":\"\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"\",\"EquipmentDisuse\":\"年\",\"Hospital\":\"\",\"BuyMoeny\":\"元\",\"SalvageValue\":\"0元\",\"DepreciationRate\":\"%\",\"InstallDate\":\"1900-01-01\",\"NowYearC\":0,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"是\",\"SupplierName\":\"\",\"StatusName\":\"正常使用\",\"lastYearC\":0,\"DepartPerson\":\"琳琳\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"在用\",\"NowMonth\":0,\"IBNumber\":\"6845-4151120532\",\"lastYear\":0,\"Aftertaxprice\":\"6845-4151120532\",\"FactoryID\":\"187\",\"FactoryName\":\"金宝\",\"DepartmentID\":\"30502\",\"Id\":\"1478\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-11-02 00:00\",\"Specification\":\"AK96\",\"EquNo\":\"\",\"Manufacturedate\":\"\"},{\"NowMonthC\":0,\"SerialNumber\":\"18859-2013\",\"ServiceEnd\":\"2016-11-01 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"456\",\"Equput\":\"血透室\",\"DeptName\":\"检验科\",\"EquName\":\"金宝透析机\",\"WordName\":\"血液净化设备和血液净化器具\",\"CategoryID\":\"10302\",\"SupplierID\":\"\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"\",\"EquipmentDisuse\":\"年\",\"Hospital\":\"\",\"BuyMoeny\":\"元\",\"SalvageValue\":\"0元\",\"DepreciationRate\":\"%\",\"InstallDate\":\"1900-01-01\",\"NowYearC\":0,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"是\",\"SupplierName\":\"\",\"StatusName\":\"正常使用\",\"lastYearC\":0,\"DepartPerson\":\"琳琳\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"维修中\",\"NowMonth\":0,\"IBNumber\":\"6845-4151120396\",\"lastYear\":0,\"Aftertaxprice\":\"6845-4151120396\",\"FactoryID\":\"187\",\"FactoryName\":\"金宝\",\"DepartmentID\":\"30502\",\"Id\":\"1477\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-11-02 00:00\",\"Specification\":\"AK96\",\"EquNo\":\"\",\"Manufacturedate\":\"\"},{\"NowMonthC\":0,\"SerialNumber\":\"18858-2013\",\"ServiceEnd\":\"2016-11-01 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"456\",\"Equput\":\"血透室\",\"DeptName\":\"检验科\",\"EquName\":\"金宝透析机\",\"WordName\":\"血液净化设备和血液净化器具\",\"CategoryID\":\"10302\",\"SupplierID\":\"\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"\",\"EquipmentDisuse\":\"年\",\"Hospital\":\"\",\"BuyMoeny\":\"元\",\"SalvageValue\":\"0元\",\"DepreciationRate\":\"%\",\"InstallDate\":\"1900-01-01\",\"NowYearC\":0,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"是\",\"SupplierName\":\"\",\"StatusName\":\"正常使用\",\"lastYearC\":0,\"DepartPerson\":\"琳琳\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"在用\",\"NowMonth\":0,\"IBNumber\":\"6845-4151120766\",\"lastYear\":0,\"Aftertaxprice\":\"6845-4151120766\",\"FactoryID\":\"187\",\"FactoryName\":\"金宝\",\"DepartmentID\":\"30502\",\"Id\":\"1476\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-11-02 00:00\",\"Specification\":\"AK96\",\"EquNo\":\"\",\"Manufacturedate\":\"\"},{\"NowMonthC\":0,\"SerialNumber\":\"38999\",\"ServiceEnd\":\"2016-11-01 00:00\",\"DepreciationPrice\":\"0元\",\"DepartPersonTel\":\"456\",\"Equput\":\"血透室\",\"DeptName\":\"检验科\",\"EquName\":\"金宝透析机\",\"WordName\":\"血液净化设备和血液净化器具\",\"CategoryID\":\"10302\",\"SupplierID\":\"\",\"RepairStatus\":\"在保|原厂在保|合同在保\",\"OSNumber\":\"\",\"EquipmentDisuse\":\"年\",\"Hospital\":\"\",\"BuyMoeny\":\"元\",\"SalvageValue\":\"0元\",\"DepreciationRate\":\"%\",\"InstallDate\":\"1900-01-01\",\"NowYearC\":0,\"MonthDepreciation\":\"0元\",\"IsWarranty\":\"是\",\"SupplierName\":\"\",\"StatusName\":\"正常使用\",\"lastYearC\":0,\"DepartPerson\":\"琳琳\",\"TotalMoeny\":0,\"NowYear\":0,\"State\":\"维修中\",\"NowMonth\":0,\"IBNumber\":\"6845-4151120143\",\"lastYear\":0,\"Aftertaxprice\":\"6845-4151120143\",\"FactoryID\":\"187\",\"FactoryName\":\"金宝\",\"DepartmentID\":\"30502\",\"Id\":\"1475\",\"TotalMoenyC\":0,\"ServiceBegin\":\"2015-11-02 00:00\",\"Specification\":\"AK95S\",\"EquNo\":\"\",\"Manufacturedate\":\"\"}],\"Id\":\"desc\",\"pager.pageNo\":1}";
        return ok(j);

    }


        public static Result menu() {
        String j="{\n" +
                "  \"treeNodes\": [\n" +
              
                "    {\n" +
                "      \"id\": 210,\n" +
                "      \"parentId\": 200,\n" +
                "      \"name\": \"设备管理\",\n" +
                "      \"iconSkin\": \"diy01\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/1.png\",\n" +
                "      \"Ico\": \"/assets/skin/1.png\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 212,\n" +
                "      \"parentId\": 210,\n" +
                "      \"name\": \"设备信息\",\n" +
                "      \"tabUrl\": \"/assets/EquManager/EquList.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": \"/assets/skin/icons/icon_2.png\"\n" +
                "    },\n" +
               
                "    {\n" +
                "      \"id\": 249,\n" +
                "      \"parentId\": 210,\n" +
                "      \"name\": \"设备查询（标签/二维码）\",\n" +
                "      \"tabUrl\": \"/assets/EquManager/EquSelect.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +

               
            
                      "    {\n" +
                "      \"id\": 260,\n" +
                "      \"parentId\": 210,\n" +
                "      \"name\": \"设备使用记录\",\n" +
                "      \"tabUrl\": \"/checklists\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +



                "{\n" +
                "      \"id\": 326,\n" +
                "      \"parentId\": 200,\n" +
                "      \"name\": \"巡检管理\",\n" +
                "      \"iconSkin\": \"diy01\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/icons/icon_7.png\",\n" +
                "      \"Ico\": \"/assets/skin/icons/icon_7.png\"\n" +
                "    },\n" +

                "    {\n" +
                "      \"id\": 327,\n" +
                "      \"parentId\": 326,\n" +
                "      \"name\": \"巡检列表\",\n" +
                "      \"tabUrl\": \"PollingNoteManage/PollingNoteList.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": \"/assets/skin/icons/icon_7.png\"\n" +
                "    },\n" +
              
                "   {\n" +
                "      \"id\": 331,\n" +
                "      \"parentId\": 326,\n" +
                "      \"name\": \"计划提醒\",\n" +
                "      \"tabUrl\": \"PollingNoteManage/PollingRemind.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": \"/assets/skin/icons/icon_7.png\"\n" +
                "    },\n" +
                "{\n" +
                "      \"id\": 332,\n" +
                "      \"parentId\": 326,\n" +
                "      \"name\": \"计划实施\",\n" +
                "      \"tabUrl\": \"PollingNoteManage/PollingPlanImplement.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": \"/assets/skin/icons/icon_7.png\"\n" +
                "    },\n" +
            


                 "    {\n" +
                "      \"id\": 216,\n" +
                "      \"parentId\": 200,\n" +
                "      \"name\": \"维修管理\",\n" +
                "      \"iconSkin\": \"diy01\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/2.png\",\n" +
                "      \"Ico\": \"/assets/skin/2.png\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 225,\n" +
                "      \"parentId\": 216,\n" +
                "      \"name\": \"设备报修\",\n" +
                "      \"tabUrl\": \"/assets/Repair/Apply.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +
            
                "    {\n" +
                "      \"id\": 227,\n" +
                "      \"parentId\": 216,\n" +
                "      \"name\": \"维修响应\",\n" +
                "      \"tabUrl\": \"/assets/Repair/Reply.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +

          "    {\n" +
                "      \"id\": 226,\n" +
                "      \"parentId\": 216,\n" +
                "      \"name\": \"维修审核\",\n" +
                "      \"tabUrl\": \"/assets/Repair/Audit.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": \"/assets/skin/icons/icon_7.png\"\n" +
                "    },\n" +

                "    {\n" +
                "      \"id\": 254,\n" +
                "      \"parentId\": 216,\n" +
                "      \"name\": \"维修处理\",\n" +
                "      \"tabUrl\": \"/assets/Repair/Deal.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +

     "    {\n" +
                "      \"id\": 250,\n" +
                "      \"parentId\": 216,\n" +
                "      \"name\": \"维修考评\",\n" +
                "      \"tabUrl\": \"/assets/Repair/Accept.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +
                    "    {\n" +
                "      \"id\": 259,\n" +
                "      \"parentId\": 216,\n" +
                "      \"name\": \"维修查询\",\n" +    
                "      \"tabUrl\": \"/assets/Repair/Look.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +


                       "{\n" +
                "      \"id\": 220,\n" +
                "      \"parentId\": 200,\n" +
                "      \"name\": \"保养管理\",\n" +
                "      \"iconSkin\": \"diy01\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/3.png\",\n" +
                "      \"Ico\": \"/assets/skin/3.png\"\n" +
                "    },\n" +
 "{\n" +
                "      \"id\": 228,\n" +
                "      \"parentId\": 220,\n" +
                "      \"name\": \"计划制定\",\n" +
                "      \"tabUrl\": \"Maintenance/MaintenancePlans.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": \"/assets/skin/icons/icon_7.png\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 230,\n" +
                "      \"parentId\": 220,\n" +
                "      \"name\": \"计划提醒\",\n" +
                "      \"tabUrl\": \"Maintenance/MaintenanceRemind.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +
               

  "    {\n" +
                "      \"id\": 253,\n" +
                "      \"parentId\": 220,\n" +
                "      \"name\": \"计划实施\",\n" +
                "      \"tabUrl\": \"Maintenance/PlanExecuteList.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +
              

                "    {\n" +
                "      \"id\": 229,\n" +
                "      \"parentId\": 220,\n" +
                "      \"name\": \"异常处理\",\n" +
                "      \"tabUrl\": \"Maintenance/ExceptionHandlingList.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +

              


                 "{\n" +
                "      \"id\": 241,\n" +
                "      \"parentId\": 200,\n" +
                "      \"name\": \"计量管理\",\n" +
                "      \"iconSkin\": \"diy01\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/4.png\",\n" +
                "      \"Ico\": \"/assets/skin/4.png\"\n" +
                "    },\n" +

                "    {\n" +
                "      \"id\": 246,\n" +
                "      \"parentId\": 241,\n" +
                "      \"name\": \"计量计划\",\n" +
                "      \"tabUrl\": \"Check/Check.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +
           
                "    {\n" +
                "      \"id\": 247,\n" +
                "      \"parentId\": 241,\n" +
                "      \"name\": \"计量提醒\",\n" +
                "      \"tabUrl\": \"Check/CheckRemind.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +

  "    {\n" +
                "      \"id\": 248,\n" +
                "      \"parentId\": 241,\n" +
                "      \"name\": \"异常事件\",\n" +
                "      \"tabUrl\": \"Check/CheckExceptionHanding.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": \"/assets/skin/icons/icon_7.png\"\n" +
                "    },\n" +

                "  {\n" +
                "                        \"id\": 244,\n" +
                "                    \"parentId\": 242,\n" +
                "                    \"name\": \"报废申请\",\n" +
                "                    \"tabUrl\": \"EquRetire/EquRetireList.html\",\n" +
                "                    \"open\": \"false\",\n" +
                "                    \"target\": \"frmright\",\n" +
                "                    \"icon\": \"skin/titlebar_arrow.gif\",\n" +
                "                    \"Ico\": \"skin/icons/icon_7.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 251,\n" +
                "                    \"parentId\": 243,\n" +
                "                    \"name\": \"盘点信息\",\n" +
                "                    \"tabUrl\": \"Inventory/InventoryList.html\",\n" +
                "                    \"open\": \"false\",\n" +
                "                    \"target\": \"frmright\",\n" +
                "                    \"icon\": \"skin/titlebar_arrow.gif\",\n" +
                "                    \"Ico\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 301,\n" +
                "                    \"parentId\": 243,\n" +
                "                    \"name\": \"盘点历史\",\n" +
                "                    \"tabUrl\": \"AssetCheckNote/AssetCheckNoteList.html\",\n" +
                "                    \"open\": \"false\",\n" +
                "                    \"target\": \"frmright\",\n" +
                "                    \"icon\": \"skin/titlebar_arrow.gif\",\n" +
                "                    \"Ico\": \"skin/icons/icon_7.png\"\n" +
                "            },\n" +
                "\n" +
                "            {\n" +
                "                \"id\": 255,\n" +
                "                    \"parentId\": 242,\n" +
                "                    \"name\": \"报废审批\",\n" +
                "                    \"tabUrl\": \"EquRetire/RetireCheckList.html\",\n" +
                "                    \"open\": \"false\",\n" +
                "                    \"target\": \"frmright\",\n" +
                "                    \"icon\": \"skin/titlebar_arrow.gif\",\n" +
                "                    \"Ico\": \"skin/icons/icon_7.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 252,\n" +
                "                    \"parentId\": 243,\n" +
                "                    \"name\": \"盘点异常\",\n" +
                "                    \"tabUrl\": \"Inventory/InventoryAbnormalList.html\",\n" +
                "                    \"open\": \"false\",\n" +
                "                    \"target\": \"frmright\",\n" +
                "                    \"icon\": \"skin/titlebar_arrow.gif\",\n" +
                "                    \"Ico\": null\n" +
                "            },\n" +
                "\n" +
                "            {\n" +
                "                \"id\": 242,\n" +
                "                    \"parentId\": 200,\n" +
                "                    \"name\": \"设备报废\",\n" +
                "                    \"iconSkin\": \"diy01\",\n" +
                "                    \"open\": \"false\",\n" +
                "                    \"target\": \"frmright\",\n" +
                "                    \"icon\": \"skin/5.png\",\n" +
                "                    \"Ico\": \"skin/5.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 243,\n" +
                "                    \"parentId\": 200,\n" +
                "                    \"name\": \"资产盘点\",\n" +
                "                    \"iconSkin\": \"diy01\",\n" +
                "                    \"open\": \"false\",\n" +
                "                    \"target\": \"frmright\",\n" +
                "                    \"icon\": \"skin/9.png\",\n" +
                "                    \"Ico\": \"skin/9.png\"\n" +
                "            },\n" +



            "    {\n" +
                "      \"id\": 269,\n" +
                "      \"parentId\": 202,\n" +
                "      \"name\": \"供应商管理\",\n" +
                "      \"iconSkin\": \"diy01\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/6.png\",\n" +
                "      \"Ico\": \"/assets/skin/6.png\"\n" +
                "    },\n" +

                "    {\n" +
                "      \"id\": 209,\n" +
                "      \"parentId\": 269,\n" +
                "      \"name\": \"供应商管理\",\n" +
                "      \"tabUrl\": \"/assets/system/Supplier.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +

                "    {\n" +
                "      \"id\": 208,\n" +
                "      \"parentId\": 269,\n" +
                "      \"name\": \"厂家管理\",\n" +
                "      \"tabUrl\": \"system/Factory.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +
               
    
                "    {\n" +
                "      \"id\": 305,\n" +
                "      \"parentId\": 269,\n" +
                "      \"name\": \"配件管理\",\n" +
                "      \"tabUrl\": \"system/PartLibraryList.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": \"/assets/skin/icons/icon_7.png\"\n" +
                "    },\n" +
          
         



                "    {\n" +
                "      \"id\": 233,\n" +
                "      \"parentId\": 201,\n" +
                "      \"name\": \"图表分析\",\n" +
                "      \"iconSkin\": \"diy01\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/8.png\",\n" +
                "      \"Ico\": \"/assets/skin/8.png\"\n" +
                "    },\n" +
                 "    {\n" +
                "      \"id\": 240,\n" +
                "      \"parentId\": 233,\n" +
                "      \"name\": \"维修费用对比折线图\",\n" +
                "      \"tabUrl\": \"Report/RepairContrast.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +

                "    {\n" +
                "      \"id\": 263,\n" +
                "      \"parentId\": 233,\n" +
                "      \"name\": \"工程师工作量对比柱状图\",\n" +
                "      \"tabUrl\": \"Report/EngineerWork.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" + 
              

                "    {\n" +
                "      \"id\": 205,\n" +
                "      \"parentId\": 202,\n" +
                "      \"name\": \"系统设置\",\n" +
                "      \"iconSkin\": \"diy01\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/icons/icon_7.png\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +
             
                "    {\n" +
                "      \"id\": 236,\n" +
                "      \"parentId\": 205,\n" +
                "      \"name\": \"科室管理\",\n" +
                "      \"tabUrl\": \"/assets/system/Departments.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    },\n" +

        


                "    {\n" +
                "      \"id\": 237,\n" +
                "      \"parentId\": 205,\n" +
                "      \"name\": \"用户管理\",\n" +
                "      \"tabUrl\": \"/assets/system/UserList.html\",\n" +
                "      \"open\": \"false\",\n" +
                "      \"target\": \"frmright\",\n" +
                "      \"icon\": \"/assets/skin/titlebar_arrow.gif\",\n" +
                "      \"Ico\": null\n" +
                "    }\n" +
          
       
                "  ]\n" +
                "}";

        return ok(
                 j
        );
    }

    /**
     * Display the 'edit form' of a existing Device.
     *
     * @param id Id of the computer to edit
     */
    public static Result edit(Long id) {
       Form<Device> deviceForm = form(Device.class).fill(
            Device.find.byId(id)
        );
        return ok(
            editForm.render(id, deviceForm)
        );
    }

    public static Result details(Long id) {

                Device dev=Device.find.byId(id);
        return ok(Json.toJson(dev)
        );
    }

    /**
     * Handle the 'edit form' submission 
     *
     * @param id Id of the computer to edit
     */
    public static Result update(Long id) {
        Form<Device> deviceForm = form(Device.class).bindFromRequest();
        if(deviceForm.hasErrors()) {
            return badRequest(editForm.render(id, deviceForm));
        }
        deviceForm.get().update();   //2.4 update(id);
        flash("success", "Device " + deviceForm.get().product.name + " has been updated");
        return GO_HOME;
    }
    
    /**
     * Display the 'new computer form'.
     */
    public static Result create() {
        Form<Device> deviceForm = form(Device.class);
        return ok(
            createForm.render(deviceForm)
        );
    }
    
    /**
     * Handle the 'new computer form' submission 
     */
    public static Result save() {
        Form<Device> deviceForm = form(Device.class).bindFromRequest();  //bind params /device?id=123
        if(deviceForm.hasErrors()) {
            return badRequest(createForm.render(deviceForm));
        }
        deviceForm.get().save();
        flash("success", "Device " + deviceForm.get().name + " has been created");
        return GO_HOME;
    }
    
    /**
     * Handle computer deletion
     */
    public static Result delete(Long id) {
        Device.find.ref(id).delete();
        flash("success", "Device has been deleted");
        return GO_HOME;
    }









    public static Result worktime(int page, String sortBy, String order, String filter) {
        return ok(
                worktime.render(
                        Device.page(page, 10, sortBy, order, filter),
                        sortBy, order, filter
                )
        );
    }


    public static Result cost(int page, String sortBy, String order, String filter) {
        return ok(
                cost.render(
                        Device.page(page, 10, sortBy, order, filter),
                        sortBy, order, filter
                )
        );
    }
    public static Result crm(int page, String sortBy, String order, String filter) {
        return ok(
                crm.render(
                        Device.page(page, 10, sortBy, order, filter),
                        sortBy, order, filter
                )
        );
    }







}
            
