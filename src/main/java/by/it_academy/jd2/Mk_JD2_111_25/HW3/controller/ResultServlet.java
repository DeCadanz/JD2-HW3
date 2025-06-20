package by.it_academy.jd2.Mk_JD2_111_25.HW3.controller;

import by.it_academy.jd2.Mk_JD2_111_25.HW3.dto.Stats;
import by.it_academy.jd2.Mk_JD2_111_25.HW3.service.VoteService;
import by.it_academy.jd2.Mk_JD2_111_25.HW3.service.api.IVoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns = "/result")
public class ResultServlet extends HttpServlet {

    private final IVoteService service = new VoteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Stats stats = service.getStats();
        req.setAttribute("artistsStats", stats.getArtists());
        req.setAttribute("genresStats", stats.getGenre());
        req.setAttribute("aboutsStats", stats.getAbouts());

        req.getRequestDispatcher("template/voteresult.jsp").forward(req, resp);

    }
}
