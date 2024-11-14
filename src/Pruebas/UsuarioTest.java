package Pruebas;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import co.edu.andes.sistema.GestorUsuarios;
import co.edu.andes.usuarios.*;

import java.io.File;
import java.util.*;


public class UsuarioTest 
{

	private Usuario usuario;
	private Usuario usuario2;
	private List<String> profesoresRegistrados;
	private GestorUsuarios gestorUsuarios;
	
	@BeforeEach
	public void setUp()
	{
		usuario = new Profesor("Andrea", "A1", "andrea", "Profesor");
		usuario2 = new Estudiante("jd","jdc","111", "Estudiante");
		gestorUsuarios = new GestorUsuarios();
		
				
	}
	
	@Test
	@DisplayName("Registrar Usuario y revisar guardado")
	public void testRegistrarUsuario()
	{
		
        boolean resultado = gestorUsuarios.registrarUsuario(usuario, "Profesor");

        assertTrue(resultado, "No sea ha registrado el usuario");
        if (resultado)
        {
        	String usuarioProfesor = usuario.getNombreUsuario();
        	Usuario resultado2 = gestorUsuarios.obtenerUsuario(usuarioProfesor);
        	assertNotNull(resultado2);
        	assertEquals(usuario.getNombre(), resultado2.getNombre());
            assertEquals(usuario.getNombreUsuario(), resultado2.getNombreUsuario());
        }
	
	}
		
		
	
	@Test
	@DisplayName("Iniciar Sesion")
	public void testIniciarSesion()
	{
		String nUsuario = usuario.getNombreUsuario();
		String clave = usuario.getPassword();
		
		
		String resultado = gestorUsuarios.iniciarSesion(nUsuario, clave);

        assertEquals("Profesor", resultado);
        
        String nUsuario2 = usuario2.getNombreUsuario();
        String clave2 = usuario2.getPassword();
        
        String resultado2 = gestorUsuarios.iniciarSesion(nUsuario2, clave2);
		assertEquals("Estudiante", resultado2);
         
	}
	
	
}
