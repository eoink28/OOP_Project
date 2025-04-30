import javax.swing.*; // Important to import for GUI creation
import java.awt.*;    // Needed for layouts and fonts

//This class builds the main window for this project
//
public class GUI extends JFrame
{
    //JComboBoxes used for selecting an input value
    //
    private JComboBox<String> clientTypeBox;
    private JComboBox<String> coverageBox;
    private JComboBox<String> TermBox;
    private JComboBox<String> areaBox;
    private JComboBox<String> labelBox;

    //Buttons to trigger actions and a label for displaying the result
    //
    private JButton predicButton;
    private JButton addRowButton;
    private JButton retrainButton;
    private JLabel resultLabel;

    //Predictor object that will handle prediction logic
    //
    private Predictor predictor;

    //Constructor for setting up the window and the UI
    //
    public GUI(Predictor predictor) 
    {
        this.predictor = predictor;

        //Set window size and name
        //
        setTitle("Policy Predictor");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Use BorderLayout for the main window
        //
        setLayout(new BorderLayout());

        //Define values for each of the dropdowns
        //
        String[] clientType = {"Individual", "Business"};
        String[] coverages = {"Basic", "Full"};
        String[] terms = {"Short", "Long"};
        String[] areas = {"Urban", "Rural"};
        String[] labels = {"yes", "no"};

        //Create the dropdowns
        //
        clientTypeBox = new JComboBox<>(clientType);
        coverageBox = new JComboBox<>(coverages);
        TermBox = new JComboBox<>(terms);
        areaBox = new JComboBox<>(areas);
        labelBox = new JComboBox<>(labels);

        //Create the buttons
        //
        predicButton = new JButton("Predict");
        addRowButton = new JButton("Add Row");
        retrainButton = new JButton("Retrain");

        //Create the result label and make it bigger
        //
        resultLabel = new JLabel("Prediction will show here");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 22));//Setting font
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);//Moving to middle of the window

        //Panel to hold all inputs at the top
        //
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Client Type:"));
        inputPanel.add(clientTypeBox);
        inputPanel.add(new JLabel("Coverage:"));
        inputPanel.add(coverageBox);
        inputPanel.add(new JLabel("Term:"));
        inputPanel.add(TermBox);
        inputPanel.add(new JLabel("Area:"));
        inputPanel.add(areaBox);
        inputPanel.add(new JLabel("Label (for training):"));
        inputPanel.add(labelBox);

        //Panel to hold buttons
        //
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(predicButton);
        buttonPanel.add(addRowButton);
        buttonPanel.add(retrainButton);

        //Panel to center buttons and prediction
        //
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(buttonPanel);
        centerPanel.add(Box.createVerticalStrut(20)); // Add space

        //Panel to hold and center prediction label
        //
        JPanel predictionPanel = new JPanel();
        predictionPanel.add(resultLabel);

        centerPanel.add(predictionPanel);

        //Add panels to the frame
        //
        add(inputPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        //When predict button is pressed listener activates and grabs the values from each dropdown
        //
        predicButton.addActionListener(e -> 
        {
            String s_clientType = (String) clientTypeBox.getSelectedItem();
            String s_coverage = (String) coverageBox.getSelectedItem();
            String s_term = (String) TermBox.getSelectedItem();
            String s_area = (String) areaBox.getSelectedItem();

            //Create an array of features to pass to the predictor
            //
            String[] features = {s_clientType, s_coverage, s_term, s_area};

            //Get prediction result from the predictor
            //
            String prediction = predictor.predict(features);

            //Display the result
            //
            resultLabel.setText("Prediction: " + prediction);
        });

        //When Add Row button is pressed, create a new row and add it to the dataset
        //
        addRowButton.addActionListener(e -> 
        {
            String s_clientType = (String) clientTypeBox.getSelectedItem();
            String s_coverage = (String) coverageBox.getSelectedItem();
            String s_term = (String) TermBox.getSelectedItem();
            String s_area = (String) areaBox.getSelectedItem();
            String s_label = (String) labelBox.getSelectedItem();

            //Create a new row
            //
            String[] newRow = {s_clientType, s_coverage, s_term, s_area, s_label};

            //Add the row to the dataset
            //
            predictor.getDataset().addRow(newRow);

            //Show a message
            //
            JOptionPane.showMessageDialog(this, "Row added! Click Retrain to update the model.");
        });

        //When Retrain button is pressed, retrain the predictor with new data
        //
        retrainButton.addActionListener(e -> 
        {
            predictor.retrain(predictor.getDataset().getData());
            JOptionPane.showMessageDialog(this, "Predictor retrained successfully!");
        });
    }
}
