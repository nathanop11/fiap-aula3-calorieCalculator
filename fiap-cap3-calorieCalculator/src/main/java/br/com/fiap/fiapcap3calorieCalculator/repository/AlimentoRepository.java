package br.com.fiap.fiapcap3calorieCalculator.repository;

import br.com.fiap.fiapcap3calorieCalculator.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
}
