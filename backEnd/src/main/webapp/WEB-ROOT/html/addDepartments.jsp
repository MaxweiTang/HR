<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%-- <link rel="stylesheet"
	href="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/WEB-ROOT/css/common.css"> --%>
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="addModel" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div id="addAlert">
		</div>
		<div class="modal-dialog" style="width: 60%; ">
		<!--  这下面放一个隐藏的input框-->
			<input type="hidden" id="submitType" value="POST">
			<div class="modal-content" style="background: #F5F5F5;">
				<div class="modal-header">
					<button type="button" class="close" id="addAlertSubmit"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">新增部门</h4>
				</div>
				<!-- <form class="form-inline horizontal " role="form"> -->
				<form class="form-horizontal" role="form" id="depForm" >
					<div class="modal-body" style="height: 60%;">
						<div class="col-lg-10 col-md-9 col-sm-9 ">

							<!-- <div class="row"> -->
							<div class="form-group " >
								<label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">部门编号</label>
								<div class=" col-lg-4 " style=" padding-top: 25px;">
									<input type="text" class=" form-control  " name="number"
										id="number" placeholder="请输入部门编号">
								</div>
								<label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">部门名称</label>
								<div class=" col-lg-4 " style=" padding-top: 25px;">
								 <input
									type="text" class="form-control  col-lg-4 " name="name"
									id="name" placeholder="请输入部门名称">
								</div>
								<label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">部门负责人</label>
								<div class=" col-lg-4 " style=" padding-top: 25px;">
								 <input
									type="text" class="form-control  col-lg-4 " name="manager"
									id="manager" placeholder="请输入部门负责人">
								</div>
								<label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">部门电话</label>
								<div class=" col-lg-4 " style=" padding-top: 25px;">
								 <input
									type="text" class="form-control  col-lg-4 " name="telephone"
									id="telephone" placeholder="请输入部门电话">
								</div>
								
							</div>
							
							
							<!-- 	</div> -->
						</div>

					</div>
					<div class="modal-footer">
						
					<!-- 	<button type="button" class="btn btn-info btn-sm " id=addSubmit
							data-dismiss="modal" style="margin-left: 15px; margin-right: 5%;">
							<span class="glyphicon glyphicon-user"></span> 新增员工
						</button> -->
						<button type="submit" class="btn btn-info btn-sm " id="addSubmit"
							name="submit"  style="margin-left: 15px; margin-right: 5%;">
							<span class="glyphicon glyphicon-user"></span> 确定
						</button>
						
					</div>

				</form>






			</div>
			<!-- /.modal-content -->
		</div>
	</div>
	<%-- <script
		src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/jquery-min.js"></script>
	<script
		src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/bootstrap.min.js"></script> --%>
	<script type="text/javascript">
	
	
		
/* 	$("#addSubmit").click(function(){
		
		var getFormData=function(form){ 
			var o={}; 
			$.each(form.serializeArray(),function(index){ 
			if(o[this['name']]){ 
			o[this['name']] = o[this['name']]+","+this['value']; 
			}else{ 
			o[this['name']] = this['value']; 
			} 
			}); 
			return o; 
			} 
		
		 $( "#addAlert" ).load( "WEB-ROOT/common/alert.jsp", function( response, status, xhr ) {
     		$('#addAlert').html(response);
    	 });
	 	var user = getFormData($("#depForm"));  
		  $.ajax({
	        type : "POST",  //请求方式
	        url : "${pageContext.request.contextPath}/departments",  //请求路径
	        data: user, 
	        async: true,
	        dataType:"json",   
	       // contentType:"application/json;charset=utf-8",
	        success : function(msg) {  //异步请求成功执行的回调函数
	        	$("#alertText").text(msg);
	        	$("#alertModel").modal({
	     	        keyboard: true
	     	    }); 
	     	 //  selectList("true"); 
	        },//ajax引擎一般用不到；状态信息；抛出的异常信息
	        error : function(msg) {
	        	alert("失败");
	        	$("#alertText").text("添加失败");
	        	$("#alertModel").modal({
	     	        keyboard: true
	     	    });  
	        }
	    });
		
	});  */
	
	
	$(function() {
		$('#depForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				number : {
					message : '部门编号验证失败',
					validators : {
						notEmpty : {
							message : '部门编号不能为空'
						},
						regexp : {
							regexp : /^[a-zA-Z0-9_]+$/,
							message : '员工编号只能包含大写、小写、数字和下划线'
						}
					}
				},
				name : {
					validators : {
						notEmpty : {
							message : '部门名称不能为空'
						},
						
					}
				},
				manager : {
					validators : {
						notEmpty : {
							message : '部门负责人不能为空'
						},
						

					}
				},
			}

		}).on(
				'success.form.bv',
				function(e) {//点击提交之后
					// Prevent form submission
					e.preventDefault();

					// Get the form instance
					var $form = $(e.target);

					// Get the BootstrapValidator instance
					var bv = $form.data('bootstrapValidator');

					// Use Ajax to submit form data 提交至form标签中的action，result自定义

				 	var departments = getFormData($("#depForm"));  
					  $.ajax({
				        type : $("#submitType").val(),  //请求方式
				        url : "${pageContext.request.contextPath}/departments",  //请求路径
				        data: departments, 
				        async: true,
				        dataType:"json",   
				        //contentType:"application/json;charset=utf-8",
				        success : function(msg) {  //异步请求成功执行的回调函数
				        	 $( "#addAlert" ).load( "WEB-ROOT/common/alert.jsp", function( response, status, xhr ) {
				          		$('#addAlert').html(response);
				          		$("#alertText").text(msg);
					        	$("#alertModel").modal({
					     	        keyboard: true
					     	    }); 
				         	 });
				        	
				     	 //  selectList("true"); 
				        },//ajax引擎一般用不到；状态信息；抛出的异常信息
				        error : function(msg) {
				        	//alert("失败");
				        	$( "#addAlert" ).load( "WEB-ROOT/common/alert.jsp", function( response, status, xhr ) {
				          		$('#addAlert').html(response);
				          		$("#alertText").text("添加失败");
					        	$("#alertModel").modal({
					     	        keyboard: true
					     	    }); 
				         	 });
				        }
				    });
				});
	});
	
	
	
	</script>


</body>