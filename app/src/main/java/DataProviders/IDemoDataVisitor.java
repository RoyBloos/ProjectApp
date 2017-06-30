package DataProviders;

public interface IDemoDataVisitor {
    void visit(NotitieDataProvider provider);
    void visit(ToDoDataProvider provider);
}

