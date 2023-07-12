
function login() {
    var usuario = $('#usuario').val();
    var contrasenna = $('#contrasenna').val();

    // Llamada AJAX utilizando jQuery
    $.ajax({
        url: 'http://localhost:8080/WSMusicProSOAP/WSMusicPro', // URL del servicio web SOAP
        type: 'POST',
        dataType: 'xml',
        data: '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://webServ/">' +
            '<soapenv:Header/>' +
            '<soapenv:Body>' +
            '<web:Login>' +
            '<usuario>' + usuario + '</usuario>' +
            '<contrasenna>' + contrasenna + '</contrasenna>' +
            '</web:Login>' +
            '</soapenv:Body>' +
            '</soapenv:Envelope>',
        contentType: 'text/xml',
        success: function (response) {
            // Manipula la respuesta del servicio web SOAP
            console.log(response);
            // Obtén el valor de la respuesta
            var returnElement = response.getElementsByTagName('return')[0];

            // Verifica el valor de retorno
            if (returnElement.textContent === 'Ingreso exitoso!') {
                // Almacena el estado de inicio de sesión en una cookie o en el almacenamiento local
                // Por ejemplo, utilizando una cookie
                document.cookie = "isLoggedIn=true";
                // Si el atributo es true, deshabilita las opciones de usuario
                window.location.href = './index.html'; // Reemplaza 'index.html' con la URL de redirección deseada
                return true;
            } else {
                // Si el atributo es false, habilita las opciones de usuario
                // $('#userOptions').removeClass('disabled');
                return false;
            }
        },
        error: function (xhr, status, error) {
            // Maneja el error de la llamada AJAX
            console.error(error);
        }
    });

    return false;
}

function actualizarNavbar() {
    // Verificar si el usuario ha iniciado sesión mediante la cookie o el almacenamiento local
    // Por ejemplo, utilizando una cookie
    var isLoggedIn = document.cookie.includes("isLoggedIn=true");

    if (isLoggedIn) {
        // Usuario ha iniciado sesión
        $('#userOptions').addClass('d-none'); // Ocultar elementos "Iniciar sesión" y "Registrar usuario"
        $('#logoutOption').removeClass('d-none'); // Mostrar elemento "Cerrar sesión"
    } else {
        // Usuario no ha iniciado sesión
        $('#userOptions').removeClass('d-none'); // Mostrar elementos "Iniciar sesión" y "Registrar usuario"
        $('#logoutOption').addClass('d-none'); // Ocultar elemento "Cerrar sesión"
    }
}

$(document).ready(function () {
    actualizarNavbar();
    $("#cerrarses").click(function () {
        document.cookie = "isLoggedIn=false";
    });
});
