import java.io.*; //Import java input/output
import java.util.*; //import java utillity for arrays

//This class reads the dataset from a CSV file
//
public class Dataset
{
    private List<String[]> data;

    //Constructor that loads the CSV into memory
    //
    public Dataset(String filename) throws IOException
    {
        data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null)
        {
            //Skip the header row 
            //
            if (line.startsWith("ClientType"))
            {
                continue;
            }

            //Split each row into an array of values
            //
            String[] row = line.split(",");
            data.add(row);
        }

        reader.close();
    }

    //Return the list of data rows
    //
    public List<String[]> getData()
    {
        return data;
    }

    //Add a new row to the dataset
    //
    public void addRow(String[] newRow)
    {
        data.add(newRow);
    }
}
