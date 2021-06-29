package com.swufe.javaee.beerV1.model;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    public List<Beer> getBrands(String color) {
        List<Beer> beer = new ArrayList<>();
        if (color.equals("amber")) {
            beer.add(new Beer("茅台酒",1000,52,"贵州",50));
            beer.add(new Beer("汾酒",1200,53,"中国",50));
        } else if (color.equals("light"))
        {
            beer.add(new Beer("泸州老窖",800,54,"四川",50));
            beer.add(new Beer("五粮液",2000,52,"四川",50));
        }else if (color.equals("brown"))
        {
            beer.add(new Beer("五粮液",2000,52,"四川",50));
        }else if (color.equals("dark"))
        {
            beer.add(new Beer("泸州老窖",800,54,"四川",50));
        }
        return(beer);
    }
}
