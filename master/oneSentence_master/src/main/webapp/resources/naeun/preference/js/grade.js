var $grade = $('#usergrade').val();
var green = '<i class="fa fa-book fa-3x" aria-hidden="true" style="color:#345E35;"></i> &nbsp;';
var lightgray = '<i class="fa fa-book fa-3x" aria-hidden="true" style="color:lightgray;"></i> &nbsp;';
var $percent = $('#percent').val();
var $countMySentences = $('#countMySentences').val();

var i;

for(i=0; i<$grade; i++)	
	document.getElementById('grade').innerHTML += green;

for(i=0; i<5-$grade; i++)
	document.getElementById('grade').innerHTML += lightgray;
	

document.getElementById('grade').innerHTML += '<br><br><h6>한문장 상위 '+$percent+'%! (총 '+$countMySentences+'개의 문장)</h6>';