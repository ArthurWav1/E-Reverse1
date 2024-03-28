package Ereverse.servlet;
import Ereverse.bean.articles.Article;
import Ereverse.dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/Article"})
public class PageArticleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
        getServletContext().getRequestDispatcher("/jsp/PageArticle.jsp").forward(request,response);
    }
}

