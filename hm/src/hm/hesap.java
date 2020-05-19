
package hm;
import javax.swing.JToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class hesap extends javax.swing.JFrame
{
   
    final int boy=9,en=9, noOfBomba=10;
    JToggleButton[][] bloklar=new JToggleButton[boy][en];
    int [][] blox=new int[boy][en];
    boolean ilk,oynanabilir;
    
    ActionListener listen=new ActionListener()
    {
        
        public void actionPerformed(ActionEvent e)
        {
           //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int i=0,j=0;
        boolean bulmak=false;
            for (i= 0; i < boy; i++)
            {
                
                for (j = 0; j < en; j++)
                {
                    if (e.getSource()==bloklar[i][j])
                    {
                       bulmak=true;
                       break;
                    }
                }
                if (bulmak)
                    break;
               
            }
            if(oynanabilir){
            bloklar[i][j].setSelected(true);
            if (!ilk)
            {
                oCikar(i,j);
                ilk=true;
            }
            if(blox[i][j]!=-1)
            {
                Open(i, j);
                reval();
            }
            else
                lose();
            kazananKontrol();
            }
           
            else
                reval();
        }
    };
    private void kazananKontrol()
    {
        boolean kazandi=true;
        
        for (int i= 0; i < boy; i++)
            {
                
                for (int j = 0; j < en; j++)
                {
                    if(blox[i][j]==0)
                    {
                        kazandi=false;
                        break;
                    }
                }
                if(!kazandi)
                    break;
            }
        if (kazandi) 
        {
            javax.swing.JOptionPane.showMessageDialog(null,"KAZANDINIZ!!!");
            oynanabilir=false;
        }
        
        
    }
    private void lose()
    {
        oynanabilir=false;
        for (int i= 0; i < boy; i++)
            {
                
                for (int j = 0; j < en; j++)
                {
                    if (blox[i][j]==-1) 
                    {
                     bloklar[i][j].setText("BOOM!!");
                     bloklar[i][j].setSelected(true);
                    }
                }
            }
                
    }
    private void Open(int y,int x)
    {
        if(y<0 || x<0 || x> en-1 || y>boy-1 || blox[y][x]!=0 )
            return;
        int bomba=0;
        
        for (int i = y-1; i <= y+1; i++)
        {
            for (int j = x-1; j <= x+1; j++)
            {
                if (!(j<0 || i<0 || j> en-1 || i>boy-1) && blox[i][j]==-1)
                {
                 bomba++;
                }
                
            }   
        }
            
            if (bomba==0) 
            {
                blox[y][x]=-2;
                
                for(int i = y-1; i <= y+1; i++)
                {
                    for (int j = x-1; j <= x+1; j++)
                   {
                        if (!(j<0 || i<0 || j> en-1 || i>boy-1))
                       if(i!=y || j!=x)
                           Open(i, j);
                   }
                }
            }
            else
                blox[y][x]=bomba;
        }
    
    private void reval()
    {
          for (int i= 0; i < boy; i++)
            {
                
                for (int j = 0; j < en; j++)
                {
                    if(blox[i][j]==0)
                    {
                       bloklar[i][j].setText("");
                       bloklar[i][j].setSelected(false);
                    }
                    if(blox[i][j]==-2)
                    {
                       bloklar[i][j].setText("");
                       bloklar[i][j].setSelected(true);
                    }
                    if (blox[i][j]>0) 
                    {
                        bloklar[i][j].setText(""+blox[i][j]);
                        bloklar[i][j].setSelected(true);
                    }
                    if(!oynanabilir && blox[i][j]==-1)
                        bloklar[i][j].setSelected(true);
                }
            }
          jPanel1.repaint();
    }
            
    
    private void oCikar(int y,int x)
    {
        for (int k = 1; k <= noOfBomba; k++)
        {
            int i,j;
           
            do
            {
                i=(int)(Math.random()*(en-.01));
                j=(int)(Math.random()*(boy-.01));
            }
        while(blox[i][j]== -1 || (i==y && j==x));
        blox[i][j]=-1;
        //bloklar[i][j].setText("boom");
        }
    }
    public hesap() 
    {
        initComponents();
     /*
    -2 ise açılır ama boba yok    
    -1 ise bomba var diyecez
    0 açık değil
    1-8 arası ise bomba sayısı
    */
        for (int i = 0; i < boy; i++) 
        {
            for (int j = 0; j < en; j++) 
            {
                 bloklar[i][j]=new JToggleButton();
                 bloklar[i][j].setSize(jPanel1.getWidth()/en,jPanel1.getHeight()/boy);
                 jPanel1.add( bloklar[i][j]);
                 bloklar[i][j].setLocation(j*jPanel1.getWidth()/en,i*jPanel1.getHeight()/boy );
                 bloklar[i][j].addActionListener(listen);
            }   
        }
     ilk=false;
     oynanabilir=true;
    }
    private void boyutlandirma()
    {
         for (int i = 0; i < boy; i++) 
        {
            for (int j = 0; j < en; j++) 
            {
                 
                 bloklar[i][j].setSize(jPanel1.getWidth()/en,jPanel1.getHeight()/boy);
                 jPanel1.add( bloklar[i][j]);
                 bloklar[i][j].setLocation(j*jPanel1.getWidth()/en,i*jPanel1.getHeight()/boy );
            }   
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        jMenu1.setText("Game");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem1.setText("Yeni Oyun    F2");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
      boyutlandirma();
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        blox=new int[en][boy];
        reval();
        oynanabilir=true;
        ilk=false;
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hesap().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
