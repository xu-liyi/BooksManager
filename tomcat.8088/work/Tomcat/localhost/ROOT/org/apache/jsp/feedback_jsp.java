/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.69
 * Generated at: 2023-09-03 05:04:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.xuliyi.learnjava.bean.AdminBean;
import com.xuliyi.learnjava.bean.HistoryBean;
import com.xuliyi.learnjava.dao.BookDao;
import com.xuliyi.learnjava.dao.AdminDao;

public final class feedback_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.xuliyi.learnjava.dao.AdminDao");
    _jspx_imports_classes.add("com.xuliyi.learnjava.dao.BookDao");
    _jspx_imports_classes.add("com.xuliyi.learnjava.bean.HistoryBean");
    _jspx_imports_classes.add("com.xuliyi.learnjava.bean.AdminBean");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html lang=\"zh-CN\" class=\"ax-vertical-centered\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>图书馆管理系统</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/bootstrap-theme.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/bootstrap-admin-theme.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/bootstrap-admin-theme.css\">\r\n");
      out.write("<script src=\"static/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"static/jQuery/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<script src=\"static/js/bootstrap-dropdown.min.js\"></script>\r\n");
      out.write("<script src=\"static/js/reader.js\"></script>\r\n");
      out.write("<script src=\"static/js/readerUpdateInfo.js\"></script>\r\n");
      out.write("<script src=\"static/js/readerUpdatePwd.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("	background-image: url(\"04.jpg\");\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script src=\"static/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"static/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<body class=\"bootstrap-admin-with-small-navbar\">\r\n");
      out.write("	");

		AdminBean admin = new AdminBean();
		String aid = (String) session.getAttribute("aid");
		AdminDao admindao = new AdminDao();
		admin = admindao.get_AidInfo2(aid);
	
      out.write("\r\n");
      out.write("	<nav\r\n");
      out.write("		class=\"navbar navbar-inverse navbar-fixed-top bootstrap-admin-navbar bootstrap-admin-navbar-under-small\"\r\n");
      out.write("		role=\"navigation\">\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<div class=\"row\">\r\n");
      out.write("				<div class=\"col-lg-12\">\r\n");
      out.write("					<div class=\"collapse navbar-collapse main-navbar-collapse\">\r\n");
      out.write("						<a class=\"navbar-brand\" href=\"index.jsp\"><strong>欢迎使用图书馆管理系统</strong></a>\r\n");
      out.write("						<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("							<li class=\"dropdown\"><a href=\"#\" role=\"button\"\r\n");
      out.write("								class=\"dropdown-toggle\" data-hover=\"dropdown\"> <i\r\n");
      out.write("									class=\"glyphicon glyphicon-user\"></i> 欢迎您，");
out.write(admin.getName());
      out.write("\r\n");
      out.write("										(");
      out.print(session.getAttribute("aid"));
      out.write(")\r\n");
      out.write("									<i class=\"caret\"></i></a>\r\n");
      out.write("								<ul class=\"dropdown-menu\">\r\n");
      out.write("									<li><a href=\"#updateinfo\" data-toggle=\"modal\">个人资料</a></li>\r\n");
      out.write("									<li role=\"presentation\" class=\"divider\"></li>\r\n");
      out.write("									<li><a href=\"#updatepwd\" data-toggle=\"modal\">修改密码</a></li>\r\n");
      out.write("									<li role=\"presentation\" class=\"divider\"></li>\r\n");
      out.write("									<li><a href=\"login.jsp\">退出</a></li>\r\n");
      out.write("								</ul>\r\n");
      out.write("							</li>\r\n");
      out.write("						</ul>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</nav>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<!-- left, vertical navbar & content -->\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("			<!-- left, vertical navbar -->\r\n");
      out.write("			<div class=\"col-md-2 bootstrap-admin-col-left\">\r\n");
      out.write("				<ul class=\"nav navbar-collapse collapse bootstrap-admin-navbar-side\">\r\n");
      out.write("					<li><a href=\"select.jsp\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-chevron-right\"></i> 图书查询</a></li>\r\n");
      out.write("					<li><a href=\"borrow.jsp\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-chevron-right\"></i> 借阅信息</a></li>\r\n");
      out.write("					<li><a href=\"history.jsp\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-chevron-right\"></i> 借阅历史</a></li>\r\n");
      out.write("				</ul><br><br>\r\n");
      out.write("				<ul class=\"nav navbar-collapse collapse bootstrap-admin-navbar-side\">\r\n");
      out.write("					<li><a href=\"bdtimes.jsp\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-chevron-right\"></i> 热门推荐</a></li>\r\n");
      out.write("					<li><a href=\"brtimes.jsp\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-chevron-right\"></i> 最佳读者</a></li>\r\n");
      out.write("				</ul><br><br>\r\n");
      out.write("				<ul class=\"nav navbar-collapse collapse bootstrap-admin-navbar-side\">\r\n");
      out.write("					<li><a href=\"feedback.jsp\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-chevron-right\"></i> 问题反馈</a></li>\r\n");
      out.write("				</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<!-- content -->\r\n");
      out.write("			<div class=\"col-md-10\">\r\n");
      out.write("				<div class=\"row\">\r\n");
      out.write("					<div class=\"col-lg-12\">\r\n");
      out.write("						<div class=\"panel panel-default bootstrap-admin-no-table-panel\">\r\n");
      out.write("							<div class=\"panel-heading\">\r\n");
      out.write("								<div class=\"text-muted bootstrap-admin-box-title\">问题反馈</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<div\r\n");
      out.write("								class=\"bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in\">\r\n");
      out.write("								<form class=\"form-horizontal\" action=\"AddProblemServlet\"\r\n");
      out.write("									method=\"post\">\r\n");
      out.write("									<div class=\"col-lg-8 form-group\">\r\n");
      out.write("										<label class=\"col-lg-4\" for=\"query_bname\">标题</label>\r\n");
      out.write("										<div class=\"col-lg-12\">\r\n");
      out.write("											<input class=\"form-control\" id=\"bookName\" name=\"name\"\r\n");
      out.write("												type=\"text\" value=\"\" required=\"required\" placeholder=\"请勿超过30个字符\">\r\n");
      out.write("											<label for=\"query_bname\" style=\"display: none;\"></label>\r\n");
      out.write("										</div>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"col-lg-8 form-group\">\r\n");
      out.write("										<label class=\"col-lg-4\" for=\"query_bname\">问题页面</label>\r\n");
      out.write("										<div class=\"col-lg-12\">\r\n");
      out.write("											<input class=\"form-control\" id=\"bookName\" name=\"page\"\r\n");
      out.write("												type=\"text\" value=\"\" required=\"required\" placeholder=\"books/XXX.jsp(仅填写XXX处)\">\r\n");
      out.write("											<label for=\"query_bname\" style=\"display: none;\"></label>\r\n");
      out.write("										</div>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"col-lg-8 form-group\">\r\n");
      out.write("										<label class=\"col-lg-4\" for=\"query_bname\">问题描述</label>\r\n");
      out.write("										<div class=\"col-lg-12\">\r\n");
      out.write("											<textarea name=\"body\" required=\"required\" class=\"form-control\" placeholder=\"请勿超过255个字符\"\r\n");
      out.write("												style=\"height: 150px;resize: none;\"></textarea>\r\n");
      out.write("											<label for=\"query_bname\" style=\"display: none;\"></label>\r\n");
      out.write("										</div>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"col-lg-8 form-group\">\r\n");
      out.write("										<label class=\"col-lg-4\" for=\"query_bname\">联系方式</label>\r\n");
      out.write("										<div class=\"col-lg-12\">\r\n");
      out.write("											<input class=\"form-control\" id=\"bookName\" name=\"phone\"\r\n");
      out.write("												type=\"text\" value=\"\" required=\"required\" placeholder=\"电话/邮箱\">\r\n");
      out.write("											<label for=\"query_bname\" style=\"display: none;\"></label>\r\n");
      out.write("										</div>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"col-lg-8 form-group\">\r\n");
      out.write("										<label class=\"control-label\" for=\"query_bname\"></label>\r\n");
      out.write("										<button type=\"submit\" class=\"btn btn-primary\" id=\"btn_query\">提 交</button>\r\n");
      out.write("										<label for=\"query_bname\" style=\"display: none;\"></label>&nbsp;\r\n");
      out.write("										<a href=\"myproblem.jsp\"><i\r\n");
      out.write("											class=\"glyphicon glyphicon-chevron-right\"></i> 我的反馈</a>\r\n");
      out.write("									</div>\r\n");
      out.write("								</form>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<!-------------------------------------------------------------->\r\n");
      out.write("\r\n");
      out.write("	<!-------------------------个人资料模糊框------------------------------------->\r\n");
      out.write("\r\n");
      out.write("	<form class=\"form-horizontal\" method=\"post\"\r\n");
      out.write("		action=\"AdminServlet\">\r\n");
      out.write("		<!--保证样式水平不混乱-->\r\n");
      out.write("		<!-- 模态框（Modal） -->\r\n");
      out.write("		<div class=\"modal fade\" id=\"updatepwd\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("			aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("			<div class=\"modal-dialog\">\r\n");
      out.write("				<div class=\"modal-content\">\r\n");
      out.write("					<div class=\"modal-header\">\r\n");
      out.write("						<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("							aria-hidden=\"true\">&times;</button>\r\n");
      out.write("						<h4 class=\"modal-title\" id=\"myModalLabel\">修改密码</h4>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("						<!--正文-->\r\n");
      out.write("						<input type=\"hidden\" name=\"tip\" value=\"1\"> <input\r\n");
      out.write("							type=\"hidden\" name=\"url\" value=\"feedback\">\r\n");
      out.write("						<div class=\"form-group\">\r\n");
      out.write("							<label for=\"firstname\" class=\"col-sm-3 control-label\">原密码</label>\r\n");
      out.write("							<div class=\"col-sm-7\">\r\n");
      out.write("								<input type=\"password\" class=\"form-control\" name=\"password\"\r\n");
      out.write("									id=\"oldPwd\" placeholder=\"请输入原密码\"> <label\r\n");
      out.write("									class=\"control-label\" for=\"oldPwd\" style=\"display: none\"></label>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("						<div class=\"form-group\">\r\n");
      out.write("							<label for=\"firstname\" class=\"col-sm-3 control-label\">新密码</label>\r\n");
      out.write("							<div class=\"col-sm-7\">\r\n");
      out.write("								<input type=\"password\" class=\"form-control\" name=\"password2\"\r\n");
      out.write("									id=\"newPwd\" placeholder=\"请输入新密码\"> <label\r\n");
      out.write("									class=\"control-label\" for=\"newPwd\" style=\"display: none\"></label>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"modal-footer\">\r\n");
      out.write("						<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭\r\n");
      out.write("						</button>\r\n");
      out.write("						<button type=\"submit\" class=\"btn btn-primary\">修改</button>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!-- /.modal-content -->\r\n");
      out.write("			</div>\r\n");
      out.write("			<!-- /.modal -->\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("	</form>\r\n");
      out.write("	<!-------------------------------------------------------------->\r\n");
      out.write("\r\n");
      out.write("	<!-------------------------个人资料模糊框------------------------------------->\r\n");
      out.write("\r\n");
      out.write("	<form class=\"form-horizontal\" method=\"post\"\r\n");
      out.write("		action=\"AdminServlet\">\r\n");
      out.write("		<!--保证样式水平不混乱-->\r\n");
      out.write("		<!-- 模态框（Modal） -->\r\n");
      out.write("		<div class=\"modal fade\" id=\"updateinfo\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("			aria-labelledby=\"ModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("			<div class=\"modal-dialog\">\r\n");
      out.write("				<div class=\"modal-content\">\r\n");
      out.write("					<div class=\"modal-header\">\r\n");
      out.write("						<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("							aria-hidden=\"true\">&times;</button>\r\n");
      out.write("						<h4 class=\"modal-title\" id=\"ModalLabel\">个人资料</h4>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("						<!--正文-->\r\n");
      out.write("						<input type=\"hidden\" name=\"tip\" value=\"2\"> <input\r\n");
      out.write("							type=\"hidden\" name=\"url\" value=\"feedback\">\r\n");
      out.write("						<div class=\"form-group\">\r\n");
      out.write("							<label for=\"firstname\" class=\"col-sm-3 control-label\">真实姓名</label>\r\n");
      out.write("							<div class=\"col-sm-7\">\r\n");
      out.write("								<input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\"\r\n");
      out.write("									placeholder=\"请输入您的真实姓名\"\r\n");
      out.write("									value='");
out.write(admin.getName());
      out.write("'> <label\r\n");
      out.write("									class=\"control-label\" for=\"name\" style=\"display: none\"></label>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("						<div class=\"form-group\">\r\n");
      out.write("							<label for=\"firstname\" class=\"col-sm-3 control-label\">手机号</label>\r\n");
      out.write("							<div class=\"col-sm-7\">\r\n");
      out.write("								<input type=\"text\" class=\"form-control\" id=\"phone\" name=\"phone\"\r\n");
      out.write("									placeholder=\"请输入您的手机号\"\r\n");
      out.write("									value='");
out.write(admin.getPhone());
      out.write("'> <label\r\n");
      out.write("									class=\"control-label\" for=\"phone\" style=\"display: none\"></label>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						\r\n");
      out.write("						<div class=\"form-group\">\r\n");
      out.write("							<label for=\"firstname\" class=\"col-sm-3 control-label\">邮箱</label>\r\n");
      out.write("							<div class=\"col-sm-7\">\r\n");
      out.write("								<input type=\"text\" class=\"form-control\" id=\"email\" name=\"email\"\r\n");
      out.write("									placeholder=\"请输入您的邮箱\" value='");
out.write(admin.getEmail());
      out.write("'>\r\n");
      out.write("								<label class=\"control-label\" for=\"email\" style=\"display: none\"></label>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"modal-footer\">\r\n");
      out.write("						<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭\r\n");
      out.write("						</button>\r\n");
      out.write("						<button type=\"submit\" class=\"btn btn-primary\">修改</button>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!-- /.modal-content -->\r\n");
      out.write("			</div>\r\n");
      out.write("			<!-- /.modal -->\r\n");
      out.write("		</div>\r\n");
      out.write("	</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
