import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import program.dao.FoodDAOImpl;
import program.model.FoodEntity;
import program.model.WorkoutEntity;
import program.service.FoodServiceImpl;
import program.utility.Manager;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class FoodServiceImplTest {

    private FoodDAOImpl dao = new FoodDAOImpl(Manager.getInstance());
    private FoodServiceImpl foodService = new FoodServiceImpl(dao);

    public static FoodEntity createTestEntity(){
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setId(100L);
        foodEntity.setFoodName("Teszt");
        foodEntity.setKcal(30);
        return foodEntity;
    }

    @BeforeClass
    public static void asd(){
        FoodDAOImpl dao = new FoodDAOImpl(Manager.getInstance());
        FoodServiceImpl foodService = new FoodServiceImpl(dao);
        foodService.createFood(createTestEntity());
    }

    @AfterClass
    public static void after(){
        FoodDAOImpl dao = new FoodDAOImpl(Manager.getInstance());
        FoodServiceImpl foodService = new FoodServiceImpl(dao);
        foodService.deleteFood(foodService.getFood("Teszt"));

    }

    private FoodEntity food = createTestEntity();

    @Test
    public void getFoodTest(){
        FoodEntity resultEntity = foodService.getFood(food.getFoodName());
        assertEquals(food, resultEntity);
    }

    @Test
    public void getAllFoodName(){
        List<String> resultNames = foodService.getAllFoodName();
        assertEquals("-", resultNames.get(0));
        assertEquals(food.getFoodName(), resultNames.get(resultNames.size()-1));
    }


}
