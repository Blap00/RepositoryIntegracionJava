package webServ;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WSMusicPro")
public class WSMusicPro {

    @WebMethod(operationName = "RegistroUsuario")
    public Boolean RegistroUsuario(
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "contrasenna") String contrasenna) {

        if (nombre.equalsIgnoreCase("Ignacio Sepúlveda Rivera") &&
                correo.equalsIgnoreCase("igna.sepulveda@duocuc.cl") &&
                usuario.equalsIgnoreCase("Hola") &&
                contrasenna.equalsIgnoreCase("123")) {
            return true;
        } else if (nombre.equalsIgnoreCase("") &&
                correo.equalsIgnoreCase("igna.sepulveda@duocuc.cl") &&
                usuario.equalsIgnoreCase("Hola") &&
                contrasenna.equalsIgnoreCase("123")) {
            System.out.println("requiere un nombre para continuar con el registro");
            return false;
        } else if (nombre.equalsIgnoreCase("Ignacio Sepúlveda Rivera") &&
                correo.equalsIgnoreCase("") &&
                usuario.equalsIgnoreCase("Hola") &&
                contrasenna.equalsIgnoreCase("123")) {
            System.out.println("requiere un correo para continuar con el registro");
            return false;
        } else if (nombre.equalsIgnoreCase("Ignacio Sepúlveda Rivera") &&
                correo.equalsIgnoreCase("igna.sepulveda@duocuc.cl") &&
                usuario.equalsIgnoreCase("") &&
                contrasenna.equalsIgnoreCase("123")) {
            System.out.println("requiere un usuario para continuar con el registro");
            return false;
        } else if (nombre.equalsIgnoreCase("Ignacio Sepúlveda Rivera") &&
                correo.equalsIgnoreCase("igna.sepulveda@duocuc.cl") &&
                usuario.equalsIgnoreCase("Hola") &&
                contrasenna.equalsIgnoreCase("")) {
            System.out.println("requiere una contraseña para continuar con el registro");
            return false;
        } else if (nombre.equalsIgnoreCase("") ||
                correo.equalsIgnoreCase("") ||
                usuario.equalsIgnoreCase("") ||
                contrasenna.equalsIgnoreCase("")) {
            System.out.println("tiene que rellenar los campos necesarios para continuar con el proceso");
            return false;
        } else {
            return false;
        }
    }

    @WebMethod(operationName = "ProcesoPago")
    public int ProcesoPago(
            @WebParam(name = "Total") int Total,
            @WebParam(name = "pago") int pago) {
        if (Total <= pago) {
            int sobr = Total - pago;
            if (sobr > 0) {
                return sobr;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }

    @WebMethod(operationName = "Login")
    public String Login(
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "contrasenna") String contrasenna) {
        if (usuario.equals("hola") && contrasenna.equals("123")) {
            return "Ingreso exitoso!";
        } else if (usuario.equals("") && contrasenna.equals("")) {
            return "Debe registrar un usuario y contraseña válidas";
        } else if (usuario.equals("hola") && contrasenna.equals("")) {
            return "Debe ingresar una contraseña válida";
        } else if (usuario.equals("") && contrasenna.equals("123")) {
            return "Debe ingresar un usuario válido";
        } else {
            return "ERROR EN EL SISTEMA; DATOS NO VÁLIDOS";
        }
    }

    @WebMethod(operationName = "Producto")
    public String Producto(
            @WebParam(name = "categoria") String categoria,
            @WebParam(name = "precio") int precio,
            @WebParam(name = "stock") int stock,
            @WebParam(name = "descuento") int descuento) {

        boolean catVal = false;
        if (categoria.equalsIgnoreCase("Instrumentos de cuerda")) {
            if (stock >= 1) {
                catVal = true;
            } else {
                catVal = false;
            }
        } else if (categoria.equalsIgnoreCase("Instrumentos de percusion")) {
            if (stock >= 1) {
                catVal = true;
            } else {
                catVal = false;
            }
        } else if (categoria.equalsIgnoreCase("Amplificadores")) {
            if (stock >= 1) {
                catVal = true;
            } else {
                catVal = false;
            }
        } else if (categoria.equalsIgnoreCase("Accesorios")) {
            if (stock >= 1) {
                catVal = true;
            } else {
                catVal = false;
            }
        } else {
            return "ERROR -1";
        }

        if (catVal == true) {
            if (precio >= 0) {
                String retornar="Categoria: "+ categoria +"precio: "+precio+", Descuento: "+descuento+", stock: "+stock+".";
                return retornar;
            } else {
                return "ERROR -1";
            }
        } else {
            return "ERROR -1";
        }
    }
}
