package br.com.school.educanet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.school.educanet.model.TbUser;
import br.com.school.educanet.repository.UserCourseRepository;
import br.com.school.educanet.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserCourseRepository userCourseRepository;
	
	 public TbUser saveUser(TbUser tbUser) {
	        TbUser existingUser = userRepository.findByEmail(tbUser.getEmail());
	        TbUser existingCpf = userRepository.findByUserCpf(tbUser.getUserCpf());
	        String checkCharacters = tbUser.getUserCpf();
	        if (existingUser != null) {
	            throw new RuntimeException("E-mail já cadastrado!");
	        } 
	        else if(existingCpf != null) {
	        	throw new RuntimeException("CPF já cadastrado!");
	        }
	        else if (checkCharacters.length()> 11 || checkCharacters.length()< 11 ) {
	        	throw new RuntimeException("Quantidade de digitos do CPF invalida!");
			}
	        else {
	            return userRepository.save(tbUser);
	        }
	    }
	
	 
	 public String deleteUserById(Long id) {
	        Optional<TbUser> existingUser = userRepository.findById(id);
	        if (existingUser != null) {
				if (userCourseRepository.searchingById(id) != null) {
					userCourseRepository.deleteById(userCourseRepository.searchingById(id));
					userRepository.deleteById(id);
					return ("Usuário excluído com sucesso!Todos registros em cursos foram apagados");
				}
				userRepository.deleteById(id);
				return ("Usuário excluido com sucesso!");
			}
			throw new RuntimeException ("Usuário não encontrado!");
	 }

}

