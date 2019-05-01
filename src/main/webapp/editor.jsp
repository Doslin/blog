<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="en-US">

<head>
    <meta charset="UTF-8">
    <title>ueditor demo</title>
    <script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body>
<!-- 加载编辑器的容器,可为div等其他的标签，提供ID就好 -->
<textarea id="uploadEditor" ></textarea>
</body>


<!-- 使用ue -->
<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('uploadEditor');
    //此处是定义自己的controller访问上传
    UE.Editor.prototype._bkGetActionUrl=UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl=function(action){
        if (action == 'uploadimage' ||action== 'uploadscrawl' || action == 'uploadimage') {
            return "${pageContext.request.contextPath}/uploadimage.do";
        } else if(action =='uploadvideo') {
            return "${basePath}/upload";
        } else if(action == 'listimage'){
            return "${basePath}/download";
        } else{
            return this._bkGetActionUrl.call(this, action);
        }
    }


</script>

//初始化之后可通过函数调用
如：var content = UE.getEditor('uploadEditor').getContent();获取html内容

</html>
