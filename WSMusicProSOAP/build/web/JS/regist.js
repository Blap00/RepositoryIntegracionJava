function registroUsuario() {
    var nombre = document.getElementById('nombre').value;
    var correo = document.getElementById('correo').value;
    var usuario = document.getElementById('usuario').value;
    var contrasenna = document.getElementById('contrasenna').value;

    // Realizar las validaciones
    if (nombre === '' || correo === '' || usuario === '' || contrasenna === '') {
        alert('Debe completar todos los campos');
        return; // Detener la ejecución de la función si faltan campos por completar
    }

    // Llamada AJAX utilizando jQuery
    $.ajax({
        url: 'http://localhost:8080/WSMusicProSOAP/WSMusicPro', // URL del servicio web SOAP
        type: 'POST',
        dataType: 'xml',
        data: '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://webServ/">' +
            '<soapenv:Header/>' +
            '<soapenv:Body>' +
            '<web:RegistroUsuario>' +
            '<nombre>' + nombre + '</nombre>' +
            '<correo>' + correo + '</correo>' +
            '<usuario>' + usuario + '</usuario>' +
            '<contrasenna>' + contrasenna + '</contrasenna>' +
            '</web:RegistroUsuario>' +
            '</soapenv:Body>' +
            '</soapenv:Envelope>',
        contentType: 'text/xml',
        success: function (response) {
            // Manipula la respuesta del servicio web SOAP
            console.log(response);
            // Obtén el valor booleano de la respuesta
            var returnElement = response.getElementsByTagName('return')[0];
            var returnValue = returnElement.textContent;

            // Verifica si el valor es verdadero o falso
            if (returnValue === 'true') {
                window.location.href = './index.html'; // Reemplaza 'index.html' con la URL de redirección deseada
            } else {
            }
        },
        error: function (xhr, status, error) {
            // Maneja el error de la llamada AJAX
            console.error(error);
        }
    });
}