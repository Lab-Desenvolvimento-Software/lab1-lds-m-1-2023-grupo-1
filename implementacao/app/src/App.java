import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.SecureDirectoryStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.Aluno;
import business.CrudMateria;
import business.CrudProfessor;
import business.Curso;
import business.Materia;
import business.Professor;
import business.Secretaria;
import business.Usuario;

public class App {
    public static void main(String[] args) throws IOException {

        iniciarArquivoUsuarios();
        List<Usuario> usuarios = getAll();

        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNome());
        }
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        Usuario usuarioLogado = null;
        boolean menuLogin = true;
        boolean menuUsuario = false;
        boolean menuCadastroSecretaria = true;
        boolean menuSecretaria = true;

        while (menuLogin) {
            System.out.println("Bem-vindo ao sistema de login e registro. Por favor, escolha uma opção:");
            System.out.println("1. Fazer login");
            System.out.println("2. Registrar");

            int escolhaMenu1 = scanner.nextInt();

            if (escolhaMenu1 == 1) {
                System.out.println("Insira seu nome de usuário:");
                String nome = scanner.next();
                System.out.println("Insira sua senha:");
                String senha = scanner.next();

                // BUSCAR CLIENTE NO ARQUIVO DE USUÁRIOS;
                boolean loginAtivo = false;
                for (Usuario usuario : usuarios) {
                    if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                        loginAtivo = true;
                        usuarioLogado = usuario;
                    }

                }
                // VALIDAR LOGIN
                if (loginAtivo == true) {

                    menuLogin = false;
                    menuUsuario = true;
                    System.out.println("");
                    System.out.println("Usuário encontrado!");
                    System.out.println("");
                } else {
                    System.out.println("");
                    System.out.println("Usuário não encontrado!");
                    System.out.println("");
                }
            } else if (escolhaMenu1 == 2) {
                System.out.println("Insira um nome de usuário para registrar:");
                String nome = scanner.next();
                System.out.println("Insira uma senha para o usuário:");
                String senha = scanner.next();

                // CADASTRAR NOVA;
                Secretaria novaSecretaria = new Secretaria(nome, senha);
                addUsuario(novaSecretaria);
                usuarios.add(novaSecretaria);
                System.out.println("\nSecretária registrada com sucesso!\n");
                while(menuSecretaria){
                    System.out.println("\nEscolha uma opção:");
                    System.out.println("1. Cadastrar Aluno/Professor");
                    System.out.println("2. Cadastrar Matéria");
                    System.out.println("2. Alterar");
                    System.out.println("3. Excluir");
                    System.out.println("4. Gerar Currículo");
                    int escolhaMenu3 = scanner.nextInt();
                    if(escolhaMenu3 == 1){
                        while(menuCadastroSecretaria){
                            menuSecretaria = false;
                            System.out.println("\nEscolha uma opção de usuário:");
                            System.out.println("1. Professor");
                            System.out.println("2. Aluno");
                            int escolhaMenu2 = scanner.nextInt();
                            if(escolhaMenu2 == 1){
                                menuCadastroSecretaria = false;
                                System.out.println("Digite o nome do professor:");
                                String nomeProfessor = scanner.next();
                                System.out.println("Digite a senha do professor:");
                                String senhaProfessor = scanner.next();
                                Professor professor = new Professor(nomeProfessor, senhaProfessor);
                                usuarios.add(professor);
                                novaSecretaria.criar(professor);
                                System.out.println("\nProfessor criado com sucesso!");
                            }
                            if(escolhaMenu2 == 2){
                                menuCadastroSecretaria = false;
                                System.out.println("Digite o nome do aluno:");
                                String nomeAluno = scanner.next();
                                System.out.println("Digite a senha do aluno:");
                                String senhaAluno = scanner.next();
                                Aluno aluno = new Aluno(nomeAluno, senhaAluno, null);
                                usuarios.add(aluno);
                                novaSecretaria.criar(aluno);
                                System.out.println("\nAluno criado com sucesso!");
                            }
                        }
                    }
                    if(escolhaMenu3==2){
                        boolean menuCadastroMateriaSecretaria = true;
                        while(menuCadastroMateriaSecretaria){
                            menuSecretaria = false;
                            System.out.println("\nDigite o nome da matéria:");
                            String nomeMateria = scanner.next();
                            System.out.println("\nDigite o preço da matéria:");
                            double precoMateria = scanner.nextDouble();
                            System.out.println("A matéria é obrigatória:");
                            System.out.println("       1. Sim");
                            System.out.println("       2. Não");
                            int escolhaObrigatoria = scanner.nextInt();
                            if(escolhaObrigatoria == 1){
                                Materia materia = new Materia(nomeMateria, precoMateria, true, true);
                                novaSecretaria.criar(materia);
                                System.out.println("Matéria adicionada com sucesso!");
                            }
                            if(escolhaObrigatoria == 2){
                                Materia materia = new Materia(nomeMateria, precoMateria, true, false);
                                novaSecretaria.criar(materia);
                                System.out.println("Matéria adicionada com sucesso!");
                            }
                        }
                    }
                }


            } else
                System.out.println("Opção inválida. Tente novamente.");
        }
        // PERSISTIR MENU DO USUÁRIO COM OS RESPECTIVOS DADOS;

        System.out.println(
                "Bem-vindo, " + usuarioLogado.getNome() + "!" + " || Tipo de conta: " + tipoUsuario(usuarioLogado)
                        + "");

        if (tipoUsuario(usuarioLogado) == "Secretária") {
            while (menuUsuario == true) {
                System.out.println("");
                System.out.println("");
                System.out.println("secretária..");
                menuUsuario = false;
            }
        }

        if (tipoUsuario(usuarioLogado) == "Aluno") {
            while (menuUsuario == true) {
                System.out.println("");
                System.out.println("");
                System.out.println("aluno..");
                menuUsuario = false;
            }
        }
        if (tipoUsuario(usuarioLogado) == "Professor") {
            while (menuUsuario == true) {
                boolean menuProfessor = true;
                while(menuProfessor){
                    System.out.println("Escolha uma opção:");
                    System.out.println("1. Ver Turma:");
                    int escolhaMenuProfessor = scanner.nextInt();
                    if(escolhaMenuProfessor == 1){
                        menuProfessor = false;
                        System.out.println("Digite o nome da matéria:");
                        String escolhaMateria = scanner.next();
                        Professor professor = new Professor("", "");
                        List<Aluno> lista = professor.getTurma(escolhaMateria);
                        try{
                            for(Aluno aluno: lista){
                                System.out.println(aluno.getNome());
                            }
                        } catch(Exception e){
                            System.out.println("Não existe uma turma com esse nome!");
                        }
                    }
                }
                menuUsuario = false;
            }
        } else {
            System.out.println("Tipo de conta indefinido");
            System.out.println("");
            menuUsuario = false;
            menuLogin = true;

        }

    }

    public void funcoesSecretaria(Secretaria secretaria){

    }

    private static File file;
    private static FileOutputStream fos;
    private static ObjectOutputStream outputFile;

    public static void iniciarArquivoUsuarios() throws IOException {
        file = new File("implementacao/app/src/arquivos/usuarios.txt.bin");
        if (!file.exists()) {
            fos = new FileOutputStream(file, false);
            outputFile = new ObjectOutputStream(fos);
        }
    }

    public static void addUsuario(Usuario usuario) {
        try (FileOutputStream fos = new FileOutputStream(file, true);
                ObjectOutputStream outputFile = new ObjectOutputStream(fos)) {
            outputFile.writeObject(usuario);
        } catch (IOException e) {
            System.out.println("ERRO ao gravar o usuário '" + usuario.getNome() + "' no disco!");
            e.printStackTrace();
        }
    }

    public static Usuario getUsuario(String id) throws IOException {
        Usuario usuario = null;

        try (FileInputStream fis = new FileInputStream(file);
                ObjectInputStream inputFile = new ObjectInputStream(fis)) {
            while (fis.available() > 0) {
                usuario = (Usuario) inputFile.readObject();

                if (id.equals(usuario.getNome())) {
                    return usuario;
                }
            }
        } catch (Exception e) {
            System.out.println("ERRO ao ler o produto de ID " + id + " no disco!");
            e.printStackTrace();
        }
        return null;
    }

    public static List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario usuario = null;
        try (FileInputStream fis = new FileInputStream(file);
                ObjectInputStream inputFile = new ObjectInputStream(fis)) {

            while (fis.available() > 0) {
                usuario = (Usuario) inputFile.readObject();
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("ERRO ao gravar usuários no disco!");
            e.printStackTrace();
        }
        return usuarios;
    }

    public static String tipoUsuario(Usuario usuario) {
        if (usuario instanceof Secretaria) {
            return "Secretária";
        } else if (usuario instanceof Aluno) {
            return "Usuário";
        } else if (usuario instanceof Professor) {
            return "Professor";
        } else {
            return "Tipo nao encontrado!";
        }
    }

}
