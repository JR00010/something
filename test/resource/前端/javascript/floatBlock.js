
/**
 * 出口浮动指令，非全局指令，按需导入
 * 指令使用  ：在标签中加入指令 v-floatBlock
 * 可传值 对象  ：
 * 	demo：""
 * 		rollNodeID：滚动条元素的id值，优先于rollNodeClass
 * 		rollNodeClass： 滚动条元素的class值 ，如果有多个相同class元素的node 值取最后一个
 * 		Yheight：Y轴方向可调整高度 ，默认0.
 * 
 */

import Vue from 'vue';
Vue.directive('floatBlock',{
	 bind(el, binding, vnode, oldVnode){
        //准备工作
        //例如，添加事件处理器或只需要运行一次的高耗任务
        const sty = el.currentStyle || window.getComputedStyle(el, null);
        
        let moveDown = (e) => {

            // 鼠标按下，计算当前元素距离可视区的距离

            const disX = e.clientX - el.offsetLeft;

            const disY = e.clientY - el.offsetTop;

            // 获取到的值带px 正则匹配替换

          /*  let styL, styT;

            // 注意在ie中 第一次获取到的值为组件自带50% 移动之后赋值为px

            if (sty.left.includes('%')) {

                styL = +document.body.clientWidth * (+sty.left.replace(/\%/g, '') / 100);

                styT = +document.body.clientHeight * (+sty.top.replace(/\%/g, '') / 100);

            } else {

                styL = +sty.left.replace(/\px/g, '');

                styT = +sty.top.replace(/\px/g, '');

            };*/

            document.onmousemove = function (e) {

                // 通过事件委托，计算移动的距离

                const l = e.clientX - disX;

                const t = e.clientY - disY;

                // 移动当前元素 

                el.style.left = `${l}px`;

                el.style.top = `${t}px`;

                //将此时的位置传出去

                //binding.value({x:e.pageX,y:e.pageY})

            };

            document.onmouseup = function (e) {

                document.onmousemove = null;

                document.onmouseup = null;

            };

        }
		el.style.cursor = 'move';
		
		el.onmousedown = moveDown;
		
		/************************************************************/
        
        let  rollNode = getRollNnode(binding);
        
        let reheiht  = binding.value.Yheight || 0; 
        
		let top = 0; //相对滚动元素的高度
		
        rollNode.onscroll = function(){
        	let Yoffset = rollNode.scrollTop; // 获取滚动过的距离
        	
        	let scollHeight = rollNode.scrollHeight; //滚动的总高度
        	
	        let clientCH = rollNode.clientHeight; // 获取滚动窗口的可视高度

			let clientEH = el.clientHeight; // 获取浮动窗口的可视高度
			
	        let leHeiht = el.offsetHeight ;
	        
	        if(top == 0){
	         	let divp = document.createElement('div');
	         	
		        divp.style.position = 'relative';
		        divp.style.background = 'transparent';
		        
		        let parentNode = el.parentNode;
		        
		        parentNode.insertBefore(divp,el);
		        
		        parentNode.removeChild(el);
		        
		        divp.appendChild(el);
		        
		        let PageTop = getElementPageTop(rollNode);
		        
		        let PageTop2 = getElementPageTop(el); // 元素在文档中的位置
		        
		    	let top1 = PageTop2 - PageTop;
		    	
		        top = top1 + leHeiht;
	        }
	        if(top <=  clientCH){ //最开始就显示在滚动窗口内
	        	
	        	if(Yoffset > top -  leHeiht ){ // 窗口浮动
	        		
	        		el.style.position = 'absolute';
	        		
        			el.style.top = (Yoffset - top ) + clientCH - reheiht + 'px';		
	        	}else{ // 窗口还原
	        		
	        		el.style.position = 'static';
	        	}
	        	
	        }else{
	        	if(Yoffset >= top - clientCH){
	        		
	        		el.style.position = 'absolute';
	        		
        			el.style.top = Yoffset - (top - clientCH)  - reheiht + 'px';	
	        	}else{ // 窗口还原
	        		
	        		el.style.position = 'static';
	        	}
	        	
	        }
        }
        
    },

    update(el, binding, vnode, oldVnode){
        //值更新时的工作
        //也会以初始值为参数调用一次
        
    },

    unbind(el, binding, vnode, oldVnode){
        //清理工作
        //例如，删除bind()添加的事件监听器
    }
})
function getElementPageTop(element){
        var actualTop=element.offsetTop;
        var parent=element.offsetParent;
        while(parent!=null){
            actualTop+=parent.offsetTop+(parent.offsetHeight-parent.clientHeight)/2;
            parent=parent.offsetParent;
        }
        return actualTop;
}
//取窗口可视范围的高度 
function getClientHeight(element) {
	var clientHeight = 0;
	if(document.body.clientHeight && document.documentElement.clientHeight) {
		var clientHeight = (document.body.clientHeight < document.documentElement.clientHeight) ? document.body.clientHeight : document.documentElement.clientHeight;
	} else {
		var clientHeight = (document.body.clientHeight > document.documentElement.clientHeight) ? document.body.clientHeight : document.documentElement.clientHeight;
	}
	return clientHeight;
}

function getRollNnode(binding){
		let valueObj = binding.value;
        
        let rollNodeId = valueObj.rollNodeID;
        let rollNodeClass = valueObj.rollNodeClass;
        
        let rollNode = document.getElementById(rollNodeId);
        if( rollNode != null ){
        	return rollNode;
        }
        let rollNode1 = document.getElementsByClassName(rollNodeClass);
        rollNode = rollNode1.length == 0 ?null:rollNode1[rollNode1.length-1];
        if( rollNode != null ){
        	return rollNode;
        }
        return window;
}
