package dev.jeandlcr.ecommerce.domain.repositories.inmemory;

import java.util.ArrayList;
import java.util.List;

import dev.jeandlcr.ecommerce.domain.interfaces.IBrandRepository;
import dev.jeandlcr.ecommerce.domain.models.Brand;

public class InMemoryBrandRepository implements IBrandRepository {

    private static final List<Brand> brands = new ArrayList<>();
    private static int IDENTITY = 0;

    public void seed() {
        brands.add(new Brand(this.getNextId(), "WATTS0", "Watts", "Marca asociada a jugos y bebidas", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LASILA", "Laive Sin Lactosa", "Productos libres de lactosa", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LAIVIO", "Laive Vio", "Bebidas vegetales", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "BAZVEL", "Bazo Velarde", "Línea de embutidos", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "SUIZA0", "Suiza", "Línea de quesos", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LAIVE0", "Laive", "Marca general de lácteos y derivados", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LAYOPI", "Laive Yopi", "Yogures bebibles", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LANUTR", "Laive Nutrilac", "Leches fortificadas", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LAIGRG", "Laive Griego", "Yogures estilo griego", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LAPREF", "La Preferida", "Productos clásicos", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LAISBL", "Laive Sbelt", "Línea saludable", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LAISWS", "Laive Swiss", "Quesos premium", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LADELI", "Laive Deliavena", "Bebidas con avena", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LAIMUU", "Laive Muuushake", "Bebidas tipo malteada", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LAIBDF", "Laive Biodefensa", "Línea probiótica", true, null, null, null, null));
        brands.add(new Brand(this.getNextId(), "LAIPRT", "Laive Protein", "Línea proteica", true, null, null, null, null));
    }

    @Override
    public void add(Brand brand) {
        if (brand == null) {
            throw new IllegalArgumentException("La marca no puede ser nula.");
        }
        if (brand.getId() == 0) {
            brand.setId(getNextId());
        }
        brands.add(brand);
    }

    private int getMaxId() {
    int max_ = 0;
        for (Brand b : brands) {
            if (b.getId() > max_) {
                max_ = b.getId();
            }
        }
        return max_;
    }

    private int getNextId() {
        if (IDENTITY == 0 && !brands.isEmpty()) {
            IDENTITY = getMaxId();
        }
        return ++IDENTITY;
    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }

    public Brand getBrandById(int id) {
        for (Brand b : brands) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    @Override
    public Brand getBrandByCode(String code) {
        for (Brand b : brands) {
            if (b.getCode().equals(code)) {
                return b;
            }
        }
        return null;
    }

    // public List<Brand> getBrandsByName(String name) {
    //     List<Brand> results = new ArrayList<>();
    //     for (Brand b : brands) {
    //         if (b.getName().toLowerCase().contains(name.toLowerCase())) {
    //             results.add(b);
    //         }
    //     }
    //     return results;
    // }
}
