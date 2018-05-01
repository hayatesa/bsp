$(function() {
	var tab = $("#data-list").bootstrapTable({
		url: '/data/tableData.json',
		method: 'get',
		contentType: 'application/json',
		dataType: 'json',
		detailView: true,
		detailFormatter: detailFormatter,
		cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		striped: true,
		height: 700,
		icons: {
		  paginationSwitchDown: 'glyphicon-collapse-down icon-chevron-down',
		  paginationSwitchUp: 'glyphicon-collapse-up icon-chevron-up',
		  refresh: 'glyphicon-refresh icon-refresh',
		  toggle: 'glyphicon-list-alt icon-list-alt',
		  columns: 'glyphicon-th icon-th',
		  detailOpen: 'glyphicon-plus icon-plus',
		  detailClose: 'glyphicon-minus icon-minus',
		},
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		/*sortOrder: 'asc', //排序方式*/
		queryParams: getQueryParams,
		pageSize: 10,
		pageList: [10, 25, 50, 100],
		showRefresh: true, // 是否显示刷新按钮
		showToggle: true,
		showFullscreen: false,
		showHeader: true,
		showFooter: false,
		showColumns:true,
		showPaginationSwitch: true,
		smartDisplay: true,
		search: true,
		searchOnEnterKey: true,
		searchAlign: 'right',
		sidePagination: "server",
		toolbar: '#tab-toolbar',
		toolbarAlign: 'left',
		trimOnSearch: true,
		minimumCountColumns: 1, //最少允许的列数
		clickToSelect: true,  //是否启用点击选中行
		idField: 'id',
		uniqueId: 'id',
		columns: [
			{checkbox: true, visible: true},
			{field: 'id', title: '用户ID',sortable:true},
			{field: 'name', title: '用户名',sortable:true},
			{field: 'age', title: '年龄',sortable:true},
			{field: 'gender', title: '性别',sortable:true,formatter: genderFormartter},
			{title: '冻结',formatter:operationFormatter},
		],
		/*onLoadSuccess: toggleFormatter,
		onToggle: toggleFormatter*/
		onLoadSuccess: switchFormatter,
		onToggle: switchFormatter,
		onColumnSwitch: switchFormatter
	})
})

var toggleFormatter = function(){
	$(".switch").bootstrapToggle({
		size:'mini',
		onstyle: 'danger',
		offstyle: 'default'
	}).bind("change",freezeChange);
}

var freezeChange = function () {
	$.ajax({
		type: "get",
		url: "/data/changeUserStatusResult.json",
		data:{
			id: $(this)[0].id,
			checked: $(this)[0].checked
		},
		success: function(data){
			if(data.code != 0){
				alert(data.msg);
				$("#data-list").bootstrapTable('refresh');
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			alert("操作失败");
			$("#data-list").bootstrapTable('refresh');
		}
	});
}

// 解决表格视图切换时bootstrap switch样式失效问题
var switchFormatter = function(){
	$(".switch").bootstrapSwitch({
		size:'mini',
		onColor: 'danger',
		offColor: 'default'
	}).bind('switchChange.bootstrapSwitch',freezeChange);
} 

var detailFormatter = function(index,row){
	return "格式化详细页面模式的视图。"
}

var getQueryParams = function(params){
	var p = {
		limit: params.limit,
		pageNumber: params.offset/params.limit+1,
		order: params.order,
		sort: params.sort,
		search: params.search
	};
	return p;
}
var genderFormartter = function(value,row,index){
	if(value === 1){
		return "<span class='label label-warning'>女</span>"
	} else if(value == 0){
		return "<span class='label label-primary'>男</span>"
	} else {
		return "<span class='label label-default'>未知</span>"
	}
	
}
var operationFormatter = function(value,row,index){
	return '<input class="switch" type="checkbox" id="'+ row.id +'"'+ (row.status===0?'checked':'') + '/>';
}

