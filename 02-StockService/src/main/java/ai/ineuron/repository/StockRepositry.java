package ai.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ai.ineuron.entity.StockPrice;

public interface StockRepositry extends JpaRepository<StockPrice, Integer> {

	public StockPrice findByCompanyName(String companyName);
}
