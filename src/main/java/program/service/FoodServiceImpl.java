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

import java.util.ArrayList;
import java.util.List;

/**
 * A FoodService implemántálása.
 */
public class FoodServiceImpl implements FoodService {

    private FoodDAOImpl dao;

    /**
     * Az osztály konstruktora.
     * @param dao - {@link FoodDAOImpl} példánya.
     */
    public FoodServiceImpl(FoodDAOImpl dao) {
        this.dao = dao;
    }


    /**
     * Az étel entitás megkapása annak neve alapján.
     * @param foodName - étel neve.
     * @return - étel entitás.
     */
    @Override
    public FoodEntity getFood(String foodName) {
        return dao.getFood(foodName);
    }

    /**
     * Az összes étel neve.
     * @return - az összes étel nevének listája.
     */
    @Override
    public List<String> getAllFoodName() {

        List<String> names = new ArrayList<>();

        List<FoodEntity> entities = new ArrayList<>(dao.getAllFood());

        for (FoodEntity asd : entities) {
            names.add(asd.getFoodName());
        }

        return names;
    }
}
