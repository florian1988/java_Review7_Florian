public class Classes {

    private int idClass;
    private String nameClasses;

    Classes(int id, String name){
        this.idClass =  id;
        this.nameClasses = name;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getNameClasses() {
        return nameClasses;
    }

    public void setNameClasses(String nameClasses) {
        this.nameClasses = nameClasses;
    }
}
