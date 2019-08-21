package br.com.treinaweb.springboot.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.springboot.entidades.PecasEstoque;

public interface RepositorioEstoque extends JpaRepository<PecasEstoque, Long> {

}
