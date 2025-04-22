import javax.swing.*; // Important to import for GUI creation

//This class builds the main window for this project
//
public class GUI extends JFrame
{
    //Jcomboboxes are used for selecting an input value
    //
    private JComboBox<String> clientTypeBox;
    private JComboBox<String> coverageBox;
    private JComboBox<String> TermBox;
    private JComboBox<String>  areaBox;

    //Button to trigger the prediction + A label for displaying the result
    //
    private JButton predicButton;
    private JLabel resultLabel;

    //Predictor object that will handle prediction logic
    //
    public Predictor predictor;

    //Constructor for settuing up the window and the UI
    public  GUI(Predictor predictor) 
    {

        this.predictor = predictor;

        //Set window size and name
        //
        setTitle("Policey Predictor");
        setSize(1000, 800);

        //Define values for each of the dropdowns
        //
        String[] clientType = {"Individual", "Buisness"};
        String[] coverages = {"Basic" , "Full"};
        String[] terms = {"Short","Long"};
        String[] areas = {"Urban","Rural"};

        //Create the dropwdoens and add the values
        //
        clientTypeBox = new JComboBox<>(clientType);
        coverageBox = new JComboBox<>(coverages);
        TermBox = new JComboBox<>(terms);
        areaBox = new JComboBox<>(areas);

        //create the buttons and labels
        //
        predicButton = new JButton("Predict");
        resultLabel = new JLabel("Prediction will show here");

        //add everything to a pannell
        //
        JPanel panel = new JPanel();
        panel.add(new JLabel("Client Type:"));
        panel.add(clientTypeBox);
        panel.add(new JLabel("Coverage:"));
        panel.add(coverageBox);
        panel.add( new JLabel("Term:"));
        panel.add(TermBox);
        panel.add(new JLabel("Area:"));
        panel.add(areaBox);

        panel.add(predicButton);
        panel.add(resultLabel);

        add(panel);

        //When predict button is pressed listner activates and grabs the values from each dropwdown
        //
        predicButton.addActionListener(e -> 
        {
            String s_clientType = (String) clientTypeBox.getSelectedItem();
            String s_coverage = (String) coverageBox.getSelectedItem();
            String s_term = (String) TermBox.getSelectedItem();
            String s_area = (String) areaBox.getSelectedItem();
            
            //Create an array of features to pass to the predictor
            //
            String[] features = { s_clientType, s_coverage, s_term, s_area };

            //Get prediction result from the predictor
            //
            String prediction = predictor.predict(features);

            //Display the result
            //
            resultLabel.setText("Prediction: " + prediction);
        });
    
    }

}
