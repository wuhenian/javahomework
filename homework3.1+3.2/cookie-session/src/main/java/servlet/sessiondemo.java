package servlet;

import model.person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name="session",value = "/session")
public class sessiondemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //得到session
        HttpSession session = req.getSession();
        //给session中存东西
        session.setAttribute("name",new person("nian",18));
        //获取session的ID
        String id=session.getId();
        //判断session是否已经存在
        if(session.isNew()){
            resp.getWriter().write("这是一个新Session,id:"+id);
        }
        else {
            resp.getWriter().write("session已经存在，id为"+id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
