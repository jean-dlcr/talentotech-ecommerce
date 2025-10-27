package dev.jeandlcr.ecommerce.domain.repositories.inmemory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.jeandlcr.ecommerce.domain.interfaces.IEmployeeRepository;
import dev.jeandlcr.ecommerce.domain.models.Employee;

public class InMemoryEmployeeRepository implements IEmployeeRepository {
    
    private final List<Employee> employees = new ArrayList<>();
    private static int IDENTITY = 0;

    public void seed() {
        if (!employees.isEmpty()) return;
        this.add(new Employee(this.getNextId(), "89707883", "Ana", "López", "Sánchez", "a.lopez.s@laive.com", "anita.lopez23@gmail.com", "51977221593", "78 Schlimgen Trail", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "71480341", "Carlos", "Gómez", "Martínez", "c.gomez.m@laive.com", "carlo.gmz89@gmail.com", "51923416274", "004 Washington Street", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "65215125", "Valentina", "Torres", "Ramírez", "v.torres.r@laive.com", "valen.torres07@gmail.com", "51919127252", "99409 Duke Pass", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "61586693", "Diego", "Martínez", "Pérez", "d.martinez.p@laive.com", "dieguito.mtz21@gmail.com", "5197776938", "59 Nelson Park", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "79116403", "Camila", "Ramírez", "López", "c.ramirez.l@laive.com", "cami.ramz88@gmail.com", "51983584407", "01 Novick Street", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "78175966", "Sebastián", "Rojas", "Castillo", "s.rojas.c@laive.com", "sebas.rojas10@gmail.com", "51976835985", "8136 Cambridge Street", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "68327719", "Mariana", "Fernández", "Quiroz", "m.fernandez.q@laive.com", "marianita.fdz33@gmail.com", "51903420814", "146 Crest Line Hill", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "75777879", "Matías", "Castro", "Vásquez", "m.castro.v@laive.com", "mati.castro77@gmail.com", "51915570689", "552 Lerdahl Place", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "71721512", "Isabela", "Morales", "Téllez", "i.morales.t@laive.com", "isa.mora22@gmail.com", "51987465520", "7 Corben Terrace", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "73282526", "Nicolás", "Álvarez", "Muñoz", "n.alvarez.m@laive.com", "nico.alvz99@gmail.com", "51948108055", "44 Melrose Lane", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "88721033", "Sofía", "González", "Salas", "s.gonzalez.s@laive.com", "sofi.gonza15@gmail.com", "51941229918", "0284 Texas Crossing", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "84022604", "Alejandro", "Pérez", "Rodríguez", "a.perez.r@laive.com", "ale.pz123@gmail.com", "51985722674", "4 Macpherson Trail", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "88857404", "Luciana", "García", "León", "l.garcia.l@laive.com", "luci.garcia08@gmail.com", "51993601910", "50176 Cascade Lane", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "81162090", "Fernando", "Navarro", "Cruz", "f.navarro.c@laive.com", "fer.navo90@gmail.com", "51984483635", "4 Stang Way", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "81486370", "Paula", "Rodríguez", "Morales", "p.rodriguez.m@laive.com", "pau.rodrigz17@gmail.com", "51942782237", "6681 Eliot Way", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "80914841", "Ricardo", "Sánchez", "Paredes", "r.sanchez.p@laive.com", "ricky.sancho44@gmail.com", "51928671241", "187 Center Plaza", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "85185390", "Daniela", "Ortiz", "Vargas", "d.ortiz.v@laive.com", "dani.ortiz26@gmail.com", "51979991634", "9235 Cherokee Hill", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "69210055", "Andrés", "Flores", "Quiñones", "a.flores.q@laive.com", "andy.flores19@gmail.com", "51910194201", "3051 Merchant Place", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "72699488", "Julieta", "Vera", "Salcedo", "j.vera.s@laive.com", "julie.verita03@gmail.com", "51903320163", "508 Summit Place", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Employee(this.getNextId(), "76321680", "Esteban", "Ramos", "López", "e.ramos.l@laive.com", "estebito.rms55@gmail.com", "51991399249", "1 Elka Pass", LocalDateTime.of(2025, 1, 1, 9, 0, 0), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
    }

    @Override
    public void add(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo.");
        }
        if (employee.getId() == 0) {
            employee.setId(getNextId());
        }
        employees.add(employee);
    }

    private int getMaxId() {
    int max_ = 0;
        for (Employee e : employees) {
            if (e.getId() > max_) {
                max_ = e.getId();
            }
        }
        return max_;
    }

    private int getNextId() {
        if (IDENTITY == 0 && !employees.isEmpty()) {
            IDENTITY = getMaxId();
        }
        return ++IDENTITY;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        for (Employee s : employees) {
            if (s.getId() == employeeId) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Employee getEmployeeByDocument(String document) {
        for (Employee s : employees) {
            if (s.getDocument().equalsIgnoreCase(document)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    public void updateAllListCreatedBy(int createdBy){
        for (Employee emp: employees) {
            emp.setCreatedBy(createdBy);
        }
    }
}
