$(function(){
	$("#addThu").hide();
	$("#thursday").on('click',function() {
		if(this.checked) {
			var count1 = document.getElementsByClassName("mon1").length;
			var count2 = document.getElementsByClassName("moncount").length;
			var count3 = document.getElementsByClassName("tue1").length;
			var count4 = document.getElementsByClassName("tuecount").length;
			var count5 = document.getElementsByClassName("wed1").length;
			var count6 = document.getElementsByClassName("wedcount").length;
			var count7 = document.getElementsByClassName("thu1").length;
			var count8 = document.getElementsByClassName("thucount").length;
			var count9 = document.getElementsByClassName("fri1").length;
			var count10 = document.getElementsByClassName("fricount").length;
			var count11 = document.getElementsByClassName("sat1").length;
			var count12 = document.getElementsByClassName("satcount").length;
			var count13 = document.getElementsByClassName("sun1").length;
			var count14 = document.getElementsByClassName("suncount").length;
			var count = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14;
			if(count === 0) {
				count = 0
			} else {
				count = count
			}
			
			//チェックがついたら、チェックボックスにnameを追加
			var thursday = document.getElementById("thursday");
			thursday.setAttribute("name","ramenShopTimeList[" + count + "].days");
			
			//<div id="parentTue">の中に<div>を形成していく
			var parentThu = document.getElementById("parentThu");
			var childThu = document.createElement("div");
			childThu.setAttribute("id","idThu");
			
			var noonStartTime = document.createElement("input");
			noonStartTime.setAttribute("type","number");
			noonStartTime.setAttribute("placeholder","開始時間");
			noonStartTime.setAttribute("name","ramenShopTimeList[" + count + "].noonStartTime");
			noonStartTime.setAttribute("class","thu1");
			
			var noonEndTime = document.createElement("input");
			noonEndTime.setAttribute("type","number");
			noonEndTime.setAttribute("placeholder","終了時間");
			noonEndTime.setAttribute("name","ramenShopTimeList[" + count + "].noonEndTime");
			
			childThu.appendChild(noonStartTime);
			childThu.appendChild(document.createTextNode("\u0020"));
			childThu.appendChild(noonEndTime);
			childThu.appendChild( document.createElement('br'));
			childThu.appendChild( document.createElement('br'));
			
			parentThu.appendChild(childThu);
			
			$("#addThu").show();
		} else {
			$("#addThu").hide();
			$("#idThu").remove();
		}
		
	});
});

$(function(){
	
	$("#addThu").on('click',function(){
		var count1 = document.getElementsByClassName("mon1").length;
		var count2 = document.getElementsByClassName("moncount").length;
		var count3 = document.getElementsByClassName("tue1").length;
		var count4 = document.getElementsByClassName("tuecount").length;
		var count5 = document.getElementsByClassName("wed1").length;
		var count6 = document.getElementsByClassName("wedcount").length;
		var count7 = document.getElementsByClassName("thu1").length;
		var count8 = document.getElementsByClassName("thucount").length;
		var count9 = document.getElementsByClassName("fri1").length;
		var count10 = document.getElementsByClassName("fricount").length;
		var count11 = document.getElementsByClassName("sat1").length;
		var count12 = document.getElementsByClassName("satcount").length;
		var count13 = document.getElementsByClassName("sun1").length;
		var count14 = document.getElementsByClassName("suncount").length;
		var count = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14;
		if(count === 0) {
			count = 0
		} else {
			count = count
		}

		var nightStartTime = document.createElement("input");
	    nightStartTime.setAttribute("type","number");
	    nightStartTime.setAttribute("placeholder","開始時間");
	    nightStartTime.setAttribute("name","ramenShopTimeList[" + count + "].nightStartTime");
	    nightStartTime.setAttribute("class","thu2 thucount");
		
		var nightEndTime = document.createElement("input");
		nightEndTime.setAttribute("type","number");
		nightEndTime.setAttribute("placeholder","終了時間");
		nightEndTime.setAttribute("name","ramenShopTimeList[" + count + "].nightEndTime");
		nightEndTime.setAttribute("class","thu2");
		
		var days = document.createElement("input");
		days.setAttribute("type","checkbox");
		days.setAttribute("checked","checked");
		days.setAttribute("value","木曜日");
		days.setAttribute("name","ramenShopTimeList[" + count + "].days");
		days.setAttribute("id","checkThu");
		days.setAttribute("class","thu2");
		
		
		var del = document.createElement("input");
		del.setAttribute("type","button");
		del.setAttribute("value","削除");
		del.setAttribute("id","del");
		del.setAttribute("class","thu2");
	    
	   
		var childThu = document.getElementById("idThu");
		childThu.appendChild(nightStartTime);
		childThu.appendChild(document.createTextNode("\u0020"))
		childThu.appendChild(nightEndTime);
		childThu.appendChild(days);
		childThu.appendChild(del);
		
		$("#checkThu").hide();
    
    if(count >= 1) {
    	$("#addThu").hide();
    }
    $("#del").on('click',function(){
    	$(".thu2").remove();
    	$("#addThu").show();
    })
	});
});