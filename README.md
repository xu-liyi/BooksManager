一个Maven+Servlet+JSP+MySQL练手项目，适合Java Web入门

静态资源和部分代码来自尚学堂[02_图书借阅系统_项目的创建_尚学堂_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1Hx4y1L7y6/?p=2&spm_id_from=333.1007.top_right_bar_window_history.content.click&vd_source=bde75a4daffb75df1c294d583808887d)

源代码基础上重写了数据库操作(dao)，使用try-with-resource自动释放资源，同时使用PreparedStatement来避免sql注入问题。

## 技术栈

- [ ] Java 1.8
  - [ ] HikariCP
  - [ ] Servlet 3.1.0

- [ ] JSP 2.3
- [ ] MySQL 5.7.30
- [ ] Maven 3.8.2
- [ ] Tomcat 8.5.69
- [ ] Eclipse 2023.06

## 配置与部署

1. 创建Maven项目，或者直接clone本项目。Archetype选择maven-archetype-webapp 1.0。注意，新版本Eclipse在创建过程中，控制台会出现`Y::`输出，要在后面输入一个`Y`，项目才可以继续创建。

2. 在`pom.xml`中添加属性与依赖，Maven会自动将依赖包加入到classpath中

   ```xml
   <properties>
       <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
       <maven.compiler.source>17</maven.compiler.source>
       <maven.compiler.target>17</maven.compiler.target>
       <java.version>8</java.version>
       <tomcat.version>8.5.69</tomcat.version>
   </properties>
     
   <dependencies>
       <dependency>
           <groupId>junit</groupId>
           <artifactId>junit</artifactId>
           <version>3.8.1</version>
           <scope>test</scope>
       </dependency>
       <dependency>
           <groupId>org.apache.tomcat.embed</groupId>
           <artifactId>tomcat-embed-core</artifactId>
           <version>${tomcat.version}</version>
           <scope>provided</scope>
       </dependency>
       <dependency>
           <groupId>org.apache.tomcat.embed</groupId>
           <artifactId>tomcat-embed-jasper</artifactId>
           <version>${tomcat.version}</version>
           <scope>provided</scope>
       </dependency>
       <dependency>
           <groupId>mysql</groupId>
           <artifactId>mysql-connector-java</artifactId>
           <version>5.1.47</version>
           <scope>runtime</scope>
       </dependency>
       <dependency>
           <groupId>javax.servlet</groupId>
           <artifactId>javax.servlet-api</artifactId>
           <version>3.1.0</version>
       </dependency>
       <dependency>
       		<groupId>com.zaxxer</groupId>
       		<artifactId>HikariCP</artifactId>
   			<version>2.7.1</version>
   		</dependency>
   </dependencies>
   ```

3. 创建MySQL数据库`books`，并运行`init.sql`文件：

4. 将Java代码放到`src/main/java`目录下，将静态文件和JSP页面放到`src/webapp`目录下

5. 运行`Main`函数即可

## 关键技术分析

### 项目整体架构

```ascii
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─xuliyi
│  │  │          └─learnjava
│  │  │              ├─bean 数据结构定义
│  │  │              │      AdminBean.java
│  │  │              │      BookBean.java
│  │  │              │      HistoryBean.java
│  │  │              │      ProblemBean.java
│  │  │              │      TypeBean.java
│  │  │              │      
│  │  │              ├─dao 数据库操作
│  │  │              │      AdminDao.java
│  │  │              │      BookDao.java
│  │  │              │      ProblemDao.java
│  │  │              │      TypeDao.java
│  │  │              │      
│  │  │              ├─main 热启动Tomcat
│  │  │              │      Main.java
│  │  │              │      
│  │  │              ├─servlet Servlet逻辑代码
│  │  │              │      AddAdminServlet.java
│  │  │              │      AddBookServlet.java
│  │  │              │      AddBookTypeServlet.java
│  │  │              │      AddProblemServlet.java
│  │  │              │      AddTimeServlet.java
│  │  │              │      AddUserServlet.java
│  │  │              │      AdminLoginServlet.java
│  │  │              │      AdminServlet.java
│  │  │              │      bdtimesServlet.java
│  │  │              │      borrowServlet.java
│  │  │              │      brtimesServlet.java
│  │  │              │      CodeServlet.java
│  │  │              │      deleteAdminServlet.java
│  │  │              │      deleteProblemServlet.java
│  │  │              │      deleteServlet.java
│  │  │              │      deleteTypeServlet.java
│  │  │              │      deleteUserServlet.java
│  │  │              │      LoginServlet.java
│  │  │              │      RegisterServlet.java
│  │  │              │      selectProblemServlet.java
│  │  │              │      selectServlet.java
│  │  │              │      updateAdminServlet.java
│  │  │              │      updateBookServlet.java
│  │  │              │      updateBookTypeServlet.java
│  │  │              │      updateProblemServlet.java
│  │  │              │      updateUserServlet.java
│  │  │              │      
│  │  │              └─util 数据库连接
│  │  │                      DBUtil.java
│  │  │                      
│  │  ├─resources
│  │  └─webapp 静态文件和JSP页面文件
│  │      │  admin.jsp
│  │      │  admin_admin.jsp
│  │      │  admin_bdtimes.jsp
│  │      │  admin_book.jsp
│  │      │  admin_booktype.jsp
│  │      │  admin_borrow.jsp
│  │      │  admin_brtimes.jsp
│  │      │  admin_feedback.jsp
│  │      │  admin_history.jsp
│  │      │  admin_login.jsp
│  │      │  admin_user.jsp
│  │      │  bdtimes.jsp
│  │      │  borrow.jsp
│  │      │  brtimes.jsp
│  │      │  feedback.jsp
│  │      │  history.jsp
│  │      │  index.jsp
│  │      │  login.jsp
│  │      │  myproblem.jsp
│  │      │  register.jsp
│  │      │  result.jsp
│  │      │  select.jsp
│  │      │  
│  │      ├─static
│  │      │  ├─assets
│  │      │  │  ├─css
│  │      │  │  │      
│  │      │  │  └─js
│  │      │  │          
│  │      │  ├─css
│  │      │  │      
│  │      │  ├─fonts
│  │      │  ├─jQuery
│  │      │  └─js
│  │      │          
│  │      └─WEB-INF
│  │              web.xml
│  │              
```

### Servlet

处理HTTP请求，从而避免直接编写TCP底层代码

编写Servlet需要继承`HttpServlet`，然后覆写`doGet()`和`doPost()`方法。方法内编写请求时的处理逻辑即可

方法传入的参数有两个：`HttpServletRequest`和`HttpServletResponse`，分别是传入的请求报文，和响应报文

Servlet是一个jar包，需要Maven来引入才能正常编译

常用核心代码注释：

```java
//设置编码和响应类型
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
//获取输出流
response.getOutputStream()
//获取请求的参数
String username = request.getParameter("username");
//使用session可以传递参数，如存取用户名等信息
HttpSession session = request.getSession();
session.setAttribute();
session.getAttribute();
//重定向
response.sendRedirect("login.jsp");

```

### JDBC

JDBC是Java访问数据库的标准接口。

使用方法是，先连接，再通过SQL语句实现增删改查

为提高资源的利用效率，通常维护一个连接池，使用静态方法返回连接

```java
//数据库用户名
	public static String JDBC_USER = "root";
	//数据库密码
	public static String JDBC_PASSWORD = "root";
	//数据库链接
	public static String JDBC_URL = "jdbc:mysql://localhost:3306/books?useSSL=false&characterEncoding=utf8";
	//使用HikariConfig连接池，提升系统效率
	public static HikariConfig config = new HikariConfig();
	//JDBC连接池接口
	public static DataSource ds;
	
	//静态初始化块，所有类共用
	static {
		//检查是否有数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//配置连接池
		config.setJdbcUrl(JDBC_URL);
		config.setUsername(JDBC_USER);
		config.setPassword(JDBC_PASSWORD);
		config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
		config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
		config.addDataSourceProperty("maximumPoolSize", "10"); // 最大连接数：10
		ds = new HikariDataSource(config);
	}
/**  
	* 获取数据库链接
	* @param      
	* @return Connection      
	* @throws  
	*/  
	public static Connection getConnectDb() {
		
		Connection conn = null;
		try {
			//conn = DriverManager.getConnection(url, username, password);
			//从连接池中提取连接
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
```

对于增删改查操作，安全的方法是使用PreparedStatement来设置和填充占位符，而不是拼接字符串

```java
String sql = "SELECT * FROM admin WHERE username=? AND password=? ";
		
//使用JDBC进行数据库查找，这里使用try-with-resource来自动释放资源
try(Connection conn = DBUtil.getConnectDb()){
    try(PreparedStatement ps = conn.prepareStatement(sql)){
        ps.setObject(1, username);
        ps.setObject(2, password);
        try(ResultSet rs = ps.executeQuery()){
            if(rs.next()) {
                return true;
            }
        }

    } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

## 待改进

- [ ] 数据库存储明文口令，可以使用对称加密存储

