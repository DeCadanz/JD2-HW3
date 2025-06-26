package by.it_academy.jd2.Mk_JD2_111_25.HW3.controller;

import by.it_academy.jd2.Mk_JD2_111_25.HW3.dto.Vote;
import by.it_academy.jd2.Mk_JD2_111_25.HW3.service.VoteService;
import by.it_academy.jd2.Mk_JD2_111_25.HW3.service.api.IVoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Arrays;

@WebServlet(urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {

    private final IVoteService service = new VoteService();

    private final String[] artists = new String[]{"Korpiklaani", "Валентина Легкоступова", "Кирилл Сочный",
            "Красная Плесень", "Пророк Санбой"};
    private final String[] genres = new String[]{"Post-punk", "Heavy metal", "Retrowave", "Italo disco", "Chanson"};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("artistsList", artists);
        req.setAttribute("genresList", genres);

        req.getRequestDispatcher("template/voteform.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String[] artists = req.getParameterValues("artist");
        String[] genres = req.getParameterValues("genre");
        String about = req.getParameter("about");

        if (artists == null || genres == null || genres.length < 3 || about.trim() == "") {
            PrintWriter writer = resp.getWriter();
            writer.write("<table border = '0' cellpadding = '5' width = '300'>");
            writer.write("<p><span style='color: red; font-size: 22px;'>Ошибка!</span></p>");
            writer.write("<tr><td>Не все поля заполнены</td></tr>");
            writer.write("<tr><td>Либо выбрано менее трёх жанров!</td></tr>");
            writer.write("<tr><td><button onclick=\"history.back()\">Вернуться</button></td></tr>");
            writer.write("</table>");
        } else {
            Vote result = new Vote();
            result.setDtCreate(LocalDateTime.now());
            result.setArtist(artists[0]);
            result.setGenres(Arrays.asList(genres));
            result.setAbout(about);
            try {
                service.add(result);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            resp.sendRedirect(req.getContextPath() + "/result");
        }
    }
}

