/*-
 * #%L
 * KaloriaSzamolo
 * %%
 * Copyright (C) 2018 University of Debrecen
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
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
