package web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAOImpl;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private static final Logger logger = (Logger) LogManager.getLogger(CarsController.class);

    private final CarDAOImpl carDAO;

    @Autowired
    public CarsController(CarDAOImpl carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping()
    public String index(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count != null) {
            logger.debug("Request parameter 'count' is present: {}", count);
            model.addAttribute("car", carDAO.show(count));
            return "some";
        } else {
            logger.debug("Request parameter 'count' is not present");
            model.addAttribute("cars", carDAO.index());
            return "all";
        }
    }
}
