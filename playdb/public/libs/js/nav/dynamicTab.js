var positionType="none";
var positionContent="";
function createPosition(targetId,str){
	var $position=$(parent.window.document.getElementById(targetId));
	$position.html(str);
}
var TabOption = function() {
};
/**
 * TabView 配置参数
 */
TabOption.prototype = {
	containerId :'',// 容器ID,
	pageid :'',// pageId 页面 pageID
	cid :'',// 指定tab的id
	position :top,
	// tab位置，可为top和bottom，默认为top
	action : function(e, p) {
		 
	}
};
/**
 * Tab Item 配置参数
 * 
 * @return
 */
var TabItemOption = function() {
}
/**
 * Tab Item 配置参数
 */
TabItemOption.prototype = {
	id :'tab_',// tabId
	title :'',// tab标题
	url :'',// 该tab链接的URL
	iframeAddtion:'',
	isClosed :true// 该tab是否可以关闭
}
/**
 * @param {}
 *            option option 可选参数 containerId tab 容器ID pageid pageId 页面 pageID
 *            cid cid tab ID
 */
var pos=2;
var timer;
var tabTotalWidth=0;
var $trueContainer;
var $btnLeft;
var $btnRight;
var containerWidth=0;
var tabMenu;
var currentTabId;
function TabView(option) {
	tabMenu = $.rightClickMenu({ top: 100, left: 100, width: 120, items:
    [
    { text: uncompile(quiLanguage.dynamicTab.tabMenu1),click: tabMenuItemClick,id:1},
	{ line: true },
    { text: uncompile(quiLanguage.dynamicTab.tabMenu2),click: tabMenuItemClick,id:2 },
    { text: uncompile(quiLanguage.dynamicTab.tabMenu3),click: tabMenuItemClick,id:3 }
    ]
    });
	tabMenu2 = $.rightClickMenu({ top: 100, left: 100, width: 120, items:
    [
    { text: uncompile(quiLanguage.dynamicTab.tabMenu3),click: tabMenuItemClick,id:3 },
	{ text: uncompile(quiLanguage.dynamicTab.tabMenu2),click: tabMenuItemClick,id:2 },
	{ line: true },
	 { text: uncompile(quiLanguage.dynamicTab.tabMenu1),click: tabMenuItemClick,id:1}
    ]
    });
	var tab_context = {
		current :null,
		current_index :0,
		current_page :null
	};
	var op = new TabOption();
	$.extend(op, option);
	var bottom = op.position == "bottom" ? "_bottom" : "";
	this.id = op.cid;
	this.pid = op.pageid;
	this.tabs = null;
	this.tabContainer = null;
	this.iframeScroller=op.iframeScroller;
	var tabTemplate = '<table class="tab_item"  id="{0}" border="0" cellpadding="0" cellspacing="0"><tr>' + '<td class="tab_item1"></td>'
			+ '<td class="tab_item2 tab_title">{1}</td>' + '<td class="tab_item2"><div class="tab_close"></div></td>' + '<td class="tab_item3"></td>'
			+ '</tr></table>';
	var tabContainerTemplate = '<div class="benma_ui_tab" id="{0}"><div class="tab_hr"></div></div>';
	var page;
	page= '<iframe id="{0}" name="{3}" {2} allowTransparency="true" frameborder="0" width="100%" height="100%" src="{1}"></iframe>';
	if (op.position == "bottom") {
		tabTemplate = '<table class="tab_item_bottom"  id="{0}" border="0" cellpadding="0" cellspacing="0"><tr>' + '<td class="tab_item1_bottom"></td>'
				+ '<td class="tab_item2_bottom tab_title">{1}</td>' + '<td class="tab_item2_bottom"><div class="tab_close tab_close_bottom"></div></td>'
				+ '<td class="tab_item3_bottom"></td>' + '</tr></table>';
		tabContainerTemplate = '<div class="benma_ui_tab benma_ui_tab_bottom" id="{0}"><div class="tab_hr tab_hr_bottom"></div></div>';
	}
	//添加线
	$("#" + op.containerId).append(tabContainerTemplate.replace("{0}", this.id));
	
	$trueContainer=$('<div class="tabContainer"></div>');
	$btnLeft=$('<div class="tabButtonLeft" style="display:none;"></div>');
	$btnRight=$('<div class="tabButtonRight" style="display:none;"></div>');
	
	//添加容器
	$("#" + op.containerId).find(".benma_ui_tab").append($trueContainer);
	
	$("#" + op.containerId).find(".benma_ui_tab").append($btnLeft);
	$("#" + op.containerId).find(".benma_ui_tab").append($btnRight);
	containerWidth=$("#" + op.containerId).width();
	$(window).bind("resize",function(){
		containerWidth=$("#" + op.containerId).width();
		containerWidth=$("#" + op.containerId).width();
		if(tabTotalWidth+34>containerWidth){
			pos=containerWidth-tabTotalWidth-34;
			$trueContainer.css("left",pos)
			$btnLeft.fadeIn(200);
			$btnRight.fadeIn(200);
		}

		if(tabTotalWidth+62<containerWidth){
					pos=2;
					$trueContainer.css("left",pos)
					$btnLeft.fadeOut(200)
					$btnRight.fadeOut(200);
				}
	})
	
	
	
	$btnLeft.bind("mousedown",function(){
		containerWidth=$("#" + op.containerId).width();
		timer=setInterval(function(){
			if(pos>16){
				pos=16;
				clearInterval(timer);
				return;
			}
			pos=pos+8;
			$trueContainer.css("left",pos);
		},30)
	})
	$btnLeft.bind("mouseup",function(){
		clearInterval(timer);
	})
	
	$btnRight.bind("mousedown",function(){
		containerWidth=$("#" + op.containerId).width();
		timer=setInterval(function(){
			if(pos>16){
				pos=16;
				clearInterval(timer);
				return;
			}
			else if(pos<containerWidth-tabTotalWidth-34){
				pos=containerWidth-tabTotalWidth-34;
				clearInterval(timer);
				return;
			}
			pos=pos-8;
			$trueContainer.css("left",pos);
		},30)
	})
	$btnRight.bind("mouseup",function(){
		clearInterval(timer);
	})
	
	//处理每个tab的鼠标事件
	function initTab(el) {
		var theTab = $(el);
		tabTotalWidth=tabTotalWidth+$(theTab).width()+5;
		containerWidth=$("#" + op.containerId).width();
		if(tabTotalWidth+34>containerWidth){
			pos=containerWidth-tabTotalWidth-34;
			$trueContainer.css("left",pos)
			$btnLeft.fadeIn(200);
			$btnRight.fadeIn(200);
		}
		var tab_item1 = $(theTab).find(".tab_item1" + bottom);
		var tab_item2 = $(theTab).find(".tab_item2" + bottom);
		var tab_item3 = $(theTab).find(".tab_item3" + bottom);
		if (tab_context.current == null || tab_context.current != this) {
			$(theTab).mouseover( function() {
				tab_item1.addClass("tab_item1_mouseover" + bottom);
				tab_item2.addClass("tab_item2_mouseover" + bottom);
				tab_item3.addClass("tab_item3_mouseover" + bottom);
			}).mouseout( function() {
				tab_item1.removeClass("tab_item1_mouseover" + bottom);
				tab_item2.removeClass("tab_item2_mouseover" + bottom);
				tab_item3.removeClass("tab_item3_mouseover" + bottom);
			}).click( function() {
				if (tab_context.current != null) {
					$(tab_context.current).find(".tab_item1" + bottom).removeClass("tab_item1_selected" + bottom);
					$(tab_context.current).find(".tab_item2" + bottom).removeClass("tab_item2_selected" + bottom);
					$(tab_context.current).find(".tab_item3" + bottom).removeClass("tab_item3_selected" + bottom);
					$(tab_context.current).find(".tab_close").addClass("tab_close_noselected");
				}
				tab_item1.addClass("tab_item1_selected" + bottom);
				tab_item2.addClass("tab_item2_selected" + bottom);
				tab_item3.addClass("tab_item3_selected" + bottom);
				tab_context.current = this;
				$(tab_context.current).find(".tab_close").removeClass("tab_close_noselected");
				activate($(this).attr("id"), false);
			});
			if(bottom=="_bottom"){
				$(theTab).bind("contextmenu", function (e)
	            {
					currentTabId=$(this).attr("id");
					tabMenu2.show({ top: e.pageY-80, left: e.pageX });
	                return false;
	            });
			}
			else{
				$(theTab).bind("contextmenu", function (e)
	            {
					currentTabId=$(this).attr("id");
					tabMenu.show({ top: e.pageY, left: e.pageX });
	                return false;
	            });
			}
			var tab_close = $(theTab).find(".tab_close").mouseover( function() {
				$(this).addClass("tab_close_mouseover");
			}).mouseout( function() {
				$(this).removeClass("tab_close_mouseover");
			}).click( function() {
				close(theTab.attr("id"));
			});
		}
	}
	
	//激活标签
	function activate(id, isAdd) {
		
		if (isAdd) {
			//$("#" + id).trigger("click");
		}
		if (tab_context.current_page) {
			tab_context.current_page.hide();
		}
		tab_context.current_page = $("#page_" + id);
		tab_context.current_page.show();
		op.action($("#" + id), tab_context.current_page);
		
		$("body").trigger("dynamicTabActived",id);
	}
	//关闭标签
	function close(id) {
		var close_page = $("#page_" + id);
		var close_tab = $("#" + id);
		tabTotalWidth=tabTotalWidth-close_tab.width()-5;
		if ($(tab_context.current).attr("id") == close_tab.attr("id")) {
			var next = close_tab.next();
			if (next.attr("id")) {
				//activate(next.attr("id"), true);
				$("#" + next.attr("id")).trigger("click");				
			} else {
				var pre = close_tab.prev();
				if (pre.attr("id")) {
					//activate(pre.attr("id"), true);
					$("#" + pre.attr("id")).trigger("click");		
				}
			}
		} else {
		}
		// close_page.find("iframe").remove();
		close_page.remove();
		close_tab.remove();
		
		if(tabTotalWidth+62<containerWidth){
			pos=2;
			$trueContainer.css("left",pos)
			$btnLeft.fadeOut(200)
			$btnRight.fadeOut(200);
		}
		$("body").trigger("dynamicTabClose",id);
	}
	//初始化
	this.init = function() {
		this.tabContainer = $("#" + this.id);
		this.tabs = this.tabContainer.find(".tab_item" + bottom);
		this.tabs.each( function() {
			initTab(this);
		});
	}
	this.add = function(option) {
		var op1 = new TabItemOption();
		
		$.extend(op1, option);
		if($("#"+op1.id).length>0){
			//this.activate(op1.id);
			$("#" + op1.id).trigger("click");
			try{
				closeProgress();
			}
			catch(e){}
		}
		else{
			if (op1.title.length > 10) {
				op1.title = op1.title.substring(0, 10);
			}
			if (op1.title.length < 4) {
				op1.title = "&nbsp;&nbsp;" + op1.title + "&nbsp;";
			}
			var pageHtml;
			if(op1.iframeAddtion==""){
				pageHtml= page.replace("{0}", "page_" + op1.id).replace("{3}", "page_" + op1.id).replace("{1}", op1.url).replace("{2}", "");;
			}
			else{
				pageHtml= page.replace("{0}", "page_" + op1.id).replace("{3}", "page_" + op1.id).replace("{1}", op1.url).replace("{2}",op1.iframeAddtion);
			}
			$("#" + this.pid).append(pageHtml);
			var html = tabTemplate.replace("{0}", op1.id).replace("{1}", op1.title);
			this.tabContainer.find(".tabContainer").append(html);
			initTab($("#" + op1.id));
			if (!op1.isClosed) {
				$("#" + op1.id).find(".tab_close").hide();
				$("#" + op1.id).attr("closeable","false");
				$("#page_" + op1.id).attr("closeable","false");
			}
			// this.init();
			//this.activate(op1.id);
			$("#" + op1.id).trigger("click");
		}
		
	}
	this.update = function(option) {
		var id = option.id;
		// alert(option.url);
		$("#" + id).find(".tab_title").html(option.title);
		$("#" + id).trigger("click");
		// $("#page_" + id).find("iframe").attr("src", option.url);
		$("#page_" + id).attr("src", option.url);
		// document.getElementById()
	}
	this.activate = function(id) {
		 $("#" + id).trigger("click");
		 //activate(id, true);
		// alert(id)
		//$("#" + id).trigger("click");
	}
	this.close = function(id) {
		close(id);
	}
	this.init();
}

function closeOtherDynamicTab(id) {
		 $("#" + id).trigger("click");
		  $("#" + id).prevAll().each(function(i){
		  	if($(this).attr("closeable")=="false"){}
			else{
				tabTotalWidth=tabTotalWidth-$(this).width()-5;
				$(this).remove();
			}
		  })
		  $("#" + id).nextAll().each(function(i){
		  	if($(this).attr("closeable")=="false"){}
			else{
				tabTotalWidth=tabTotalWidth-$(this).width()-5;
				$(this).remove();
			}
		  })
		  
		  
		  $("#page_" + id).prevAll().each(function(i){
		  	if($(this).attr("closeable")=="false"){}
			else{
				$(this).remove();
			}
		  })
		  $("#page_" + id).nextAll().each(function(i){
		  	if($(this).attr("closeable")=="false"){}
			else{
				$(this).remove();
			}
		  })		  
		if(tabTotalWidth+62<containerWidth){
			pos=2;
			$trueContainer.css("left",pos)
			$btnLeft.fadeOut(200)
			$btnRight.fadeOut(200);
		}
		$("body").trigger("dynamicTabCloseOther",id);
	}
function closeAllDynamicTab(id) {
		  $("#" + id).parent().find(">table").each(function(i){
		  	if($(this).attr("closeable")=="false"){
				$(this).trigger("click");
			}
			else{
				tabTotalWidth=tabTotalWidth-$(this).width()-5;
				$(this).remove();
			}
		  })
		  $("#page_" + id).parent().find(">iframe").each(function(i){
		  	if($(this).attr("closeable")=="false"){}
			else{
				$(this).remove();
			}
		  })
		 	  
		if(tabTotalWidth+62<containerWidth){
			pos=2;
			$trueContainer.css("left",pos);
			$btnLeft.fadeOut(200);
			$btnRight.fadeOut(200);
		}
		$("body").trigger("dynamicTabCloseAll");
	}	
function iframeClickHandler(){
	tabMenu.hide();
	tabMenu2.hide();
}
function tabMenuItemClick(item, i)
{
    //top.Dialog.alert("菜单项："+item.text+"，点击行："+userName);
	if(item.id==1){
		document.getElementById("page_"+currentTabId).contentWindow.location.reload();
	}
	else if(item.id==2){
		closeOtherDynamicTab(currentTabId);
	}
	else if(item.id==3){
		closeAllDynamicTab(currentTabId);
	}
	
}
