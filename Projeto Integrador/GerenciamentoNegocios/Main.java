import javax.swing.SwingUtilities;
import Telas.TelaInicial;

public class Main {
    public static void main(String[] args) {
        // Inicia a aplicação gráfica com a TelaInicial
        SwingUtilities.invokeLater(() -> new TelaInicial().setVisible(true));
    }
}