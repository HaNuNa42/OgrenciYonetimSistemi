

function yenitanimlamaEkle() {

	$('#modaltanimlama').modal('show');
	$("#guncellebutton").hide();
	$("#kaydetbutton").show();
}


function ekletanimlama() {

	var param = {
		kodadi: $("#kodadi").val(),
		aciklama: $("#aciklama").val(),
		
	}

	if (param.kodadi < 1) {
		toastr.warning('Kod adı bilgisini giriniz !<br>');
	}
		if (param.aciklama < 1) {
		toastr.warning('Açıklama bilgisini giriniz !<br>');
	}
	
	if (param != null) {

		var ser_data = JSON.stringify(param);
		toastr.warning(ser_data);

		$.ajax({
			type: "POST",
			contentType: 'application/json; charset=UTF-8',
			url: 'ekletanimlama',
			data: ser_data,
			success: function(data) {
				toastr.success("Kayıt başarılı !");

				$('#datatable2').DataTable().ajax.reload();


			},
			error: function(data) {
				toastr.error("Bir hata oluştu, lütfen daha sonra tekrar deneyiniz...", data);
			}
		});

	}
	else {
		toastr.error("Bir hata oluştu, lütfen daha sonra tekrar deneyiniz...", data);
	}
}