package http.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by alvin on 2016/5/23.
 */
public class TestTransfers extends HttpServlet {
    private static final long serialVersionUID= 1L;
    protected void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
//判断请求报文是否来自代维系统的ip地址
        String ip = request.getRemoteHost();
// 获取收到的报文
        BufferedReader reader = request.getReader();
        String line = "";
        StringBuffer inputString = new StringBuffer();
        while((line = reader.readLine()) != null) {
            inputString.append(line);
        }
//如有必要，可以在报文中增加其他验证和加密的参数
//解析获取到的报文，根据ip地址、其他验证、加密等等来判断请求报文的服务器是否有权限
//如果请求验证合格，则根据请求的参数装配返回的报文
// 要返回的报文
        StringBuffer resultBuffer = new StringBuffer();
        resultBuffer.append("");
        resultBuffer.append("");
        resultBuffer.append("953947334");
        resultBuffer.append("20120402113943");
        resultBuffer.append("");
        resultBuffer.append("0000");
        resultBuffer.append("成功");
        resultBuffer.append("");
        resultBuffer.append("");
        resultBuffer.append("");
        resultBuffer.append("长治县");
        resultBuffer.append("铁通");
        resultBuffer.append("线路");
        resultBuffer.append("王加和");
        resultBuffer.append("20120301000000");
        resultBuffer.append("20120331235959");
        resultBuffer.append("50");
        resultBuffer.append("40");
        resultBuffer.append("0.80");
        resultBuffer.append("");
//......
//......
//......
//循环组装响应的报文
        resultBuffer.append("");
        resultBuffer.append("");
// 设置发送报文的格式
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(resultBuffer.toString());
        out.flush();
        out.close();
    }
}
