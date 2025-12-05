package ai.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.ineuron.entity.StockPrice;
import ai.ineuron.exception.StockNotFoundException;
import ai.ineuron.repository.StockRepositry;

@Service(value ="service")
public class StockPriceServiceImpl implements IStockPriceService {
	
	@Autowired
	private StockRepositry repo;
	
	@Override
	public Double findByCompanyName(String companyName) {
		
		StockPrice stockPrice = repo.findByCompanyName(companyName);
		if (stockPrice==null) 
			throw new StockNotFoundException("Stock not Available...");
		
		return stockPrice.getStockPrice();
	}
}

