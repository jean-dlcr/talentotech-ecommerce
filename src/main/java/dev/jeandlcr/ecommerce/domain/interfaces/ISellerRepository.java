package dev.jeandlcr.ecommerce.domain.interfaces;

import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.Seller;

public interface ISellerRepository {
    void add(Seller seller);
    Seller getSellerById(int sellerId);
    List<Seller> getAll();
    Seller getSellerByDocument(String document);
}
