$(function () {
    var tab = $("#data-list").bootstrapTable({
        //url: '/proccess/page',
        url: '/static/data/orderData.json',
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
            //{checkbox: true, visible: true},
            {field: 'lrId', title: '订单号',sortable:true},
            {field: 'loanableBook.lbName', title: '书名',sortable:false},
            {field: 'amount', title: '数量',sortable:false},
            {field: 'loanableBook.user.mail', title: '借出方',sortable:false},
            {field: 'user.mail', title: '借入方',sortable:false},
            //{field: 'createTime', title: '订单日期',formatter:createTimeFormatter,sortable:true},
            //{field: 'takeAwayTime', title: '开始日期',formatter:takeAwayTimeFormatter,sortable:true},
            //{field: 'expectedReturnTime', title: '还书日期',formatter:expectedReturnTimeFormatter,sortable:true},
            {title: '状态', formatter:statusFormatter},
            {title: '操作',formatter:operationFormatter},
        ],
    })
})
var init_table = function() {

}

var createTimeFormatter= function (index,row) {
    return millisecondsToDateTime(row.createTime);
}

var takeAwayTimeFormatter= function (index,row) {
    return millisecondsToDateTime(row.takeAwayTime);
}

var expectedReturnTimeFormatter= function (index,row) {
    return millisecondsToDateTime(row.expectedReturnTime);
}

var statusFormatter = function(index,row){
    switch(row.lrStruts)
    {
        case 0:
            return '<span class="label label-success">正常</span> 等待借出方同意';
            break;
        case 4:
            return '<span class="label label-success">正常</span> 等待借出方把图书送达中转站';
            break;
        case 6:
            return '<span class="label label-success">正常</span> 等待借入方取走图书';
            break;
        case 7:
            return '<span class="label label-danger">异常</span> 借入方未按时取走图书，等待借入方取回图书';
            break;
        case 8:
            return '<span class="label label-success">正常</span> 等待借出方送达中转站';
            break;
        case 9:
            return '<span class="label label-danger">异常</span> 借入方未按时归还图书';
            break;
        case 10:
            return '<span class="label label-success">正常</span> 等待借出方取回图书';
            break;
        case 11:
            return '<span class="label label-danger">异常</span> 借出方未按时取回图书';
            break;
        default:
            return '等待借入方取走';
            break;
    };
}

var detailFormatter = function(index,row){
	return '<ul class="media-list">' +
        '  <li class="media">' +
        '    <div class="media-body">' +
        '      <h4 class="media-heading">'+row+'</h4>' +
        '      XX：' +row+
        '      </br>XX：' +row+
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
		search: params.search,
        status: vue_app.status,
	};
	return p;
}

var operationFormatter = function(value,row,index){// 根据订单状态生成操作按钮
    var html = '<div id="tab-toolbar" class="btn-group" role="group" >';
    if (row.lrStruts==4 || row.lrStruts==6 || row.lrStruts==7 || row.lrStruts==8 || row.lrStruts==9 || row.lrStruts==10 || row.lrStruts==11 || row.lrStruts==12) {
        html+='<button onclick="doNextStep('+row.clbId+')" type="button" class="btn btn-defualt btn-xs" title="下一步"><i class="fa fa-arrow-right" aria-hidden="true"></i> 下一步</button>';
    }
    if(row.lrStruts==7 || row.lrStruts==11) {
        html+='<button onclick="doDonate('+row.clbId+')" type="button" class="btn btn-danger btn-xs" title="捐赠"><i class="fa fa-share-alt" aria-hidden="true"></i> 捐赠</button>';
    }
    html+='<button onclick="doOpenModal('+row.clbId+')" type="button" class="btn btn-primary btn-xs" title="发送消息"><i class="fa fa-send-o" aria-hidden="true"></i> 消息</button>';
    html+='</div>';
    return html;
}

var doReload = function () {
    $("#data-list").bootstrapTable('refresh');
}

var doSendMsg=function () {
    confirm("确认操作", function () {
        $.ajax({
            url: '',
            data: {
                lrId: id
            },
            success: function (data) {
                if (data.code!=0){
                    alert(data.msg);
                }
                doReload();
            }
        })
    })
}

var doDonate=function () {
    confirm("确认操作", function () {
        $.ajax({
            url: '',
            data: {
                lrId: id
            },
            success: function (data) {
                if (data.code!=0){
                    alert(data.msg);
                }
                doReload();
            }
        })
    })
}

var doOpenModal = function (id) {//打开模态框
    $('#input-modal').modal('show');
}

var doNextStep=function (id) {//审核通过
    confirm("确认操作", function () {
        $.ajax({
            url: '/proccess/next_step',
            data: {
                lrId: id
            },
            success: function (data) {
                if (data.code!=0){
                    alert(data.msg);
                }
                doReload();
            }
        })
    })
}

var vue_app=new Vue({
    el: '#vue-app',
    data: {
        status: 0,
        sendTo: 1,
        msg: '',
        inputMsg: ''
    },
	methods: {
		reload: doReload,
	},
	created: function () {
        init_table();
    }
});