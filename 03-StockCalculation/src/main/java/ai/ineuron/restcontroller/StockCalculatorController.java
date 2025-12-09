package ai.ineuron.restcontroller;

import ai.ineuron.client.IStockClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class StockCalculatorController {

	@Autowired
	private IStockClient client;

	@GetMapping("/calculate/{companyName}/{quantity}")
	public ResponseEntity<?> calculate(@PathVariable String companyName, @PathVariable Integer quantity) {

		ResponseEntity<?> responseEntity = null;
		Double TotalPrice = null;

		try {

			responseEntity = client.getStockPrice(companyName);

			Double statusCode = (double) responseEntity.getStatusCode().value();

			if (statusCode == 200) {

				Double stockPrice = (Double) responseEntity.getBody();
				TotalPrice = stockPrice * quantity;
				String response = "Total Price:: " + TotalPrice;// calculation the Total Price

				responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
			}

		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("company not found", HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
}
