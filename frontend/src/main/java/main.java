import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/teste")
public class main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String mensagem = "Olá! Essa mensagem veio do Java no servidor!";
        int numero = 42;

        PrintWriter out = response.getWriter();
        String json = "{\"mensagem\": \"" + mensagem + "\", \"numero\": " + numero + ", \"timestamp\": " + System.currentTimeMillis() + "}";
        out.print(json);
        out.flush();
    }
}