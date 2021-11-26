import javax.swing.*;
import java.awt.* ;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener{

    private Drawing draw = new Drawing();

    public Window(String Title,int x,int y)
    {
        super(Title);
        this.setSize(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane() ;

        JMenuBar m= new JMenuBar();

        JMenu menu1= new JMenu("File");
        JMenuItem open = new JMenuItem("Open") ;
        menu1.add(open);
        open.addActionListener(this);
        JMenuItem newItem = new JMenuItem("New") ;
        menu1.add(newItem);
        newItem.addActionListener(this);
        JMenuItem save = new JMenuItem("Save") ;
        menu1.add(save);
        save.addActionListener(this);
        JMenuItem exit = new JMenuItem("Exit") ;
        exit.addActionListener(this);
        menu1.add(exit);

        m.add(menu1);
        JMenu menu2 = new JMenu("About");
        JMenuItem authorsMenu = new JMenuItem("Authors");
        menu2.add(authorsMenu);
        authorsMenu.addActionListener(this);
        m.add(menu2);
        setJMenuBar(m);

        String ColorName[] ={"Black", "Red",
                "Green","Blue","Yellow","Pink",
                "Magenta","Orange"};

        Color ColorColor[] = {Color.black, Color.red,
                Color.green, Color.blue, Color.yellow,
                Color.pink, Color.magenta, Color.orange};

        JButton buttonColor[]= new JButton[8];

        JPanel panColor= new JPanel();
        panColor.setLayout( new GridLayout(2,4));

        for (int i=0;i<8;i++)
        {
            buttonColor[i] = new JButton(ColorName[i]);
            (buttonColor[i]).setBackground(ColorColor[i]);
            panColor.add(buttonColor[i]);
            buttonColor[i].addActionListener(this);
        }
        buttonColor[0].setForeground(Color.white);
        buttonColor[3].setForeground(Color.white);


        JPanel panShape = new JPanel();
        panShape.setLayout( new GridLayout(2,2));

        String shapeName[] = {"Ellipse", "Circle", "Rectangle", "Square"};
        JButton buttonShape[]= new JButton[4];

        for (int i=0;i<4;i++)
        {
            buttonShape[i]= new JButton(shapeName[i]);
            panShape.add(buttonShape[i]);
            buttonShape[i].addActionListener(this);
        }

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1,2));

        southPanel.add(panColor,"South");
        southPanel.add(panShape,"South");

        contentPane.add(southPanel,"South");

        contentPane.add(draw,"Center");

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        String cmd=e.getActionCommand();

        switch (cmd)
        {
            case "Black" : 	draw.setColor(Color.black);
                break;
            case "Red" : 	draw.setColor(Color.red);
                break;
            case "Green" : 	draw.setColor(Color.green);
                break;
            case "Blue" : 	draw.setColor(Color.blue);
                break;
            case "Yellow" : draw.setColor(Color.yellow);
                break;
            case "Pink":	draw.setColor(Color.pink);
                break;
            case "Orange":	draw.setColor(Color.orange);
                break;
            case "Magenta":	draw.setColor(Color.magenta);
                break;

            case "Ellipse":	draw.setNameFigure("Ellipse");
                break;
            case "Circle":	draw.setNameFigure("Circle");
                break;
            case "Rectangle":	draw.setNameFigure("Rectangle");
                break;
            case "Square":	draw.setNameFigure("Square");
                break;


            case "Exit"	: 	System.exit(0);
                break;
            case "New" : 	draw.reset();
                break;
            case "Authors" :
                JOptionPane info = new JOptionPane();
                info.showInternalMessageDialog(
                        info, "Authors : A.T. for 2g3td3 the best !",
                        "information",
                        JOptionPane.INFORMATION_MESSAGE);
                break;

            case "Save" : 	JFileChooser fds=new JFileChooser();
                int c=fds.showSaveDialog(this);
                if (c==JFileChooser.CANCEL_OPTION)
                {System.out.println("Cancelled");
                    break;}
                String nameFile=fds.getSelectedFile().getAbsolutePath();
                draw.saveDrawing(nameFile);
                break;
            case "Open" : 	JFileChooser fdo=new JFileChooser();
                int x=fdo.showOpenDialog(this);
                if (x==JFileChooser.CANCEL_OPTION)
                {System.out.println("Cancelled");
                    break;}
                String nameFileOpen=fdo.getSelectedFile().getAbsolutePath();
                draw.recallDrawing(nameFileOpen);
                break;

            default : System.out.println("Cmd not understood : "+cmd);
                break;
        }

    }
}
