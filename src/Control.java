public class Control
{
    public static void main(String[] args)
    {
        try
        {
            //Create the dataset from the CSV file
            //
            Dataset dataset = new Dataset("DataSet.csv");

            //Create the predictor using the dataset
            //
            Predictor predictor = new Predictor(dataset.getData());

            //Pass predictor into GUI and display the window
            //
            GUI gui = new GUI(predictor);
            gui.setVisible(true);
        }
        catch (Exception e)
        {
            e.printStackTrace(); // Print any errors if something goes wrong
        }
    }
}
