$(document).ready(function() {
    $('#books').click(function() {
        $.ajax({
            url:'search.jsp',
            type:'GET',
            dataType: 'text',
            success: function(data){
            	$('#dictionary').html(data);
            }// end
        });// end ajax
        return false;
    });
});