package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "components/head.jsp", out, false);
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "components/header.jsp", out, false);
      out.write("\n");
      out.write("        <main>\n");
      out.write("            <div class=\"page-wrapper\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row d-flex justify-content-center\">\n");
      out.write("                        <div class=\"col-lg-8\">\n");
      out.write("                            <h3>Login now!</h3>\n");
      out.write("                           \n");
      out.write("                            <form action=\"login\" method=\"post\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"exampleInputEmail1\">Username</label>\n");
      out.write("                                    <input type=\"text\" name=\"username\" class=\"form-control\" placeholder=\"Enter Username\" required />\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"exampleInputPassword1\">Password</label>\n");
      out.write("                                    <input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Enter Password\" required />\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group form-check\">\n");
      out.write("                                    <input type=\"checkbox\" name=\"remember\" value=\"remember\" class=\"form-check-input\" id=\"exampleCheck1\">\n");
      out.write("                                    <label class=\"form-check-label\" for=\"exampleCheck1\">Remember me</label>\n");
      out.write("                                </div>\n");
      out.write("                                <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.errorMsg ne null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label for=\"error\" class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.errorMsg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </c:if>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-sign-in-alt\"></i> Login</button>\n");
      out.write("                                <a class=\"btn btn-success\" href=\"register\"><i class=\"fas fa-user-plus\"></i> Register</a>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </main>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "components/js.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "components/footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
