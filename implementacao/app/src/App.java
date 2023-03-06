import java.util.List;
import java.util.Scanner;

import business.Aluno;
import business.Curso;
import business.Professor;
import business.Secretária;

public class App {
    public static void main(String[] args) throws Exception {
        List<Aluno> lista;

        


        Curso curso = new Curso("Eng soft", 10);
        
        Secretária secretaria = new Secretária("Ana","123",123);
        
        Aluno teste = new Aluno("Paulo", "123", curso);
        Aluno teste1 = new Aluno("Lucas", "123", curso);
        Aluno teste2 = new Aluno("Carlos", "123", curso);
        Aluno teste3 = new Aluno("Joao", "123", curso);
        
        Professor pteste1= new Professor("Jorge", "123");
        Professor pteste2= new Professor("Paula", "123");
        
        secretaria.criar(teste1);
        secretaria.criar(teste2);
        secretaria.criar(teste3);
        
        secretaria.criar(pteste1);
        secretaria.criar(pteste2);
        
        secretaria.getAllUsers().stream().forEach((selecionado) -> System.out.println(selecionado.toString()));
        
        
        

    }
}
