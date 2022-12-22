package com.test.task.controller;

import com.test.task.model.Product;
import com.test.task.service.ProductService;
import com.test.task.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/Store")
public class StorePageServlet extends HttpServlet {
    private final ProductService<Product> productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");


        request.setAttribute("product", productService);

        getServletContext().getRequestDispatcher("/store.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> productListAfterChoose = new ArrayList<>();

        String value = request.getParameter("value");

        if(value.equals("Change")){
            getServletContext().getRequestDispatcher("/store.jsp").forward(request, response);
        }



        String[] req = (String[]) request.getAttribute("id");

        List<Integer> idLists = Arrays.stream(req).map(Integer::parseInt)
                .collect(Collectors.toList());

        if (value.equals("Check")) {
            for (Integer id : idLists) {
                Product productByIdFromDb = productService.getProductByIdFromDb(id);
                productListAfterChoose.add(productByIdFromDb);

            }
            request.setAttribute("product", productListAfterChoose);

            getServletContext().getRequestDispatcher("/get-check.jsp").forward(request, response);
        }
    }

}
