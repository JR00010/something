/**
 * 
 */

<script type="text/javascript">
    function uploadFile(){
        var file = $("#file")[0].files[0];  //文件对象
        if(file==undefined){
            alert("请先选中文件");
            return;
        }
        if(file.size>1024*1024*1024*2){
            alert("文件不能大于2GB");
            return;
        }
        $("#upload").attr("disabled","disabled");
        isUpload(file);
    }
    function isUpload (file) {
        var form=new FormData();
        var reader = new FileReader();
        //绑定读取失败事件
        $(reader).error(function(e){
            $("#upload").removeAttr("disabled");
            alert("读取失败");
        })
        
        var fileWithSize=file;
        //根据文件大小计算fileMd5值
        if(file.size>1024*1024*50){
            var fileStart=file.slice(0,1024*1024);
            var fileEnd=file.slice(file.size-1024*1024，file.size);
            var arr=[fileStart,fileEnd];
            fileWithSize = new Blob(arr, { type: "text/plain" });
        }
        //绑定读取成功事件
        $(reader).load(function(e){
　               var fileMd5 = hex_md5(reader.result);

            form.append("fileMd5", fileMd5);  
            form.append("videoSize", file.size);  
            //校验是否上传过该文件，返回上传进度
            $.ajax({ 
                url: "${basePath}/global/isFileExist",
    
                type: "POST",

                data: form,

                async: true,        //异步

                processData: false,  //很重要，告诉jquery不要对form进行处理

                contentType: false,  //很重要，指定为false才能形成正确的Content-Type

                success: function(data){
                    if(data.code==1){
                        $("#process").css("width","100%");
                        $("#process").html("100%");
                        $("#upload").removeAttr("disabled");
                        alert(data.msg)
                    }else{//视频未上传或者部分上传
                        //分片上传
                        $("#process").css("width","0%");
                        $("#process").html("");
                        uploadBySplit(file,fileMd5,0);
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    $("#upload").removeAttr("disabled");
                    alert("服务器出错!");
                }
            });
        })
        
        reader.readAsBinaryString(fileWithSize);
    }
    //分片上传
    function uploadBySplit(file,fileMd5,i){
        var splitSize=1024*1024*20;//分片大小20M
        var size=file.size;//总大小
        splitCount = Math.ceil(size / splitSize);  //总片数
        
        if(i==splitCount){
            $("#upload").removeAttr("disabled");
            return;
        }
        
        //计算每一片的起始与结束位置
        var start = i * splitSize;
        var end = Math.min(size, start + splitSize);
        
        var fileData=file.slice(start,end);
        var reader = new FileReader();
        $(reader).load(function(e){
　               var md5 = hex_md5(reader.result);

            //构造一个表单，FormData是HTML5新增的
            var form = new FormData();
            form.append("fileMd5", fileMd5);
            form.append("size", size);//总大小
            form.append("total", splitCount);  //总片数
            form.append("index", i);        //当前是第几片
            form.append("md5", md5); 
            
            //判断分片是否上传
             $.ajax({
                url: "${basePath}/global/isFileSplitExist",

                type: "POST",

                data: form,

                async: true,        //异步

                processData: false,  //很重要，告诉jquery不要对form进行处理

                contentType: false,  //很重要，指定为false才能形成正确的Content-Type
                
                success: function(data){
                    if(data.code==1){//已上传
                        //处理上传进度
                        var process=Math.round(end/size*100)+"%";
                        $("#process").css("width",process);
                        $("#process").html(process);
                        i++;
                        uploadBySplit(file,fileMd5,i);
                    }else{//未上传
                        form.append("fileData", fileData);
                        //上传分片
                        $.ajax({
                            url: "${basePath}/global/fileUpload",

                            type: "POST",
            
                            data: form,
            
                            async: true,        //异步
            
                            processData: false,  //很重要，告诉jquery不要对form进行处理
            
                            contentType: false,  //很重要，指定为false才能形成正确的Content-Type
                            
                            success: function(data){
                                //处理上传进度
                                var process=Math.round(end/size*100)+"%";
                                $("#process").css("width",process);
                                $("#process").html(process);
                                i++;
                                uploadBySplit(file,fileMd5,i);
                            },
                             error: function(XMLHttpRequest, textStatus, errorThrown) {
                                $("#upload").removeAttr("disabled");
                                alert("服务器出错!");
                            }
                        
                        });
                    }
                },
                
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    $("#upload").removeAttr("disabled");
                    alert("服务器出错!");
                }
             });
            
            
        });
        reader.readAsBinaryString(fileData);
       
    }
