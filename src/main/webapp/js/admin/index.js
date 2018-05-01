$(function(){
	fillPage('/templates/admin/userPage.html')
})

var header_app = new Vue({
	el: "#header-app",
	data: {
		server: server,
		user: {
			id: url('u'),
			username: url('u')
		},
		newMessages: {}
	},
	methods: {
		logout: function() {
			var id = this.user.id;
			confirm('确定退出登录？', function(id){
				$.ajax({
					type:"get",
					url: server + "/data/logout.json?id="+id,
					success: function(data){
						if(data.code === 0){
							window.location.href='login.html';
						}
						else{
							alert('系统异常，请联系管理员');
						}
					}
				});
			});
		},
		loadNewMessages: function() {
			var app = this;
			var m = {};
			$.ajax({
				type:"get",
				url: server + "/data/inboxData.json?id="+this.user.username,
				success: function(data){
 					if(data.num){
 						app.newMessages = data;
 					}
				}
			});
		},
		timeFormat: function(ms){
			// 毫秒转日期时间
			return millisecondsToDateTime(ms);
		},
		titleFormat: function(msg){
			// 长度超过12，截取12个字符
			if(msg.length<=12){
				return msg;
			}				
			return msg.substr(0,11)+"···";
		},
		numberFormat: function(num){
			// 消息数量角标，大于99显示99+
			if(num<=99){
				return num;
			}
			return '&middot;&middot;';
		},
		settings:function(){
			sidebar_app.go('/templates/admin/settings.html','系统设置');
		}
	},
	computed :{
		
	},
	created: function(){
		// 创建实例时获取未读消息
		this.loadNewMessages();
	}
})

var sidebar_app = new Vue({
	el: "#sidebar-app",
	data:{
		title: '主页',
		user: {
			id: url('u'),
			username: url('u')
		}
	},
	methods: {
		profileEdit: function(){
			alert('修改信息成功')
		},
		go: function(p,tilte){
			fillPage(p)
			this.title = tilte;
		}
	}
})

var title_app = new Vue({
	el: "#title-app",
	data:{
	},
	computed:{
		title: function(){
			return sidebar_app.title;
		},
	},
	methods: {
		
	}
})

var fillPage = function(goal){
	$.ajax({
		method:"get",
        dataType: "html",
		url: server + goal,
		success: function(content) {
			$("#page-container").html(content)
		}
	});
}
