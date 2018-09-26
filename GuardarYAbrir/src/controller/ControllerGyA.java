package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import model.ModelGyA;
import view.ViewGyA;

public class ControllerGyA implements ActionListener
{
    private final ModelGyA modelGyA;
    private final ViewGyA viewGyA;

    public ControllerGyA(ViewGyA viewGyA, ModelGyA modelGyA)    
    {
        this.viewGyA = viewGyA;
        this.modelGyA = modelGyA;
        viewGyA.jmi_abrir.addActionListener(this);
        viewGyA.jmi_guardar.addActionListener(this);
        initView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewGyA.jmi_abrir){
            JFileChooser file=new JFileChooser(); //Crea el objeto para el filechooser
            file.showOpenDialog(null); //Carga la ventana de dialogo y encuentra la ruta donde almacenamos el archivo 
            modelGyA.setPath(""+file.getSelectedFile()); //obtiene la ruta del archivo y la pasa al modelo
            modelGyA.readFile(modelGyA.getPath()); //abre el archivo obteniendo la ruta desde el modelo
            viewGyA.jta_txt.setText(modelGyA.getMessage()); //muestra el contenido en el JTextArea
        }else if(e.getSource()==viewGyA.jmi_guardar){
            JFileChooser file=new JFileChooser(); 
            file.showSaveDialog(null);
            modelGyA.setPath(""+file.getSelectedFile());
            modelGyA.setMessage(viewGyA.jta_txt.getText());
            modelGyA.writeFile(modelGyA.getPath(), modelGyA.getMessage());
        }
    }
    private void initView() 
    {
        viewGyA.setTitle("Archivo!");
        viewGyA.setResizable(false);
        viewGyA.setLocationRelativeTo(null);
        viewGyA.setVisible(true);
    }
}