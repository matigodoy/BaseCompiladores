package compiladores;

public class Visitor extends compiladoresBaseVisitor<String> {
    private Integer assignments = 0;

    @Override
    public String visitPrograma(compiladoresParser.ProgramaContext ctx) {
        String returnValue = super.visitPrograma(ctx);
        System.out.println("Cantidad de asignaciones: " + assignments);
        return returnValue;
    }

    @Override
    public String visitAsignacion(compiladoresParser.AsignacionContext ctx) {
        assignments++;
        System.out.println("Soy una hoja y tengo " + ctx.getChildCount() + " hijos");
        System.out.println("    -> asignando valor a " + ctx.getChild(0).getText());
        return super.visitAsignacion(ctx);
    }
}