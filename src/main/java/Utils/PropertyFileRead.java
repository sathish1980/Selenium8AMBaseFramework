package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileRead {
	
	static String  filepath = System.getProperty("user.dir")+"//Environment//env.properties";
	
	public static Properties GetDataFromPropFile() throws IOException
	{
		File F = new File(filepath);
		FileInputStream Fs = new FileInputStream(F);
		Properties p = new Properties();
		p.load(Fs);
		return p;
	}

}
