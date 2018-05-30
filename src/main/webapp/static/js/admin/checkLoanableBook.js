$(function() {
	var tab = $("#data-list").bootstrapTable({
		url: '/clb/page',
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
			{field: 'clbId', title: 'ID',sortable:true},
			{field: 'clbName', title: '书名',sortable:true},
			{field: 'isbn', title: 'ISBN',sortable:true},
			{field: 'clbNumber', title: '数量',sortable:true},
			{title: '操作',formatter:operationFormatter},
		],
	})
})

var detailFormatter = function(index,row){
	return "格式化详细页面模式的视图。"
}

var getQueryParams = function(params){
	var p = {
		limit: params.limit,
		pageNumber: params.offset/params.limit+1,
		order: params.order,
		sort: params.sort,
		search: params.search,
        clbStatus: 0,
	};
	return p;
}

var operationFormatter = function(value,row,index){
	return '';
}

