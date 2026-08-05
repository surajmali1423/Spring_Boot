package in.striker.SpringFilters.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class AuthanticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        System.out.println("Incoming Request Method : "
                + httpServletRequest.getMethod()
                + " And URL Is : "
                + httpServletRequest.getRequestURI());

        String token = httpServletRequest.getHeader("token");
        String apiKey = httpServletRequest.getHeader("X-API-KEY");

        // Validate Token
        if (token == null || !token.equals("12345")) {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write("""
                {
                  "message":"Invalid or Missing Token"
                }
                """);
            return;
        }

        // Validate API Key
        if (apiKey == null || !apiKey.equals("key123")) {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write("""
                {
                  "message":"Invalid or Missing API Key"
                }
                """);
            return;
        }

        System.out.println("Authentication Running...");
        // Continue only if authentication succeeds
        chain.doFilter(request, response);

        System.out.println("Response Status : " + httpServletResponse.getStatus());
    }
}