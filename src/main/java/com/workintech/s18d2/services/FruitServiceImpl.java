package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public Fruit getById(long id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException("Plant with given id is not exist: " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Fruit save(Fruit fruit) {

        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(long id) {
        Fruit fruit=getById(id);
        fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}
