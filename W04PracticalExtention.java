public class W04PracticalExtention{
	public static void main (String [] args){
	String output = "";
	System.out.println("Please chose an option: \n1. Metric to Imperial \n2. Imperial to Metric");
	int	Selection = EasyIn.getInt();//Allow user to choose what they want to convert																																
	if (Selection==1){//If the user chooses to convert from Metric to Imperial this code section is run
	System.out.println("Please eneter the number of meters you want to convert:");
	float Meters = EasyIn.getFloat();//User can input the number of meters they wish to convert (this can be a decimal number)
	if (Meters <= 0) System.out.println("Invalid Input");//If the user eters something invalid and error message is displayed 
	else output=MetricToImperial(Meters);
	System.out.println(output);}//Once the conversion is complete the string is printed
	if (Selection==2){ output=ImperialToMetric();
	System.out.println(output);}//Once the conversion is complete the string is printed
	else if (Selection!=1 && Selection!=2)System.out.println("Invalid choice.");	//If the user makes an invalid choice at the start
	}
	
public static String MetricToImperial(float Meters){
	String Y="",F="",I="",OutString="";
	float Inches = Meters*39.3700787f;//First of all the numbers of inches are calculated 
	int Yards = (int) Inches/36;//The number of yards is then calculated by dividing the number of inches by 36
	//The output string is then updated accordingly 
	if (Yards>1) Y="yards";
	else if (Yards==1)  Y="yard";
	Inches = Inches-(Yards*36);//The number of inches is then updated 
	int Feet = (int) Inches/12;//The number of feet is then calculated by dividing the number of inches by 12
	//Again the output string is then updated accordingly 
	if (Feet>1) F="feet";
	else if (Feet==1) F="foot";
	Inches = Inches-(Feet*12);//Finally the number of inches is then updates again 
	if (Inches>1.0){ 
		Inches = (float)(Math.round(Inches*100.0)/100.0);//The number of inches variable is rounded to 2.d.p
		//Once more the output string is then updated accordingly 
		I="inches";}
	else if (Inches==1.0) I="inch";
	OutString=OutputFormat(Y, F, I, Yards, Feet, Inches);
	return OutString;
	}


public static String OutputFormat(String Y, String F, String I, int Yards, int Feet, float Inches){
	String OutString ="The conversion = ";//Defining the string which is used to hold the output
	if (Yards != 0 && Feet != 0 && Inches !=0)			OutString=OutString+Yards+" "+Y+", "+Feet+" "+F+" and "+Inches+" "+I;
	else if (Yards != 0 && Feet != 0 && Inches ==0f)	OutString=OutString+Yards+" "+Y+" and "+Feet+" "+F;
	else if (Yards != 0 && Feet == 0 && Inches !=0f)	OutString=OutString+Yards+" "+Y+" and "+Inches+" "+I;
	else if (Yards == 0 && Feet != 0 && Inches !=0f)  	OutString=OutString+Feet+" "+F+" and "+Inches+" "+I;
	else if (Yards != 0 && Feet == 0 && Inches ==0f)	OutString=OutString+Yards+" "+Y;
	else if (Yards == 0 && Feet != 0 && Inches ==0f)	OutString=OutString+Feet+" "+F;
	else if (Yards == 0 && Feet == 0 && Inches !=0f) 	OutString=OutString+Inches+" "+I;
	else if (Yards == 0 && Feet == 0 && Inches ==0f) 	OutString="No distance at all...";
	return OutString;
	
}

	
public static String ImperialToMetric(){
	String OutString ="The conversion = ";//Defining the string which is used to hold the output
	System.out.println("Please enter the number of yards: ");
	int Yards = EasyIn.getInt();//The user eneters the number of yards
	if (Yards < 0) System.out.println("Invalid Input");//If the user eters something invalid and error message is displayed 
	System.out.println("Please enter the number of feet: ");
	int Feet = EasyIn.getInt();//The user eneters the number of feet
	if (Feet < 0) System.out.println("Invalid Input");//If the user eters something invalid and error message is displayed 
	System.out.println("Please enter the number of inches: ");
	float Inches = EasyIn.getFloat();//The user eneters the number of inches
	if (Inches < 0) System.out.println("Invalid Input");//If the user eters something invalid and error message is displayed 
	float Meters = Yards/1.09361f;	//The number of meters in the yards entered is calculated 
	Meters += Feet/3.28084f;//The number of meters in the feet entered is calculated 
	Meters += Inches/39.3701f;//The number of meters in the inches entered is calculated 
	float CM = Meters*100f;//The number of CM is calculated 
	Meters=0f;//The meters variable is set back to 0 
	while (CM>=100){//A loop which continues as long as the variable CM is greater than 1000
		Meters++;//The number of whole metters is then calculated by
		CM = CM- 100;}//Take one meter from the number of CM's left 
	CM = (float)(Math.round(CM*100.0)/100.0);//Round the variable CM to 2.d.p
	//The output string is then updated accordingly 
	if (Meters>1) OutString=OutString+Meters+" meters";
	else if (Meters==1) OutString=OutString+Meters+" meter";
	if (CM>1) OutString=OutString+CM+" cm's ";
	else if (CM==1)  OutString=OutString+CM+" cm ";
	else if (CM==0)  OutString=OutString;
	
	return OutString;
	}
	
}