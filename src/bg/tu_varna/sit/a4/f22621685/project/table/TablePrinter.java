package bg.tu_varna.sit.a4.f22621685.project.table;

public class TablePrinter {

    public static void printTable(Table table){
        int numRows = table.getColumns().get(0).getCells().size();

        // Отпечатване на данните вертикално
        for (int i = 0; i < numRows; i++) {
            for (Column column : table.getColumns()) {
                System.out.print(column.getCells().get(i).getData() + "\t|\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
