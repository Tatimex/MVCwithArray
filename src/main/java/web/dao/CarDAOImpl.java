package web.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarDAOImpl implements CarDAO {
    private static final Logger logger = (Logger) LogManager.getLogger(CarDAOImpl.class);

    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(1L, "GAZ", 2000));
        cars.add(new Car(2L, "UAZ", 2014));
        cars.add(new Car(3L, "Volga", 1995));
        cars.add(new Car(4L, "Lada", 2020));
        cars.add(new Car(5L, "VAZ", 2021));
    }

    @Override
    public List<Car> index() {
        logger.debug("Returning list of all cars");
        return cars;
    }

    @Override
    public List<Car> show(int count) {
        logger.debug("Returning list of cars with count: {}", count);
        return count > 0 && count < cars.size() ? cars.subList(0, count) : cars;
    }
}
