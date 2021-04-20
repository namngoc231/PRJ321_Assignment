package org.apache.jsp.components;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- Footer -->\n");
      out.write("<footer class=\"page-footer font-small unique-color-dark\">\n");
      out.write("    <!-- Footer Links -->\n");
      out.write("    <div class=\"container text-center text-md-left mt-5\">\n");
      out.write("\n");
      out.write("        <!-- Grid row -->\n");
      out.write("        <div class=\"row mt-3\">\n");
      out.write("\n");
      out.write("            <!-- Grid column -->\n");
      out.write("            <div class=\"col-md-3 col-lg-2 col-xl-2 mx-auto mb-4\">\n");
      out.write("\n");
      out.write("                <!-- Links -->\n");
      out.write("                <h6 class=\"text-uppercase font-weight-bold\" style=\"font-size: 0.92rem\">Hỗ trợ</h6>\n");
      out.write("                <hr class=\"deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto\" style=\"width: 160px;\">\n");
      out.write("                <p>\n");
      out.write("                    <a href=\"#!\">Chăm sóc tại nhà</a>\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("                    <a href=\"#!\">Tiêm phòng vacxin</a>\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("                    <a href=\"#!\">Phụ kiện thú cưng</a>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- Grid column -->\n");
      out.write("\n");
      out.write("            <!-- Grid column -->\n");
      out.write("            <div class=\"col-md-2 col-lg-2 col-xl-2 mx-auto mb-4\">\n");
      out.write("\n");
      out.write("                <!-- Links -->\n");
      out.write("                <h6 class=\"text-uppercase font-weight-bold\" style=\"font-size:0.92rem\">Giống mèo cảnh</h6>\n");
      out.write("                <hr class=\"deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto\" style=\"width: 130px;\">\n");
      out.write("                <p>\n");
      out.write("                    <a href=\"#!\">Mèo Anh</a>\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("                    <a href=\"#!\">Mèo Ba Tư</a>\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("                    <a href=\"#!\">Mèo Xiêm</a>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- Grid column -->\n");
      out.write("\n");
      out.write("            <!-- Grid column -->\n");
      out.write("            <div class=\"col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4\">\n");
      out.write("                <!-- Links -->\n");
      out.write("                <h6 class=\"text-uppercase font-weight-bold\" style=\"font-size:0.92rem\">Liên hệ</h6>\n");
      out.write("                <hr class=\"deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto\" style=\"width: 55px;\">\n");
      out.write("                <p>\n");
      out.write("                    <i class=\"fas fa-home mr-3\"></i> FPT University</p>\n");
      out.write("                <p>\n");
      out.write("                    <i class=\"fas fa-envelope mr-3\"></i> namngoc231@gmail.com</p>\n");
      out.write("                <p>\n");
      out.write("                    <i class=\"fas fa-phone mr-3\"></i> + 0866199497 </p>\n");
      out.write("            </div>\n");
      out.write("            <!-- Grid column -->\n");
      out.write("        </div>\n");
      out.write("        <!-- Grid row -->\n");
      out.write("    </div>\n");
      out.write("    <!-- Footer Links -->\n");
      out.write("</footer>\n");
      out.write("<!-- Footer -->\n");
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
