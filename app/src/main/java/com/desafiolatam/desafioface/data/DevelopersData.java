package com.desafiolatam.desafioface.data;

import com.desafiolatam.desafioface.models.Developer;

import java.util.List;

/**
 * Created by karan_000 on 31-03-2017.
 */

public class DevelopersData {

    public void handler(Developer[] developers){
        for (Developer developer: developers){
            List<Developer> developerList = Developer.find(Developer.class, "serverId = ?", String.valueOf(developer.getId()));

            if (developerList == null || developerList.size() == 0){
                developer.create();
            }
        }
    }

    public List<Developer> developers(){
        return Developer.listAll(Developer.class);
    }
}
