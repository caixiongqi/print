<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浏览器打印</title>
<!-- 不需要打印的内容设置display。 设置打印不显示页眉用page注解下的margin属性 -->
<style type="text/css" media="print">
	.noprint {
		display: none;
	}
	
	@page {
	    size: auto;  /* auto is the initial value */
	    margin: 0mm; /* this affects the margin in the printer settings */
    }
</style>
</head>
<body>
	<!--startprint-->
	<div>
		<h1>测试打印</h1><br/>
	</div>
	<div>
		<img src="/image/erweima.png">
	</div>
	<!--endprint-->
	<div class="noprint">
		<input type="button" id="print" name="print" onclick="doPrint()" value="打印">
	</div>

	<script type="text/javascript"
		src="/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		function doPrint() {
			/* oldHtml = window.document.body.innerHTML;

			sprnstr = "<!--startprint-->"; //开始打印标识字符串有17个字符
			eprnstr = "<!--endprint-->"; //结束打印标识字符串
			prnhtml = oldHtml.substr(oldHtml.indexOf(sprnstr) + 17); //从开始打印标识之后的内容
			prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr)); //截取开始标识和结束标识之间的内容
			window.document.body.innerHTML = prnhtml; //把需要打印的指定内容赋给body.innerHTML
			window.print(); //调用浏览器的打印功能打印指定区域 
			window.document.body.innerHTML = oldHtml;//重新给页面内容赋值；*/
			window.print();
		}
	</script>
</body>
</html>