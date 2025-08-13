package com.hcl.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hcl.entity.Trader;
import com.hcl.exception.UserAlreadyExists;
import com.hcl.repository.TraderRepository;

@Service
public class TraderService {
	private final TraderRepository traderRepository;

	public TraderService(TraderRepository traderRepository) {
		this.traderRepository = traderRepository;
	}

	public List<Trader> getAll() {
		return traderRepository.findAll();
	}

	public Trader getById(Long id) {
		return traderRepository.findById(id).get();
	}

	public Trader createTrader(Trader trader) {
		boolean exists = traderRepository.existsByEmail(trader.getEmail());
		if (exists) {
			throw new UserAlreadyExists(trader.getEmail());
		}
		return traderRepository.save(trader);
	}

	public Trader getByEmail(String email) {

		return traderRepository.findByEmail(email);
	}

	public Trader updateTrader(Trader upTrader) {
		return traderRepository.save(upTrader);
	}
}