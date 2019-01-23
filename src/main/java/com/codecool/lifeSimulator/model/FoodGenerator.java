package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.view.PlanetRender;

public class FoodGenerator extends Thread{
    private Planet planet;
    private PlanetRender render;

    public FoodGenerator(Planet planet, PlanetRender render) {
        this.planet = planet;
        this.render = render;
        setName("FoodGenerator");
    }


    @Override
    public void run() {
        while (true) {
            try {
                planet.generateFoodOnRandomPosition(render);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
