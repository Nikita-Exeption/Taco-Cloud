package org.Nikita.Taco.Cloud.controller;

import org.Nikita.Taco.Cloud.model.TacoOrder;
import org.Nikita.Taco.Cloud.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final Logger  logger = LoggerFactory.getLogger(OrderController.class);
    private final OrderRepository jdbcOrderRepository;

    @Autowired
    public OrderController(OrderRepository jdbcOrderRepository){
        this.jdbcOrderRepository = jdbcOrderRepository;
    }

    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("tacoOrder", new TacoOrder());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors){
        if (errors.hasErrors()){
            return "orderForm";
        }
        jdbcOrderRepository.save(order);
        return "redirect:/";
    }

}
