package pe.edu.upeu.qumirv1.dtos;




public record UsuarioCrearDto (String nombres, String apellidos, String correo, char[] password, String token, 
String dni, String perfilPrin, String estado, String offlinex) { }
