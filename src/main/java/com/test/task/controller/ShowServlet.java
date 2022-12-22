package com.test.task.controller;

import com.test.task.model.DiscountCard;
import com.test.task.model.Product;
import com.test.task.service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/Show")
public class ShowServlet extends HttpServlet {
    private final ProductService<Product> productService = new ProductServiceImpl();
    private final CartService<Product> cartService = new CartServiceImpl();

    private final DiscountCardService<DiscountCard> discountCardService = new DiscountCardServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> productListAfterChoose = new ArrayList<>();

        request.setCharacterEncoding("UTF-8");

        String[] req = request.getParameterValues("id");

        checkValidChoose(request, response, req);

        List<Integer> idLists = Arrays.stream(req).map(Integer::parseInt)
                .collect(Collectors.toList());


        int card =Integer.parseInt(request.getParameter("card"));


         checkValidCard(request, response, requestToService(card));


        for (Integer id : idLists) {

            Product productByIdFromDb = productService.getProductByIdFromDb(id);
            productListAfterChoose.add(productByIdFromDb);

        }

            request.setAttribute("product", cartService.createCart(productListAfterChoose));

            getServletContext().getRequestDispatcher("/show-cart.jsp").forward(request, response);


    }

    private boolean requestToService(int card) {

        return discountCardService.giveAccessToDiscountCardRepository()
                .stream().map(DiscountCard::getIdCard)
                .anyMatch(e -> e.equals(card));
    }

    private void checkValidChoose(HttpServletRequest request, HttpServletResponse response, String[] req)
            throws ServletException, IOException {
        if (req ==null) {
            getServletContext().getRequestDispatcher("/invalidChoose.jsp").forward(request, response);
        }
    }

    private void checkValidCard(HttpServletRequest request, HttpServletResponse response, boolean anyMatch)
            throws ServletException, IOException {
        if (!anyMatch){
            getServletContext().getRequestDispatcher("/invalidCard.jsp").forward(request, response);
        }
    }
}
