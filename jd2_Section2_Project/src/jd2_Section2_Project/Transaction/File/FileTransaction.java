package jd2_Section2_Project.Transaction.File;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import jd2_Section2_Project.Model.Phone;
import jd2_Section2_Project.Model.User;

public class FileTransaction implements IFileTransaction {

	final static String path="src/jd2_Section2_Project/PhoneInfoFile/AboutPhone.txt";
	@Override
	public void write(Phone phone, List<User> userList) {
		 try {		        
		        StringBuilder result = userList.stream().collect(StringBuilder::new, (x, y) -> x.append(y),
		        		(a, b) -> a.append(";").append(b));
		        String content = phone.toString()+ "\r\n" + result.toString(); 
		        File file = new  File(path);
		        if (!file.exists()) {
		            file.createNewFile();
		        }
		        FileWriter fw = new FileWriter(file.getAbsoluteFile());
		        BufferedWriter bw = new BufferedWriter(fw);
		       // Files.write(Paths.get(path), content.getBytes());
		        bw.write(content);
		        bw.close();

		        System.out.println("Done");

		    } catch (IOException e) {
		        e.printStackTrace();
		    }	
	}

	@Override
	public void read() {
		BufferedReader br = null;
		FileReader fileReader = null;
		try {
			
			fileReader = new FileReader(path);
			br = new BufferedReader(fileReader);
			Stream<String> fileLines = br.lines();
			fileLines.forEach(element -> System.out.printf("%s\n", element));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();			
		} catch (IOException e) {
			e.printStackTrace();		
		}finally{
			try {
				fileReader.close();
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
