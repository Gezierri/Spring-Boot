package br.com.treinaweb.springboot.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.springboot.entidades.Instituicao;
import br.com.treinaweb.springboot.repositorio.RepositorioInstituicao;

@Controller
@RequestMapping("/")
public class InstituicaoController {
	
	@Autowired
	private RepositorioInstituicao repositorioInstituicao;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView resultado = new ModelAndView("/instituicao/index");//caminho para pasta instiuicao que contém os HTMLs 
		List<Instituicao> instituicoes = repositorioInstituicao.findAll();
		resultado.addObject("instituicoes", instituicoes);
		return resultado;
	}
	
	@GetMapping("/instituicao/inserir")
	public ModelAndView inserir() {
		ModelAndView resultado = new ModelAndView("/instituicao/inserir");
		resultado.addObject("instituicao", new Instituicao());
		return resultado;
	}
	
	@PostMapping("/instituicao/inserir")
	public String inserir(Instituicao instituicao) {
		repositorioInstituicao.save(instituicao);
		return "redirect:/";
	}
	
	@GetMapping("/instituicao/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Instituicao instituicao = repositorioInstituicao.getOne(id);
		ModelAndView resultado = new ModelAndView("/instituicao/editar");
		resultado.addObject("instituicao", instituicao);
		return resultado;
	}
	
	@PostMapping("/instituicao/editar")
	public String editar(Instituicao instituicao) {
		repositorioInstituicao.save(instituicao);
		return "redirect:/";
	}
	
	@GetMapping("/instituicao/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		repositorioInstituicao.delete(id);
		return "redirect:/instituicao/index";
	}
	
	@GetMapping({"/instituicao/pesquisarPorNome/{nome}", "/instituicao/pesquisarPorNome"})
	public @ResponseBody List<Instituicao> pesquisarPorNome(@PathVariable Optional<String> nome){
		if (nome.isPresent()) {
			return repositorioInstituicao.findByNomeContaining(nome.get());
		}else {
			return repositorioInstituicao.findAll();
		}
	}
}
