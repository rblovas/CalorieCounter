package program.service;

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
import program.dao.FoodDAOImpl;
import program.model.FoodEntity;
import program.service.api.FoodService;
import program.utility.Manager;

import java.util.List;

public class FoodServiceImpl implements FoodService {

    private FoodDAOImpl dao;

    public FoodServiceImpl(FoodDAOImpl dao) {
        this.dao = dao;
    }


    @Override
    public FoodEntity getFood(String foodName) {
        return dao.getFood(foodName);
    }

    @Override
    public void createFood(FoodEntity foodEntity) {
        dao.persist(foodEntity);
    }

    public void uploadFoods(List<String> foods, List<Integer> calories) {
        FoodService foodService = new FoodServiceImpl(new FoodDAOImpl(Manager.getInstance()));
        FoodEntity foodEntity = new FoodEntity();

        foodEntity.setFoodName("tej");
        foodEntity.setKcal(440);
        foodService.createFood(foodEntity);
        foods.add(foodEntity.getFoodName());
        calories.add(foodEntity.getKcal());

        foodEntity.setFoodName("főtt tojás");
        foodEntity.setKcal(82);
        foodService.createFood(foodEntity);
        foods.add(foodEntity.getFoodName());
        calories.add(foodEntity.getKcal());

        foodEntity.setFoodName("cukor");
        foodEntity.setKcal(4000);
        foodService.createFood(foodEntity);
        foods.add(foodEntity.getFoodName());
        calories.add(foodEntity.getKcal());

        foodEntity.setFoodName("liszt");
        foodEntity.setKcal(3370);
        foodService.createFood(foodEntity);
        foods.add(foodEntity.getFoodName());
        calories.add(foodEntity.getKcal());


        foodEntity.setFoodName("alma");
        foodEntity.setKcal(78);
        foodService.createFood(foodEntity);
        foods.add(foodEntity.getFoodName());
        calories.add(foodEntity.getKcal());


        foodEntity.setFoodName("talicska");
        foodEntity.setKcal(5000);
        foodService.createFood(foodEntity);
        foods.add(foodEntity.getFoodName());
        calories.add(foodEntity.getKcal());

        foodEntity.setFoodName("-");
        foodEntity.setKcal(0);
        foodService.createFood(foodEntity);
        foods.add(foodEntity.getFoodName());
        calories.add(foodEntity.getKcal());


    }
}
