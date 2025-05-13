    package pe.edu.upc.free_mind.securities;

    import java.io.Serializable;

    public class JwtRequest implements Serializable {
        private static final long serialVersionUID = 5926468583005150707L;
        private String correo;
        private String contrasena;
        public JwtRequest() {
            super();
            // TODO Auto-generated constructor stub
        }
        public JwtRequest(String correo, String contrasena) {
            super();
            this.correo = correo;
            this.contrasena = contrasena;
        }
        public static long getSerialversionuid() {
            return serialVersionUID;
        }
        public String getCorreo() {
            return correo;
        }
        public String getContrasena() {
            return contrasena;
        }
        public void setCorreo(String correo) {
            this.correo = correo;
        }
        public void setContrasena(String contrasena) { this.contrasena = contrasena;
        }
    }