(function($){
	
	$(document).ready(function(){
		
		var $output = $('#output');

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
			});
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
			});
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
			});

		});
		
	});
	
})(jQuery);