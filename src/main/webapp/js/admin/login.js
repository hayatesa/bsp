var doLogin = function () {
    var uname=this.username.trim();
    var upassword=this.password.trim();
    if (!uname){
        this.msg='<span class="pull-left text-danger">请填写用户名</span>';
        return;
    }
    if (!upassword){
        this.msg='<span class="pull-left text-danger">请填写密码</span>';
        return;
    }
    $.ajax({
        
    });
}

var login_app = new  Vue({
    el: '#login-page',
    data: {
        username: 'hayate',
        password: '123456',
        msg: '',
        email: ''
    },
    methods: {
        login: doLogin
    }
})