//图片上传下载测试
function sub(STring[]) {
   var formData = new FormData();
   var img_file = $("#filename");
   
   var fileObj = img_file[0].files[0];
   
   formData.append("filename",fileObj);
   formData.append("strJson",json);
   $.ajax({
	   
	   type: "POST",
       url: PageContext +"/upload.do",
       data:formData,
       async:false,
       processData:false,
       contentType :false,
       success : function(data) {
       	
           alert("aaaaa");
          // $(".newtypepic").val(data);
                       
           //	return false;
       },
       error : function(data, type, err) {
			alert("错误类型：" + type + "; 错误信息：" + err);
			 return false;
		}
   });
}

function old_sub(){
	 $("#queryForm").ajaxSubmit({
	        type: "POST",
	        url: PageContext +"/upload.do",
	        dataType : "text",
	        success : function(data) {
	        	
	        	
	            $(".newtypepic").val(data);
	                        
	            	return false;
	        },
	        error : function(data, type, err) {
				alert("错误类型：" + type + "; 错误信息：" + err);
				 return false;
			}
	    }); 
	    return false;
}