package Interface;

import Domain.Maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class lienzo extends javax.swing.JPanel implements Runnable {

    int[][] matrizGeneral;
    Maze maze;


    public lienzo() {
        initComponents();
        this.maze = new Maze(matrizGeneral);
        facil();
        medium();
        dificult();
    }

    Thread threadSmart;
    //threadFast, threadItem,
    

    BufferedImage personaje, puerta_salida, muro, dona, popeye;
    URL pers = getClass().getResource("/imagenes/Stitch.png");
    URL mu = getClass().getResource("/imagenes/muroo.jpg");
    URL door = getClass().getResource("/imagenes/puerta.png");
    URL don = getClass().getResource("/imagenes/donaHomero.png");
    URL popeyeurl = getClass().getResource("/imagenes/Popeye.png");
    public void medium() {
        maze.setFilas(16);
        maze.setColumnas(16);
        maze.setS(15);
        maze.setE(3);
        maze.setFil_entrada(3);
        maze.setCol_entrada(0);
        maze.setFilasalida(14);
        maze.setColumnaSalida(15);
        maze.setX(0);
        maze.setY(0);
        maze.setTermino(0);
        maze.setDona(9);
        maze.setSmart(6);

        int[][] copia = 
        {{0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0},
        {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1},
        {1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1},
        {0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1},
        {1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0},
        {maze.getSmart(), 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0},
        {1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0},
        {1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0},
        {0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0},
        {1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, maze.getS()},
        {1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0}};

        try {
            personaje = ImageIO.read(pers);
            puerta_salida = ImageIO.read(door);
            muro = ImageIO.read(mu);
            dona=ImageIO.read(don);
            popeye = ImageIO.read(popeyeurl);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen " + e.getMessage());

        }
        matrizGeneral = copia;
        //threadFast = new Thread(this);
        //threadItem = new Thread(this);
        threadSmart = new Thread(this); 
        maze.setFil_entrada(3);
        maze.setCol_entrada(0);
        maze.setFilasalida(14);
        maze.setColumnaSalida(15);
        maze.setF(1);
        maze.setTermino(0);
        repaint();
    }

    public void facil() {
        maze.setFilas(13);
        maze.setColumnas(13);
        maze.setS(4);
        maze.setE(13);
        maze.setFil_entrada(12);
        maze.setCol_entrada(0);
        maze.setFilasalida(4);
        maze.setColumnaSalida(12);
        maze.setX(0);
        maze.setY(0);
        maze.setTermino(0);
        int[][] copia = 
           {{1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, maze.getS()},
            {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
  {maze.getE(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
        try {
            personaje = ImageIO.read(pers);
            puerta_salida = ImageIO.read(door);
            muro = ImageIO.read(mu);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen " + e.getMessage());

        }
        matrizGeneral = copia;
       // threadFast = new Thread(this);

        maze.setFil_entrada(12);
        maze.setCol_entrada(0);
        maze.setFilasalida(4);
        maze.setColumnaSalida(12);
        maze.setF(1);
        maze.setTermino(0);

        repaint();
    }

    public void dificult() {
        maze.setFilas(19);
        maze.setColumnas(19);
        maze.setS1(4);
        maze.setS(4); //
        maze.setE(3); // 
        maze.setE1(3);
        maze.setFil_entrada1(3);
        maze.setFil_entrada(0); //
        maze.setCol_entrada(3); //
        maze.setCol_entrada1(15);
        maze.setFilasalida(1); //
        maze.setFilasalida1(14);
        maze.setColumnaSalida1(0);
        maze.setColumnaSalida(18); //
        maze.setX(0);
        maze.setY(0);
        maze.setTermino(0);

        int[][] copia = 
       {{0, 0, 0, maze.getE(), 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1,1},
        {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, maze.getS()},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0},
        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0},
        {1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0},
        {1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0},
        {1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0},
        {maze.getE(), 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
        {0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
        {0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0},
        {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0},
        {1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0},
        {1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, maze.getS()},
        {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
        {1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}};


        try {
            personaje = ImageIO.read(pers);
            puerta_salida = ImageIO.read(door);
            muro = ImageIO.read(mu);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen " + e.getMessage());

        }
        matrizGeneral = copia;
//        threadFast = new Thread(this);
        maze.setFil_entrada(0); //
        maze.setFil_entrada1(3);
        maze.setCol_entrada1(15); 
        maze.setCol_entrada(3);  //
        maze.setFilasalida(1);  //
        maze.setFilasalida1(14);
        maze.setColumnaSalida(18);  //
        maze.setColumnaSalida1(0);
       
        
        
        maze.setF(1);
        maze.setTermino(0);
        
        repaint();
    }

//    public void aleatorio() {
//        for (int i = 0; i < matrizGeneral.length; i++) {
//            for (int j = 0; j < matrizGeneral.length; j++) {
//                int dato = (int) (Math.random() * 1.99);
//                if (i == maze.getFil_entrada() && j == maze.getCol_entrada()) {
//                    matrizGeneral[i][j] = maze.getE();
//
//                } else if (i == maze.getFilasalida() && j == maze.getFilasalida()) {
//                    matrizGeneral[i][j] = maze.getS();
//                } else {
//                    matrizGeneral[i][j] = dato;
//                }
//            }
//
//        }
//        int k = maze.getFil_entrada(), l = maze.getCol_entrada();
//        while (k < maze.getFilasalida() || l < maze.getColumnaSalisa()) {
//            int camino = (int) (Math.random() * 1.99);
//            if (camino == 0 && maze.getColumnaSalisa() > 1) {
//                matrizGeneral[k][++l] = 0;
//
//            } else if (maze.getFilasalida() > k) {
//                matrizGeneral[++k][l] = 0;
//
//            } else {
//                matrizGeneral[k][++l] = 0;
//            }
//        }
//        matrizGeneral[maze.getFilasalida()][maze.getColumnaSalisa()] = maze.getS();
//        repaint();
//
//    }

    public void paint(Graphics g) {
        if (maze.getF() >= 1) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
            for (int i = 0; i < matrizGeneral.length; i++) {
                for (int j = 0; j < matrizGeneral.length; j++) {
                    g.setColor(Color.DARK_GRAY);
                    if (matrizGeneral[i][j] == 0 || matrizGeneral[i][j] == 8) {
                        g.drawRect(j * 35, i * 35, 35, 35); // tama;o del rectangulo, modificar

                    } else if (matrizGeneral[i][j] == 1) {
                        g.drawImage(muro, j * 35, i * 35, 35, 35, this);
                    }else if (matrizGeneral[i][j] == 9) {
                        g.drawImage(dona, j * 35, i * 35, 35, 35, this);
                    }else if (matrizGeneral[i][j] == maze.getSmart()) {
                        g.drawImage(popeye, j * 35, i * 35, 35, 35, this);
                    } else if (matrizGeneral[i][j] == maze.getE()) {
                        g.drawImage(personaje, j * 35, i * 35, 35, 35, this);
                    } else if (matrizGeneral[i][j] == maze.getE1()) {
                        g.drawImage(personaje, j * 35, i * 35, 35, 35, this);
                    } else if (matrizGeneral[i][j] == maze.getS()) {
                        g.drawImage(puerta_salida, j * 35, i * 35, 35, 35, this);
                    } else if (matrizGeneral[i][j] == maze.getS1()) {
                        g.drawImage(puerta_salida, j * 35, i * 35, 35, 35, this);
                    } else if (matrizGeneral[i][j] == 5) {
                        g.setColor(Color.yellow);
                        g.fillRect(j * 35, i * 35, 35, 35);
                        g.setColor(Color.BLUE);
                        g.drawRect(j * 35, i * 35, 35, 35);
                    }
                }
            }
        }
    }

    public boolean existeCamino(int fila, int columna) {
        if (fila < 0 || fila >= maze.getFilas() || columna < 0 || columna >= maze.getColumnas()) {
            return false;
        }
        if (matrizGeneral[fila][columna] == 5 || matrizGeneral[fila][columna] == 1) {
            return false;
        }
        return true;
    }
    
//    public boolean existeCaminoItem(int fila, int columna) {
//        if (fila < 0 || fila >= maze.getFilas() || columna < 0 || columna >= maze.getColumnas()) {
//            return false;
//
//        }
//        if (matrizGeneral[fila][columna] == 1) {
//            return false;
//        }
//        return true;
//    }

    public boolean resolver(int fil, int col) {
        boolean salida = false;

        try {
            threadSmart.sleep(250);

        } catch (Exception e) {

        }
        matrizGeneral[fil][col] = 5;
        if (fil == maze.getFilasalida() && col == maze.getColumnaSalisa()) {
            return true;
        }
        //abajo
        if (!salida && existeCamino(fil + 1, col)) {
            matrizGeneral[fil + 1][col] = maze.getSmart();
            repaint();
            salida = resolver(fil + 1, col);
        }
        //derecha
        if (!salida && existeCamino(fil, col + 1)) {
            matrizGeneral[fil][col + 1] = maze.getSmart();
            repaint();
            salida = resolver(fil, col + 1);
        }
        //izquierda
        if (!salida && existeCamino(fil, col - 1)) {
            matrizGeneral[fil][col - 1] = maze.getSmart();
            repaint();
            salida = resolver(fil, col - 1);
        }
        //arriba

        if (!salida && existeCamino(fil - 1, col)) {
            matrizGeneral[fil - 1][col] = maze.getSmart();
            repaint();
            salida = resolver(fil - 1, col);
        }
        return salida;
    }
    
//    public boolean item(int col, int fil){
//         boolean salida = false;
//
//        try {
//            threadItem.sleep(250);
//
//        } catch (Exception e) {
//
//        }
//        matrizGeneral[fil][col] = 5;
//        if (fil == maze.getFilasalida() && col == maze.getColumnaSalisa()) {
//            return true;
//        }
//        //abajo
//        if (!salida && existeCaminoItem(fil + 1, col)) {
//            matrizGeneral[fil + 1][col] = maze.getSmart();
//            repaint();
//            salida = item(fil + 1, col);
//        }
//        //derecha
//        if (!salida && existeCaminoItem(fil, col + 1)) {
//            matrizGeneral[fil][col + 1] = maze.getSmart();
//            repaint();
//            salida = item(fil, col + 1);
//        }
//        //izquierda
//        if (!salida && existeCaminoItem(fil, col - 1)) {
//            matrizGeneral[fil][col - 1] = maze.getSmart();
//            repaint();
//            salida = item(fil, col - 1);
//        }
//        //arriba
//
//        if (!salida && existeCaminoItem(fil - 1, col)) {
//            matrizGeneral[fil - 1][col] = maze.getE();
//            repaint();
//            salida = item(fil - 1, col);
//
//        }
//        return salida;
//    }
//    
    
//     public boolean smart(int col, int fil){
//        boolean salida = false;
//
//        try {
//            threadSmart.sleep(250);
//
//        } catch (Exception e) {
//
//        }
//        matrizGeneral[fil][col] = 5;
//        if (fil == maze.getFilasalida() && col == maze.getColumnaSalisa()) {
//            return true;
//        }
//        //abajo
//        if (!salida && existeCamino(fil + 1, col)) {
//            matrizGeneral[fil + 1][col] = maze.getSmart();
//            repaint();
//            salida = smart(fil + 1, col);
//        }
//        //derecha
//        if (!salida && existeCamino(fil, col + 1)) {
//            matrizGeneral[fil][col + 1] = maze.getSmart();
//            repaint();
//            salida = smart(fil, col + 1);
//        }
//        //izquierda
//        if (!salida && existeCamino(fil, col - 1)) {
//            matrizGeneral[fil][col - 1] = maze.getSmart();
//            repaint();
//            salida = smart(fil, col - 1);
//        }
//        //arriba
//        if (!salida && existeCamino(fil - 1, col)) {
//            matrizGeneral[fil - 1][col] = maze.getSmart();
//            repaint();
//            salida = smart(fil - 1, col);
//
//        }
//        return salida;
//    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1237, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 901, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        maze.setX(evt.getX() / 35);
        maze.setY(evt.getY() / 35);

        if (matrizGeneral[maze.getY()][maze.getX()] != maze.getE() && matrizGeneral[maze.getY()][maze.getX()] != maze.getS() && maze.getF() == 1) {
            if (evt.getButton() == evt.BUTTON1 && maze.getRadioBotones() == 3) {
                matrizGeneral[maze.getY()][maze.getX()] = 1;

            } else if (evt.getButton() == evt.BUTTON3 && maze.getRadioBotones() == 3) {
                matrizGeneral[maze.getY()][maze.getX()] = 0;

            } else if (evt.getButton() == evt.BUTTON1 && maze.getRadioBotones() == 1) {
                matrizGeneral[maze.getFil_entrada()][maze.getCol_entrada()] = 0;
                matrizGeneral[maze.getY()][maze.getX()] = maze.getE();
                maze.setFil_entrada(maze.getY());
                maze.setCol_entrada(maze.getX());

            } else if (evt.getButton() == evt.BUTTON1 && maze.getRadioBotones() == 2) {
                matrizGeneral[maze.getFilasalida()][maze.getColumnaSalisa()] = 0;
                matrizGeneral[maze.getY()][maze.getX()] = maze.getS();
                maze.setFilasalida(maze.getY());
                maze.setColumnaSalida(maze.getX());

            }
            repaint();
        }

    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        maze.setX(evt.getX() / 35);
        maze.setY(evt.getY() / 35);

        if (matrizGeneral[maze.getY()][maze.getX()] != maze.getE() && matrizGeneral[maze.getY()][maze.getX()] != maze.getS()) {
            if (evt.getButton() == evt.BUTTON1 ) {
                matrizGeneral[maze.getY()][maze.getX()] = 1;

            } else if (evt.getButton() == evt.BUTTON3 ) {
                matrizGeneral[maze.getY()][maze.getX()] = 0;

            }
            repaint();
        }
    }//GEN-LAST:event_formMousePressed

    @Override
    public void run() {

//        if (resolver(maze.getFil_entrada(), maze.getCol_entrada())) {
//            maze.setTermino(1);
//            JOptionPane.showMessageDialog(null, "Felicidades, lo lograste");
//        } else {
//            maze.setTermino(1);
//            JOptionPane.showMessageDialog(null, "No hay salida");
//        }
//        
//        if(item(maze.getFil_entrada(), maze.getCol_entrada())){
//         maze.setTermino(1);
//            //JOptionPane.showMessageDialog(null, "Felicidades, lo lograste");
//        } else {
//            maze.setTermino(1);
//           // JOptionPane.showMessageDialog(null, "No hay salida");
//        }
//        
        if(resolver(7, 0)){
            maze.setTermino(1);
        }else{
            maze.setTermino(1);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
