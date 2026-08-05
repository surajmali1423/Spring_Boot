package in.striker.SpringFilters.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LogginhFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;


        long StartTime = System.currentTimeMillis();

        String requestId = UUID.randomUUID().toString();
        httpServletResponse.setHeader("x-RequestId" , requestId);

        System.out.println("Incoming Request Method : "+ httpServletRequest.getMethod()
                +" And URL Is :"+httpServletRequest.getRequestURI() +" ."
        );

        try {
            System.out.println("Loggin Running...");
            chain.doFilter(request ,response);
        }
        finally {

            long endTime = System.currentTimeMillis() - StartTime;
            System.out.println("Responce : "+ httpServletResponse.getStatus());
            System.out.println("API Responce Time : "+endTime);
        }
    }
}
