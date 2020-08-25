PROYECTO EN GITHUB:
https://github.com/josephStart/cl-jose-huenul-springboot-app.git

PRE-REQUISITOS
- Version instalada de JDK 1.8

PARA LEVANTAR EL PROYECTO:

1. En la carpeta del proyecto ejecutar en una CLI los siguientes comandos: ./gradlew clean && ./gradlew build
2. En la misma carpeta, en la CLI se debe ejecutar después: ./gradlew bootRun

- ACCEDER A LA BASE DE DATOS EN MEMORIA H2: http://localhost:7001/h2-console
	- CONFIGURACION LOGIN:

		Saved Settings: Generic H2(Embedded)
		Setting Name: Generic H2(Embedded)
		
		Driver Class: org.h2.Driver
		JDBC URL: jdbc:h2:mem:UserInfoDB
		User Name: sa
		Password: DBAdmin
		
- PARA CREAR UN NUEVO USUARIO Y MOSTRAR LA INFORMACION(METODO POST):
http://localhost:7001/usuario/crear-usuario

CUERPO:
{
"name" : "Test" ,
"email" : "test@test.com" ,
"password" : "Test21" ,
  "phones" : [
          {
          "number" : "1234567" ,
          "citycode" : "1" ,
          "countrycode" : "57"
          },
    {
          "number" : "56789" ,
          "citycode" : "2" ,
          "countrycode" : "31"
          },
    {
          "number" : "98765" ,
          "citycode" : "10" ,
          "countrycode" : "67"
          },
    {
          "number" : "5432" ,
          "citycode" : "5" ,
          "countrycode" : "45"
          }
  ]
}