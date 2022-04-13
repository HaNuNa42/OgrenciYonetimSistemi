

function yenikullaniciEkle() {

	$('#modalkullanici').modal('show');
	$("#guncellebutton").hide();
	$("#kaydetbutton").show();
}


function eklekullanici() {

	var param = {
		kullaniciadi: $("#kullaniciadi").val(),
		adi: $("#adi").val(),
		soyadi: $("#soyadi").val(),
		mail: $("#mail").val(),
		sifre: $("#sifre").val(),
		sifretekrar: $("#sifretekrar").val(),
		rol: $("#rol").val(),
		brans: $("#brans").val(),
		telefon: $('#telefon').val(),
		adres: $('#adres').val(),
	}

	if (param.adi < 1) {
		toastr.warning('Adı bilgisini giriniz !<br>');
	}
	if (param.soyadi < 1) {
		toastr.warning('Soyadı bilgisini giriniz !<br>');
	}
	if (param.kullaniciadi < 1) {
		toastr.warning('Kullanıcı adını giriniz !<br>');
	}
	if (param.mail < 1) {
		toastr.warning('E-Posta bilgisini giriniz !<br>');
	}
	
	if (param.sifre < 1) {
		toastr.warning('Parola alanı boş geçilemez !<br>');
	}
	if (param.sifretekrar < 1) {
		toastr.warning('Lütfen Parolayı Doğrulayınız !<br>');
	}
	if (param.sifre != param.sifre) {
		toastr.warning(' Girdiğiniz parolalar uyuşmamaktadır ! Lütfen tekrar deneyiniz !<br>');
	}
	

	if (param != null) {

		var ser_data = JSON.stringify(param);
		console.log(ser_data);

		$.ajax({
			type: "POST",
			contentType: 'application/json; charset=UTF-8',
			url: 'eklekullanici',
			data: ser_data,
			success: function(data) {
				toastr.success("Kayıt olma başarılı !");

				$('#datatable2').DataTable().ajax.reload();
			console.log(data);

			},
			error: function(data1) {
			console.log(data1);
				toastr.error("Bir hata oluştu, lütfen daha sonra tekrar deneyiniz...", data1);
			}
		});

	}
	else {
		toastr.error("Bir hata oluştu, lütfen daha sonra tekrar deneyiniz...", data);
	}
}