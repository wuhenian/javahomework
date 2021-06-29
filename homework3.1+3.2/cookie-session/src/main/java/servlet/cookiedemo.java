package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="cookie",value = "/cookie")
public class cookiedemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //打印字符串 命名为out
        PrintWriter out=resp.getWriter();
        //cookie  服务器端从客户端获取 用req
        Cookie[] cookies = req.getCookies();
        //判断cookie是否存在
        if (cookies!=null){
            out.write("欢迎回来！");
            for (int i=0; i<cookies.length;i++){
                Cookie cookie=cookies[i];
                if (cookie.getName().equals("cookiename")){

                    out.write(cookie.getValue().toString());
                }
            }
        }
        else  {
         out.write("这是你第一次访问");
        }
        //服务端给客户端发送cookie
        Cookie cookie=new Cookie("cookiename","nian");
        resp.addCookie(cookie);
        //设置有效期为一天
        cookie.setMaxAge(24*60*60);



     }






    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
