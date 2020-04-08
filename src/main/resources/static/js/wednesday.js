$(function(){
	$("#addWed").hide();
	$("#wednesday").on('click',function() {
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
			var wednesday = document.getElementById("wednesday");
			wednesday.setAttribute("name","ramenShopTimeList[" + count + "].days");
			
			//<div id="parentTue">の中に<div>を形成していく
			var parentWed = document.getElementById("parentWed");
			var childWed = document.createElement("div");
			childWed.setAttribute("id","idWed");
			
			var noonStartTime = document.createElement("input");
			noonStartTime.setAttribute("type","number");
			noonStartTime.setAttribute("placeholder","開始時間");
			noonStartTime.setAttribute("name","ramenShopTimeList[" + count + "].noonStartTime");
			noonStartTime.setAttribute("class","wed1");
			
			var noonEndTime = document.createElement("input");
			noonEndTime.setAttribute("type","number");
			noonEndTime.setAttribute("placeholder","終了時間");
			noonEndTime.setAttribute("name","ramenShopTimeList[" + count + "].noonEndTime");
			
			childWed.appendChild(noonStartTime);
			childWed.appendChild(document.createTextNode("\u0020"));
			childWed.appendChild(noonEndTime);
			childWed.appendChild( document.createElement('br'));
			childWed.appendChild( document.createElement('br'));
			
			parentWed.appendChild(childWed);
			
			$("#addWed").show();
		} else {
			$("#addWed").hide();
			$("#idWed").remove();
		}
		
	});
});

$(function(){
	
	$("#addWed").on('click',function(){
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
	    nightStartTime.setAttribute("class","wed2 wedcount");
		
		var nightEndTime = document.createElement("input");
		nightEndTime.setAttribute("type","number");
		nightEndTime.setAttribute("placeholder","終了時間");
		nightEndTime.setAttribute("name","ramenShopTimeList[" + count + "].nightEndTime");
		nightEndTime.setAttribute("class","wed2");
		
		var days = document.createElement("input");
		days.setAttribute("type","checkbox");
		days.setAttribute("checked","checked");
		days.setAttribute("value","水曜日");
		days.setAttribute("name","ramenShopTimeList[" + count + "].days");
		days.setAttribute("id","checkWed");
		days.setAttribute("class","wed2");
		
		
		var del = document.createElement("input");
		del.setAttribute("type","button");
		del.setAttribute("value","削除");
		del.setAttribute("id","del");
		del.setAttribute("class","wed2");
	    
	   
		var childWed = document.getElementById("idWed");
		childWed.appendChild(nightStartTime);
		childWed.appendChild(document.createTextNode("\u0020"))
		childWed.appendChild(nightEndTime);
		childWed.appendChild(days);
		childWed.appendChild(del);
		
		$("#checkWed").hide();
    
    if(count >= 1) {
    	$("#addWed").hide();
    }
    $("#del").on('click',function(){
    	$(".wed2").remove();
    	$("#addWed").show();
    })
	});
});