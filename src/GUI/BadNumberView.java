package GUI;
import Model.BadNumberOfTreasures;
public class BadNumberView extends javax.swing.JPanel {

  private BadNumberOfTreasures badModel;
  
  public BadNumberView() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jL_text = new javax.swing.JLabel();
    jL_niveles = new javax.swing.JLabel();
    jL_showlevels = new javax.swing.JLabel();
    jL_visibles = new javax.swing.JLabel();
    jL_showvisibles = new javax.swing.JLabel();
    jL_hidden = new javax.swing.JLabel();
    jL_showhidden = new javax.swing.JLabel();

    jL_text.setText("/*Texto*/");

    jL_niveles.setText("Niveles:");

    jL_showlevels.setText("/*Lv*/");

    jL_visibles.setText("Visibles:");

    jL_showvisibles.setText("/*Vis*/");

    jL_hidden.setText("Ocultos:");

    jL_showhidden.setText("/*Ocl*/");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jL_text)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jL_niveles)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jL_showlevels)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jL_visibles)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jL_showvisibles)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jL_hidden)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jL_showhidden)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jL_text)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jL_niveles)
          .addComponent(jL_showlevels)
          .addComponent(jL_visibles)
          .addComponent(jL_showvisibles)
          .addComponent(jL_hidden)
          .addComponent(jL_showhidden))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  public void setBC(BadNumberOfTreasures bad) {
		this.badModel = bad;
		this.jL_text.setText(bad.getText());
		this.jL_showlevels.setText(Integer.toString(bad.getLevels()));
		this.jL_showvisibles.setText(Integer.toString(bad.getNVisibleTreasures()));
		this.jL_showhidden.setText(Integer.toString(bad.getNHiddenTreasures()));
		repaint();
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jL_hidden;
  private javax.swing.JLabel jL_niveles;
  private javax.swing.JLabel jL_showhidden;
  private javax.swing.JLabel jL_showlevels;
  private javax.swing.JLabel jL_showvisibles;
  private javax.swing.JLabel jL_text;
  private javax.swing.JLabel jL_visibles;
  // End of variables declaration//GEN-END:variables
}
