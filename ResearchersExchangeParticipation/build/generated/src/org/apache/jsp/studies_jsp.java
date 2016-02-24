package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import rep.model.Study;

public final class studies_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      response.setContentType("text/html");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"CSS/style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <header>            \n");
      out.write("        <span class=\"align_left_green\">\n");
      out.write("            <a href=\"UserController?action=home\"> Researchers Exchange Participation</a>\n");
      out.write("        </span>\n");
      out.write("\n");
      out.write("        <span class =\"align_right\">\n");
      out.write("            <a href=\"UserController?action=about\">About Us</a>&nbsp;\n");
      out.write("            <a href=\"UserController?action=how\">How it works</a>&nbsp;\n");
      out.write("             \n");
      out.write("            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </span>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"js/javascript.js\"></script>\n");
      out.write("<h3 class=\"h3_label\"><b>My Studies </b></h3>\n");
      out.write("<p><a href=\"newstudy.jsp\" >Add a new Study</a></p>\n");
      out.write("<a href=\"main.jsp\"> <h4>Back to main page </h4> </a>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"studies\">\n");
      out.write("    <form action=\"StudyController\" method=\"get\">\n");
      out.write("        <table class=\"table_participate\">\n");
      out.write("            \n");
      out.write("            ");

               if(request.getAttribute("newStudy")!=null)
               {
                    
      out.write("\n");
      out.write("                    <tr class=\"table_participate\">\n");
      out.write("                    <th><b> Study Name</b></th>   \n");
      out.write("                    <th><b> Requested participants</b></th> \n");
      out.write("                    <th><b> Participations</b></th> \n");
      out.write("                    <th><b> Status </b></th>\n");
      out.write("                    <th><b> Action</b></th> \n");
      out.write("            </tr>\n");
      out.write("                ");
 
                List<Study> list = (ArrayList<Study>) request.getAttribute("newStudy");              
                for(Study study : list) {
            
      out.write("   \n");
      out.write("            \n");
      out.write("             <tr>            \n");
      out.write("                <td class=\"td_participate_odd\"><b>");
 out.print(study.getName());
      out.write(" </b></td> \n");
      out.write("                <td class=\"td_participate_odd\" > ");
 out.print(study.getRequestedParticipants());
      out.write(" <b></b></td>\n");
      out.write("                <td class=\"td_participate_odd\"><b> ");
 out.print(study.getNumOfParticipants());
      out.write(" </b></td>\n");
      out.write("                <td class=\"td_participate_odd\"><input onclick=\"getCode(");
 out.print(study.getCode());
      out.write(")\" class=\"part_button\" name=\"action\" type=\"submit\" value =\"");
 if((study.getStatus().equalsIgnoreCase("start")))
                { 
                    out.print("stop"); 
                }
                else
                {
                    out.print("start");
                }
//
      out.write("\"/>\n");
      out.write("                 \n");
      out.write("                </td>\n");
      out.write("               \n");
      out.write("                <td class=\"td_participate_odd\"><input onclick=\"getCode(");
 out.print(study.getCode());
      out.write(")\" class=\"part_button\" type=\"submit\" name=\"action\" value=\"edit\" /></td> \n");
      out.write("                              \n");
      out.write("            </tr>\n");
      out.write("           \n");
      out.write("                \n");
      out.write("                ");
 }
                
                
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                ");

                }
                if(request.getAttribute("newStudy")== null) 
                {                
                
      out.write("      \n");
      out.write("                 <h3> no entries found </h3> \n");
      out.write("                ");
 }
                
      out.write("\n");
      out.write("                               \n");
      out.write("              </table>\n");
      out.write("                \n");
      out.write("                 <input type=\"hidden\" id=\"code\" name=\"studyCode\" >            \n");
      out.write("    </form>\n");
      out.write("       \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<footer>\n");
      out.write("    ");
      out.write("\n");
      out.write("<p>\n");
      out.write("    &copy; Researchers Exchange Participations\n");
      out.write("</p>\n");
      out.write("<p>\n");
      out.write("   \n");
      out.write("        \n");
      out.write("        \n");
      out.write("   ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cookie.myCookie.value}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("         \n");
      out.write("   \n");
      out.write("</p>\n");
      out.write("\n");
      out.write("</footer>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty theUser.name}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                Hello,");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${theUser.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty theUser}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <a href=\"login.jsp\">Login</a>&nbsp;\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
