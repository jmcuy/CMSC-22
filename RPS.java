
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Created by JHESSA B. on 25/10/2016.
 */
public class RPS extends Frame {
    private Random rand = new Random();
    String[] arr = {"ROCK","PAPER","SCISSORS","LIZARD","SPOCK"};
    private int score = 0;
    private int compScore = 0;

    public void paint(){
        setLayout(new FlowLayout());
        setTitle("RockPaperScissorsLizardSpock");
        setVisible(true);
        setSize(250,400);
        setLocation(550,200);
        setResizable(false);
        Font fo = new Font("doesn'tmatter",Font.BOLD,12);
        setFont(fo);
    }
    public RPS(){
        paint();
        Label l = new Label("Your Choice:");

        CheckboxGroup c = new CheckboxGroup();
        Checkbox rock = new Checkbox("ROCK", c, true);
        Checkbox paper = new Checkbox("PAPER", c, false);
        Checkbox scissors = new Checkbox("SCISSORS",c,false);
        Checkbox lizard = new Checkbox("LIZARD", c, false);
        Checkbox spock = new Checkbox("SPOCK",c,false);

        Button button = new Button("RockPaperScissorsSLizardSpock!!");
        TextArea text = new TextArea("Results:",5,20,TextArea.SCROLLBARS_NONE);

        Label player = new Label("Player's score:");
        TextField field1 = new TextField("",5);

        Label comp = new Label("Computer's score:");
        TextField field2 = new TextField("",5);

        add(l);
        add(rock);
        add(paper);
        add(scissors);
        add(lizard);
        add(spock);
        add(text);
        add(button);
        add(player);
        add(comp);
        add(field1);
        add(field2);
        text.setEditable(false);
        field1.setEditable(false);
        field2.setEditable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = rand.nextInt(arr.length);
                isPlayerWin(rock,text,i);
                isPlayerWin(paper,text,i);
                isPlayerWin(scissors,text,i);
                isPlayerWin(spock,text,i);
                isPlayerWin(lizard,text,i);
                ifPlayerScoreHigher();
                ifCompScoreHigher();
                field1.setText(Integer.toString(score)); //updates textfields
                field2.setText(Integer.toString(compScore));
            }
        });
        closeFrame(this);
    }

    public void setTextArea(TextArea t, String s){
        t.setText(s);
    }

    public void isPlayerWin(Checkbox c, TextArea t,int i){
        if(c.getState()){
            if((c.getLabel() == "ROCK" && arr[i] == "SCISSORS") || (c.getLabel() == "ROCK" && arr[i] == "LIZARD") ||
                    (c.getLabel() == "PAPER" && arr[i] == "ROCK") || (c.getLabel() == "PAPER" && arr[i] == "SPOCK") ||
                    (c.getLabel() == "SCISSORS" && arr[i] == "PAPER") || (c.getLabel() == "SCISSORS" && arr[i] == "LIZARD") ||
                    (c.getLabel() == "SPOCK" && arr[i] == "SCISSORS") || (c.getLabel() == "SPOCK" && arr[i] == "ROCK") ||
                    (c.getLabel() == "LIZARD" && arr[i] == "PAPER") || (c.getLabel() == "LIZARD" && arr[i] == "SPOCK")) {
                setTextArea(t, "Results: \nPlayer chose " + c.getLabel() + "\n" + "Computer chose " + arr[i] + "\n" + "YOU WIN THIS ROUND");
                score++;
            }else if(arr[i] == c.getLabel()){
                setTextArea(t,"Results: \nPlayer chose " + c.getLabel() + "\n" + "Computer chose " + arr[i] + "\n" + "ITS A DRAW");
            } else {
                compScore++;
                setTextArea(t,"Results: \nPlayer chose " + c.getLabel() + "\n" + "Computer chose " + arr[i] + "\n" + "YOU LOSE THIS ROUND");
            }
        }
    }

    public void closeFrame(Frame f){
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    public void showDialogue(String label){
        Frame f = new Frame();
        Dialog d = new Dialog(f, "GAME OVER!!");
        d.setLayout(new FlowLayout());
        d.setSize(200,100);
        d.setLocation(575,350);
        closeFrame(f);
        d.add(new Label(label));
        Button b = new Button("OK");
        d.add(b);
        d.setVisible(true);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.dispose(); // dispose frame
                RPS frame = new RPS();
                frame.setVisible(true);
            }
        });
    }
    public void ifPlayerScoreHigher() {
        if(score == 5) {
            showDialogue("PLAYER WINS");
            dispose();

        }
    }
    public void ifCompScoreHigher(){
        if(compScore == 5){
            showDialogue("COMPUTER WINS");
            dispose();
        }

    }
    public static void main(String[] arvs){
        new RPS();
    }
}
