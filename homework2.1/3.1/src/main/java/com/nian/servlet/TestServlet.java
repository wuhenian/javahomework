
package com.nian.servlet;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.nian.model.colorAndChar.*;

@WebServlet(value="/TestServlet")
public class TestServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("image/jpeg");
		/*随机字符串*/
		String randomString = getRandomString();
		/*将randomString放到session中*/
		request.getSession(true).setAttribute("randomString", randomString);
		/*设置图片的宽高*/
		int width = 100;
		int height = 30;
		/*随机颜色用于背景颜色，反色用于前景颜色*/
		Color color = getRandomColor();
		Color reverse = getReverseColor(color);
		BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.setColor(reverse);
		g.drawString(randomString, 18, 20);
		for(int i = 0, n = random.nextInt(100); i <n; i++)
		{
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		ServletOutputStream out = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(bi);
		out.close();
	}
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
 
}
