package com.lotto.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lotto.web.services.ConsumerService;
import com.lotto.web.domains.ConsumerBean;
import com.lotto.web.pool.Constants;
import com.lotto.web.serviceimpls.ConsumerServiceImpl;

@WebServlet("/consumer.do")
public class ConsumerController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConsumerBean param = new ConsumerBean();
		ConsumerService service = new ConsumerServiceImpl();
		switch (request.getParameter("action")) {
		case "move":
			request.getRequestDispatcher
			(String.format(
					Constants.VIEW_PATH,
					"consumer",
					request.getParameter("dest")))
					.forward(request, response);
			break;
		case "join":
			String cid = request.getParameter("cid");
			String pass = request.getParameter("pass");
			param.setCid(cid);
			param.setPass(pass);
			service.registerConsumer(param);
			request.getRequestDispatcher
			(String.format(
					Constants.VIEW_PATH,
					"consumer",
					request.getParameter("dest")))
					.forward(request, response);
			break;
		case "login":
			cid = request.getParameter("cid");
			pass = request.getParameter("pass");
			if(cid.equals(service.login(param).getCid())&&pass.equals(service.login(param).getPass())) {
				request.setAttribute("customer",param);
				request.getRequestDispatcher(
						String.format(Constants.VIEW_PATH, "customer", request.getParameter("dest")))
						.forward(request, response);
			}else {
				request.setAttribute("customer",param);
				request.getRequestDispatcher(
						String.format(Constants.VIEW_PATH, "customer","login"))
						.forward(request, response);
			}

			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
