package teste;

import static org.junit.jupiter.api.Assertions.*;

import business.*;
import org.junit.jupiter.api.*;

class AlunoTest {
    private Aluno alunoTest;
    private Semestre semestreTest;


    @BeforeEach
    void setUp() {
        alunoTest = new Aluno("Marcus", "12345", new Curso("Eng Software", 10000));
    }

    @Test
    void testAttach() {
    }

    @Test
    void testNotifyAllObservers() {
    }

    @Test
    void testCancelarMateria() {
    }

    @Test
    void testMatricular() {

        /*Materia materiaTest = new Materia("AEDs II", 750L, true);s
        assertTrue(alunoTest.matricular(materiaTest), "Matricula nas matérias");*/

        for (int i = 1; i < 10; i++) {

            boolean obrigatorio = i % 3 == 0;

            Materia materiaTest = new Materia(Integer.toString(i + 1000), Integer.toUnsignedLong(i * 150), true, obrigatorio);

            assertTrue(alunoTest.matricular(materiaTest), "Matricula nas matérias");
        }

    }
}