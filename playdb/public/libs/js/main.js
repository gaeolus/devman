/*created by fukai */
var leftOverHeight=0;
var rightOverHeight=0;
var middleOverHeight=0;
var exitMenu=0;
var hexitMenu=0;
var progressFlag=0;
var oldBannerHeight=0;
var oldFootHeight=0;
var broswerFlag;
var broswerVersion;
var maskDiv;
var positionType="none";
var positionContent="";
var codePageMenu;
var _autoFormat=true;
var pResizeTimer = null;
var mainLayout;
var currentMouseX;
var currentMouseY;
$(function(){
	var mainFlag=1;
	var contentFlag=null;
	if(contentFlag!=null){
		alert("内容页面不可引入main.js！");
	}
	
	if($("#theme").attr("install")=="true"||$("#theme").attr("authorizeInfo")=="true"){
		alert("您的部署信息是："+document.location);
	}
	
	maskDiv = $('<div class="loadmask"></div>');
	$("#bs_right").append(maskDiv);
	//判断浏览器
	var userAgent = navigator.userAgent, 
	rMsie = /(msie\s|trident.*rv:)([\w.]+)/, 
	rFirefox = /(firefox)\/([\w.]+)/, 
	rOpera = /(opera).+version\/([\w.]+)/, 
	rChrome = /(chrome)\/([\w.]+)/, 
	rSafari = /version\/([\w.]+).*(safari)/;
	var browser;
	var version;
	var ua = userAgent.toLowerCase();
	function uaMatch(ua) {
		var match = rMsie.exec(ua);
		if (match != null) {
			return { browser : "IE", version : match[2] || "0" };
		}
		var match = rFirefox.exec(ua);
		if (match != null) {
			return { browser : match[1] || "", version : match[2] || "0" };
		}
		var match = rOpera.exec(ua);
		if (match != null) {
			return { browser : match[1] || "", version : match[2] || "0" };
		}
		var match = rChrome.exec(ua);
		if (match != null) {
			return { browser : match[1] || "", version : match[2] || "0" };
		}
		var match = rSafari.exec(ua);
		if (match != null) {
			return { browser : match[2] || "", version : match[1] || "0" };
		}
		if (match != null) {
			return { browser : "", version : "0" };
		}
	}
	var browserMatch = uaMatch(userAgent.toLowerCase());
	if (browserMatch.browser) {
		browser = browserMatch.browser;
		version = browserMatch.version;
	}
	if(browser=="IE"){
		if(version=="6.0"){
			broswerFlag="IE6";
		}
		else if(version=="7.0"){
			broswerFlag="IE7";
		}
		else if(version=="8.0"){
			broswerFlag="IE8";
		}
		else if(version=="9.0"){
			broswerFlag="IE9";
		}
		else if(version=="10.0"){
			broswerFlag="IE10";
		}
		else if(version=="11.0"){
			broswerFlag="IE11";
		}
	}
	else{
		broswerFlag=browser;
	}
	broswerVersion=Number(version.split(".")[0]);
	
	var ie6detect=$("#theme").attr("ie6detect");
	if(ie6detect!=null&&ie6detect!=""){
		if(broswerFlag=="IE6"){
			top.Dialog.open({URL:ie6detect,Title:uncompile(quiLanguage.jsError.ieDetectTitle),Width:360,Height:210,ShowCloseButton:false,CloseHideScroller:true});
		}
	}
	var ie7detect=$("#theme").attr("ie7detect");
	if(ie7detect!=null&&ie7detect!=""){
		if(broswerFlag=="IE7"){
			top.Dialog.open({URL:ie7detect,Title:uncompile(quiLanguage.jsError.ieDetectTitle),Width:360,Height:210,ShowCloseButton:false,CloseHideScroller:true});
		}
	}
	
	var ie8detect=$("#theme").attr("ie8detect");
	if(ie8detect!=null&&ie8detect!=""){
		if(broswerFlag=="IE8"){
			top.Dialog.open({URL:ie8detect,Title:uncompile(quiLanguage.jsError.ieDetectTitle),Width:360,Height:210,ShowCloseButton:false,CloseHideScroller:true});
		}
	}
	
	if($("#theme").attr("autoFormat")=="false"||$("#theme").attr("autoFormat")==false){
		_autoFormat=false;
	}
	
	oldBannerHeight=$("#bs_bannercenter").outerHeight();
	oldFootHeight=$("#fbox").outerHeight();
	
	
	if(_autoFormat==true){
		var ht = document.getElementsByTagName('html')[0];
		ht.style.overflow = 'hidden';
		firstReset();
		window.onresize = function(){
			if ( pResizeTimer ) clearTimeout (pResizeTimer);
	   		pResizeTimer = setTimeout ("autoReset()", 100);
		}
	}
	
	
	//渲染分隔条
	$(".spliter").each(function(){
		$(this).spliterRender();
	})
   
   //处理字体
	var font=12;
	var fontFamily="宋体";
	if($("#theme").attr("defaultFontSize")!=null){
		font=Number($("#theme").attr("defaultFontSize"));
	}
	if($("#theme").attr("defaultFontFamily")!=null){
		fontFamily=$("#theme").attr("defaultFontFamily");
	}
	try {
		var cookFont=jQuery.jCookie('fontSize');
		var cookFontFamily=jQuery.jCookie('fontFamily');
		if(cookFont!=false){
			font=parseInt(cookFont);
		}
		if(cookFontFamily!=false){
			fontFamily=cookFontFamily;
		}
	}
	catch(e){}
	if(font==12){
		$(".fontChange").eq(2).find("a").addClass("fontChange_cur");
	}
	else if(font==14){
		$(".fontChange").eq(1).find("a").addClass("fontChange_cur");
	}
	else if(font==16){
		$(".fontChange").eq(0).find("a").addClass("fontChange_cur");
	}	
	
	if(fontFamily=="宋体"){
		$(".fontFamily").eq(0).find("a").addClass("fontChange_cur");
	}
	else if(fontFamily=="微软雅黑"){
		$(".fontFamily").eq(1).find("a").addClass("fontChange_cur");
	}	

	$(".fontChange a").each(function(){
		$(this).click(function(){
			$(".fontChange a").removeClass("fontChange_cur");
			$(this).addClass("fontChange_cur");
			var num=parseInt($(this).attr("setFont"));
			$("#theme").attr("defaultFontSize",num);
			jQuery.jCookie('fontSize',num);
			try {
				document.getElementById("frmright").contentWindow.changeFont(num);
			}
			catch(e){}
			try {
				document.getElementById("frmleft").contentWindow.changeFont(num);
			}
			catch(e){}
			try {
				document.getElementById("frmmiddle").contentWindow.changeFont(num);
			}
			catch(e){}
		});
	});
	
	$(".fontFamily a").each(function(){
		$(this).click(function(){
			$(".fontFamily a").removeClass("fontChange_cur");
			$(this).addClass("fontChange_cur");
			var fontName=$(this).attr("setFont");
			$("#theme").attr("defaultFontFamily",fontName)
			jQuery.jCookie('fontFamily',fontName);
			try {
				document.getElementById("frmright").contentWindow.changeFontFamily(fontName);
			}
			catch(e){}
			try {
				document.getElementById("frmleft").contentWindow.changeFontFamily(fontName);
			}
			catch(e){}
			try {
				document.getElementById("frmmiddle").contentWindow.changeFontFamily(fontName);
			}
			catch(e){}
		});
	});

	//弹出菜单
	if($(".popupMenu").length>0){
		$(".popupMenu").popupMenuRender();
	}
	$("#fullSrceen").fullSrceenRender();
	var $layout=$("#mainLayout");
	if($layout.length>0){
		var leftWidth=210;
		var rightWidth=170;
		var isLeftCollapse=false;
		var isRightCollapse=false;
		var allowLeftResize=true;
		var allowRightResize=true;
		var space=10;
		var minLeftWidth=150;
		var maxLeftWidth=400;
		var minRightWidth=150;
		var maxRightWidth=400;
		if($layout.attr("leftWidth")){
			leftWidth=Number($layout.attr("leftWidth"));
		}
		if($layout.attr("rightWidth")){
			rightWidth=Number($layout.attr("rightWidth"));
		}
		if($layout.attr("space")){
			space=Number($layout.attr("space"));
		}
		if($layout.attr("minLeftWidth")){
			minLeftWidth=Number($layout.attr("minLeftWidth"));
		}
		if($layout.attr("maxLeftWidth")){
			maxLeftWidth=Number($layout.attr("maxLeftWidth"));
		}
		if($layout.attr("minRightWidth")){
			minRightWidth=Number($layout.attr("minRightWidth"));
		}
		if($layout.attr("maxRightWidth")){
			maxRightWidth=Number($layout.attr("maxRightWidth"));
		}
		if($layout.attr("isLeftCollapse")=="true"||$layout.attr("isLeftCollapse")==true){
			isLeftCollapse=true;
		}
		if($layout.attr("isRightCollapse")=="true"||$layout.attr("isRightCollapse")==true){
			isRightCollapse=true;
		}
		if($layout.attr("allowLeftResize")=="false"||$layout.attr("allowLeftResize")==false){
			allowLeftResize=false;
		}
		if($layout.attr("allowRightResize")=="false"||$layout.attr("allowRightResize")==false){
			allowRightResize=false;
		}
		if(broswerFlag=="IE6"){
			allowLeftResize=false;
			allowRightResize=false;
		}
		mainLayout=$("#mainLayout").quiLayout({
			leftWidth:leftWidth,
			rightWidth:rightWidth,
			isLeftCollapse:isLeftCollapse,
			isRightCollapse:isRightCollapse,
			allowLeftResize:allowLeftResize,
			allowRightResize:allowRightResize,
			space:space,
			minLeftWidth:minLeftWidth,
			maxLeftWidth:maxLeftWidth,
			minRightWidth:minRightWidth,
			maxRightWidth:maxRightWidth
		});
	}
	
	
});
$.fn.popupMenuRender = function() {
	$(this).hover(function(){
		$(this).find(".popupMenu_con").show();
	},function(){
		$(this).find(".popupMenu_con").hide();
	});
};

jQuery.fn.extend({
	fullSrceenRender:function(){
		var $instance=$(this);
		var hideNav=false;
		var modernFullScreen=true;
		if($instance.attr("hideNav")=="true"||$(this).attr("hideNav")==true){
			hideNav=true;
		}
		if($instance.attr("modernFullScreen")=="false"||$(this).attr("modernFullScreen")==false){
			modernFullScreen=false;
		}
		else{
			if(broswerFlag=="IE6"||broswerFlag=="IE7"||broswerFlag=="IE8"){
				modernFullScreen=false;
			}
		}
		if(modernFullScreen){
			$instance.click(function(){
				if (RunPrefixMethod(document, "FullScreen") || RunPrefixMethod(document, "IsFullScreen")) {
					RunPrefixMethod(document, "CancelFullScreen");
					autoReset();
				}
				else {
					RunPrefixMethod($("body")[0], "RequestFullScreen");
					autoReset();
				}
			})
		}
		else{
			var beforeClickText=$instance.text();
			var afterClickText=uncompile(quiLanguage.fullScreen.exit);
			if($instance.attr("afterClickText")){
				afterClickText=$instance.attr("afterClickText");
			}
			
			var beforeClickStyle=$instance.attr("class");
			
			var afterClickStyle="icon_actualscreen hand";
			if($instance.attr("afterClickStyle")){
				afterClickStyle=$instance.attr("afterClickStyle");
			}
			
			$instance.toggle(function(){
				$("#bs_bannercenter").hide();
				$("#bs_bannercenter").height(0);
				if(broswerFlag!="IE6"){
					$("#fbox").hide();
					$("#fbox").height(0);
				}
				else{
					//$(".fontChange").hide();
					//$(".fontTitle").hide();
					//$("#fbox").hide();
					//$("#fbox").height(0);
				}
				if(hideNav){
					if($("#mainLayout").length>0){
						mainLayout.setLeftCollapse(true); 
						mainLayout.setRightCollapse(true); 
					}
					else{
						$(".spliter").spliterClose();
					}
				}
				autoReset();
				$(this).text(afterClickText);
				$(this).removeClass(beforeClickStyle);
				$(this).addClass(afterClickStyle);
			},function(){
				$("#bs_bannercenter").show();
				$("#fbox").show();
				$("#bs_bannercenter").height(oldBannerHeight);
				$("#fbox").height(oldFootHeight);
				if(hideNav){
					if($("#mainLayout").length>0){
						mainLayout.setLeftCollapse(false); 
						mainLayout.setRightCollapse(false); 
					}
					else{
						$(".spliter").spliterOpen();
					}
				}
				autoReset();
				$(this).text(beforeClickText);
				$(this).removeClass(afterClickStyle);
				$(this).addClass(beforeClickStyle);
			});
		}
		
		
	},
	buttonInputRender:function() {
		if(!$(this).attr("class")){
			$(this).addClass("button");
		}
		var btnTextNum=_getStrLength($(this).val());
		if($(this).attr("useMinWidth")=="false"||$(this).attr("useMinWidth")==false){}
		else{
			if(btnTextNum<5){
				$(this).width(60);
			}
		}
		$(this).hover(
			function() {
					$(this).addClass("button_hover");
				},
			function(){
					$(this).removeClass("button_hover");
				}
		);

		if($(this).attr("toggle")=="true"||$(this).attr("toggle")==true){
			//创建隐藏域
			var $hidden = $("<input type='hidden'/>");
			if($(this).attr("name")!=null){
				$hidden.attr("name",$(this).attr("name"));
			}
			$(this).after($hidden);
			var toggleValue=0;
			if($(this).attr("relValue")=="1"){
				toggleValue=1;
			}
			$(this).attr("relValue",toggleValue);
			$hidden.attr("relValue",toggleValue);
			if(toggleValue==0){
				$(this).toggle(function(){
					$(this).addClass("toggle");
					$(this).attr("relValue",1);
					$hidden.attr("relValue",1);
				},function(){
					$(this).removeClass("toggle");
					$(this).attr("relValue",0);
					$hidden.attr("relValue",0);
				})
			}
			else{
				$(this).addClass("toggle");
				$(this).toggle(function(){
					$(this).removeClass("toggle");
					$(this).attr("relValue",0);
					$hidden.attr("relValue",0);
				},function(){
					$(this).addClass("toggle");
					$(this).attr("relValue",1);
					$hidden.attr("relValue",1);
				})
			}
		}
	},
	
	buttonRender:function() {
			$(this).addClass("button");
			var btnTextNum=_getStrLength($(this).text());
			var textNum=0;
			var textWidth=50;
			textNum=_getStrLength($(this).filter(":has(span)").find("span").text());
			if(textNum!=0){
				textWidth=20+7*textNum+10;
			}
			if(broswerFlag=="Firefox"||broswerFlag=="Opera"||broswerFlag=="Safari"){
				$(this).filter(":has(span)").css({
					"paddingLeft":"5px",
					"width":textWidth+8+"px"
				});
			}
			else{
				$(this).filter(":has(span)").css({
					"paddingLeft":"5px",
					"width":textWidth+"px"
				});
			}
			if(btnTextNum<5){
				$(this).width(66);
			}
			
			$(this).filter(":has(span)").find("span").css({
				"cursor":"default"
			});
			
			$(this).hover(
				function() {
						$(this).addClass("button_hover");
					},
				function(){
						$(this).removeClass("button_hover");
					}
			);
	}
});
var pfx = ["webkit", "moz", "ms", "o", ""];
function RunPrefixMethod(obj, method) {
	
	var p = 0, m, t;
	while (p < pfx.length && !obj[m]) {
		m = method;
		if (pfx[p] == "") {
			m = m.substr(0,1).toLowerCase() + m.substr(1);
		}
		m = pfx[p] + m;
		t = typeof obj[m];
		if (t != "undefined") {
			pfx = [pfx[p]];
			return (t == "function" ? obj[m]() : obj[m]);
		}
		p++;
	}

}
//用于外部调用的全屏方法
function fullScrennHander(state,hideNav,modernFullScreen){
	if(modernFullScreen){
		if(state==true){
			RunPrefixMethod($("body")[0], "RequestFullScreen");
		}
		else if(state==false){
			RunPrefixMethod(document, "CancelFullScreen");
		}
	}
	else{
		if(state==true){
			$("#bs_bannercenter").hide();
				$("#bs_bannercenter").height(0);
				if(broswerFlag!="IE6"){
					$("#fbox").hide();
					$("#fbox").height(0);
				}
				else{
					//$(".fontChange").hide();
					//$(".fontTitle").hide();
					//$("#fbox").hide();
					//$("#fbox").height(0);
				}
				if(hideNav){
					if($("#mainLayout").length>0){
						mainLayout.setLeftCollapse(true); 
						mainLayout.setRightCollapse(true); 
					}
					else{
						$(".spliter").spliterClose();
					}
				}
				autoReset();
		}
		else if(state==false){
			$("#bs_bannercenter").show();
			$("#fbox").show();
			$("#bs_bannercenter").height(oldBannerHeight);
			$("#fbox").height(oldFootHeight);
			if(hideNav!=null){
				if(hideNav==true){
					if($("#mainLayout").length>0){
						mainLayout.setLeftCollapse(false); 
						mainLayout.setRightCollapse(false); 
					}
					else{
						$(".spliter").spliterOpen();
					}
				}
			}
		}
	}
	
}

/*iframe自适应高度*/
function iframeHeight(iframeId){
	var frm=document.getElementById(iframeId);
	frm.style.height =frm.contentWindow.document.body.scrollHeight+"px";
	
}
/*iframe自适应高度*/

function createPosition(targetId,str){
	var $position=$("#"+targetId);
	$position.html(str);
}

function getFontSize(){
	var font=jQuery.jCookie('fontSize');
	var fontSize;
	if(font!=false){
		fontSize=parseInt(font);
	}
	else{
		if($("#theme").attr("defaultFontSize")!=null){
			fontSize=Number($("#theme").attr("defaultFontSize"));
		}
	}
	return fontSize;
}

function getFontFamily(){
	var fontFamilyCook=jQuery.jCookie('fontFamily');
	var fontFamily;
	if(fontFamilyCook!=false){
		fontFamily=fontFamilyCook;
	}
	else{
		if($("#theme").attr("defaultFontFamily")!=null){
			fontFamily=$("#theme").attr("defaultFontFamily");
		}
	}
	return fontFamily;
}

function firstReset(){
	leftOverHeight=$("#hbox").outerHeight()+$("#fbox").outerHeight()+$("#lbox_topcenter").outerHeight()+$("#lbox_bottomcenter").outerHeight();
	rightOverHeight=$("#hbox").outerHeight()+$("#fbox").outerHeight()+$("#rbox_topcenter").outerHeight()+$("#rbox_bottomcenter").outerHeight();
	middleOverHeight=$("#hbox").outerHeight()+$("#fbox").outerHeight()+$("#mbox_topcenter").outerHeight()+$("#mbox_bottomcenter").outerHeight();
	var currentheight =document.documentElement.clientHeight;
	var currentwidth =document.documentElement.clientWidth;
	try {
			var leftHeight= currentheight-leftOverHeight-parseInt($("#lbox").css("paddingTop"))-parseInt($("#lbox").css("paddingBottom"));
			$("#bs_left").height(leftHeight);
        } 
     catch (e) {}
	 try {
			 var rightHeight= currentheight-rightOverHeight-parseInt($("#rbox").css("paddingTop"))-parseInt($("#rbox").css("paddingBottom"));
			 $("#bs_right").height(rightHeight);
        } 
     catch (e) {}
	 try {
			var middleHeight= currentheight-middleOverHeight-parseInt($("#mbox").css("paddingTop"))-parseInt($("#mbox").css("paddingBottom"));
			$("#bs_middle").height(middleHeight);
        } 
     catch (e) {}
	 try {
		mainResizeHandler(currentheight,currentwidth);
	}
	catch(e){}
}

function autoReset(){
	leftOverHeight=$("#hbox").outerHeight()+$("#fbox").outerHeight()+$("#lbox_topcenter").outerHeight()+$("#lbox_bottomcenter").outerHeight();
	rightOverHeight=$("#hbox").outerHeight()+$("#fbox").outerHeight()+$("#rbox_topcenter").outerHeight()+$("#rbox_bottomcenter").outerHeight();
	middleOverHeight=$("#hbox").outerHeight()+$("#fbox").outerHeight()+$("#mbox_topcenter").outerHeight()+$("#mbox_bottomcenter").outerHeight();
	 var currentheight =document.documentElement.clientHeight;
	 var currentwidth =document.documentElement.clientWidth;
	  try {
			var leftHeight= currentheight-leftOverHeight-parseInt($("#lbox").css("paddingTop"))-parseInt($("#lbox").css("paddingBottom"));
			$("#bs_left").height(leftHeight);
			document.getElementById("frmleft").contentWindow._customHeightSet(leftHeight);
        } 
     catch (e) {}
	 try {
			 var rightHeight= currentheight-rightOverHeight-parseInt($("#rbox").css("paddingTop"))-parseInt($("#rbox").css("paddingBottom"));
			 $("#bs_right").height(rightHeight);
			document.getElementById("frmright").contentWindow._customHeightSet(rightHeight);
			 
			
        } 
     catch (e) {}
	 try {
			var middleHeight= currentheight-middleOverHeight-parseInt($("#mbox").css("paddingTop"))-parseInt($("#mbox").css("paddingBottom"));
			$("#bs_middle").height(middleHeight);
			document.getElementById("frmmiddle").contentWindow._customHeightSet(middleHeight);
        } 
     catch (e) {}
	 try {
		mainResizeHandler(currentheight,currentwidth);
	}
	catch(e){}
	if($("#mainLayout").length>0){
		mainLayout._onResize();
	}
}


jQuery.jCookie = function(sCookieName_, oValue_, oExpires_, oOptions_) {
	
	if (!navigator.cookieEnabled) { return false; }
	
	var oOptions_ = oOptions_ || {};
	if (typeof(arguments[0]) !== 'string' && arguments.length === 1) {
		oOptions_ = arguments[0];
		sCookieName_ = oOptions_.name;
		oValue_ = oOptions_.value;
		oExpires_ = oOptions_.expires;
	}
	
	sCookieName_ = encodeURI(sCookieName_);
	
	if (oValue_ && (typeof(oValue_) !== 'number' && typeof(oValue_) !== 'string' && oValue_ !== null)) { return false; }
	
	var _sPath = oOptions_.path ? "; path=" + oOptions_.path : "";
	var _sDomain = oOptions_.domain ? "; domain=" + oOptions_.domain : "";
	var _sSecure = oOptions_.secure ? "; secure" : "";
	var sExpires_ = "";
	
	if (oValue_ || (oValue_ === null && arguments.length == 2)) {
	
		oExpires_ = (oExpires_ === null || (oValue_ === null && arguments.length == 2)) ? -1 : oExpires_;
		
		if (typeof(oExpires_) === 'number' && oExpires_ != 'session' && oExpires_ !== undefined) {
			var _date = new Date();
			_date.setTime(_date.getTime() + (oExpires_ * 24 * 60 * 60 * 1000));
			sExpires_ = ["; expires=", _date.toGMTString()].join("");
		}
		document.cookie = [sCookieName_, "=", encodeURI(oValue_), sExpires_, _sDomain, _sPath, _sSecure].join("");
		
		return true;
	}
	
	if (!oValue_ && typeof(arguments[0]) === 'string' && arguments.length == 1 && document.cookie && document.cookie.length) {
		var _aCookies = document.cookie.split(';');
		var _iLenght = _aCookies.length;
		while (_iLenght--) {
			var _aCurrrent = _aCookies[_iLenght].split("=");
			if (jQuery.trim(_aCurrrent[0]) === sCookieName_) { return decodeURI(_aCurrrent[1]); }
		}
	}
	
	return false;
};
function showProgressBar(str,type){
	var titleStr=uncompile(quiLanguage.progressBar.title);
	if(str){
		titleStr=str;
	}
	var progressType="simple";
	if(type){
		if(type=="normal"){
			progressType=type;
		}
	}
	if(progressType=="simple"){
		top.progressFlag=2;
		top.showSimpleProgress(titleStr,0,true,"#ffffff");
	}
	else{
		top.progressFlag=1;
		var diag = new top.Dialog();
		diag.Width = 360;
		diag.Height = 70;
		diag.Title = titleStr;
		diag.InvokeElementId="progress"
		diag.show();
	}
};
function showSimpleProgress(title,delay,useloading,bgcolor){
	$("#bs_right").mask(title,delay,useloading,bgcolor);
};
function hideSimpleProgress(){
	$("#bs_right").unmask();
};

//遮罩
;(function($){
	$.fn.mask = function(label, delay, loading, bgcolor){
		$(this).each(function() {
			if(loading==null){
				loading=true;
			}
			var bgcolorValue="#cccccc";
			if(bgcolor){
				bgcolorValue=bgcolor;
			}
			if(delay !== undefined && delay > 0&& delay !=null) {
		        var element = $(this);
		        element.data("_mask_timeout", setTimeout(function() { $.maskElement(element, label ,loading, bgcolorValue)}, delay));
			} else {
				$.maskElement($(this), label, loading, bgcolorValue);
			}
		});
	};
	
	$.fn.unmask = function(){
		$(this).each(function() {
			$.unmaskElement($(this));
		});
	};
	
	$.fn.isMasked = function(){
		return this.hasClass("masked");
	};

	$.maskElement = function(element, label,loading ,bgcolor){
		maskDiv.show();
		var eleHeight=Math.round(element.height() / 2 - 30);
		var eleWidth=Math.round(element.width() / 2 - 100);
		if (element.data("_mask_timeout") !== undefined) {
			clearTimeout(element.data("_mask_timeout"));
			element.removeData("_mask_timeout");
		}

		if(element.isMasked()) {
			$.unmaskElement(element);
		}
		
		if(element.css("position") == "static") {
			element.addClass("masked-relative");
		}
		
		element.addClass("masked");
		
		
		
		maskDiv.css({
			"backgroundColor":bgcolor
		})
		
		if(navigator.userAgent.toLowerCase().indexOf("msie") > -1){
			maskDiv.height(element.height() + parseInt(element.css("padding-top")) + parseInt(element.css("padding-bottom")));
			maskDiv.width(element.width() + parseInt(element.css("padding-left")) + parseInt(element.css("padding-right")));
		}
		
		if(navigator.userAgent.toLowerCase().indexOf("msie 6") > -1){
			element.find("select").addClass("masked-hidden");
		}
		
		
		if(label !== undefined&&label!=null) {
			var maskMsgDiv = $('<div class="loadmask-msg" style="display:none;"></div>');
			if(loading){
				maskMsgDiv.append('<div class="mask_lading">' + label + '</div>');
			}
			else{
				maskMsgDiv.append('<div  class="normal">' + label + '</div>');
			}
			element.append(maskMsgDiv);
			
			maskMsgDiv[0].style.top=eleHeight  +"px";
			maskMsgDiv[0].style.left=eleWidth+"px";
			
			maskMsgDiv[0].style.display="";
		}
		
	};
	
	$.unmaskElement = function(element){
		if (element.data("_mask_timeout") !== undefined) {
			clearTimeout(element.data("_mask_timeout"));
			element.removeData("_mask_timeout");
		}
		
		element.find(".loadmask-msg").remove();
		element.removeClass("masked");
		element.removeClass("masked-relative");
		element.find("select").removeClass("masked-hidden");
		maskDiv.hide();
	};
 
})(jQuery);
/*可调用的提示*/
if(jQuery) {
	( function($) {
	$.cursorMessageData = {}; // needed for e.g. timeoutId

	$(window).ready(function(e) {
		if ($('#cursorMessageDiv').length==0) {
			
			   $('body').append('<div id="cursorMessageDiv">&nbsp;</div>');
			  $('#cursorMessageDiv').hide();
		}

		$('body').mousemove(function(e) {
			$.cursorMessageData.mouseX = e.pageX;
			$.cursorMessageData.mouseY = e.pageY;
			currentMouseX = e.pageX;
			currentMouseY = e.pageY;
			if ($.cursorMessageData.options != undefined) $._showCursorMessage();
		});
	});
	$.extend({
		cursorMessage: function(message, options) {
			if( options == undefined ) options = {};
			if( options.offsetX == undefined ) options.offsetX = 5;
			if( options.offsetY == undefined ) options.offsetY = 5;
			if( options.hideTimeout == undefined ) options.hideTimeout = 3000;

			$('#cursorMessageDiv').html(message).show();
			if (jQuery.cursorMessageData.hideTimeoutId != undefined)  clearTimeout(jQuery.cursorMessageData.hideTimeoutId);
			if (options.hideTimeout>0) jQuery.cursorMessageData.hideTimeoutId = setTimeout($.hideCursorMessage, options.hideTimeout);
			jQuery.cursorMessageData.options = options;
			$._showCursorMessage();
		},
		hideCursorMessage: function() {
			$('#cursorMessageDiv').hide();
		},
		_showCursorMessage: function() {
			$('#cursorMessageDiv').css({ top: ($.cursorMessageData.mouseY + $.cursorMessageData.options.offsetY)+'px', left: ($.cursorMessageData.mouseX + $.cursorMessageData.options.offsetX) });
		}
	});
})(jQuery);
}
/*可调用的提示*/
(function ($)
{
    //quiui 继承方法
    Function.prototype.quiExtend = function (parent, overrides)
    {
        if (typeof parent != 'function') return this;
        //保存对父类的引用
        this.base = parent.prototype;
        this.base.constructor = parent;
        //继承
        var f = function () { };
        f.prototype = parent.prototype;
        this.prototype = new f();
        this.prototype.constructor = this;
        //附加属性方法
        if (overrides) $.extend(this.prototype, overrides);
    };
    //延时加载
    Function.prototype.quiDefer = function (o, defer, args)
    {
        var fn = this;
        return setTimeout(function () { fn.apply(o, args || []); }, defer);
    };

    // 核心对象
    window.qui = $.quiui = {
        version: 'QUI3.1',
        managerCount: 0,
        //组件管理器池
        managers: {},
        managerIdPrev: 'quiui',
		
		
        //错误提示
        error: {
            managerIsExist: uncompile(quiLanguage.jsError.idInfo)
        },
        getId: function (prev)
        {
            prev = prev || this.managerIdPrev;
            var id = prev + (1000 + this.managerCount);
            this.managerCount++;
            return id;
        },
        add: function (manager)
        {
            if (arguments.length == 2)
            {
                var m = arguments[1];
                m.id = m.id || m.options.id || arguments[0].id;
                this.addManager(m);
                return;
            }
            if (!manager.id) manager.id = this.getId(manager.__idPrev());
            if (this.managers[manager.id])
                throw new Error(this.error.managerIsExist);
            this.managers[manager.id] = manager;
        },
        remove: function (arg)
        {
            if (typeof arg == "string" || typeof arg == "number")
            {
                delete $.quiui.managers[arg];
            }
            else if (typeof arg == "object" && arg instanceof $.quiui.core.Component)
            {
                delete $.quiui.managers[arg.id];
            }
        },
        //获取quiui对象
        //1,传入quiui ID
        //2,传入Dom Object Array(jQuery)
        get: function (arg, idAttrName)
        {
            idAttrName = idAttrName || "quiuiid";
            if (typeof arg == "string" || typeof arg == "number")
            {
                return $.quiui.managers[arg];
            }
            else if (typeof arg == "object" && arg.length)
            {
                if (!arg[0][idAttrName] && !$(arg[0]).attr(idAttrName)) return null;
                return $.quiui.managers[arg[0][idAttrName] || $(arg[0]).attr(idAttrName)];
            }
            return null;
        },
        //根据类型查找某一个对象
        find: function (type)
        {
            var arr = [];
            for (var id in this.managers)
            {
                var manager = this.managers[id];
                if (type instanceof Function)
                {
                    if (manager instanceof type)
                    {
                        arr.push(manager);
                    }
                }
                else if (type instanceof Array)
                {
                    if ($.inArray(manager.__getType(), type) != -1)
                    {
                        arr.push(manager);
                    }
                }
                else
                {
                    if (manager.__getType() == type)
                    {
                        arr.push(manager);
                    }
                }
            }
            return arr;
        },
        //$.fn.qui{Plugin} 和 $.fn.quiGet{Plugin}Manager
        //会调用这个方法,并传入作用域(this)
        //@parm [plugin]  插件名
        //@parm [args] 参数(数组)
        //@parm [ext] 扩展参数,定义命名空间或者id属性名
        run: function (plugin, args, ext)
        {
            if (!plugin) return;
            ext = $.extend({
                defaultsNamespace: 'quiDefaults',
                methodsNamespace: 'quiMethods',
                controlNamespace: 'controls',
                idAttrName: 'quiuiid',
                isStatic: false,
                hasElement: true,           //是否拥有element主体(比如drag、resizable等辅助性插件就不拥有)
                propertyToElemnt: null      //链接到element的属性名
            }, ext || {});
            plugin = plugin.replace(/^quiGet/, '');
            plugin = plugin.replace(/^qui/, '');
            if (this == null || this == window || ext.isStatic)
            {
                if (!$.quiui.plugins[plugin])
                {
                    $.quiui.plugins[plugin] = {
                        fn: $['qui' + plugin],
                        isStatic: true
                    };
                }
                return new $.quiui[ext.controlNamespace][plugin]($.extend({}, $[ext.defaultsNamespace][plugin] || {}, $[ext.defaultsNamespace][plugin + 'String'] || {}, args.length > 0 ? args[0] : {}));
            }
            if (!$.quiui.plugins[plugin])
            {
                $.quiui.plugins[plugin] = {
                    fn: $.fn['qui' + plugin],
                    isStatic: false
                };
            }
            if (/Manager$/.test(plugin)) return $.quiui.get(this, ext.idAttrName);
            this.each(function ()
            {
                if (this[ext.idAttrName] || $(this).attr(ext.idAttrName))
                {
                    var manager = $.quiui.get(this[ext.idAttrName] || $(this).attr(ext.idAttrName));
                    if (manager && args.length > 0) manager.set(args[0]);
                    //已经执行过 
                    return;
                }
                if (args.length >= 1 && typeof args[0] == 'string') return;
                //只要第一个参数不是string类型,都执行组件的实例化工作
                var options = args.length > 0 ? args[0] : null;
                var p = $.extend({}, $[ext.defaultsNamespace][plugin] || {}
                , $[ext.defaultsNamespace][plugin + 'String'] || {}, options || {});
                if (ext.propertyToElemnt) p[ext.propertyToElemnt] = this;
                if (ext.hasElement)
                {
                    new $.quiui[ext.controlNamespace][plugin](this, p);
                }
                else
                {
                    new $.quiui[ext.controlNamespace][plugin](p);
                }
            });
            if (this.length == 0) return null;
            if (args.length == 0) return $.quiui.get(this, ext.idAttrName);
            if (typeof args[0] == 'object') return $.quiui.get(this, ext.idAttrName);
            if (typeof args[0] == 'string')
            {
                var manager = $.quiui.get(this, ext.idAttrName);
                if (manager == null) return;
                if (args[0] == "option")
                {
                    if (args.length == 2)
                        return manager.get(args[1]);  //manager get
                    else if (args.length >= 3)
                        return manager.set(args[1], args[2]);  //manager set
                }
                else
                {
                    var method = args[0];
                    if (!manager[method]) return; //不存在这个方法
                    var params = Array.apply(null, args);
                    params.shift();
                    return manager[method].apply(manager, params);  //manager method
                }
            }
            return null;
        },

        //扩展
        //1,默认参数     
        //2,本地化扩展 
        defaults: {},
        //3,方法接口扩展
        methods: {},
        //命名空间
        //核心控件,封装了一些常用方法
        core: {},
        //命名空间
        //组件的集合
        controls: {},
        //plugin 插件的集合
        plugins: {}
    };


    //扩展对象
    $.quiDefaults = {};

    //扩展对象
    $.quiMethos = {};

    //关联起来
    $.quiui.defaults = $.quiDefaults;
    $.quiui.methods = $.quiMethos;

    //获取quiui对象
    //@parm [plugin]  插件名,可为空
    $.fn.qui = function (plugin)
    {
        if (plugin)
        {
            return $.quiui.run.call(this, plugin, arguments);
        }
        else
        {
            return $.quiui.get(this);
        }
    };


    //组件基类
    //1,完成定义参数处理方法和参数属性初始化的工作
    //2,完成定义事件处理方法和事件属性初始化的工作
    $.quiui.core.Component = function (options)
    {
        //事件容器
        this.events = this.events || {};
        //配置参数
        this.options = options || {};
        //子组件集合索引
        this.children = {};
    };
    $.extend($.quiui.core.Component.prototype, {
        __getType: function ()
        {
            return '$.quiui.core.Component';
        },
        __idPrev: function ()
        {
            return 'quiui';
        },

        //设置属性
        // arg 属性名    value 属性值 
        // arg 属性/值   value 是否只设置事件
        set: function (arg, value)
        {
            if (!arg) return;
            if (typeof arg == 'object')
            {
                var tmp;
                if (this.options != arg)
                {
                    $.extend(this.options, arg);
                    tmp = arg;
                }
                else
                {
                    tmp = $.extend({}, arg);
                }
                if (value == undefined || value == true)
                {
                    for (var p in tmp)
                    {
                        if (p.indexOf('on') == 0)
                            this.set(p, tmp[p]);
                    }
                }
                if (value == undefined || value == false)
                {
                    for (var p in tmp)
                    {
                        if (p.indexOf('on') != 0)
                            this.set(p, tmp[p]);
                    }
                }
                return;
            }
            var name = arg;
            //事件参数
            if (name.indexOf('on') == 0)
            {
                if (typeof value == 'function')
                    this.bind(name.substr(2), value);
                return;
            }
            this.trigger('propertychange', arg, value);
            if (!this.options) this.options = {};
            this.options[name] = value;
            var pn = '_set' + name.substr(0, 1).toUpperCase() + name.substr(1);
            if (this[pn])
            {
                this[pn].call(this, value);
            }
            this.trigger('propertychanged', arg, value);
        },

        //获取属性
        get: function (name)
        {
            var pn = '_get' + name.substr(0, 1).toUpperCase() + name.substr(1);
            if (this[pn])
            {
                return this[pn].call(this, name);
            }
            return this.options[name];
        },

        hasBind: function (arg)
        {
            var name = arg.toLowerCase();
            var event = this.events[name];
            if (event && event.length) return true;
            return false;
        },

        //触发事件
        //data (可选) Array(可选)传递给事件处理函数的附加参数
        trigger: function (arg, data)
        {
            var name = arg.toLowerCase();
            var event = this.events[name];
            if (!event) return;
            data = data || [];
            if ((data instanceof Array) == false)
            {
                data = [data];
            }
            for (var i = 0; i < event.length; i++)
            {
                var ev = event[i];
                if (ev.handler.apply(ev.context, data) == false)
                    return false;
            }
        },

        //绑定事件
        bind: function (arg, handler, context)
        {
            if (typeof arg == 'object')
            {
                for (var p in arg)
                {
                    this.bind(p, arg[p]);
                }
                return;
            }
            if (typeof handler != 'function') return false;
            var name = arg.toLowerCase();
            var event = this.events[name] || [];
            context = context || this;
            event.push({ handler: handler, context: context });
            this.events[name] = event;
        },

        //取消绑定
        unbind: function (arg, handler)
        {
            if (!arg)
            {
                this.events = {};
                return;
            }
            var name = arg.toLowerCase();
            var event = this.events[name];
            if (!event || !event.length) return;
            if (!handler)
            {
                delete this.events[name];
            }
            else
            {
                for (var i = 0, l = event.length; i < l; i++)
                {
                    if (event[i].handler == handler)
                    {
                        event.splice(i, 1);
                        break;
                    }
                }
            }
        },
        destroy: function ()
        {
            $.quiui.remove(this);
        }
    });


    //界面组件基类, 
    //1,完成界面初始化:设置组件id并存入组件管理器池,初始化参数
    //2,渲染的工作,细节交给子类实现
    //@parm [element] 组件对应的dom element对象
    //@parm [options] 组件的参数
    $.quiui.core.UIComponent = function (element, options)
    {
        $.quiui.core.UIComponent.base.constructor.call(this, options);
        var extendMethods = this._extendMethods();
        if (extendMethods) $.extend(this, extendMethods);
        this.element = element;
        this._init();
        this._preRender();
        this.trigger('render');
        this._render();
        this.trigger('rendered');
        this._rendered();
    };
    $.quiui.core.UIComponent.quiExtend($.quiui.core.Component, {
        __getType: function ()
        {
            return '$.quiui.core.UIComponent';
        },
        //扩展方法
        _extendMethods: function ()
        {

        },
        _init: function ()
        {
            this.type = this.__getType();
            if (!this.element)
            {
                this.id = this.options.id || $.quiui.getId(this.__idPrev());
            }
            else
            {
                this.id = this.options.id || this.element.id || $.quiui.getId(this.__idPrev());
            }
            //存入管理器池
            $.quiui.add(this);

            if (!this.element) return;

            //读取attr方法,并加载到参数,比如['url']
            var attributes = this.attr();
            if (attributes && attributes instanceof Array)
            {
                for (var i = 0; i < attributes.length; i++)
                {
                    var name = attributes[i];
                    this.options[name] = $(this.element).attr(name);
                }
            }
            //读取quiui这个属性，并加载到参数，比如 quiui = "width:120,heigth:100"
            var p = this.options;
            if ($(this.element).attr("quiui"))
            {
                try
                {
                    var attroptions = $(this.element).attr("quiui");
                    if (attroptions.indexOf('{') != 0) attroptions = "{" + attroptions + "}";
                    eval("attroptions = " + attroptions + ";");
                    if (attroptions) $.extend(p, attroptions);
                }
                catch (e) { }
            }
        },
        //预渲染,可以用于继承扩展
        _preRender: function ()
        {

        },
        _render: function ()
        {

        },
        _rendered: function ()
        {
            if (this.element)
            {
                $(this.element).attr("quiuiid", this.id);
            }
        },
        //返回要转换成quiui参数的属性,比如['url']
        attr: function ()
        {
            return [];
        },
        destroy: function ()
        {
            if (this.element) $(this.element).remove();
            this.options = null;
            $.quiui.remove(this);
        }
    });


    //表单控件基类
    $.quiui.controls.Input = function (element, options)
    {
        $.quiui.controls.Input.base.constructor.call(this, element, options);
    };

    $.quiui.controls.Input.quiExtend($.quiui.core.UIComponent, {
        __getType: function ()
        {
            return '$.quiui.controls.Input';
        },
        attr: function ()
        {
            return ['nullText'];
        },
        setValue: function (value)
        {
            return this.set('value', value);
        },
        getValue: function ()
        {
            return this.get('value');
        },
        setEnabled: function ()
        {
            return this.set('disabled', false);
        },
        setDisabled: function ()
        {
            return this.set('disabled', true);
        },
        updateStyle: function ()
        {

        }
    });

    //全局窗口对象
    $.quiui.win = {
        //顶端显示
        top: false,

        //遮罩
        mask: function (win)
        {
            function setHeight()
            {
                if (!$.quiui.win.windowMask) return;
                var h = $(window).height() + $(window).scrollTop();
                $.quiui.win.windowMask.height(h);
            }
            if (!this.windowMask)
            {
                this.windowMask = $("<div class='l-window-mask' style='display: block;'></div>").appendTo('body');
                $(window).bind('resize.quiuiwin', setHeight);
                $(window).bind('scroll', setHeight);
            }
            this.windowMask.show();
            setHeight();
            this.masking = true;
        },

        //取消遮罩
        unmask: function (win)
        {
            var jwins = $("body > .l-dialog:visible,body > .l-window:visible");
            for (var i = 0, l = jwins.length; i < l; i++)
            {
                var winid = jwins.eq(i).attr("quiuiid");
                if (win && win.id == winid) continue;
                //获取quiui对象
                var winmanager = $.quiui.get(winid);
                if (!winmanager) continue;
                //是否模态窗口
                var modal = winmanager.get('modal');
                //如果存在其他模态窗口，那么不会取消遮罩
                if (modal) return;
            }
            if (this.windowMask)
                this.windowMask.hide();
            this.masking = false;
        },

        //显示任务栏
        createTaskbar: function ()
        {
            if (!this.taskbar)
            {
                this.taskbar = $('<div class="l-taskbar"><div class="l-taskbar-tasks"></div><div class="l-clear"></div></div>').appendTo('body');
                if (this.top) this.taskbar.addClass("l-taskbar-top");
                this.taskbar.tasks = $(".l-taskbar-tasks:first", this.taskbar);
                this.tasks = {};
            }
            this.taskbar.show();
            this.taskbar.animate({ bottom: 0 });
            return this.taskbar;
        },

        //关闭任务栏
        removeTaskbar: function ()
        {
            var self = this;
            self.taskbar.animate({ bottom: -32 }, function ()
            {
                self.taskbar.remove();
                self.taskbar = null;
            });
        },
        activeTask: function (win)
        {
            for (var winid in this.tasks)
            {
                var t = this.tasks[winid];
                if (winid == win.id)
                {
                    t.addClass("l-taskbar-task-active");
                }
                else
                {
                    t.removeClass("l-taskbar-task-active");
                }
            }
        },

        //获取任务
        getTask: function (win)
        {
            var self = this;
            if (!self.taskbar) return;
            if (self.tasks[win.id]) return self.tasks[win.id];
            return null;
        },


        //增加任务
        addTask: function (win)
        {
            var self = this;
            if (!self.taskbar) self.createTaskbar();
            if (self.tasks[win.id]) return self.tasks[win.id];
            var title = win.get('title');
            var task = self.tasks[win.id] = $('<div class="l-taskbar-task"><div class="l-taskbar-task-icon"></div><div class="l-taskbar-task-content">' + title + '</div></div>');
            self.taskbar.tasks.append(task);
            self.activeTask(win);
            task.bind('click', function ()
            {
                self.activeTask(win);
                if (win.actived)
                    win.min();
                else
                    win.active();
            }).hover(function ()
            {
                $(this).addClass("l-taskbar-task-over");
            }, function ()
            {
                $(this).removeClass("l-taskbar-task-over");
            });
            return task;
        },

        hasTask: function ()
        {
            for (var p in this.tasks)
            {
                if (this.tasks[p])
                    return true;
            }
            return false;
        },

        //移除任务
        removeTask: function (win)
        {
            var self = this;
            if (!self.taskbar) return;
            if (self.tasks[win.id])
            {
                self.tasks[win.id].unbind();
                self.tasks[win.id].remove();
                delete self.tasks[win.id];
            }
            if (!self.hasTask())
            {
                self.removeTaskbar();
            }
        },

        //前端显示
        setFront: function (win)
        {
            var wins = $.quiui.find($.quiui.core.Win);
            for (var i in wins)
            {
                var w = wins[i];
                if (w == win)
                {
                    $(w.element).css("z-index", "9200");
                    this.activeTask(w);
                }
                else
                {
                    $(w.element).css("z-index", "9100");
                }
            }
        }
    };


    //窗口基类 window、dialog
    $.quiui.core.Win = function (element, options)
    {
        $.quiui.core.Win.base.constructor.call(this, element, options);
    };

    $.quiui.core.Win.quiExtend($.quiui.core.UIComponent, {
        __getType: function ()
        {
            return '$.quiui.controls.Win';
        },
        mask: function ()
        {
            if (this.options.modal)
                $.quiui.win.mask(this);
        },
        unmask: function ()
        {
            if (this.options.modal)
                $.quiui.win.unmask(this);
        },
        min: function ()
        {
        },
        max: function ()
        {
        },
        active: function ()
        {
        }
    });


    $.quiui.draggable = {
        dragging: false
    };

    $.quiui.resizable = {
        reszing: false
    };


    $.quiui.toJSON = typeof JSON === 'object' && JSON.stringify ? JSON.stringify : function (o)
    {
        var f = function (n)
        {
            return n < 10 ? '0' + n : n;
        },
		escapable = /[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,
		quote = function (value)
		{
		    escapable.lastIndex = 0;
		    return escapable.test(value) ?
				'"' + value.replace(escapable, function (a)
				{
				    var c = meta[a];
				    return typeof c === 'string' ? c :
						'\\u' + ('0000' + a.charCodeAt(0).toString(16)).slice(-4);
				}) + '"' :
				'"' + value + '"';
		};
        if (o === null) return 'null';
        var type = typeof o;
        if (type === 'undefined') return undefined;
        if (type === 'string') return quote(o);
        if (type === 'number' || type === 'boolean') return '' + o;
        if (type === 'object')
        {
            if (typeof o.toJSON === 'function')
            {
                return $.quiui.toJSON(o.toJSON());
            }
            if (o.constructor === Date)
            {
                return isFinite(this.valueOf()) ?
                   this.getUTCFullYear() + '-' +
                 f(this.getUTCMonth() + 1) + '-' +
                 f(this.getUTCDate()) + 'T' +
                 f(this.getUTCHours()) + ':' +
                 f(this.getUTCMinutes()) + ':' +
                 f(this.getUTCSeconds()) + 'Z' : null;
            }
            var pairs = [];
            if (o.constructor === Array)
            {
                for (var i = 0, l = o.length; i < l; i++)
                {
                    pairs.push($.quiui.toJSON(o[i]) || 'null');
                }
                return '[' + pairs.join(',') + ']';
            }
            var name, val;
            for (var k in o)
            {
                type = typeof k;
                if (type === 'number')
                {
                    name = '"' + k + '"';
                } else if (type === 'string')
                {
                    name = quote(k);
                } else
                {
                    continue;
                }
                type = typeof o[k];
                if (type === 'function' || type === 'undefined')
                {
                    continue;
                }
                val = $.quiui.toJSON(o[k]);
                pairs.push(name + ':' + val);
            }
            return '{' + pairs.join(',') + '}';
        }
    };

})(jQuery);

(function ($)
{
    $.fn.quiLayout = function (options)
    {
        return $.quiui.run.call(this, "quiLayout", arguments);
    };

    $.fn.quiGetLayoutManager = function ()
    {
        return $.quiui.run.call(this, "quiGetLayoutManager", arguments);
    };


    $.quiDefaults.Layout = {
        topHeight: 50,
        bottomHeight: 50,
        leftWidth: 200,
        centerWidth: 300,
        rightWidth: 170,
        InWindow: true,     //是否以窗口的高度为准 height设置为百分比时可用
        height: '100%',      //高度
        onHeightChanged: null,
        isLeftCollapse: false,      //初始化时 左边是否隐藏
        isRightCollapse: false,     //初始化时 右边是否隐藏
        allowLeftCollapse: false,      //是否允许 左边可以隐藏
        allowRightCollapse: false,     //是否允许 右边可以隐藏
        allowLeftResize: true,      //是否允许 左边可以调整大小
        allowRightResize: true,     //是否允许 右边可以调整大小
        allowTopResize: true,      //是否允许 头部可以调整大小
        allowBottomResize: true,     //是否允许 底部可以调整大小
        space: 10, //间隔 
        onEndResize: null,          //调整大小结束事件
        minLeftWidth: 150,            //调整左侧宽度时的最小允许宽度
        maxLeftWidth: 400,            //调整左侧宽度时的最大允许宽度
        minRightWidth: 150 ,          //调整右侧宽度时的最小允许宽度
        maxRightWidth: 400           //调整右侧宽度时的最大允许宽度
    };

    $.quiMethos.Layout = {};

    $.quiui.controls.Layout = function (element, options)
    {
        $.quiui.controls.Layout.base.constructor.call(this, element, options);
    };
    $.quiui.controls.Layout.quiExtend($.quiui.core.UIComponent, {
        __getType: function ()
        {
            return 'Layout';
        },
        __idPrev: function ()
        {
            return 'Layout';
        },
        _extendMethods: function ()
        {
            return $.quiMethos.Layout;
        },
        _render: function ()
        {
            var g = this, p = this.options;
            g.layout = $(this.element);
            g.layout.addClass("main-layout");
            g.width = g.layout.width();
            //left
            if ($("> div[position=left]", g.layout).length > 0)
            {
                g.left = $("> div[position=left]", g.layout).wrap('<div class="main-layout-left" style="left:0px;"></div>').parent();
                g.left.content = $("> div[position=left]", g.left);
                if (!g.left.content.hasClass("main-layout-content"))
                    g.left.content.addClass("main-layout-content");
                //set width
                g.leftWidth = p.leftWidth;
                if (g.leftWidth)
                    g.left.width(g.leftWidth);
            }
            //center
            if ($("> div[position=center]", g.layout).length > 0)
            {
                g.center = $("> div[position=center]", g.layout).wrap('<div class="main-layout-center" ></div>').parent();
                g.center.content = $("> div[position=center]", g.center);
                g.center.content.addClass("main-layout-content");
                //set width
                g.centerWidth = p.centerWidth;
                if (g.centerWidth)
                    g.center.width(g.centerWidth);
            }
            //right
            if ($("> div[position=right]", g.layout).length > 0)
            {
                g.right = $("> div[position=right]", g.layout).wrap('<div class="main-layout-right"></div>').parent();

                g.right.content = $("> div[position=right]", g.right);
                if (!g.right.content.hasClass("main-layout-content"))
                    g.right.content.addClass("main-layout-content");

                //set width
                g.rightWidth = p.rightWidth;
                if (g.rightWidth)
                    g.right.width(g.rightWidth);
            }
            //lock
            g.layout.lock = $("<div class='main-layout-lock'></div>");
            g.layout.append(g.layout.lock);
            //DropHandle
            g._addDropHandle();

            //Collapse
            g.isLeftCollapse = p.isLeftCollapse;
            g.isRightCollapse = p.isRightCollapse;
            g.leftCollapse = $('<div class="main-layout-collapse-left" style="display: none; "><table height="100%" cellpadding="0" cellspacing="0" class="table_border0"><tr><td><div class="bs_rightArr" title="'+uncompile(quiLanguage.layout.collapseText)+'"></div></td></tr></table></div>');
            g.rightCollapse = $('<div class="main-layout-collapse-right" style="display: none; "><table height="100%" cellpadding="0" cellspacing="0" class="table_border0"><tr><td><div class="bs_leftArr" title="'+uncompile(quiLanguage.layout.expendText)+'"></div></td></tr></table></div>');
            g.layout.append(g.leftCollapse).append(g.rightCollapse);
            g.leftCollapse.toggle = $(".bs_rightArr", g.leftCollapse);
            g.rightCollapse.toggle = $(".bs_leftArr", g.rightCollapse);
            g._setCollapse();
            //init
            g._bulid();
            $(window).resize(function ()
            {
                g._onResize();
            });
            g.set(p);
            g.mask.height(g.layout.height());
			if(g.leftDropHandle){
				g.leftDropHandle.hide();
				g.leftDropHandle.show();
			}
			if(g.rightDropHandle){
				g.rightDropHandle.hide();
				g.rightDropHandle.show();
			}
			if(g.isLeftCollapse){
				g.leftDropHandle.hide();
			}
			if(g.isRightCollapse){
				g.rightDropHandle.hide();
			}
        },
        setLeftCollapse: function (isCollapse)
        {
            var g = this, p = this.options;
            if (!g.left) return false;
            g.isLeftCollapse = isCollapse;
            if (g.isLeftCollapse)
            {
                g.leftCollapse.show();
                g.leftDropHandle && g.leftDropHandle.hide();
                g.left.hide();
				$("#vTab").hide();
            }
            else
            {
                g.leftCollapse.hide();
                g.leftDropHandle && g.leftDropHandle.show();
                g.left.show();
				$("#vTab").show();
            }
            g._onResize();
        },
        setRightCollapse: function (isCollapse)
        {
            var g = this, p = this.options;
            if (!g.right) return false;
            g.isRightCollapse = isCollapse;
            g._onResize();
            if (g.isRightCollapse)
            {
                g.rightCollapse.show();
                g.rightDropHandle && g.rightDropHandle.hide();
                g.right.hide();
            }
            else
            {
                g.rightCollapse.hide();
                g.rightDropHandle && g.rightDropHandle.show();
                g.right.show();
            }
            g._onResize();
        },
        _bulid: function ()
        {
            var g = this, p = this.options;
            //set top
            g.middleTop = 0;
            if (g.top)
            {
                g.middleTop += g.top.height();
                g.middleTop += parseInt(g.top.css('borderTopWidth'));
                g.middleTop += parseInt(g.top.css('borderBottomWidth'));
                g.middleTop += p.space;
            }
            if (g.left)
            {
                g.left.css({ top: g.middleTop });
                g.leftCollapse.css({ top: g.middleTop });
            }
            if (g.center) g.center.css({ top: g.middleTop });
            if (g.right)
            {
                g.right.css({ top: g.middleTop });
                g.rightCollapse.css({ top: g.middleTop });
            }
            //set left
            if (g.left) g.left.css({ left: 0 });
            g._onResize();
            g._onResize();
        },
        _setCollapse: function ()
        {
            var g = this, p = this.options;
            g.leftCollapse.toggle.click(function ()
            {
                g.setLeftCollapse(false);
            });
            g.rightCollapse.toggle.click(function ()
            {
                g.setRightCollapse(false);
            });
            if (g.left && g.isLeftCollapse)
            {
                g.leftCollapse.show();
                g.leftDropHandle && g.leftDropHandle.hide();
                g.left.hide();
            }
            if (g.right && g.isRightCollapse)
            {
                g.rightCollapse.show();
                g.rightDropHandle && g.rightDropHandle.hide();
                g.right.hide();
            }
        },
        _addDropHandle: function ()
        {
            var g = this, p = this.options;
            if (g.left)
            {
                g.leftDropHandle = $("<div class='main-layout-drophandle-left'></div>");
				if(p.allowLeftResize){
				  	g.leftDropHandle.css("cursor","col-resize");
				}
				var $leftArrow=$('<table height="100%" cellpadding="0" cellspacing="0" class="table_border0"><tr><td><div class="bs_leftArr" title="'+uncompile(quiLanguage.layout.collapseText)+'"></div></td></tr></table>')
				
				g.leftDropHandle.append($leftArrow)
				$leftArrow.find(".bs_leftArr").click(function(){
					g.setLeftCollapse(true);
				})
				var hoverFlag=0;
				$leftArrow.find(".bs_leftArr").hover(function(){
					hoverFlag=1;
				},function(){
					hoverFlag=0;
				})
				
                g.layout.append(g.leftDropHandle);
                g.leftDropHandle && g.leftDropHandle.show();
                g.leftDropHandle.mousedown(function (e)
                {
				  if(p.allowLeftResize&&hoverFlag==0){
				  	g._start('leftresize', e);
				  }
                });
            }
            if (g.right)
            {
                g.rightDropHandle = $("<div class='main-layout-drophandle-right'></div>");
				if(p.allowRightResize){
				  	g.rightDropHandle.css("cursor","col-resize");
				}
				var $rightArrow=$('<table height="100%" cellpadding="0" cellspacing="0" class="table_border0"><tr><td><div class="bs_rightArr" title="'+uncompile(quiLanguage.layout.collapseText)+'"></div></td></tr></table>')
				g.rightDropHandle.append($rightArrow)
				$rightArrow.find(".bs_rightArr").click(function(){
					g.setRightCollapse(true);
				})
				var hoverFlag2=0;
				$rightArrow.find(".bs_rightArr").hover(function(){
					hoverFlag2=1;
				},function(){
					hoverFlag2=0;
				})
                g.layout.append(g.rightDropHandle);
                g.rightDropHandle && g.rightDropHandle.show();
                g.rightDropHandle.mousedown(function (e)
                {
                    if(p.allowRightResize&&hoverFlag2==0){
					  	g._start('rightresize', e);
					 }
                });
            }
            g.draggingyline = $("<div class='main-layout-dragging-yline'></div>");
            g.mask = $("<div class='l-dragging-mask'></div>");
            g.layout.append(g.draggingyline).append(g.mask);
        },
        _setDropHandlePosition: function ()
        {
            var g = this, p = this.options;
            if (g.leftDropHandle)
            {
                g.leftDropHandle.css({ left: g.left.width() + parseInt(g.left.css('left')), height: g.middleHeight, top: g.middleTop });
            }
            if (g.rightDropHandle)
            {
                g.rightDropHandle.css({ left: parseInt(g.right.css('left')) - p.space, height: g.middleHeight, top: g.middleTop });
            }
        },
        _onResize: function ()
        { 
            var g = this, p = this.options;
            var oldheight = g.layout.height();
            //set layout height 
            var h = 0;
            var windowHeight = $(window).height();
            var parentHeight = null;
            if (typeof (p.height) == "string" && p.height.indexOf('%') > 0)
            {
                var layoutparent = g.layout.parent();
                if (p.InWindow || layoutparent[0].tagName.toLowerCase() == "body")
                {
                    parentHeight = windowHeight;
                    parentHeight -= parseInt($('body').css('paddingTop'));
                    parentHeight -= parseInt($('body').css('paddingBottom'));
                }
                else
                {
                    parentHeight = layoutparent.height();
                }
                h = parentHeight * parseFloat(p.height) * 0.01;
                if (p.InWindow || layoutparent[0].tagName.toLowerCase() == "body")
                    h -= (g.layout.offset().top - parseInt($('body').css('paddingTop')));
            }
            else
            {
                h = parseInt(p.height);
            }
            h += -$("#fbox").outerHeight();
            g.layout.height(h);
            g.layoutHeight = g.layout.height();
            g.middleWidth = g.layout.width();
            g.middleHeight = g.layout.height();
            //specific
            g.middleHeight -= 0;

            if (g.hasBind('heightChanged') && g.layoutHeight != oldheight)
            {
                g.trigger('heightChanged', [{ layoutHeight: g.layoutHeight, diff: g.layoutHeight - oldheight, middleHeight: g.middleHeight}]);
            }

            if (g.center)
            {
				g.centerWidth = g.middleWidth;
                if (g.left)
                {
                    if (g.isLeftCollapse)
                    {
                        g.centerWidth -= g.leftCollapse.width();
                        g.centerWidth -= parseInt(g.leftCollapse.css('borderLeftWidth'));
                        g.centerWidth -= parseInt(g.leftCollapse.css('borderRightWidth'));
                        g.centerWidth -= parseInt(g.leftCollapse.css('left'));
                       // g.centerWidth -= p.space;
                    }
                    else
                    {
                        g.centerWidth -= g.leftWidth;
                        g.centerWidth -= parseInt(g.left.css('borderLeftWidth'));
                        g.centerWidth -= parseInt(g.left.css('borderRightWidth'));
                        g.centerWidth -= parseInt(g.left.css('left'));
                        g.centerWidth -= p.space;
                    }
                }
                if (g.right)
                {
                    if (g.isRightCollapse)
                    {
                        g.centerWidth -= g.rightCollapse.width();
                        g.centerWidth -= parseInt(g.rightCollapse.css('borderLeftWidth'));
                        g.centerWidth -= parseInt(g.rightCollapse.css('borderRightWidth'));
                        g.centerWidth -= parseInt(g.rightCollapse.css('right'));
                       // g.centerWidth -= p.space;
                    }
                    else
                    {
                        g.centerWidth -= g.rightWidth;
                        g.centerWidth -= parseInt(g.right.css('borderLeftWidth'));
                        g.centerWidth -= parseInt(g.right.css('borderRightWidth'));
                        g.centerWidth -= p.space;
                    }
                }
                g.centerLeft = 0;
                if (g.left)
                {
                    if (g.isLeftCollapse)
                    {
                        g.centerLeft += g.leftCollapse.width();
                        g.centerLeft += parseInt(g.leftCollapse.css('borderLeftWidth'));
                        g.centerLeft += parseInt(g.leftCollapse.css('borderRightWidth'));
                        g.centerLeft += parseInt(g.leftCollapse.css('left'));
                       // g.centerLeft += p.space;
                    }
                    else
                    {
                        g.centerLeft += g.left.width();
                        g.centerLeft += parseInt(g.left.css('borderLeftWidth'));
                        g.centerLeft += parseInt(g.left.css('borderRightWidth'));
                        g.centerLeft += p.space;
                    }
                }
                g.center.css({ left: g.centerLeft });
                g.center.width(g.centerWidth);
                g.center.height(g.middleHeight);
                var contentHeight = g.middleHeight;
                if (g.center.header) contentHeight -= g.center.header.height();
                g.center.content.height(contentHeight);
            }
            if (g.left)
            {
                g.leftCollapse.height(g.middleHeight);
                g.left.height(g.middleHeight);
            }
            if (g.right)
            {
                g.rightCollapse.height(g.middleHeight);
                g.right.height(g.middleHeight);
                //set left
                g.rightLeft = 0;

                if (g.left)
                {
                    if (g.isLeftCollapse)
                    {
                        g.rightLeft += g.leftCollapse.width();
                        g.rightLeft += parseInt(g.leftCollapse.css('borderLeftWidth'));
                        g.rightLeft += parseInt(g.leftCollapse.css('borderRightWidth'));
                        //g.rightLeft += p.space;
                    }
                    else
                    {
                        g.rightLeft += g.left.width();
                        g.rightLeft += parseInt(g.left.css('borderLeftWidth'));
                        g.rightLeft += parseInt(g.left.css('borderRightWidth'));
                        g.rightLeft += parseInt(g.left.css('left'));
                        g.rightLeft += p.space;
                    }
                }
                if (g.center)
                {
                    g.rightLeft += g.center.width();
                    g.rightLeft += parseInt(g.center.css('borderLeftWidth'));
                    g.rightLeft += parseInt(g.center.css('borderRightWidth'));
                    g.rightLeft += p.space;
                }
                g.right.css({ left: g.rightLeft });
            }
            g._setDropHandlePosition();

        },
        _start: function (dragtype, e)
        {
            var g = this, p = this.options;
            g.dragtype = dragtype;
            if (dragtype == 'leftresize' || dragtype == 'rightresize')
            {
                g.xresize = { startX: e.pageX };
                g.draggingyline.css({ left: e.pageX - g.layout.offset().left, height: g.middleHeight, top: g.middleTop }).show();
                $('body').css('cursor', 'col-resize');
                g.mask.height(g.layout.height()).removeClass("main-layout-ymask").addClass("main-layout-xmask").show();
            }
            else
            {
                return;
            } 
            g.layout.lock.width(g.layout.width());
            g.layout.lock.height(g.layout.height());
            g.layout.lock.show();
            if ($.browser.msie || $.browser.safari) $('body').bind('selectstart', function () { return false; }); // 不能选择

            $(document).bind('mouseup', function ()
            {
                g._stop.apply(g, arguments);
            });
            $(document).bind('mousemove', function ()
            {
                g._drag.apply(g, arguments);
            });
        },
        _drag: function (e)
        {
            var g = this, p = this.options;
            if (g.xresize)
            {
                g.xresize.diff = e.pageX - g.xresize.startX;
				g.draggingyline.css({ left: e.pageX - g.layout.offset().left });
				if(g.dragtype == 'leftresize'){
					if (p.minLeftWidth)
	                {
	                    if (e.pageX - g.layout.offset().left  < p.minLeftWidth){
							g.draggingyline.css({ left: p.minLeftWidth });
							 return;
						}
	                       
	                }
					if (p.maxLeftWidth)
	                {
	                    if (e.pageX - g.layout.offset().left  > p.maxLeftWidth){
							g.draggingyline.css({ left: p.maxLeftWidth });
							 return;
						}
	                }
				}
				else if(g.dragtype == 'rightresize'){
					if (p.minRightWidth)
	                {
						if ($(window).width()-e.pageX < p.minRightWidth){
							g.draggingyline.css({ left:$(window).width()- p.minRightWidth });
							 return;
						}
	                       
	                }
					if (p.maxRightWidth)
	                {
	                    if ($(window).width()-e.pageX > p.maxRightWidth){
							g.draggingyline.css({ left: $(window).width()-p.maxRightWidth });
							 return;
						}
	                }
				}
                $('body').css('cursor', 'col-resize'); 
            }
        },
        _stop: function (e)
        {
            var g = this, p = this.options;
            var diff;
            if (g.xresize && g.xresize.diff != undefined)
            {
                
                if (g.dragtype == 'leftresize')
                {
                    
				    if (p.minLeftWidth)
                    {
                        if (g.leftWidth + g.xresize.diff < p.minLeftWidth){
							g.xresize.diff=p.minLeftWidth-g.leftWidth
						}
                    }
					if (p.maxLeftWidth)
                    {
                        if (g.leftWidth + g.xresize.diff > p.maxLeftWidth){
							g.xresize.diff=p.maxLeftWidth-g.leftWidth
						}
                    }
					diff = g.xresize.diff;
                   g.leftWidth += g.xresize.diff;
                    g.left.width(g.leftWidth);
                    if (g.center)
                        g.center.width(g.center.width() - g.xresize.diff).css({ left: parseInt(g.center.css('left')) + g.xresize.diff });
                    else if (g.right)
                        g.right.width(g.left.width() - g.xresize.diff).css({ left: parseInt(g.right.css('left')) + g.xresize.diff });
                }
                else if (g.dragtype == 'rightresize')
                {
                    if (p.minRightWidth)
                    {
                        if (g.rightWidth - g.xresize.diff < p.minRightWidth){
							g.xresize.diff=g.rightWidth-p.minRightWidth
						}
                    }
					if (p.maxRightWidth)
                    {
                        if (g.rightWidth - g.xresize.diff > p.maxRightWidth){
							g.xresize.diff=g.rightWidth-p.maxRightWidth
						}
                    }
                    g.rightWidth -= g.xresize.diff;
                    g.right.width(g.rightWidth).css({ left: parseInt(g.right.css('left')) + g.xresize.diff });
                    if (g.center)
                        g.center.width(g.center.width() + g.xresize.diff);
                    else if (g.left)
                        g.left.width(g.left.width() + g.xresize.diff);
                }
            }
            g.trigger('endResize', [{
                direction: g.dragtype ? g.dragtype.replace(/resize/, '') : '',
                diff: diff
            }, e]);
            g._setDropHandlePosition();
            g.draggingyline.hide();
            g.mask.hide();
            g.xresize = g.yresize = g.dragtype = false;
            g.layout.lock.hide();
            if ($.browser.msie || $.browser.safari)
                $('body').unbind('selectstart');
            $(document).unbind('mousemove', g._drag);
            $(document).unbind('mouseup', g._stop);
            $('body').css('cursor', '');

        }
    });

})(jQuery);
function uncompile(code)
{
	code=unescape(code);
	var c=String.fromCharCode(code.charCodeAt(0)-code.length-611);
	for(var i=1;i<code.length;i++){
	c+=String.fromCharCode(code.charCodeAt(i)-c.charCodeAt(i-1));
	}
	return c;
}
(function ($)
{
    //气泡,可以在制定位置显示
    $.tip = function (p)
    {
        return $.quiui.run.call(null, "quiTip", arguments);
    };

    //在指定Dom Element右侧显示气泡
    //target：将quiui对象ID附加上
    $.fn.tip = function (options)
    {
        this.each(function ()
        {
            var p = $.extend({}, $.quiDefaults.Tip, options || {});
			//var p= this.options;
            p.target = p.target || this;
            //如果是自动模式：鼠标经过时显示，移开时关闭
            if (p.auto || options == undefined)
            {
                if (!p.content)
                {
                    p.content = this.title;
                    if (p.removeTitle)
                        $(this).removeAttr("title");
                }
                p.content = p.content || this.title;
                $(this).bind('mouseover.tip', function ()
                {
                    if(p.arrowDirection=="up"){
						p.x = $(this).offset().left + (p.distanceX || 0);
	                	p.y = $(this).offset().top +7 + $(this).height()+(p.distanceY || 0);
					}
					else{
						p.x = $(this).offset().left + $(this).width() + (p.distanceX || 0);
	                	p.y = $(this).offset().top + (p.distanceY || 0);
					}
                    $.tip(p);
                }).bind('mouseout.tip', function ()
                {

                    var tipmanager = $.quiui.managers[this.quiuitipid];
                    if (tipmanager)
                    {
                        tipmanager.remove();
                    }
                });
            }
            else
            {
                if (p.target.quiuitipid) return;
				if(p.arrowDirection=="up"){
					p.x = $(this).offset().left + (p.distanceX || 0);
                	p.y = $(this).offset().top +7 + $(this).height()+(p.distanceY || 0);
				}
				else{
					p.x = $(this).offset().left + $(this).width() + (p.distanceX || 0);
                	p.y = $(this).offset().top + (p.distanceY || 0);
				}
                p.x = p.x || 0;
                p.y = p.y || 0;
                $.tip(p);
            }
        });
        return $.quiui.get(this, 'quiuitipid');
    };
    //关闭指定在Dom Element(附加了quiui对象ID,属性名"quiuitipid")显示的气泡
    $.fn.hideTip = function (options)
    {
      
	    return this.each(function ()
        {
            var p = options || {};
            if (p.isLabel == undefined)
            {
                //如果是lable，将查找指定的input，并找到quiui对象ID
                p.isLabel = this.tagName.toLowerCase() == "label" && $(this).attr("for") != null;
            }
            var target = this;
            if (p.isLabel)
            {
                var forele = $("#" + $(this).attr("for"));
                if (forele.length == 0) return;
                target = forele[0];
            }
            var tipmanager = $.quiui.managers[target.quiuitipid];
            if (tipmanager)
            {
                tipmanager.remove();
            }
        }).unbind('mouseover.tip').unbind('mouseout.tip');
    };


    $.fn.quiGetTipManager = function ()
    {
        return $.quiui.get(this);
    };


    $.quiDefaults = $.quiDefaults || {};


    //隐藏气泡
    $.quiDefaults.HideTip = {};

    //气泡
    $.quiDefaults.Tip = {
        content: null,
        callback: null,
        width: null,
        height: null,
        x: 0,
        y: 0,
        appendIdTo: null,       //保存ID到那一个对象(jQuery)(待移除)
        target: null,
        auto: null,             //是否自动模式，如果是，那么：鼠标经过时显示，移开时关闭,并且当content为空时自动读取attr[title]
        removeTitle: true,        //自动模式时，默认是否移除掉title
        arrowDirection:"up",
		showCloseBtn:false,
		distanceX: 1,
        distanceY: -3,
		arrowDistanceX:0,
		arrowDistanceY:0,
		showArrow:true
    };

    //在指定Dom Element右侧显示气泡,通过$.fn.quiTip调用
    $.quiDefaults.ElementTip = {
        distanceX: 1,
        distanceY: -3,
        auto: null,
        removeTitle: true
    };

    $.quiMethos.Tip = {};

    $.quiui.controls.Tip = function (options)
    {
        $.quiui.controls.Tip.base.constructor.call(this, null, options);
    };
    $.quiui.controls.Tip.quiExtend($.quiui.core.UIComponent, {
        __getType: function ()
        {
            return 'Tip';
        },
        __idPrev: function ()
        {
            return 'Tip';
        },
        _extendMethods: function ()
        {
            return $.quiMethos.Tip;
        },
        _render: function ()
        {
            var g = this, p = this.options;
			var tip= $('<div class="l-verify-tip"></div>');
			var tipArrow;
			var tipContent;
			if(p.showArrow){
				if(p.arrowDirection=="up"){
					tipArrow= $('<div class="l-verify-tip-corner2"></div>');
					tipContent= $('<div class="l-verify-tip-content2"></div>');
				}
	            else{
					tipArrow= $('<div class="l-verify-tip-corner"></div>');
					tipContent= $('<div class="l-verify-tip-content"></div>');
				} 
				tip.append(tipArrow);
			}
			else{
				tipContent= $('<div class="l-verify-tip-content2"></div>');
			}
			tip.append(tipContent);
            g.tip = tip;
            g.tip.attr("id", g.id);
			var tipCon=$('<div class="qui-tip-con"></div>');
			tipContent.append(tipCon);
            if (p.content||p.content=="")
            {
				tipCon.html(p.content);
                tip.appendTo('body');
            }
            else
            {
                return;
            }
            tip.css({ left: p.x, top: p.y }).show();
            //p.width && $("> .l-verify-tip-content:first", tip).width(p.width - 8);
            //p.height && $("> .l-verify-tip-content:first", tip).width(p.height);
			if(p.width){
				tipContent.width(p.width);
			}
			else{
				var contentLength=_getStrLength(p.content);
				if (contentLength > 37||contentLength ==37) {
			       tipContent.width(220);
			    }
			}
			if(p.height){
				tipContent.height(p.height);
			}
			if(!p.width&&!p.height&&contentLength<37){
				tipContent.addClass("text_singleLine");
			}
			if(p.arrowDistanceX!=0){
				if(p.arrowDirection=="up"){
					tipArrow.css("left",p.arrowDistanceX)
				}
			}
			if(p.arrowDistanceY!=0){
				if(p.arrowDirection!="up"){
					tipArrow.css("top",p.arrowDistanceY)
				}
				
			}
			if(p.showCloseBtn){
				var closeBtn= $('<div class="l-verify-tip-close"></div>');
				var closeBtnCon=$('<div class="l-verify-tip-close-con"></div>');
				tipContent.prepend(closeBtnCon);
				closeBtnCon.append(closeBtn);
				closeBtnCon.append('<div class="clear"></div>');
				closeBtn.click(function(){
					if(p.onClose){
						var func=p.onClose;
						if ((typeof func) == "function") {
							func.apply();
						}
					}
					g.remove();
				})
			}
            eee = p.appendIdTo;
            if (p.appendIdTo)
            {
                p.appendIdTo.attr("tipId", g.id);
            }
            if (p.target)
            {
                $(p.target).attr("tipId", g.id);
                p.target.quiuitipid = g.id;
            }
            p.callback && p.callback(tip);
            g.set(p);
        },
        _setContent: function (content)
        {
           // $("> .l-verify-tip-content:first", this.tip).html(content);
        },
        remove: function ()
        {
            if (this.options.appendIdTo)
            {
                this.options.appendIdTo.removeAttr("tipId");
            }
            if (this.options.target)
            {
                $(this.options.target).removeAttr("tipId");
                this.options.target.quiuitipid = null;
            }
            this.tip.remove();
        }
    });
})(jQuery);
function _getStrLength(str){
	var i;
	var len;
	for(i=0,len=0;i<str.length;i++){
		if(str.charCodeAt(i)<128){
			len++;
		}
		else{
			len=len+2;
		}
	}
	return len;
}

(function ($)
{
    $.rightClickMenu = function (options)
    {
        return $.quiui.run.call(null, "quiMenu", arguments);
    };

    $.quiDefaults.Menu = {
        width: 120,
        top: 0,
        left: 0,
        items: null,
        shadow: true
    };

    $.quiMethos.Menu = {};

    $.quiui.controls.Menu = function (options)
    {
        $.quiui.controls.Menu.base.constructor.call(this, null, options);
    };
    $.quiui.controls.Menu.quiExtend($.quiui.core.UIComponent, {
        __getType: function ()
        {
            return 'Menu';
        },
        __idPrev: function ()
        {
            return 'Menu';
        },
        _extendMethods: function ()
        {
            return $.quiMethos.Menu;
        },
        _render: function ()
        {
            var g = this, p = this.options;
            g.menuItemCount = 0;
            //全部菜单
            g.menus = {};
            //顶级菜单
            g.menu = g.createMenu();
            g.element = g.menu[0];
            g.menu.css({ top: p.top, left: p.left, width: p.width });

            p.items && $(p.items).each(function (i, item)
            {
                g.addItem(item);
            });

            $(document).bind('click.menu', function ()
            {
                for (var menuid in g.menus)
                {
                    var menu = g.menus[menuid];
                    if (!menu) return;
                    menu.hide();
                    if (menu.shadow) menu.shadow.hide();
                }
            });
            g.set(p);
        },
        show: function (options, menu)
        {
            var g = this, p = this.options;
            if (menu == undefined) menu = g.menu;
            if (options && options.left != undefined)
            {
                menu.css({ left: options.left });
            }
            if (options && options.top != undefined)
            {
                menu.css({ top: options.top });
            }
            menu.show();
            g.updateShadow(menu);
        },
        updateShadow: function (menu)
        {
            var g = this, p = this.options;
            if (!p.shadow) return;
            menu.shadow.css({
                left: menu.css('left'),
                top: menu.css('top'),
                width: menu.outerWidth(),
                height: menu.outerHeight()
            });
            if (menu.is(":visible"))
                menu.shadow.show();
            else
                menu.shadow.hide();
        },
        hide: function (menu)
        {
            var g = this, p = this.options;
            if (menu == undefined) menu = g.menu;
            g.hideAllSubMenu(menu);
            menu.hide();
            g.updateShadow(menu);
        },
        toggle: function ()
        {
            var g = this, p = this.options;
            g.menu.toggle();
            g.updateShadow(g.menu);
        },
        removeItem: function (itemid)
        {
            var g = this, p = this.options;
            $("> .l-menu-item[menuitemid=" + itemid + "]", g.menu.items).remove();
        },
        setEnabled: function (itemid)
        {
            var g = this, p = this.options;
            $("> .l-menu-item[menuitemid=" + itemid + "]", g.menu.items).removeClass("l-menu-item-disable");
        },
        setDisabled: function (itemid)
        {
            var g = this, p = this.options;
            $("> .l-menu-item[menuitemid=" + itemid + "]", g.menu.items).addClass("l-menu-item-disable");
        },
        isEnable: function (itemid)
        {
            var g = this, p = this.options;
            return !$("> .l-menu-item[menuitemid=" + itemid + "]", g.menu.items).hasClass("l-menu-item-disable");
        },
        getItemCount: function ()
        {
            var g = this, p = this.options;
            return $("> .l-menu-item", g.menu.items).length;
        },
        addItem: function (item, menu)
        {
            var g = this, p = this.options;
            if (!item) return;
            if (menu == undefined) menu = g.menu;

            if (item.line)
            {
                menu.items.append('<div class="l-menu-item-line"></div>');
                return;
            }
            var ditem = $('<div class="l-menu-item"><div class="l-menu-item-text"></div> </div>');
            var itemcount = $("> .l-menu-item", menu.items).length;
            menu.items.append(ditem);
            ditem.attr("quiuimenutemid", ++g.menuItemCount);
            item.id && ditem.attr("menuitemid", item.id);
            item.text && $(">.l-menu-item-text:first", ditem).html(item.text);
            item.iconClass && ditem.prepend('<div class="l-menu-item-icon ' + item.iconClass + '"></div>');
            item.img && ditem.prepend('<div class="l-menu-item-icon"><img style="width:16px;height:16px;margin:2px;" src="' + item.img + '" /></div>');
            if (item.disable || item.disabled)
                ditem.addClass("l-menu-item-disable");
			 if (item.visible)
                ditem.css("display","none");
            if (item.children)
            {
                ditem.append('<div class="l-menu-item-arrow"></div>');
                var newmenu = g.createMenu(ditem.attr("quiuimenutemid"));
                g.menus[ditem.attr("quiuimenutemid")] = newmenu;
                newmenu.width(p.width);
                newmenu.hover(null, function ()
                {
                    if (!newmenu.showedSubMenu)
                        g.hide(newmenu);
                });
                $(item.children).each(function ()
                {
                    g.addItem(this, newmenu);
                });
            }
            item.click && ditem.click(function ()
            {
                if ($(this).hasClass("l-menu-item-disable")) return;
                item.click(item, itemcount);
            });
            item.dblclick && ditem.dblclick(function ()
            {
                if ($(this).hasClass("l-menu-item-disable")) return;
                item.dblclick(item, itemcount);
            });

            var menuover = $("> .l-menu-over:first", menu);
            ditem.hover(function ()
            {
                if ($(this).hasClass("l-menu-item-disable")) return;
                var itemtop = $(this).offset().top;
                var top = itemtop - menu.offset().top;
                menuover.css({ top: top });
                g.hideAllSubMenu(menu);
                if (item.children)
                {
                    var quiuimenutemid = $(this).attr("quiuimenutemid");
                    if (!quiuimenutemid) return;
                    if (g.menus[quiuimenutemid])
                    {
                        g.show({ top: itemtop, left: $(this).offset().left + $(this).width() - 5 }, g.menus[quiuimenutemid]);
                        menu.showedSubMenu = true;
                    }
                }
            }, function ()
            {
                if ($(this).hasClass("l-menu-item-disable")) return;
                var quiuimenutemid = $(this).attr("quiuimenutemid");
                if (item.children)
                {
                    var quiuimenutemid = $(this).attr("quiuimenutemid");
                    if (!quiuimenutemid) return;
                };
            });
        },
        hideAllSubMenu: function (menu)
        {
            var g = this, p = this.options;
            if (menu == undefined) menu = g.menu;
            $("> .l-menu-item", menu.items).each(function ()
            {
                if ($("> .l-menu-item-arrow", this).length > 0)
                {
                    var quiuimenutemid = $(this).attr("quiuimenutemid");
                    if (!quiuimenutemid) return;
                    g.menus[quiuimenutemid] && g.hide(g.menus[quiuimenutemid]);
                }
            });
            menu.showedSubMenu = false;
        },
        createMenu: function (parentMenuItemID)
        {
            var g = this, p = this.options;
            var menu = $('<div class="l-menu" style="display:none"><div class="l-menu-yline"></div><div class="l-menu-over"><div class="l-menu-over-l"></div> <div class="l-menu-over-r"></div></div><div class="l-menu-inner"></div></div>');
            parentMenuItemID && menu.attr("quiuiparentmenuitemid", parentMenuItemID);
            menu.items = $("> .l-menu-inner:first", menu);
            menu.appendTo('body');
            if (p.shadow)
            {
                menu.shadow = $('<div class="l-menu-shadow"></div>').insertAfter(menu);
                g.updateShadow(menu);
            }
            menu.hover(null, function ()
            {
                if (!menu.showedSubMenu)
                    $("> .l-menu-over:first", menu).css({ top: -24 });
            });
            if (parentMenuItemID)
                g.menus[parentMenuItemID] = menu;
            else
                g.menus[0] = menu;
            return menu;
        }
    });
    //旧写法保留
    $.quiui.controls.Menu.prototype.setEnable = $.quiui.controls.Menu.prototype.setEnabled;
    $.quiui.controls.Menu.prototype.setDisable = $.quiui.controls.Menu.prototype.setDisabled;
})(jQuery);