package com.swufe.javaee.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbyServlet2 extends HttpServlet {
    private Map<String, List<String>> userHobby;
    @Override
    public void init() {
       userHobby = new HashMap<>();
       List<String> bob=new ArrayList<>();
       bob.add("skiing");
       bob.add("extreme");

        List<String> jim=new ArrayList<>();
        jim.add("skiing");
        jim.add("dating");

        List<String> james=new ArrayList<>();
        james.add("dating");
        james.add("extreme");

        List<String> tom=new ArrayList<>();
        tom.add("scuba");
        tom.add("extreme");

        List<String> fei=new ArrayList<>();
        fei.add("scuba");
        fei.add("extreme");

        List<String> jone=new ArrayList<>();
        jone.add("scuba");
        jone.add("skiing");

        List<String> fred=new ArrayList<>();
        fred.add("dating");
        fred.add("scuba");

        List<String> pradeep=new ArrayList<>();
        pradeep.add("dating");
        pradeep.add("extreme");

        List<String> philippe=new ArrayList<>();
        philippe.add("skiing");
        philippe.add("dating");

       userHobby.put("Bob", bob);
       userHobby.put("Jim", jim);
       userHobby.put("James", james);
       userHobby.put("Tom", tom);
       userHobby.put("Fei", fei);
       userHobby.put("Jone", jone);
       userHobby.put("Fred", fred);
       userHobby.put("Pradeep", pradeep);
       userHobby.put("Philippe", philippe);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String hobby = request.getParameter("hobby");
       List<String> names = new ArrayList<>();
       userHobby.forEach((k, v) -> {
            for(int i=0;i<v.size();i++){
                if(v.get(i).equals(hobby)){
                    names.add(k);

                }
            }
       });
       request.setAttribute("names", names);
       request.setAttribute("hobby", hobby);
       request.getRequestDispatcher("hobbyResult2.jsp").forward(request, response);
    }

}
