package br.com.fiap.fiapcap3calorieCalculator.repository;

import br.com.fiap.fiapcap3calorieCalculator.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
