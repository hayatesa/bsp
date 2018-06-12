$(function() {
	var tab = $("#data-list").bootstrapTable({
		url: '/admin/page',
        method: 'get',
        contentType: 'application/json',
        dataType: 'json',
        //detailView: true,
        //detailFormatter: detailFormatter,
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        striped: true,
        height: 705,
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
        pageSize: 14,
        pageList: [14, 28, 56, 100],
        showRefresh: true, // 是否显示刷新按钮
        showToggle: true,
        showFullscreen: false,
        showHeader: true,
        showFooter: false,
        showColumns:true,
        //showPaginationSwitch: true,
        smartDisplay: true,
        search: true,
        searchOnEnterKey: true,
        searchAlign: 'right',
        sidePagination: "server",
        toolbar: '#tab-toolbar',
        toolbarAlign: 'left',
        trimOnSearch: true,
        minimumCountColumns: 1, //最少允许的列数
        //clickToSelect: true,  //是否启用点击选中行
        idField: 'id',
        uniqueId: 'id',
		columns: [
			{field: 'aUuid', title: '用户ID',sortable:false},
			{field: 'aId', title: '用户名',sortable:false},
			{field: 'aName', title: '姓名',sortable:false},
			{field: 'aPhone', title: '手机号',sortable:false},
			{field: 'aLevel', title: '类型',formatter:levelFormatter,sortable:false},
			{title: '冻结',formatter:operationFormatter},
		],
		/*onLoadSuccess: toggleFormatter,
		onToggle: toggleFormatter*/
		onLoadSuccess: switchFormatter,
		onToggle: switchFormatter,
		onColumnSwitch: switchFormatter
	})
})

var doReload = function () {
    $("#data-list").bootstrapTable('refresh');
}

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
		url: "/admin/lockOrUnlock",
		data:{
			uuid: $(this)[0].id
		},
		success: function(data){
            if (data.code==401){
                window.location.href='/login';
                return;
            }
            if (data.code!=0){
                alert(data.msg);
                doReload();
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
		offColor: 'primary'
	}).bind('switchChange.bootstrapSwitch',freezeChange);
} 

var levelFormatter = function(value,index,row){
    switch (value) {
        case 0:
            return '<span class="label label-primary">永久</span>';
            break;
        case 1:
            return '<span class="label label-info">超级</span>';
            break;
        case 2:
            return '<span class="label label-warning">普通</span>';
            break;
    }
    return '<span class="label label-default">未知</span>';
}
var detailFormatter = function(index,row){
	var nickname = row.details.uNickname?row.details.uNickname:'无';
	var gender = row.details.uSex?row.details.uSex:'无';
	var phone = row.details.uPhone?row.details.uPhone:'无';
	var address = row.details.uAddress?row.details.uAddress:'无';
	var wechat = row.details.uWechat?row.details.uWechat:'无';
	var qq = row.details.uQq?row.details.uQq:'无';
	var signature = row.details.uSignature?row.details.uSignature:'无';
    return '<ul class="media-list">' +
        '  <li class="media">' +
        '    <div class="media-body">' +
        '      <h4 class="media-heading">'+row.user.mail +'</h4>' +
        '      ID：' +row.user.aUuid+
        '      <br/>昵称：' +nickname+
        '      <br/>性别：' +gender+
        '      </br>手机：' +phone+
        '      </br>QQ：' +qq+
        '      </br>微信：' +wechat+
        '      </br>地址：' +address+
        '      </br>个性签名：' +signature+
        '    </div>' +
        '  </li>' +
        '</ul>';
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

var operationFormatter = function(value,row,index){
	return '<input class="switch" type="checkbox" id="'+ row.aUuid +'"'+ (row.isDelete==1?'checked':'') + '/>';
}

var doOpenModal = function (id) {//打开模态框

    $('#input-modal').modal('show');
    // 初始化


}

var vue_app=new Vue({
    el: '#vue-app',
    data: {
        status: 0 // 显示数据
    },
    methods: {
        reload: doReload,
        openModal: doOpenModal,
    },
    created: function () {
    }
});