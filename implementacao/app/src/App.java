import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.nio.file.SecureDirectoryStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.Aluno;
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
                System.out.println("Usuário registrado com sucesso!");

            } else
                System.out.println("Opção inválida. Tente novamente.");
        }
        // PERSISTIR MENU DO USUÁRIO COM OS RESPECTIVOS DADOS;

        while (menuUsuario == true) {
            System.out.println(
                    "Bem-vindo, " + usuarioLogado.getNome() + "!" + " || Tipo de conta: " + tipoUsuario(usuarioLogado)
                            + "");

            if (tipoUsuario(usuarioLogado) == "Secretária") {
                System.out.println("");
                System.out.println("");
                System.out.println("OK");
            }

            if (tipoUsuario(usuarioLogado) == "Aluno") {
                System.out.println("");
                System.out.println("");
                System.out.println("OK");
            }
            if (tipoUsuario(usuarioLogado) == "Professor") {
                System.out.println("");
                System.out.println("");
                System.out.println("OK");
            } else {
                System.out.println("Tipo de conta indefinido");
            }

        }

    }

    private static File file;
    private static FileOutputStream fos;
    private static ObjectOutputStream outputFile;

    public static void iniciarArquivoUsuarios() throws IOException {
        file = new File("lab1-lds-m-1-2023-grupo-1/implementacao/app/src/arquivos/usuarios.txt.bin");
        if (!file.exists()) {
            fos = new FileOutputStream(file, false);
            outputFile = new ObjectOutputStream(fos);
        }
    }

    public static void addUsuario(Usuario usuario) {
        try {
            outputFile.writeObject(usuario);

        } catch (Exception e) {
            System.out.println("ERRO ao gravar o usuário '" + usuario.getNome() + "' no disco!");
            e.printStackTrace();
        }
    }

    public static Usuario getUsuario(String id) {
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
