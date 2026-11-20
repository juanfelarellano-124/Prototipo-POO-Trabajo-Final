/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package Vista;

import Modelo.Empleado;
import Modelo.PersonaNatural;
import Modelo.Proyecto;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsaProyectoTest {

    private UsaProyecto instance;

    @Before
    public void setUp() {
        instance = new UsaProyecto();
    }

    // Metodo auxiliar para crear proyectos de prueba
    private Proyecto crearProyecto(String codigo, String titulo,
            String estado) {

        return new Proyecto(
                codigo,
                titulo,
                LocalDate.of(2026, 1, 10),
                "meses",
                (byte) 3,
                null,
                null,
                new ArrayList<Empleado>(),
                estado
        );
    }

    @Test
    public void testGenerarCodigoProyecto() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = LocalDate.now().getYear() + "-001";

        String result = instance.generarCodigoProyecto(datos);

        assertEquals(expResult, result);
    }

    @Test
    public void testGenerarCodigoProyectoConsecutivo() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        datos.add(crearProyecto(
                LocalDate.now().getYear() + "-001",
                "Proyecto anterior",
                "FINALIZADO"
        ));

        String expResult = LocalDate.now().getYear() + "-002";

        String result = instance.generarCodigoProyecto(datos);

        assertEquals(expResult, result);
    }

    @Test
    public void testMostrarProyecto() {

        Proyecto p = crearProyecto(
                "2026-001",
                "Sistema de gestion",
                "EN CURSO"
        );

        String expResult =
                "Código: 2026-001\n"
                + "Título: Sistema de gestion\n"
                + "Fecha inicio: 2026-01-10\n"
                + "Duración: 3 meses\n"
                + "Fecha finalización: 2026-04-10\n"
                + "Estado: EN CURSO\n"
                + "Cliente: null\n"
                + "Gerente: null\n"
                + "Equipo: []\n"
                + "----------------------------------------\n";

        String result = instance.mostrarProyecto(p);

        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarTodosProyectos() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.consultarTodosProyectos(datos);

        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarTodosProyectosConDatos() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        datos.add(crearProyecto(
                "2026-001",
                "Sistema de gestion",
                "EN CURSO"
        ));

        String result = instance.consultarTodosProyectos(datos);

        assertTrue(result.contains("2026-001"));
        assertTrue(result.contains("Sistema de gestion"));
    }

    @Test
    public void testConsultarProyectosEnCurso() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.consultarProyectosEnCurso(datos);

        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarProyectosEnCursoConDatos() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        datos.add(crearProyecto(
                "2026-001",
                "Proyecto activo",
                "EN CURSO"
        ));

        datos.add(crearProyecto(
                "2026-002",
                "Proyecto finalizado",
                "FINALIZADO"
        ));

        String result = instance.consultarProyectosEnCurso(datos);

        assertTrue(result.contains("2026-001"));
        assertFalse(result.contains("2026-002"));
    }

    @Test
    public void testConsultarPrimerProyecto() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.consultarPrimerProyecto(datos);

        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarUltimoProyecto() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.consultarUltimoProyecto(datos);

        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarProyectoDadoCodigo() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.consultarProyectoDadoCodigo(
                datos, "2026-001"
        );

        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarGerenteProyectoDadoCodigo() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.consultarGerenteProyectoDadoCodigo(
                datos, "2026-001"
        );

        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarEquipoProyectoDadoCodigo() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.consultarEquipoProyectoDadoCodigo(
                datos, "2026-001"
        );

        assertEquals(expResult, result);
    }

    @Test
    public void testRegistrarIntegranteProyectoDadoCodigo() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.registrarIntegranteProyectoDadoCodigo(
                datos, "2026-001"
        );

        assertEquals(expResult, result);
    }

    @Test
    public void testRegistrarEquipoProyectoDadoCodigo() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.registrarEquipoProyectoDadoCodigo(
                datos, "2026-001"
        );

        assertEquals(expResult, result);
    }

    @Test
    public void testActualizarEstadoProyectoDadoCodigo() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.actualizarEstadoProyectoDadoCodigo(
                datos, "2026-001"
        );

        assertEquals(expResult, result);
    }

    @Test
    public void testEliminarIntegranteProyectoDadoCodigo() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.eliminarIntegranteProyectoDadoCodigo(
                datos, "2026-001"
        );

        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarProyectosDadoNumIDEGerente() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.consultarProyectosDadoNumIDEGerente(
                datos, "123456789"
        );

        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarProyectosDadoNumIDECliente() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.consultarProyectosDadoNumIDECliente(
                datos, "123456789"
        );

        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarProyectosDadoTipoCliente() {

        ArrayList<Proyecto> datos = new ArrayList<>();

        String expResult = "La lista de proyectos está vacía.";

        String result = instance.consultarProyectosDadoTipoCliente(
                datos, "PersonaNatural"
        );

        assertEquals(expResult, result);
    }
}