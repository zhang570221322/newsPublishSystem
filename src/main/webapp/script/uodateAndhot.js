       (function ($) {
           //扩展方法获取url参数
           $.getUrlParam = function (name) {

               var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象

               var r = window.location.search.substr(1).match(reg);  //匹配目标参数

               if (r != null) return unescape(r[2]); return null; //返回参数值
           }
       })(jQuery);

$(document).ready(function(){
//               alert("test");
    $.ajax({
        type:'get',
        url:"GET/application/indexContent.do",
        cache:false,
        dataType:'json',
        success:function(data){
//                           alert("success");
//                           alert(data.user);
//                       alert(data.categories);
            if(data!=null){

                $.each( data.recentReports , function(index, content)
                {
                    $('#updateReport').append(
                        "<a href='detail.html?id="+content.id+"'>"+content.title+"</a> 	<span class='label label-success'> "+content.clickNumber+"</span> <br><br>"
                    );
                });
                $.each( data.hottestReports , function(index, content)
                {
                    $('#hottestReports').append(
                        "<a href='detail.html?id="+content.id+"'>"+content.title+"</a> 	<span class='label label-success'> "+content.clickNumber+"</span> <br><br>"
                    );
                });


            }else{
                alert("error");
            }
        }
    });
});