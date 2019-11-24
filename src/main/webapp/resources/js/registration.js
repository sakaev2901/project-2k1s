$(document).ready(function() {
	$('#passwordAgain').on('input', function () {
		if (document.getElementById('password').value != document.getElementById('passwordAgain').value) {
			document.getElementById('passwordAgain').setCustomValidity('Пароли не совпадают');
			return false;
		}
		else {
			document.getElementById('passwordAgain').setCustomValidity('');
			return true;
		}
	}
	);
	$('#signUp').submit(function(event) {
		if (document.getElementById('signUp').checkValidity() === false || passwordAgainValid() === false) {
			event.preventDefault();
		}
		document.getElementById('signUp').classList.add('was-validated');
	});
});

