package car.ticket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.ticket.dao.TicketDAO;
import car.ticket.dto.TicketDTO;
import car.common.handler.HandlerAdapter;

public class TicketUpdateController implements Controller {
	private static Log log = LogFactory.getLog(TicketUpdateController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int ticket_code = Integer.parseInt(request.getParameter("ticket_code"));
		log.info(ticket_code);
		System.out.println(ticket_code);
		TicketDAO ticketDAO = new TicketDAO();
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO = ticketDAO.ticketDetailSearch(ticket_code);
		request.setAttribute("ticketDTO", ticketDTO);
		HandlerAdapter ticketHandlerAdapter = new HandlerAdapter();
		log.info("정기권 수정");
		ticketHandlerAdapter.setPath("WEB-INF/view/ticket/ticket_update.jsp");
		return ticketHandlerAdapter;
	}

}
