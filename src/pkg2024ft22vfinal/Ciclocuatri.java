
package pkg2024ft22vfinal;

/**
 *
 * @author aleja
 */
class Ciclocuatri {
    private int id;
    private int idciclo;
    private String nombreciclo;
    private int idcuatri;
    private String nombrecuatri;
    
    Ciclocuatri(int id, int idciclo, String nombreciclo, int idcuatri, String nombrecuatri ){
        this.id = id;
        this.idciclo = idciclo;
        this.nombreciclo = nombreciclo;
        this.idcuatri = idcuatri;
        this.nombrecuatri = nombrecuatri;
    }

    Ciclocuatri(String nombreciclo, String nombrecuatri) {
        this.nombreciclo = nombreciclo;
        this.nombrecuatri= nombrecuatri;
         }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdciclo() {
        return idciclo;
    }

    public void setIdciclo(int idciclo) {
        this.idciclo = idciclo;
    }

    public String getNombreciclo() {
        return nombreciclo;
    }

    public void setNombreciclo(String nombreciclo) {
        this.nombreciclo = nombreciclo;
    }

    public int getIdcuatri() {
        return idcuatri;
    }

    public void setIdcuatri(int idcuatri) {
        this.idcuatri = idcuatri;
    }

    public String getNombrecuatri() {
        return nombrecuatri;
    }

    public void setNombrecuatri(String nombrecuatri) {
        this.nombrecuatri = nombrecuatri;
    }
}
