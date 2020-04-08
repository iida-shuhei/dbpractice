$(function(){
	$("#addMon").hide();
	
	$("#monday").on('click',function() {
		if(this.checked) {
			//チェックがついたら、チェックボックスにnameを追加
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
			
			var monday = document.getElementById("monday");
			monday.setAttribute("name","ramenShopTimeList[" + count + "].days");
			
			//<div id="parentMon">の中に<div>を形成していく
			var parentMon = document.getElementById("parentMon");
			var childMon = document.createElement("div");
			childMon.setAttribute("id","idMon");
			
			var noonStartTime = document.createElement("input");
			noonStartTime.setAttribute("type","number");
			noonStartTime.setAttribute("placeholder","開始時間");
			noonStartTime.setAttribute("name","ramenShopTimeList[" + count + "].noonStartTime");
			noonStartTime.setAttribute("class","mon1");
			
			var noonEndTime = document.createElement("input");
			noonEndTime.setAttribute("type","number");
			noonEndTime.setAttribute("placeholder","終了時間");
			noonEndTime.setAttribute("name","ramenShopTimeList[" + count + "].noonEndTime");
			
			childMon.appendChild(noonStartTime);
			childMon.appendChild(document.createTextNode("\u0020"));
			childMon.appendChild(noonEndTime);
			childMon.appendChild( document.createElement('br'));
			childMon.appendChild( document.createElement('br'));
			
			parentMon.appendChild(childMon);
			
			$("#addMon").show();
		} else {
			$("#addMon").hide();
			$("#idMon").remove();
		}
		
	});
});

$(function(){
	$("#addMon").on('click',function(){
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

    var nightStartTime = document.createElement("input");
    nightStartTime.setAttribute("type","number");
    nightStartTime.setAttribute("placeholder","開始時間");
    nightStartTime.setAttribute("name","ramenShopTimeList[" + count + "].nightStartTime");
    nightStartTime.setAttribute("class","mon2 moncount");
	
	var nightEndTime = document.createElement("input");
	nightEndTime.setAttribute("type","number");
	nightEndTime.setAttribute("placeholder","終了時間");
	nightEndTime.setAttribute("name","ramenShopTimeList[" + count + "].nightEndTime");
	nightEndTime.setAttribute("class","mon2");
	
	var days = document.createElement("input");
	days.setAttribute("type","checkbox");
	days.setAttribute("checked","checked");
	days.setAttribute("value","月曜日");
	days.setAttribute("name","ramenShopTimeList[" + count + "].days");
	days.setAttribute("id","checkMon");
	days.setAttribute("class","mon2");
	
	
	var del = document.createElement("input");
	del.setAttribute("type","button");
	del.setAttribute("value","削除");
	del.setAttribute("id","del");
	del.setAttribute("class","mon2");
    
   
	var childMon = document.getElementById("idMon");
	childMon.appendChild(nightStartTime);
	childMon.appendChild(document.createTextNode("\u0020"))
	childMon.appendChild(nightEndTime);
	childMon.appendChild(days);
	childMon.appendChild(del);
    
    $("#checkMon").hide();
    
    if(count >= 1) {
    	$("#addMon").hide();
    }
    $("#del").on('click',function(){
    	$(".mon2").remove();
    	$("#addMon").show();
    })
	});
});