import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main
{
	public static void main(String args[])
	{
		File file = new File("../Input Files/Prob5Input.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));

			String text;
			
			ArrayList<Car> list = new ArrayList<>();
			String[] labels = input.readLine().split("\t");
			while( (text=input.readLine())!= null)
			{
				list.add(new Car(text));
            }

			input.close();

			for(int i = 1; i < labels.length - 1; i++) {
				String label = labels[i];
				System.out.println(format("Highest " + (label.equals("Cylinders")? "# " : "") + label, "Lowest " + (label.equals("Cylinders")? "# " : "") + label));
                ArrayList<Car> listCopy = new ArrayList<>();
                for(Car c: list)
                    listCopy.add(c);
                listCopy.removeIf(l -> l.get(label) == -1);
                Collections.sort(listCopy, (a, b) -> a.get(label).compareTo(b.get(label)));
				for(int j = 0; j < 3; j++)
					System.out.println(format(listCopy.get(listCopy.size() - 1 - j).model, listCopy.get(j).model));
				System.out.println();
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}

	public static String format(String one, String two) {
		return String.format("%-40s %s", one, two);
	}
}

class Car {

	String model;
	double mpg;
	double cylinders;
	double displacement;
	double horsepower;
	double weight;
	double acceleration;
	double year;
	String origin;

	public Car(String model, double mpg, double cylinders, double displacement, double horsepower, double weight, double acceleration, double year, String origin) {
		this.model = model;
		this.mpg = mpg;
		this.cylinders = cylinders;
		this.displacement = displacement;
		this.horsepower = horsepower;
		this.weight = weight;
		this.acceleration = acceleration;
		this.year = year;
		this.origin = origin;
	}

	public Car(String[] arr) {
		this(arr[0], toDouble(arr[1]), toDouble(arr[2]), toDouble(arr[3]), toDouble(arr[4]), toDouble(arr[5]), toDouble(arr[6]), toDouble(arr[7]), arr[8]);
	}

	public Car(String text) {
		this(text.split("\t"));
	}

	public Double get(String name) {
		switch(name.toLowerCase()) {
			case "mpg":
				return mpg;
			case "cylinders":
				return cylinders;
			case "displacement":
				return displacement;
			case "horsepower":
				return horsepower;
			case "weight":
				return weight;
			case "acceleration":
				return acceleration;
			case "year":
				return year;
		}
		return null;
	} 

	public static double toDouble(String str) {
		if(str.equals("NA"))
			return -1;
		return Double.parseDouble(str);
	}

}