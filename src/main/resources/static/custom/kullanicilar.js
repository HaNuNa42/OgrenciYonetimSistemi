
$('#datatablekullanicilar').DataTable({
			responsive: true,
			serverSide: true,
			processing: true,
			searching: false,
			ajax: {
			
				url: 'getAllUser',
				type: 'POST',
				contentType: 'application/json; charset=UTF-8',
				

			},
			columns: [
				{ data: 'id' },
				{ data: 'adi' },
				{ data: 'soyadi' },
				{ data: 'kullaniciadi' },
				{ data: 'mail' },
				{ data: 'telefon' },
				{ data: 'adres' },
				{ data: 'brans' },
				{ data: 'rol' },
				
				{
					data: function(data) {
						return '\
						<a href="javascript:GetByUserId(' + data.id + ');" class="btn btn-sm btn-warning btn-icon" title="Güncelle">\
								<i class="la la-edit"></i>\
							</a>\
						<a href="javascript:deleteUserModal(' + data.id + ');"   class="btn btn-sm btn-danger btn-icon"  title="Sil">\
								<i class="la la-trash"></i>\
							</a>\
						';
					},
				},
				

			],
			columnDefs: [
				{
					targets: 9,
					orderable: false,
				}
			]
		});



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

				$('#datatablekullanicilar').DataTable().ajax.reload();
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


function kullaniciGuncelle() {

	$('#modalkullanici').modal('show');
	$("#guncellebutton").show();
	$("#kaydetbutton").hide();
}


var secilenId = 0;
function guncellekullanici(id) {

	var param = {
	id: secilenId
	}

		var ser_data = JSON.stringify(param);
		console.log(ser_data);

		$.ajax({
			type: "POST",
			contentType: 'application/json; charset=UTF-8',
			url: 'guncellekullanici',
			data: ser_data,
			success: function(data) {
				toastr.success("Guncelleme başarılı !");

				$('#datatablekullanicilar').DataTable().ajax.reload();
			console.log(data);

			},
			error: function(data1) {
			console.log(data1);
				toastr.error("Bir hata oluştu, lütfen daha sonra tekrar deneyiniz...", data1);
			}
		});
}

var secilenIdd = 0;
function silkullanici(id) {

	var param = {
	id: secilenIdd
	}

		var ser_data = JSON.stringify(param);
		console.log(ser_data);

		$.ajax({
			type: "POST",
			contentType: 'application/json; charset=UTF-8',
			url: 'silkullanici',
			data: ser_data,
			success: function(data) {
				toastr.success("silme başarılı !");

				$('#datatablekullanicilar').DataTable().ajax.reload();
			console.log(data);

			},
			error: function(data1) {
			console.log(data1);
				toastr.error("Bir hata oluştu, lütfen daha sonra tekrar deneyiniz...", data1);
			}
		});
}