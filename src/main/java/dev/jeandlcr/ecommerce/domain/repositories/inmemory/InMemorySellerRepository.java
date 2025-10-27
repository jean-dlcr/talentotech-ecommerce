package dev.jeandlcr.ecommerce.domain.repositories.inmemory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.jeandlcr.ecommerce.domain.interfaces.ISellerRepository;
import dev.jeandlcr.ecommerce.domain.models.Employee;
import dev.jeandlcr.ecommerce.domain.models.Seller;

public class InMemorySellerRepository implements ISellerRepository{

    private final List<Seller> sellers = new ArrayList<>();
    private final InMemoryEmployeeRepository employeeRepository;
    private static int IDENTITY = 0;

    private static final String[] SELLER_DNIS = {"68327719", "78175966", "73282526", "88721033", "65215125", "80914841", "76321680", "81162090", "84022604", "88857404", "71721512", "72699488", "71480341", "75777879", "81486370"};

    public InMemorySellerRepository(InMemoryEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void seed() {
        if (!sellers.isEmpty()) return;

        String sellerCode = "";
        for (Employee employee : employeeRepository.getAll()) {
            if (!isSeller(employee)) continue;
            sellerCode = String.format("VND%03d", employee.getId());
            this.add(new Seller(this.getNextId(), employee, sellerCode, "L001", 0.1f, true, LocalDateTime.of(2025,1,1,9,0,0), null, null, null));
        }
    }

    @Override
    public void add(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("El vendedor no puede ser nulo.");
        }
        if (seller.getId() == 0) {
            seller.setId(getNextId());
        }
        sellers.add(seller);
    }

    private int getMaxId() {
    int max_ = 0;
        for (Seller s : sellers) {
            if (s.getId() > max_) {
                max_ = s.getId();
            }
        }
        return max_;
    }

    private int getNextId() {
        if (IDENTITY == 0 && !sellers.isEmpty()) {
            IDENTITY = getMaxId();
        }
        return ++IDENTITY;
    }

    @Override
    public Seller getSellerById(int sellerId) {
        for (Seller s : sellers) {
            if (s.getId() == sellerId) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Seller> getAll() {
        return sellers;
    }

    @Override
    public Seller getSellerByDocument(String document) {
        for (Seller s : sellers) {
            if (s.getEmployeeData().getDocument().equalsIgnoreCase(document)) {
                return s;
            }
        }
        return null;
    }

    private boolean isSeller(Employee e){
        for (String document: SELLER_DNIS){
            if(e.getDocument().equalsIgnoreCase(document)) return true;
        }
        return false;
    }

    public void updateAllListCreatedBy(int createdBy){
        for (Seller s: sellers) {
            s.setCreatedBy(createdBy);
        }
    }
}
