package org.openscience.jchempaint.action;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

import org.openscience.cdk.exception.CDKException;
import org.openscience.jchempaint.JChemPaintPanel;


import static org.openscience.jchempaint.action.CreateSmilesAction.getSmiles;

public class AllDoneAction extends JCPAction{
    public AllDoneAction() {
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String smiles = getSmiles(jcpPanel.getChemModel());
//            System.out.println(smiles);
            FileWriter writer = new FileWriter("smile.txt", false);
            writer.write(smiles);
            writer.flush();
            JChemPaintPanel.closeAllInstances();
        }

        catch (CDKException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }

    }

}
