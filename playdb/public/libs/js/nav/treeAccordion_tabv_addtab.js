var treeData;
var zTree_Menu = null;
	var setting = {
		view: {
			fontCss: getFontCss,
			showLine: false,
			selectedMulti: false,
			dblClickExpand: false
		},
		callback: {
			beforeClick:beforeClick,
			onClick: onClick
		}
	};
	
	
	
	function initComplete(){
		initTree(0);
		
		//所在位置
		top.frmright.positionContent="【"+uncompile(quiLanguage.treeAccordion.positionContent2)+"首页】";
		top.frmright.createPosition(top.frmright.positionTarget,top.frmright.positionContent);
		
		//$("#vTab").verticalTabModernRender();
		//$("#vTab").bind("actived",function(e,i){
		//initTree(i);
		
			//存储点击tab索引
			//jQuery.jCookie('leftvtabIdx',i.toString());
		//})
		
		//每次刷新时保持上次打开的
		showContent();
		triggerCustomHeightSet()
		//$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		//zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
	}
	function initTree(idx){
		treeData=getTreeData(idx);
		var zNodes=treeData.treeNodes;
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
	}
	
	//每次刷新时保持上次打开的
	function showContent(){
		//还原上次选中的tab
		var vtabIdx=jQuery.jCookie('leftvtabIdx');
		if(vtabIdx==false||vtabIdx=="false"){
			initTree(0);
		}
		else{
			var idx=parseInt(vtabIdx);
			$("#vTab").verticalTabSetIdx(idx);
			initTree(idx);
		}
		
		var treeNodeId=jQuery.jCookie('leftTreeNodeId');
		if(treeNodeId==false||treeNodeId=="false"){
			top.positionType="simple";
			top.positionContent="【"+uncompile(quiLanguage.treeAccordion.positionContent1)+"】";
		}
		else{
			var node = zTree_Menu.getNodeByParam("id", treeNodeId);
			//展开上次选中的
			zTree_Menu.selectNode(node);
			
			//如果上次选中的为第一级或第二级节点，则添加选中样式
			if (node.level === 0||node.level === 1) {
				//得到当前点击节点，添加选中样式
				var a = $("#" + node.tId + "_a");
				a.click()
			}
			if(node.url){
				//每次刷新时设置当前位置内容
				top.positionType="simple";
				if(node.getParentNode()){
					top.positionContent="【"+uncompile(quiLanguage.treeAccordion.positionContent2)+node.getParentNode().name+">>"+node.name+"】";
				}
				//打开上次的链接
				top.frmright.location=node.url;
			}
		}
	}
	//每次点击切换状态和样式
	function beforeClick(treeId, treeNode) {
			//第一级点击项添加选中样式
			if (treeNode.level === 0) {
				//第一级移除选中样式
				$("#"+treeId).find("a").each(function(){
					if($(this).hasClass("curLevel0")){
						$(this).removeClass("curLevel0");
					}
				})
				
				var a = $("#" + treeNode.tId + "_a");
				a.addClass("curLevel0");
			
				//单击展开或收缩
				if(treeNode.open){
					zTree_Menu.expandNode(treeNode,false);
					var a = $("#" + treeNode.tId + "_a");
					a.removeClass("curLevel0");
					a.removeClass("curSelectedNode");
				}
				else{
					zTree_Menu.expandAll(false);
					zTree_Menu.expandNode(treeNode);
				}
			}
			else if (treeNode.level === 1) {
				//第二级移除选中样式
				$("#"+treeId).find("a").each(function(){
					if($(this).hasClass("curLevel1")){
						$(this).removeClass("curLevel1");
					}
				})
				
				var a = $("#" + treeNode.tId + "_a");
				a.addClass("curLevel1");
				//单击展开或收缩
				if(treeNode.open){
					zTree_Menu.expandNode(treeNode,false);
					var a = $("#" + treeNode.tId + "_a");
					a.removeClass("curLevel1");
					a.removeClass("curSelectedNode");
				}
				else{
					zTree_Menu.expandNode(treeNode);
					var a2 = $("#" + treeNode.getParentNode().tId + "_a");
					a2.addClass("curLevel0");
				}
			}
			else{
				zTree_Menu.expandNode(treeNode);
			}
			
			
		}
		
	function onClick(e,treeId, treeNode){
		if (treeNode.level === 0) {
			if(!treeNode.open){
				var a = $("#" + treeNode.tId + "_a");
				a.removeClass("curSelectedNode");
			}
		}
		
		//出现进度条
		if(treeNode.tabUrl!=null){
			showProgressBar();
			top.frmright.tabAddHandler(treeNode.id,treeNode.name,treeNode.tabUrl);
		}
		
		//存储点击节点id
		jQuery.jCookie('leftTreeNodeId',treeNode.id.toString());
		if (treeNode.level === 0){
			if(!treeNode.open){
				jQuery.jCookie('leftTreeNodeId',"false");
			}
		}
	}
	

	function  showAll(){
		zTree_Menu.expandAll(true);
	}
	function  hideAll(){
		zTree_Menu.expandAll(false);
		//所在位置
		top.frmright.positionContent="【"+uncompile(quiLanguage.treeAccordion.positionContent2)+"首页】";
		top.frmright.createPosition(top.frmright.positionTarget,top.frmright.positionContent);
		jQuery.jCookie('leftTreeNodeId',"false");
	}
	function findNode(){
		var value = $.trim($("#searchKey").val());
		if(value!=""){
			getNodesByParamFuzzy('name', value)
		}
	}
	 //根据某一条件查找节点 模糊查询
    function getNodesByParamFuzzy(key, value, parentNode){
        var nodes = zTree_Menu.getNodesByParamFuzzy(key, value, parentNode);  
        //取消之前的高亮显示
        highlightNodes(zTree_Menu, zTree_Menu.highlightNodeList, false);
        //高亮显示
        highlightNodes(zTree_Menu, nodes, true);
        zTree_Menu.highlightNodeList = nodes;
        //选中第一个
        if(null != nodes && nodes.length > 0){
            zTree_Menu.expandAll(false);
			var pNode=nodes[0].getParentNode()
			zTree_Menu.expandNode(pNode,true);
			zTree_Menu.expandNode(nodes[0],true);
        }
    }
	
	//根据某一条件查找节点 精确查询
    function getNodesByParam(key, value, parentNode){
        var nodes = zTree_Menu.getNodesByParam(key, value, parentNode);  
        //取消之前的高亮显示
        highlightNodes(zTree_Menu, zTree_Menu.highlightNodeList, false);
        //高亮显示
        highlightNodes(zTree_Menu, nodes, true);
        zTree_Menu.highlightNodeList = nodes;
        //选中第一个
        if(null != nodes && nodes.length > 0){
           
			var pNode=nodes[0].getParentNode()
			if(!pNode.open){
				 zTree_Menu.expandAll(false);
				 zTree_Menu.expandNode(pNode,true);
			}
			//每次点击时设置当前位置内容
			if(pNode){
				top.frmright.positionContent="【"+uncompile(quiLanguage.treeAccordion.positionContent2)+pNode.name+">>"+nodes[0].name+"】";
			}
			else{
				top.frmright.positionContent="【"+uncompile(quiLanguage.treeAccordion.positionContent2)+nodes[0].name+"】";
			}
			top.frmright.positionType="simple";
			top.frmright.createPosition(top.frmright.positionTarget,top.frmright.positionContent);
			//zTree_Menu.expandNode(nodes[0],true);
        }
    }
    
    //高亮显示
    function highlightNodes(zTree, nodes, highlight) {
        if(null == nodes)  return;
		for( var i = 0, l = nodes.length; i < l; i++) {
			nodes[i].highlight = highlight;
			zTree.updateNode(nodes[i]);
		}
	}
	function getFontCss(treeId, node){
	    return (!!node.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
	}
	//返回首页的处理
	function homeHandler(){
		zTree_Menu.expandAll(false);
		top.positionType="none";
		jQuery.jCookie('leftTreeNodeId',"false");
	}
