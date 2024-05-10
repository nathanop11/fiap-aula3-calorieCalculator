package br.com.fiap.fiapcap3calorieCalculator.repository;

import br.com.fiap.fiapcap3calorieCalculator.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByEmail(String email);

}
