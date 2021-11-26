import javax.swing.*;
import java.awt.* ;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Drawing extends JPanel implements MouseMotionListener, MouseListener{
    private ArrayList<Figure> list;
    private Color c;
    private String nameFigure;

    private int x;
    private int y;

    public Drawing()
    {
        super();
        this.setBackground(Color.white);
        this.c = Color.black;
        this.nameFigure = "Rectangle";
        this.list = new ArrayList<Figure>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (Figure f : list)
        {
            f.draw(g);
        }
    }

    public void saveDrawing(String nameFile)
    {
        try{
            FileOutputStream fos = new FileOutputStream(nameFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(list.size());

            for (Figure f : list)
            {
                oos.writeObject(f);
            }
            oos.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void recallDrawing(String nameFile)
    {
        try{
            FileInputStream fis = new FileInputStream(nameFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            reset();

            int numberOfFigure=ois.readInt();
            for (int i=0; i<numberOfFigure; i++)
            {Figure f=(Figure) ois.readObject();
                list.add(f);
            }

            ois.close();
            paintComponent(this.getGraphics());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void reset()
    {
        this.list.clear();
        paintComponent(this.getGraphics());
    }

    public void setColor(Color col)
    {
        this.c=col;
    }

    public void setNameFigure(String name)
    {
        this.nameFigure=name;
    }

    public ArrayList<Figure> getList()
    {
        return this.list;
    }

    public void mouseDragged(MouseEvent e)
    {
        (list.get(list.size()-1)).setBoundingBox(e.getX()-this.x, e.getY()-this.y);
        paintComponent(this.getGraphics());
    }
    public void mouseMoved(MouseEvent e)
    {
    }
    public void mouseClicked(MouseEvent e)
    {
    }
    public void mouseEntered(MouseEvent e)
    {}
    public void mouseExited(MouseEvent e)
    {}
    public void mousePressed(MouseEvent e)
    {
        this.x=e.getX();
        this.y=e.getY();

        System.out.println("Drawing of a "+c+" "+nameFigure+" @ "+e.getX()+
                " "+e.getY());

        switch (nameFigure) {
            case "Rectangle" : 	list.add(new Rectangle(this.x,this.y,c));
                break;
            case "Square" : 	list.add(new Square(this.x,this.y,c));
                break;
            case "Circle" : 	list.add(new Circle(this.x,this.y,c));
                break;
            case "Ellipse" : 	list.add(new Ellipse(this.x,this.y,c));
                break;
        }
    }
    public void mouseReleased(MouseEvent e)
    {
        System.out.println("Ending the Figure");
        (list.get(list.size()-1)).setBoundingBox(e.getX()-this.x, e.getY()-this.y);
        paintComponent(this.getGraphics());
    }
}
