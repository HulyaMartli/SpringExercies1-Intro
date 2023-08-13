package org.hulyam.service;

import org.hulyam.repository.ISalesRepository;
import org.hulyam.repository.entity.Sales;
import org.hulyam.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SalesService extends ServiceManager<Sales, Long> {
    private final ISalesRepository salesRepository;

    public SalesService(ISalesRepository salesRepository) {
        super(salesRepository);
        this.salesRepository = salesRepository;
    }
}
