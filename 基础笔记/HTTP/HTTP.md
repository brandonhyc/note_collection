****### what is url
It's the unique identification of resources

### What is HTTP?
HTTP is a web's application-layer protocol for transferring different forms of data between client and server. 

### 必考 HTTP features: connectionless, stateless, transferring different forms of data
1. the client disconnect from server after sending the request. When the response is ready, the server will re-establish connection and send the response.
2. server maintains no information about past client requests. When finished a communication, if the client has the same request again, client and server need to provide information to each other as new information.
3. HTTP is capable of transferring different forms of data. 

### 必考 HTTP vs HTTPS
The mean difference is that HTTP is insecure but the HTTPS consists of HTTP within a connection encrypted by TLS or SSL. Also, by default, http port number is *80* and https port number is *443*.

### IP address, Port Number, Socket
IP is the a unique numerical label assigned for each device within a computer network. Port Number, within a communication session, a port number is associated with ip to complete the destination address. Socket = IP + Port Number

### Non-persistent connection and persistent connection
1. In non-persistent connection, each request/response pair are sent over separate TCP connection
2. In persistent connection, all of requests and their responses are sent over the same TCP connection

## 必考 HTTP Request Message
Request line + subsequent Header lines + [] + Entity Body. <br>
Request line has method field, the URL field and the version field. 

### 必考 COMMON Request Method and Code
* 1xx request received, information message. 
* 200 OK: request success and information is return, 
* 301 redirect requested object has been moved, and new URL is specified. The client software will automatically retrieve the new URL. 
* 400 Bad Request, request could not be understood by server. 
* 404 Not found, the document does not exist on the server. 
* 505 The requested HTTP version is not supported by the server. 

### 必考 HTTP Response Message
Status line + subsequent Header lines + [] + Entity Body<br>
Status line contains: version, status code and status text

### REST vs SOAP
SOAP is a protocol, REST is a design.
SOAP only support XML, but REST supports different format like text, JSON, XML.
SOAP can use almost any transport to send the request, REST uses HTTP/HTTPS; 
A SOAP client is tightly coupled to the server.


### GET vs POST
The form-data can be sent as URL variables (with method="get") or as HTTP post transaction (with method="post").

Notes on GET:
* Appends form-data into the URL in name/value pairs
* The length of a URL is limited (about 3000 characters)
* Never use GET to send sensitive data! (will be visible in the URL)
* Useful for form submissions where a user want to bookmark the result
* GET is better for non-secure data, like query strings in Google
* 
Notes on POST:
* Appends form-data inside the body of the HTTP request (data is not shown is in URL)
* Has no size limitations
* Form submissions with POST cannot be bookmarked

### POST vs PUT
POST is for the purpose of creating, put is for the purpose of updating.
POST updates a resource, adds a subsidiary resource, or causes a change. A POST is not idempotent, in the way that x++ is not idempotent.
PUT is idempotent, so if you PUT an object twice, it has same effect. 


### HTTP请求发起和响应过程

从用户输入URL，到浏览器呈现给用户页面，经过了什么过程

1. 用户输入URL，浏览器获取到URL
2. 浏览器(应用层)进行DNS解析（如果输入的是IP地址，此步骤省略）
3. 根据解析出的IP地址+端口，浏览器（应用层）发起HTTP请求，请求中携带（请求头header（也可细分为请求行和请求头）、请求体body），
    <br>
    header包含：
    1. 请求的方法（get、post、put..）
    2. 协议（http、https、ftp、sftp…）
    3. 目标url（具体的请求路径已经文件名）
    4. 一些必要信息（缓存、cookie之类）
    
    body包含：
    1. 请求的内容
  
4. 请求到达传输层，tcp协议为传输报文提供可靠的字节流传输服务，它通过三次握手等手段来保证传输过程中的安全可靠。通过对大块数据的分割成一个个报文段的方式提供给大量数据的便携传输。
5. 到网络层， 网络层通过ARP寻址得到接收方的Mac地址，IP协议把在传输层被分割成一个个数据包传送接收方。
6. 数据到达数据链路层，请求阶段完成
7. 接收方在数据链路层收到数据包之后，层层传递到应用层，接收方应用程序就获得到请求报文。
8. 接收方收到发送方的HTTP请求之后，进行请求文件资源（如HTML页面）的寻找并响应报文
9. 发送方收到响应报文后，如果报文中的状态码表示请求成功，则接受返回的资源（如HTML文件），进行页面渲染。


![alt text](https://i.imgur.com/wZtvWjj.png)


1. HTML parser：HTML解析器，其本质是将HTML文本解释成DOM tree。
2. CSS  parser：CSS解析器，其本质是讲DOM中各元素对象加入样式信息
3. JavaScript引擎：专门处理JavaScript脚本的虚拟机，其本质是解析JS代码并且把逻辑（HTML和CSS的操作）应用到布局中，从而按程序要的要求呈现相应的结果
4. DOM tree:文档对象模型树，也就是浏览器通过HTMLparser解析HTML页面生成的HTML树状结构以及相应的接口。
5. render tree：渲染树，也就是浏览器引擎通过DOM Tree和CSS Rule Tree构建出来的一个树状结构，和dom tree不一样的是，它只有要最终呈现出来的内容，像或者带有display:none的节点是不存在render tree中的。
6. layout：也叫reflow 重排，渲染中的一种行为。当rendertree中任一节点的几何尺寸发生改变了，render tree都会重新布局。
7. repaint：重绘，渲染中的一种行为。render tree中任一元素样式属性（几何尺寸没改变）发生改变了，render tree都会重新画，比如字体颜色、背景等变化。

1. 浏览器通过HTMLParser根据深度遍历的原则把HTML解析成DOM Tree。
2. 将CSS解析成CSS Rule Tree（CSSOM Tree）。
3. 根据DOM树和CSSOM树来构造render Tree。
4. layout：根据得到的render tree来计算所有节点在屏幕的位置。
5. paint：遍历render树，并调用硬件图形API来绘制每个节点。
