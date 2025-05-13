package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findOneByCorreo(String correo);

    @Query("select count(u.correo) from Usuario u where u.correo = :correo")
    public int buscarCorreo(@Param("correo") String correo);


    @Query(value = "SELECT u.nombre, SUM(p.monto)\n" +
            " FROM Usuario u\n" +
            " INNER JOIN Pago p\n" +
            " on u.id_usuario = p.id_usuario\n" +
            " GROUP BY u.nombre\n", nativeQuery = true)
    public List<String[]> amountByUsuario();

    @Query(value = "SELECT u.nombre, COUNT(c.id_comentario)\n" +
            " FROM Usuario u\n" +
            " INNER JOIN Comentario c\n" +
            " on u.id_usuario = c.id_usuario\n" +
            " GROUP BY u.nombre", nativeQuery = true)
    public List<String[]> comentByUsuario();

    @Query(value = "SELECT r.nombre, COUNT(u.id_usuario)\n" +
            " FROM Usuario u\n" +
            " JOIN Rol r" +
            " ON u.id_rol = r.id_rol\n" +
            " GROUP BY r.nombre;\n", nativeQuery = true)
    public List<String[]> cantidadUsuario();
}