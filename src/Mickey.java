
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.*;


public class Mickey extends Frame implements ActionListener, MouseListener
{
    //window size
    static final int windowWidth = 800;
    static final int windowHeight = 800;
    //initial coordinate and size of the rectangular
    int x = 250;
    int y = 300;
    int dx = 300;
    int dy = 300;

    //flags for controlling actions
    boolean clicked=false;
    boolean bigger=false;
    boolean smaller=false;
    boolean defau=false;

    Mickey() //default constructor
    {
        //clicked = false;

        setTitle("Mickey");
        //https://way2java.com/awt-components/java-awt-menu-%E2%80%93-multiple-pull-down-lists/
        MenuBar menu_bar = new MenuBar();

        Menu def = new Menu("File");
        def.add(new MenuItem("Set Default"));
        def.addActionListener(this);
        menu_bar.add(def);
        setMenuBar(menu_bar);

        //https://www.javatpoint.com/java-awt-panel
        Panel panel=new Panel();
        panel.setBounds(0,60,windowWidth,40);


        //Adding buttons with action listener
        Button button_s = new Button();
        button_s.setLabel("Smaller"); //first button
        button_s.addActionListener(this);
        Button button_b = new Button();
        button_b.addActionListener(this);
        button_b.setLabel("Bigger"); //second button

        //adding panels
        panel.add(button_s);
        panel.add(button_b);

        //color of the panel
        panel.setBackground(Color.black);
        add(panel);
        setLayout(null); //setting layout
        addWindowListener(new MyFinishWindow()); //window listener to end program when window closed.
        addMouseListener(this); //mouse listener for capturing the mouse location
        setBackground(Color.red); //setting background color as red

    }

    //end program when window is closed.
    public class MyFinishWindow extends WindowAdapter
    {

        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }

    //paint function to draw and paint the rectangular shape
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (smaller||bigger||defau||clicked) {
            // draw rectangular if the user press button called "smaller, bigger or default or user clicks on screen"
            drawRect(g2d, x,y, 20);
        }
        else {
            drawRect(g2d, x, y, 20);  // set the initial rectangular on centre with the pre-defined values.
        }

    }

    // draw and fill the colors for the rectangular shape
    private void drawRect(Graphics2D g2d, int x, int y, int r) {
        g2d.setColor(Color.black);
        g2d.fill3DRect(x, y, dx, dy,true); // x-y coordinates with the width and height values

    }


    //According to ActionEvent Handler perform operations (clicking buttons or selecting menu item)
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        String str = arg0.getActionCommand();
        //System.out.println(str);
        if(str.equals("Set Default")) {  //Set Default option gives the initial values and repaints the rectangular
            System.out.println("Defaults.");
            defau=true;
            x=250;
            y=300;
            dx=300;
            dy=300;
            repaint();

        }
        else if(str.equals("Smaller")) { //Smaller option makes the shape 0.5 times smaller than previous size

            smaller=true; // flag will be true
            this.dx=this.dx/2;
            this.dy=this.dy/2;
            repaint();


        }
        else if(str.equals("Bigger")) { //Bigger option makes the shape two times bigger than previous size

            bigger=true;// flag will be true
            this.dx=this.dx*2;
            this.dy=this.dy*2;
            repaint();
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) { //Check if the mouse is clicked

        if(e.getButton()!=e.NOBUTTON) { //if any buttons clicked,
            clicked =  true; //set the flag true
            x = e.getX(); //print x and y values
            y = e.getY();

        }
        repaint();

    }
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    public static void main(String[] args) {

        Mickey f = new Mickey(); // Instance of the Mickey class
        f.setSize(windowWidth, windowHeight); //set the window size
        f.setVisible(true);// Make the vindow visible.



    }
}

