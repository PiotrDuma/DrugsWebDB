DrugsWebDB

Java Springboot REST Web Server API with mySQL.

Web application which returns JSON object describing Drug medicine used in android application by HTML request.
Server returns information from SQL query in string response.

To send request scan medicine barcode in your application, then fill HTML url pattern:

 "http://{ip_adress}:{port_number}/DrugsWebDB/{id_Barcode}"

example:

http://localhost:8080/DrugsWebDB/5909990061716

response:

{"dose":"0,4 G","contents":"10 TABL.","name":"ABAKTAL","producent":"SANDOZ"}

