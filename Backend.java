import javax.swing.SwingUtilities;

public class Backend {
        public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                // Now we will instantiate the RockPaperGui object
                RockPaperGui rockPaperGui = new RockPaperGui();
                // display the Gui
                rockPaperGui.setVisible(true);
            }
        });
    }
}
