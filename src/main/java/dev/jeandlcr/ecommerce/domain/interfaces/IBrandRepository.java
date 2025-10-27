package dev.jeandlcr.ecommerce.domain.interfaces;

import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.Brand;

public interface IBrandRepository {
    void add(Brand brand);
    List<Brand> getAll();
    Brand getBrandById(int id);
    Brand getBrandByCode(String code);
}
