### What is Http?
HTTP is a web's application-layer protocol for transferring different forms of data between client and server. 

### HTTP features: connectionless, stateless, transferring different forms of data
1. the client disconnect from server after sending the request. When the response is ready, the server will re-establish connection and send the response.
2. server maintains no information about past client requests. When finished a communication, if the client has the same request again, client and server need to provide information to each other as new information.
3. HTTP is capable of transferring different forms of data. 

### IP address, Port Number, Socket
IP is the a unique numerical label assigned for each device within a computer network. Port Number, within a communication session, a port number is associated with ip to complete the destination address. Socket = IP + Port Number

### Non-persistent connection and persistent connection
1. In non-persistent connection, each request/response pair are sent over separate TCP connection
2. In persistent connection, all of requests and their responses are sent over the same TCP connection  

## HTTP Request Message
Request line + subsequent Header lines + [] + Entity Body. <br>
Request line has method, field, the URL field and the version field. 

### COMMON Request Method and Code
1xx request received, information message. 200 OK: request success and information is return, 301 redirect requested object has been moved, and new URL is specified. The client software will automatically retrieve the new URL. 400 Bad Request, request could not be understood by server. 404 Not found, the document does not exist on the server. 505 The requested HTTP version is not supported by the server. 


### HTTP Response Message
Status line + subsequent Header lines + [] + Entity Body<br>
Status line contains: version, status code and phase massage

### HTTP vs HTTPS
The mean difference is that HTTP is insecure but the HTTPS consists of HTTP within a connection encrypted by TLS or SSL. Also, by default, http port number is *80* and https port number is *443*.

