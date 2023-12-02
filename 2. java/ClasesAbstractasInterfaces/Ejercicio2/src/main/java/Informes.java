public class Informes {
    private long text;
    private long pages;
    private String autor;
    private String revisor;

    @Override
    public String toString() {
        return "Informes{" +
                "text=" + text +
                ", pages=" + pages +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
