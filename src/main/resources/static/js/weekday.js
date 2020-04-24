$(function(){
	$("#addMon").hide();
	$("#allMon").hide();
	$("#allTue").hide();
	$("#allWed").hide();
	$("#allThu").hide();
	$("#allFri").hide();
	$("#allSat").hide();
	$("#allSun").hide();
	var map = new Map();
	var array = [];
	var countMon = 0;
	var countMonAdd = 0;
	var countTue = 0;
	var countTueAdd = 0;
	var countWed = 0;
	var countWedAdd = 0;
	var countThu = 0;
	var countThuAdd = 0;
	var countFri = 0;
	var countFriAdd = 0;
	var countSat = 0;
	var countSatAdd = 0;
	var countSun = 0;
	var countSunAdd = 0;
	
// ---------------------------------月曜日--------------------------------------
	
	$("#monday").on('click',function() {
		if(this.checked) {
			// チェックがついたら、チェックボックスにnameを追加
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
			var count15 = document.getElementsByClassName("tue3").length;
			var count16 = document.getElementsByClassName("wed3").length;
			var count17 = document.getElementsByClassName("thu3").length;
			var count18 = document.getElementsByClassName("fri3").length;
			var count19 = document.getElementsByClassName("sat3").length;
			var count20 = document.getElementsByClassName("sun3").length;
			countMon = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15 + count16 + count17 + count18 + count19 + count20;
			if(countMon === 0) {
				countMon = 0
			} else {
				countMon = countMon
			}
			
			// keyを取り出してarray[]につめている
			var keys = map.keys();
			for(var key of keys) {
				array.push(key);
	        }

	        // array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
	        for (var value of array) {
	            if(value === countMon) {
	            	countMon = Math.max.apply(null,array) + 1;
	            } else {
	            	countMon = countMon;
	            }
	        }
	        
	        // mapにセットしている
			map.set(countMon, 'countMon');
			
			
			var monday = document.getElementById("monday");
			monday.setAttribute("name","ramenShopTimeList[" + countMon + "].days");
			
			// <div id="parentMon">の中に<div>を形成していく
			var parentMon = document.getElementById("parentMon");
			var childMon = document.createElement("div");
			childMon.setAttribute("id","idMon");
			
			var noonStartTime = document.createElement("input");
			noonStartTime.setAttribute("type","number");
			noonStartTime.setAttribute("placeholder","開始時間");
			noonStartTime.setAttribute("name","ramenShopTimeList[" + countMon + "].noonStartTime");
			noonStartTime.setAttribute("class","mon1");
			
			var noonEndTime = document.createElement("input");
			noonEndTime.setAttribute("type","number");
			noonEndTime.setAttribute("placeholder","終了時間");
			noonEndTime.setAttribute("name","ramenShopTimeList[" + countMon + "].noonEndTime");
			
			childMon.appendChild(noonStartTime);
			childMon.appendChild(document.createTextNode("\u0020"));
			childMon.appendChild(noonEndTime);
			childMon.appendChild( document.createElement('br'));
			childMon.appendChild( document.createElement('br'));
			
			parentMon.appendChild(childMon);
			
			$("#addMon").show();
			$("#allMon").show();
			
		} else {
			$("#addMon").hide();
			$("#allMon").hide();
			$("#idMon").remove();
			var Mon24 = document.getElementById( "Mon24" );
			Mon24.checked = false;
			$('#Mon24').removeAttr('name');
			
			map.delete(countMon);
            map.delete(countMonAdd);
		}
		
		//月曜日の24時間ボタンを押した時
		$("#Mon24").on('click',function(){
			if(this.checked) {
				
				var Mon24 = document.getElementById("Mon24");
				Mon24.setAttribute("name","ramenShopTimeList[" + countMon + "].otherTime");
				
				$("#addMon").hide();
				$("#idMon").remove();
				
				map.delete(countMonAdd);
				
			} else {
				
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
				var count15 = document.getElementsByClassName("mon3").length;
				countMon = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15;
				if(countMon === 0) {
					countMon = 0
				} else {
					countMon = countMon
				}
				
				// keyを取り出してarray[]につめている
				var keys = map.keys();
				for(var key of keys) {
					array.push(key);
				}
				
				// array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
				for (var value of array) {
					if(value === countMon) {
						countMon = Math.max.apply(null,array) + 1;
					} else {
						countMon = countMon;
					}
				}
				
				// mapにセットしている
				map.set(countMon, 'countMon');
				
				
				var monday = document.getElementById("monday");
				monday.setAttribute("name","ramenShopTimeList[" + countMon + "].days");
				
				// <div id="parentMon">の中に<div>を形成していく
				var parentMon = document.getElementById("parentMon");
				var childMon = document.createElement("div");
				childMon.setAttribute("id","idMon");
				
				var noonStartTime = document.createElement("input");
				noonStartTime.setAttribute("type","number");
				noonStartTime.setAttribute("placeholder","開始時間");
				noonStartTime.setAttribute("name","ramenShopTimeList[" + countMon + "].noonStartTime");
				noonStartTime.setAttribute("class","mon1");
				
				var noonEndTime = document.createElement("input");
				noonEndTime.setAttribute("type","number");
				noonEndTime.setAttribute("placeholder","終了時間");
				noonEndTime.setAttribute("name","ramenShopTimeList[" + countMon + "].noonEndTime");
				
				childMon.appendChild(noonStartTime);
				childMon.appendChild(document.createTextNode("\u0020"));
				childMon.appendChild(noonEndTime);
				childMon.appendChild( document.createElement('br'));
				childMon.appendChild( document.createElement('br'));
				
				parentMon.appendChild(childMon);
				
				$('#Mon24').removeAttr('name');
				
				$("#addMon").show();
				$("#allMon").show();
			}
		});
		
		$("#addMon").on('click',function(){
			
			var nightStartTime = document.createElement("input");
			nightStartTime.setAttribute("type","number");
			nightStartTime.setAttribute("placeholder","開始時間");
			nightStartTime.setAttribute("name","ramenShopTimeList[" + countMon + "].nightStartTime");
			nightStartTime.setAttribute("class","mon2 moncount");
			
			var nightEndTime = document.createElement("input");
			nightEndTime.setAttribute("type","number");
			nightEndTime.setAttribute("placeholder","終了時間");
			nightEndTime.setAttribute("name","ramenShopTimeList[" + countMon + "].nightEndTime");
			nightEndTime.setAttribute("class","mon2");
			
			var del = document.createElement("input");
			del.setAttribute("type","button");
			del.setAttribute("value","削除");
			del.setAttribute("id","delMon");
			del.setAttribute("class","mon2 btn btn-outline-info");
			
			
			var childMon = document.getElementById("idMon");
			childMon.appendChild(nightStartTime);
			childMon.appendChild(document.createTextNode("\u0020"))
			childMon.appendChild(nightEndTime);
			childMon.appendChild(del);
			
			$("#checkMon").hide();
			
			if(countMon >= 1) {
				$("#addMon").hide();
			}
			
			$("#delMon").on('click',function(){
				$(".mon2").remove();
				map.delete(countMonAdd);
				$("#addMon").show();
			})
		})
		
	});
	
// ---------------------------------火曜日--------------------------------------
	
	$("#addTue").hide();
	$("#tuesday").on('click',function() {
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
			var count15 = document.getElementsByClassName("mon3").length;
			var count16 = document.getElementsByClassName("wed3").length;
			var count17 = document.getElementsByClassName("thu3").length;
			var count18 = document.getElementsByClassName("fri3").length;
			var count19 = document.getElementsByClassName("sat3").length;
			var count20 = document.getElementsByClassName("sun3").length;
			countTue = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15 + count16 + count17 + count18 + count19 + count20;
			if(countTue === 0) {
				countTue = 0
			} else {
				countTue = countTue
			}
			
			// keyを取り出してarray[]につめている
			var keys = map.keys();
			for(var key of keys) {
				array.push(key);
	        }

	        // array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
	        for (var value of array) {
	            if(value === countTue) {
	            	countTue = Math.max.apply(null,array) + 1;
	            } else {
	            	countTue = countTue;
	            }
	        }
	        
	        // mapにセットしている
			map.set(countTue, 'countTue');
			
			//チェックがついたら、チェックボックスにnameを追加
			var tuesday = document.getElementById("tuesday");
			tuesday.setAttribute("name","ramenShopTimeList[" + countTue + "].days");
			
			//<div id="parentTue">の中に<div>を形成していく
			var parentTue = document.getElementById("parentTue");
			var childTue = document.createElement("div");
			childTue.setAttribute("id","idTue");
			
			var noonStartTime = document.createElement("input");
			noonStartTime.setAttribute("type","number");
			noonStartTime.setAttribute("placeholder","開始時間");
			noonStartTime.setAttribute("name","ramenShopTimeList[" + countTue + "].noonStartTime");
			noonStartTime.setAttribute("class","tue1");
			
			var noonEndTime = document.createElement("input");
			noonEndTime.setAttribute("type","number");
			noonEndTime.setAttribute("placeholder","終了時間");
			noonEndTime.setAttribute("name","ramenShopTimeList[" + countTue + "].noonEndTime");
			
			childTue.appendChild(noonStartTime);
			childTue.appendChild(document.createTextNode("\u0020"));
			childTue.appendChild(noonEndTime);
			childTue.appendChild( document.createElement('br'));
			childTue.appendChild( document.createElement('br'));
			
			parentTue.appendChild(childTue);
			
			$("#addTue").show();
			$("#allTue").show();
			
		} else {
			$("#addTue").hide();
			$("#idTue").remove();
			$("#allTue").hide();
			var Tue24 = document.getElementById( "Tue24" );
			Tue24.checked = false;
			$('#Tue24').removeAttr('name');
			
			map.delete(countTue);
            map.delete(countTueAdd);
		}
		
		//火曜日の24時間ボタンを押した時
		$("#Tue24").on('click',function(){
			if(this.checked) {
				
				var Tue24 = document.getElementById("Tue24");
				Tue24.setAttribute("name","ramenShopTimeList[" + countTue + "].otherTime");
				
				$("#addTue").hide();
				$("#idTue").remove();
				
				map.delete(countTueAdd);
				
			} else {
				
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
				var count15 = document.getElementsByClassName("tue3").length;
				countTue = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15;
				if(countTue === 0) {
					countTue = 0
				} else {
					countTue = countTue
				}
				
				// keyを取り出してarray[]につめている
				var keys = map.keys();
				for(var key of keys) {
					array.push(key);
				}
				
				// array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
				for (var value of array) {
					if(value === countTue) {
						countTue = Math.max.apply(null,array) + 1;
					} else {
						countTue = countTue;
					}
				}
				
				// mapにセットしている
				map.set(countTue, 'countTue');
				
				//チェックがついたら、チェックボックスにnameを追加
				var tuesday = document.getElementById("tuesday");
				tuesday.setAttribute("name","ramenShopTimeList[" + countTue + "].days");
				
				//<div id="parentTue">の中に<div>を形成していく
				var parentTue = document.getElementById("parentTue");
				var childTue = document.createElement("div");
				childTue.setAttribute("id","idTue");
				
				var noonStartTime = document.createElement("input");
				noonStartTime.setAttribute("type","number");
				noonStartTime.setAttribute("placeholder","開始時間");
				noonStartTime.setAttribute("name","ramenShopTimeList[" + countTue + "].noonStartTime");
				noonStartTime.setAttribute("class","tue1");
				
				var noonEndTime = document.createElement("input");
				noonEndTime.setAttribute("type","number");
				noonEndTime.setAttribute("placeholder","終了時間");
				noonEndTime.setAttribute("name","ramenShopTimeList[" + countTue + "].noonEndTime");
				
				childTue.appendChild(noonStartTime);
				childTue.appendChild(document.createTextNode("\u0020"));
				childTue.appendChild(noonEndTime);
				childTue.appendChild( document.createElement('br'));
				childTue.appendChild( document.createElement('br'));
				
				parentTue.appendChild(childTue);
				
				$('#Tue24').removeAttr('name');
				
				$("#addTue").show();
				$("#allTue").show();
			}
		});
		$("#addTue").on('click',function(){
			var nightStartTime = document.createElement("input");
			nightStartTime.setAttribute("type","number");
			nightStartTime.setAttribute("placeholder","開始時間");
			nightStartTime.setAttribute("name","ramenShopTimeList[" + countTue + "].nightStartTime");
			nightStartTime.setAttribute("class","tue2 tuecount");
			
			var nightEndTime = document.createElement("input");
			nightEndTime.setAttribute("type","number");
			nightEndTime.setAttribute("placeholder","終了時間");
			nightEndTime.setAttribute("name","ramenShopTimeList[" + countTue + "].nightEndTime");
			nightEndTime.setAttribute("class","tue2");
			
			var del = document.createElement("input");
			del.setAttribute("type","button");
			del.setAttribute("value","削除");
			del.setAttribute("id","delTue");
			del.setAttribute("class","tue2 btn btn-outline-info");
			
			
			var childTue = document.getElementById("idTue");
			childTue.appendChild(nightStartTime);
			childTue.appendChild(document.createTextNode("\u0020"))
			childTue.appendChild(nightEndTime);
			childTue.appendChild(del);
			
			$("#checkTue").hide();
			
			if(countTue >= 1) {
				$("#addTue").hide();
			}
			
			$("#delTue").on('click',function(){
				$(".tue2").remove();
				map.delete(countTueAdd);
				$("#addTue").show();
			})
		})
	});

// ---------------------------------水曜日--------------------------------------

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
		var count15 = document.getElementsByClassName("tue3").length;
		var count16 = document.getElementsByClassName("mon3").length;
		var count17 = document.getElementsByClassName("thu3").length;
		var count18 = document.getElementsByClassName("fri3").length;
		var count19 = document.getElementsByClassName("sat3").length;
		var count20 = document.getElementsByClassName("sun3").length;
		countWed = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15 + count16 + count17 + count18 + count19 + count20;
		if(countWed === 0) {
			countWed = 0
		} else {
			countWed = countWed
		}
		
		// keyを取り出してarray[]につめている
		var keys = map.keys();
		for(var key of keys) {
			array.push(key);
        }

        // array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
        for (var value of array) {
            if(value === countWed) {
            	countWed = Math.max.apply(null,array) + 1;
            } else {
            	countWed = countWed;
            }
        }
        
        // mapにセットしている
		map.set(countWed, 'countWed');
		
		//チェックがついたら、チェックボックスにnameを追加
		var wednesday = document.getElementById("wednesday");
		wednesday.setAttribute("name","ramenShopTimeList[" + countWed + "].days");
		
		//<div id="parentTue">の中に<div>を形成していく
		var parentWed = document.getElementById("parentWed");
		var childWed = document.createElement("div");
		childWed.setAttribute("id","idWed");
		
		var noonStartTime = document.createElement("input");
		noonStartTime.setAttribute("type","number");
		noonStartTime.setAttribute("placeholder","開始時間");
		noonStartTime.setAttribute("name","ramenShopTimeList[" + countWed + "].noonStartTime");
		noonStartTime.setAttribute("class","wed1");
		
		var noonEndTime = document.createElement("input");
		noonEndTime.setAttribute("type","number");
		noonEndTime.setAttribute("placeholder","終了時間");
		noonEndTime.setAttribute("name","ramenShopTimeList[" + countWed + "].noonEndTime");
		
		childWed.appendChild(noonStartTime);
		childWed.appendChild(document.createTextNode("\u0020"));
		childWed.appendChild(noonEndTime);
		childWed.appendChild( document.createElement('br'));
		childWed.appendChild( document.createElement('br'));
		
		parentWed.appendChild(childWed);
		
		$("#addWed").show();
		$("#allWed").show();
		
		} else {
			$("#addWed").hide();
			$("#idWed").remove();
			$("#allWed").hide();
			var Wed24 = document.getElementById( "Wed24" );
			Wed24.checked = false;
			$('#Wed24').removeAttr('name');
			
			map.delete(countWed);
            map.delete(countWedAdd);
		}
	
	//水曜日の24時間ボタンを押した時
	$("#Wed24").on('click',function(){
		if(this.checked) {
			
			var Wed24 = document.getElementById("Wed24");
			Wed24.setAttribute("name","ramenShopTimeList[" + countWed + "].otherTime");
			
			$("#addWed").hide();
			$("#idWed").remove();
			
			map.delete(countWedAdd);
			
		} else {
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
			var count15 = document.getElementsByClassName("wed3").length;
			countWed = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15;
			if(countWed === 0) {
				countWed = 0
			} else {
				countWed = countWed
			}
			
			// keyを取り出してarray[]につめている
			var keys = map.keys();
			for(var key of keys) {
				array.push(key);
			}
			
			// array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
			for (var value of array) {
				if(value === countWed) {
					countWed = Math.max.apply(null,array) + 1;
				} else {
					countWed = countWed;
				}
			}
			
			// mapにセットしている
			map.set(countWed, 'countWed');
			
			//チェックがついたら、チェックボックスにnameを追加
			var wednesday = document.getElementById("wednesday");
			wednesday.setAttribute("name","ramenShopTimeList[" + countWed + "].days");
			
			//<div id="parentTue">の中に<div>を形成していく
			var parentWed = document.getElementById("parentWed");
			var childWed = document.createElement("div");
			childWed.setAttribute("id","idWed");
			
			var noonStartTime = document.createElement("input");
			noonStartTime.setAttribute("type","number");
			noonStartTime.setAttribute("placeholder","開始時間");
			noonStartTime.setAttribute("name","ramenShopTimeList[" + countWed + "].noonStartTime");
			noonStartTime.setAttribute("class","wed1");
			
			var noonEndTime = document.createElement("input");
			noonEndTime.setAttribute("type","number");
			noonEndTime.setAttribute("placeholder","終了時間");
			noonEndTime.setAttribute("name","ramenShopTimeList[" + countWed + "].noonEndTime");
			
			childWed.appendChild(noonStartTime);
			childWed.appendChild(document.createTextNode("\u0020"));
			childWed.appendChild(noonEndTime);
			childWed.appendChild( document.createElement('br'));
			childWed.appendChild( document.createElement('br'));
			
			parentWed.appendChild(childWed);
			
			$('#Wed24').removeAttr('name');
			
			$("#addWed").show();
			$("#allWed").show();
			}
		});
	
	$("#addWed").on('click',function(){
		var nightStartTime = document.createElement("input");
		nightStartTime.setAttribute("type","number");
		nightStartTime.setAttribute("placeholder","開始時間");
		nightStartTime.setAttribute("name","ramenShopTimeList[" + countWed + "].nightStartTime");
		nightStartTime.setAttribute("class","wed2 wedcount");
		
		var nightEndTime = document.createElement("input");
		nightEndTime.setAttribute("type","number");
		nightEndTime.setAttribute("placeholder","終了時間");
		nightEndTime.setAttribute("name","ramenShopTimeList[" + countWed + "].nightEndTime");
		nightEndTime.setAttribute("class","wed2");
		
		var del = document.createElement("input");
		del.setAttribute("type","button");
		del.setAttribute("value","削除");
		del.setAttribute("id","delWed");
		del.setAttribute("class","wed2 btn btn-outline-info");
		
		
		var childWed = document.getElementById("idWed");
		childWed.appendChild(nightStartTime);
		childWed.appendChild(document.createTextNode("\u0020"))
		childWed.appendChild(nightEndTime);
		childWed.appendChild(del);
		
		$("#checkWed").hide();
		
		if(countWed >= 1) {
			$("#addWed").hide();
		}
		$("#delWed").on('click',function(){
			$(".wed2").remove();
			map.delete(countWedAdd);
			$("#addWed").show();
		})
	})
	
	});

// ---------------------------------木曜日--------------------------------------

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
			var count15 = document.getElementsByClassName("tue3").length;
			var count16 = document.getElementsByClassName("wed3").length;
			var count17 = document.getElementsByClassName("mon3").length;
			var count18 = document.getElementsByClassName("fri3").length;
			var count19 = document.getElementsByClassName("sat3").length;
			var count20 = document.getElementsByClassName("sun3").length;
			countThu = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15 + count16 + count17 + count18 + count19 + count20;
			if(countThu === 0) {
				countThu = 0
			} else {
				countThu = countThu
			}
			
			// keyを取り出してarray[]につめている
			var keys = map.keys();
			for(var key of keys) {
				array.push(key);
	        }

	        // array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
	        for (var value of array) {
	            if(value === countThu) {
	            	countThu = Math.max.apply(null,array) + 1;
	            } else {
	            	countThu = countThu;
	            }
	        }
	        
	        // mapにセットしている
			map.set(countThu, 'countThu');
			
			//チェックがついたら、チェックボックスにnameを追加
			var thursday = document.getElementById("thursday");
			thursday.setAttribute("name","ramenShopTimeList[" + countThu + "].days");
			
			//<div id="parentTue">の中に<div>を形成していく
			var parentThu = document.getElementById("parentThu");
			var childThu = document.createElement("div");
			childThu.setAttribute("id","idThu");
			
			var noonStartTime = document.createElement("input");
			noonStartTime.setAttribute("type","number");
			noonStartTime.setAttribute("placeholder","開始時間");
			noonStartTime.setAttribute("name","ramenShopTimeList[" + countThu + "].noonStartTime");
			noonStartTime.setAttribute("class","thu1");
			
			var noonEndTime = document.createElement("input");
			noonEndTime.setAttribute("type","number");
			noonEndTime.setAttribute("placeholder","終了時間");
			noonEndTime.setAttribute("name","ramenShopTimeList[" + countThu + "].noonEndTime");
			
			childThu.appendChild(noonStartTime);
			childThu.appendChild(document.createTextNode("\u0020"));
			childThu.appendChild(noonEndTime);
			childThu.appendChild( document.createElement('br'));
			childThu.appendChild( document.createElement('br'));
			
			parentThu.appendChild(childThu);
			
			$("#addThu").show();
			$("#allThu").show();
			
		} else {
			$("#addThu").hide();
			$("#idThu").remove();
			$("#allThu").hide();
			var Thu24 = document.getElementById( "Thu24" );
			Thu24.checked = false;
			$('#Thu24').removeAttr('name');
			
			map.delete(countThu);
            map.delete(countThuAdd);
		}
		
		//木曜日の24時間ボタンを押した時
		$("#Thu24").on('click',function(){
			if(this.checked) {
				
				var Thu24 = document.getElementById("Thu24");
				Thu24.setAttribute("name","ramenShopTimeList[" + countThu + "].otherTime");
				
				$("#addThu").hide();
				$("#idThu").remove();
				
				map.delete(countThuAdd);
				
			} else {
				
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
				var count15 = document.getElementsByClassName("thu3").length;
				countThu = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15;
				if(countThu === 0) {
					countThu = 0
				} else {
					countThu = countThu
				}
				
				// keyを取り出してarray[]につめている
				var keys = map.keys();
				for(var key of keys) {
					array.push(key);
				}
				
				// array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
				for (var value of array) {
					if(value === countThu) {
						countThu = Math.max.apply(null,array) + 1;
					} else {
						countThu = countThu;
					}
				}
				
				// mapにセットしている
				map.set(countThu, 'countThu');
				
				//チェックがついたら、チェックボックスにnameを追加
				var thursday = document.getElementById("thursday");
				thursday.setAttribute("name","ramenShopTimeList[" + countThu + "].days");
				
				//<div id="parentTue">の中に<div>を形成していく
				var parentThu = document.getElementById("parentThu");
				var childThu = document.createElement("div");
				childThu.setAttribute("id","idThu");
				
				var noonStartTime = document.createElement("input");
				noonStartTime.setAttribute("type","number");
				noonStartTime.setAttribute("placeholder","開始時間");
				noonStartTime.setAttribute("name","ramenShopTimeList[" + countThu + "].noonStartTime");
				noonStartTime.setAttribute("class","thu1");
				
				var noonEndTime = document.createElement("input");
				noonEndTime.setAttribute("type","number");
				noonEndTime.setAttribute("placeholder","終了時間");
				noonEndTime.setAttribute("name","ramenShopTimeList[" + countThu + "].noonEndTime");
				
				childThu.appendChild(noonStartTime);
				childThu.appendChild(document.createTextNode("\u0020"));
				childThu.appendChild(noonEndTime);
				childThu.appendChild( document.createElement('br'));
				childThu.appendChild( document.createElement('br'));
				
				$('#Thu24').removeAttr('name');
				
				parentThu.appendChild(childThu);
				
				$("#addThu").show();
				$("#allThu").show();
			}
		});
		
		$("#addThu").on('click',function(){
			var nightStartTime = document.createElement("input");
			nightStartTime.setAttribute("type","number");
			nightStartTime.setAttribute("placeholder","開始時間");
			nightStartTime.setAttribute("name","ramenShopTimeList[" + countThu + "].nightStartTime");
			nightStartTime.setAttribute("class","thu2 thucount");
			
			var nightEndTime = document.createElement("input");
			nightEndTime.setAttribute("type","number");
			nightEndTime.setAttribute("placeholder","終了時間");
			nightEndTime.setAttribute("name","ramenShopTimeList[" + countThu + "].nightEndTime");
			nightEndTime.setAttribute("class","thu2");
			
			var del = document.createElement("input");
			del.setAttribute("type","button");
			del.setAttribute("value","削除");
			del.setAttribute("id","delThu");
			del.setAttribute("class","thu2 btn btn-outline-info");
			
			
			var childThu = document.getElementById("idThu");
			childThu.appendChild(nightStartTime);
			childThu.appendChild(document.createTextNode("\u0020"))
			childThu.appendChild(nightEndTime);
			childThu.appendChild(del);
			
			$("#checkThu").hide();
			
			if(countThu >= 1) {
				$("#addThu").hide();
			}
			$("#delThu").on('click',function(){
				$(".thu2").remove();
				map.delete(countThuAdd);
				$("#addThu").show();
			})
		})
		
	});

// ---------------------------------金曜日--------------------------------------	
	
	$("#addFri").hide();
	$("#friday").on('click',function() {
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
			var count15 = document.getElementsByClassName("tue3").length;
			var count16 = document.getElementsByClassName("wed3").length;
			var count17 = document.getElementsByClassName("thu3").length;
			var count18 = document.getElementsByClassName("mon3").length;
			var count19 = document.getElementsByClassName("sat3").length;
			var count20 = document.getElementsByClassName("sun3").length;
			countFri = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15 + count16 + count17 + count18 + count19 + count20;
			if(countFri === 0) {
				countFri = 0
			} else {
				countFri = countFri
			}
			
			// keyを取り出してarray[]につめている
			var keys = map.keys();
			for(var key of keys) {
				array.push(key);
	        }

	        // array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
	        for (var value of array) {
	            if(value === countFri) {
	            	countFri = Math.max.apply(null,array) + 1;
	            } else {
	            	countFri = countFri;
	            }
	        }
	        
	        // mapにセットしている
			map.set(countFri, 'countFri');
			
			//チェックがついたら、チェックボックスにnameを追加
			var friday = document.getElementById("friday");
			friday.setAttribute("name","ramenShopTimeList[" + countFri + "].days");
			
			//<div id="parentTue">の中に<div>を形成していく
			var parentFri = document.getElementById("parentFri");
			var childFri = document.createElement("div");
			childFri.setAttribute("id","idFri");
			
			var noonStartTime = document.createElement("input");
			noonStartTime.setAttribute("type","number");
			noonStartTime.setAttribute("placeholder","開始時間");
			noonStartTime.setAttribute("name","ramenShopTimeList[" + countFri + "].noonStartTime");
			noonStartTime.setAttribute("class","fri1");
			
			var noonEndTime = document.createElement("input");
			noonEndTime.setAttribute("type","number");
			noonEndTime.setAttribute("placeholder","終了時間");
			noonEndTime.setAttribute("name","ramenShopTimeList[" + countFri + "].noonEndTime");
			
			childFri.appendChild(noonStartTime);
			childFri.appendChild(document.createTextNode("\u0020"));
			childFri.appendChild(noonEndTime);
			childFri.appendChild( document.createElement('br'));
			childFri.appendChild( document.createElement('br'));
			
			parentFri.appendChild(childFri);
			
			$("#addFri").show();
			$("#allFri").show();
			
			} else {
				$("#addFri").hide();
				$("#idFri").remove();
				$("#allFri").hide();
				var Fri24 = document.getElementById( "Fri24" );
				Fri24.checked = false;
				$('#Fri24').removeAttr('name');
				
				map.delete(countFri);
	            map.delete(countFriAdd);
			}
		
		//金曜日の24時間ボタンを押した時
		$("#Fri24").on('click',function(){
			if(this.checked) {
				
				var Fri24 = document.getElementById("Fri24");
				Fri24.setAttribute("name","ramenShopTimeList[" + countFri + "].otherTime");
				
				$("#addFri").hide();
				$("#idFri").remove();
				
				map.delete(countFriAdd);
				
			} else {
				
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
				var count15 = document.getElementsByClassName("fri3").length;
				countFri = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15;
				if(countFri === 0) {
					countFri = 0
				} else {
					countFri = countFri
				}
				
				// keyを取り出してarray[]につめている
				var keys = map.keys();
				for(var key of keys) {
					array.push(key);
				}
				
				// array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
				for (var value of array) {
					if(value === countFri) {
						countFri = Math.max.apply(null,array) + 1;
					} else {
						countFri = countFri;
					}
				}
				
				// mapにセットしている
				map.set(countFri, 'countFri');
				
				//チェックがついたら、チェックボックスにnameを追加
				var friday = document.getElementById("friday");
				friday.setAttribute("name","ramenShopTimeList[" + countFri + "].days");
				
				//<div id="parentTue">の中に<div>を形成していく
				var parentFri = document.getElementById("parentFri");
				var childFri = document.createElement("div");
				childFri.setAttribute("id","idFri");
				
				var noonStartTime = document.createElement("input");
				noonStartTime.setAttribute("type","number");
				noonStartTime.setAttribute("placeholder","開始時間");
				noonStartTime.setAttribute("name","ramenShopTimeList[" + countFri + "].noonStartTime");
				noonStartTime.setAttribute("class","fri1");
				
				var noonEndTime = document.createElement("input");
				noonEndTime.setAttribute("type","number");
				noonEndTime.setAttribute("placeholder","終了時間");
				noonEndTime.setAttribute("name","ramenShopTimeList[" + countFri + "].noonEndTime");
				
				childFri.appendChild(noonStartTime);
				childFri.appendChild(document.createTextNode("\u0020"));
				childFri.appendChild(noonEndTime);
				childFri.appendChild( document.createElement('br'));
				childFri.appendChild( document.createElement('br'));
				
				parentFri.appendChild(childFri);
				
				$('#Fri24').removeAttr('name');
				
				$("#addFri").show();
				$("#allFri").show();
			}
		});
		
		$("#addFri").on('click',function(){
			var nightStartTime = document.createElement("input");
			nightStartTime.setAttribute("type","number");
			nightStartTime.setAttribute("placeholder","開始時間");
			nightStartTime.setAttribute("name","ramenShopTimeList[" + countFri + "].nightStartTime");
			nightStartTime.setAttribute("class","fri2 fricount");
			
			var nightEndTime = document.createElement("input");
			nightEndTime.setAttribute("type","number");
			nightEndTime.setAttribute("placeholder","終了時間");
			nightEndTime.setAttribute("name","ramenShopTimeList[" + countFri + "].nightEndTime");
			nightEndTime.setAttribute("class","fri2");
			
			var del = document.createElement("input");
			del.setAttribute("type","button");
			del.setAttribute("value","削除");
			del.setAttribute("id","delFri");
			del.setAttribute("class","fri2 btn btn-outline-info");
			
			
			var childFri = document.getElementById("idFri");
			childFri.appendChild(nightStartTime);
			childFri.appendChild(document.createTextNode("\u0020"))
			childFri.appendChild(nightEndTime);
			childFri.appendChild(del);
			
			$("#checkFri").hide();
			
			if(countFri >= 1) {
				$("#addFri").hide();
			}
			$("#delFri").on('click',function(){
				$(".fri2").remove();
				map.delete(countFriAdd);
				$("#addFri").show();
			})
		})
		
	});
	
// ---------------------------------土曜日--------------------------------------	

	$("#addSat").hide();
	$("#saturday").on('click',function() {
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
			var count15 = document.getElementsByClassName("tue3").length;
			var count16 = document.getElementsByClassName("wed3").length;
			var count17 = document.getElementsByClassName("thu3").length;
			var count18 = document.getElementsByClassName("fri3").length;
			var count19 = document.getElementsByClassName("mon3").length;
			var count20 = document.getElementsByClassName("sun3").length;
			countSat = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15 + count16 + count17 + count18 + count19 + count20;
			if(countSat === 0) {
				countSat = 0
			} else {
				countSat = countSat
			}
			
			// keyを取り出してarray[]につめている
			var keys = map.keys();
			for(var key of keys) {
				array.push(key);
	        }

	        // array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
	        for (var value of array) {
	            if(value === countSat) {
	            	countSat = Math.max.apply(null,array) + 1;
	            } else {
	            	countSat = countSat;
	            }
	        }
	        
	        // mapにセットしている
			map.set(countSat, 'countSat');
			
			//チェックがついたら、チェックボックスにnameを追加
			var saturday = document.getElementById("saturday");
			saturday.setAttribute("name","ramenShopTimeList[" + countSat + "].days");
			
			//<div id="parentTue">の中に<div>を形成していく
			var parentSat = document.getElementById("parentSat");
			var childSat = document.createElement("div");
			childSat.setAttribute("id","idSat");
			
			var noonStartTime = document.createElement("input");
			noonStartTime.setAttribute("type","number");
			noonStartTime.setAttribute("placeholder","開始時間");
			noonStartTime.setAttribute("name","ramenShopTimeList[" + countSat + "].noonStartTime");
			noonStartTime.setAttribute("class","sat1");
			
			var noonEndTime = document.createElement("input");
			noonEndTime.setAttribute("type","number");
			noonEndTime.setAttribute("placeholder","終了時間");
			noonEndTime.setAttribute("name","ramenShopTimeList[" + countSat + "].noonEndTime");
			
			childSat.appendChild(noonStartTime);
			childSat.appendChild(document.createTextNode("\u0020"));
			childSat.appendChild(noonEndTime);
			childSat.appendChild( document.createElement('br'));
			childSat.appendChild( document.createElement('br'));
			
			parentSat.appendChild(childSat);
			
			$("#addSat").show();
			$("#allSat").show();
			
		} else {
			$("#addSat").hide();
			$("#idSat").remove();
			$("#allSat").hide();
			var Sat24 = document.getElementById( "Sat24" );
			Sat24.checked = false;
			$('#Sat24').removeAttr('name');
			
			map.delete(countSat);
            map.delete(countSatAdd);
		}
		
		//土曜日の24時間ボタンを押した時
		$("#Sat24").on('click',function(){
			if(this.checked) {
				
				var Sat24 = document.getElementById("Sat24");
				Sat24.setAttribute("name","ramenShopTimeList[" + countSat + "].otherTime");
				
				$("#addSat").hide();
				$("#idSat").remove();
				
				map.delete(countSatAdd);
				
			} else {
				
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
				var count15 = document.getElementsByClassName("sat3").length;
				countSat = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15;
				if(countSat === 0) {
					countSat = 0
				} else {
					countSat = countSat
				}
				
				// keyを取り出してarray[]につめている
				var keys = map.keys();
				for(var key of keys) {
					array.push(key);
				}
				
				// array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
				for (var value of array) {
					if(value === countSat) {
						countSat = Math.max.apply(null,array) + 1;
					} else {
						countSat = countSat;
					}
				}
				
				// mapにセットしている
				map.set(countSat, 'countSat');
				
				//チェックがついたら、チェックボックスにnameを追加
				var saturday = document.getElementById("saturday");
				saturday.setAttribute("name","ramenShopTimeList[" + countSat + "].days");
				
				//<div id="parentTue">の中に<div>を形成していく
				var parentSat = document.getElementById("parentSat");
				var childSat = document.createElement("div");
				childSat.setAttribute("id","idSat");
				
				var noonStartTime = document.createElement("input");
				noonStartTime.setAttribute("type","number");
				noonStartTime.setAttribute("placeholder","開始時間");
				noonStartTime.setAttribute("name","ramenShopTimeList[" + countSat + "].noonStartTime");
				noonStartTime.setAttribute("class","sat1");
				
				var noonEndTime = document.createElement("input");
				noonEndTime.setAttribute("type","number");
				noonEndTime.setAttribute("placeholder","終了時間");
				noonEndTime.setAttribute("name","ramenShopTimeList[" + countSat + "].noonEndTime");
				
				childSat.appendChild(noonStartTime);
				childSat.appendChild(document.createTextNode("\u0020"));
				childSat.appendChild(noonEndTime);
				childSat.appendChild( document.createElement('br'));
				childSat.appendChild( document.createElement('br'));
				
				parentSat.appendChild(childSat);
				
				$('#Sat24').removeAttr('name');
				
				$("#addSat").show();
				$("#allSat").show();
			}
		});
		
		$("#addSat").on('click',function(){
			var nightStartTime = document.createElement("input");
			nightStartTime.setAttribute("type","number");
			nightStartTime.setAttribute("placeholder","開始時間");
			nightStartTime.setAttribute("name","ramenShopTimeList[" + countSat + "].nightStartTime");
			nightStartTime.setAttribute("class","sat2 satcount");
			
			var nightEndTime = document.createElement("input");
			nightEndTime.setAttribute("type","number");
			nightEndTime.setAttribute("placeholder","終了時間");
			nightEndTime.setAttribute("name","ramenShopTimeList[" + countSat + "].nightEndTime");
			nightEndTime.setAttribute("class","sat2");
			
			var del = document.createElement("input");
			del.setAttribute("type","button");
			del.setAttribute("value","削除");
			del.setAttribute("id","delSat");
			del.setAttribute("class","sat2 btn btn-outline-info");
			
			
			var childSat = document.getElementById("idSat");
			childSat.appendChild(nightStartTime);
			childSat.appendChild(document.createTextNode("\u0020"))
			childSat.appendChild(nightEndTime);
			childSat.appendChild(del);
			
			$("#checkSat").hide();
			
			if(countSat >= 1) {
				$("#addSat").hide();
			}
			
			$("#delSat").on('click',function(){
				$(".sat2").remove();
				map.delete(countSatAdd);
				$("#addSat").show();
			})
		})
		
	});

// ---------------------------------日曜日--------------------------------------	
	$("#addSun").hide();
	$("#sunday").on('click',function() {
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
			var count15 = document.getElementsByClassName("tue3").length;
			var count16 = document.getElementsByClassName("wed3").length;
			var count17 = document.getElementsByClassName("thu3").length;
			var count18 = document.getElementsByClassName("fri3").length;
			var count19 = document.getElementsByClassName("sat3").length;
			var count20 = document.getElementsByClassName("mon3").length;
			countSun = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15 + count16 + count17 + count18 + count19 + count20;
			if(countSun === 0) {
				countSun = 0
			} else {
				countSun = countSun
			}
			
			// keyを取り出してarray[]につめている
			var keys = map.keys();
			for(var key of keys) {
				array.push(key);
	        }

	        // array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
	        for (var value of array) {
	            if(value === countSun) {
	            	countSun = Math.max.apply(null,array) + 1;
	            } else {
	            	countSun = countSun;
	            }
	        }
	        
	        // mapにセットしている
			map.set(countSun, 'countSun');
			
			//チェックがついたら、チェックボックスにnameを追加
			var sunday = document.getElementById("sunday");
			sunday.setAttribute("name","ramenShopTimeList[" + countSun + "].days");
			
			//<div id="parentTue">の中に<div>を形成していく
			var parentSun = document.getElementById("parentSun");
			var childSun = document.createElement("div");
			childSun.setAttribute("id","idSun");
			
			var noonStartTime = document.createElement("input");
			noonStartTime.setAttribute("type","number");
			noonStartTime.setAttribute("placeholder","開始時間");
			noonStartTime.setAttribute("name","ramenShopTimeList[" + countSun + "].noonStartTime");
			noonStartTime.setAttribute("class","sun1");
			
			var noonEndTime = document.createElement("input");
			noonEndTime.setAttribute("type","number");
			noonEndTime.setAttribute("placeholder","終了時間");
			noonEndTime.setAttribute("name","ramenShopTimeList[" + countSun + "].noonEndTime");
			
			childSun.appendChild(noonStartTime);
			childSun.appendChild(document.createTextNode("\u0020"));
			childSun.appendChild(noonEndTime);
			childSun.appendChild( document.createElement('br'));
			childSun.appendChild( document.createElement('br'));
			
			parentSun.appendChild(childSun);
			
			$("#addSun").show();
			$("#allSun").show();
			
			} else {
				$("#addSun").hide();
				$("#idSun").remove();
				$("#allSun").hide();
				var Sun24 = document.getElementById( "Sun24" );
				Sun24.checked = false;
				$('#Sun24').removeAttr('name');
				
				map.delete(countSun);
	            map.delete(countSunAdd);
			}
		
		//日曜日の24時間ボタンを押した時
		$("#Sun24").on('click',function(){
			if(this.checked) {
				
				var Sun24 = document.getElementById("Sun24");
				Sun24.setAttribute("name","ramenShopTimeList[" + countSun + "].otherTime");
				
				$("#addSun").hide();
				$("#idSun").remove();
				
				map.delete(countSunAdd);
				
			} else {
				
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
				var count15 = document.getElementsByClassName("sun3").length;
				countSun = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10 + count11 + count12 + count13 + count14 + count15;
				if(countSun === 0) {
					countSun = 0
				} else {
					countSun = countSun
				}
				
				// keyを取り出してarray[]につめている
				var keys = map.keys();
				for(var key of keys) {
					array.push(key);
				}
				
				// array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをcountWaseの値とする
				for (var value of array) {
					if(value === countSun) {
						countSun = Math.max.apply(null,array) + 1;
					} else {
						countSun = countSun;
					}
				}
				
				// mapにセットしている
				map.set(countSun, 'countSun');
				
				//チェックがついたら、チェックボックスにnameを追加
				var sunday = document.getElementById("sunday");
				sunday.setAttribute("name","ramenShopTimeList[" + countSun + "].days");
				
				//<div id="parentTue">の中に<div>を形成していく
				var parentSun = document.getElementById("parentSun");
				var childSun = document.createElement("div");
				childSun.setAttribute("id","idSun");
				
				var noonStartTime = document.createElement("input");
				noonStartTime.setAttribute("type","number");
				noonStartTime.setAttribute("placeholder","開始時間");
				noonStartTime.setAttribute("name","ramenShopTimeList[" + countSun + "].noonStartTime");
				noonStartTime.setAttribute("class","sun1");
				
				var noonEndTime = document.createElement("input");
				noonEndTime.setAttribute("type","number");
				noonEndTime.setAttribute("placeholder","終了時間");
				noonEndTime.setAttribute("name","ramenShopTimeList[" + countSun + "].noonEndTime");
				
				childSun.appendChild(noonStartTime);
				childSun.appendChild(document.createTextNode("\u0020"));
				childSun.appendChild(noonEndTime);
				childSun.appendChild( document.createElement('br'));
				childSun.appendChild( document.createElement('br'));
				
				parentSun.appendChild(childSun);
				
				$('#Sun24').removeAttr('name');
				
				$("#addSun").show();
				$("#allSun").show();
			}
		});
		
		$("#addSun").on('click',function(){
			var nightStartTime = document.createElement("input");
			nightStartTime.setAttribute("type","number");
			nightStartTime.setAttribute("placeholder","開始時間");
			nightStartTime.setAttribute("name","ramenShopTimeList[" + countSun + "].nightStartTime");
			nightStartTime.setAttribute("class","sun2 suncount");
			
			var nightEndTime = document.createElement("input");
			nightEndTime.setAttribute("type","number");
			nightEndTime.setAttribute("placeholder","終了時間");
			nightEndTime.setAttribute("name","ramenShopTimeList[" + countSun + "].nightEndTime");
			nightEndTime.setAttribute("class","sun2");
			

			var del = document.createElement("input");
			del.setAttribute("type","button");
			del.setAttribute("value","削除");
			del.setAttribute("id","delSun");
			del.setAttribute("class","sun2 btn btn-outline-info");
			
			
			var childSun = document.getElementById("idSun");
			childSun.appendChild(nightStartTime);
			childSun.appendChild(document.createTextNode("\u0020"))
			childSun.appendChild(nightEndTime);
			childSun.appendChild(del);
			
			$("#checkSun").hide();
			
			if(countSun >= 1) {
				$("#addSun").hide();
			}
			$("#delSun").on('click',function(){
				$(".sun2").remove();
				map.delete(countSunAdd);
				$("#addSun").show();
			})
		});
	});
});