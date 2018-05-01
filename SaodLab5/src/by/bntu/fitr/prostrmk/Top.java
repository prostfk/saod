package by.bntu.fitr.prostrmk;

public class Top {

    private String label;
    private boolean isVisited;

    public Top(String label) {
        this.label = label;
        this.isVisited = false;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }


}
