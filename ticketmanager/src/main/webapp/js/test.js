(function($){
	
	var $output = null,
		timer = null;
	
	$(document).ready(function(){
		
		$output = $('#output');

		$('#createLink').on('click', function(event){
			event.preventDefault();
			$.ajax('resource/ticket', {
			    type: 'PUT',
			    contentType: 'application/json; charset=UTF-8', 
			    data: JSON.stringify({id: 5, description: 'hola 5'})
			}).done(function(data, textStatus, jqXHR){
				$output.text(data.message);
				$output.append('<br/>' + jqXHR.getResponseHeader('Location'));
			}).fail(function(jqXHR, textStatus, errorThrown){
			    $output.text($.parseJSON(jqXHR.responseText).message);
			}).always(cleanOutput);
		});
		
		$('#deleteLink').on('click', function(event){
			event.preventDefault();
			$.ajax('resource/ticket/5', {
			    type: 'DELETE',
			    contentType: 'application/json; charset=UTF-8'
			}).done(function(data, textStatus, jqXHR){
				$output.text(data.message);
			}).fail(function(jqXHR, textStatus, errorThrown){
				$output.text($.parseJSON(jqXHR.responseText).message);
			}).always(cleanOutput);
		});
		
		$('#updateLink').on('click', function(event){
			event.preventDefault();
			$.ajax('resource/ticket/5', {
			    type: 'POST',
			    contentType: 'application/json; charset=UTF-8', 
			    data: JSON.stringify({id: 5, description: 'hola 55555'})
			}).done(function(data, textStatus, jqXHR){
				$output.text(data.message);
			}).fail(function(jqXHR, textStatus, errorThrown){
				$output.text($.parseJSON(jqXHR.responseText).message);
			}).always(cleanOutput);

		});
		
		
	});
	
	function cleanOutput(){
		if (timer != null) {
			clearTimeout(timer);
			timer = null;
		}
		timer = setTimeout(function(){
			$output.text("");
		}, 4000);
	}
	
})(jQuery);