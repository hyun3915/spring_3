/**
 * 
 */
	$("#btn").click(function () {
		var i = $("#id").val();
		var p = $("#pw").val();
		var n = $("#name").val();
		var e = $("#email").val();
		
		var ch1 = false;
		var ch2 = false;
		var ch3 = false;		
		var ch4 = false;		
		
		if(i!=''){
			ch1 = true;
		}
		if(p!=''){
			ch2 = true;
		}
		if(n!=''){
			ch3 = true;
		}
		if(e!=''){
			ch4 = true;
		}
		
		if(ch1 &&ch2 &&ch3 &&ch4) {
			$("#frm").submit();
		}else{
			alert("필수 항목을 입력하세요");
		}
		
	});