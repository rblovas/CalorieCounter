package program.dao.api;

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

import program.model.FoodEntity;

import java.util.List;

/**
 * Ételek DAO függvényeit tartalmazó interfész.
 */
public interface FoodDAO {

    /**
     * Egy étel entitás lekérését teszi lehetővé, nevének megadása által.
     * @param foodName - lekérdezni kívánt étel neve.
     * @return - étel entitás.
     */
    FoodEntity getFood(String foodName);

    /**
     * Lekéri az ételeket tartalmazó adatbázisból az összes entitást.
     * @return étel entitás.
     */
    List<FoodEntity> getAllFood();

    void persist(FoodEntity entity);
}
