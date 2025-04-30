import java.util.*;

//This class does  very basic yes/no prediction based on matching rows in the training data
//
public class Predictor
{
    private List<String[]> data;
    private Dataset dataset; // Save the dataset object for retraining

    //Constructor stores the dataset and the original data
    //
    public Predictor(List<String[]> data, Dataset dataset)
    {
        this.data = data;
        this.dataset = dataset;
    }

    //Predict method checks how many "yes" and "no" matches exist for the selected features
    //
    public String predict(String[] features)
    {
        int yes = 0;
        int no = 0;

        for (String[] row : data)
        {
            boolean matches = true;

            //Check if all 4 features match the row
            //
            for (int i = 0; i < 4; i++)
            {
                if (!row[i].equals(features[i]))
                {
                    matches = false;
                    break;
                }
            }

            //If row matches the input features, count the label
            //
            if (matches)
            {
                if (row[4].equalsIgnoreCase("yes"))
                {
                    yes++;
                }
                else if (row[4].equalsIgnoreCase("no"))
                {
                    no++;
                }
            }
        }

        //Compare yes and no counts and return the result
        //
        if (yes > no)
        {
            return "Yes";
        }
        else if (no > yes)
        {
            return "No";
        }
        else
        {
            return "TIE/EQUAL AMOUNTS!!"; // Tie or no matching data
        }
    }

    //Allows retraining with new data
    //
    public void retrain(List<String[]> newData)
    {
        this.data = newData;
    }

    //Get the dataset to allow adding new rows
    //
    public Dataset getDataset()
    {
        return dataset;
    }
}
